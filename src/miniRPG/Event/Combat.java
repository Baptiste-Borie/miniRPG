package miniRPG.Event;

import java.util.Random;
import java.util.Scanner;

import miniRPG.Person.Person;
import miniRPG.Person.Joueur;

/**
 * Classe Combat représente un événement de combat dans le miniRPG.
 * Gère les interactions entre le joueur et un ennemi, comme attaquer, esquiver,
 * défendre et fuir.
 * 
 * Le combat peut inclure des mécaniques spéciales comme des boss ou des bonus
 * d'attaque en fonction des actions réussies.
 * 
 * @author Baptiste Borie
 */
public class Combat {

    /**
     * Indique si la prochaine attaque du joueur sera boostée.
     */
    private boolean isNextAttackBoosted = false;

    /**
     * Le joueur participant au combat.
     */
    private Joueur player;

    /**
     * L'ennemi affronté par le joueur.
     */
    private Person enemy;

    /**
     * Indique si le joueur est en mode défense.
     */
    private boolean isPlayerDefending = false;

    /**
     * Indique si le joueur tente d'esquiver l'attaque ennemie.
     */
    private boolean isPlayerDodging = false;

    /**
     * Indique si le joueur a fui le combat.
     */
    private boolean fleeExit = false;

    /**
     * Générateur de nombres aléatoires pour déterminer le succès des actions.
     */
    private Random random = new Random();

    /**
     * Scanner pour lire les entrées utilisateur pendant le combat.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Indique si le combat est un combat contre un boss.
     */
    private boolean bossFight;

    /**
     * Constructeur de la classe Combat.
     * Initialise un combat standard entre le joueur et un ennemi.
     * 
     * @param player Le joueur participant au combat.
     * @param enemy  L'ennemi affronté.
     */
    public Combat(Person player, Person enemy) {
        this.player = (Joueur) player;
        this.bossFight = false;
        this.enemy = enemy;
    }

    /**
     * Constructeur de la classe Combat.
     * Initialise un combat avec une option pour un combat de boss.
     * 
     * @param player    Le joueur participant au combat.
     * @param enemy     L'ennemi affronté.
     * @param bossFight Indique si le combat est contre un boss.
     */
    public Combat(Person player, Person enemy, boolean BossFight) {
        this.player = (Joueur) player;
        this.bossFight = BossFight;
        this.enemy = enemy;
    }

    /**
     * Démarre le combat et gère le déroulement au tour par tour.
     * Permet au joueur et à l'ennemi d'effectuer des actions jusqu'à ce que
     * l'un des deux soit vaincu ou que le joueur s'enfuie.
     */
    public void start() {
        System.out.println("Le combat commence entre " + player.getName() + " et " + enemy.getName() + " !");

        // Boucle de combat au tour par tour
        while (player.isAlive() && enemy.isAlive() && !fleeExit) {
            // Afficher la vie des deux avant chaque tour
            displayHealthStatus();

            // Tour du joueur
            playerTurn();

            // Vérifier si l'ennemi est toujours en vie
            if (!enemy.isAlive()) {
                System.out.println(enemy.getName() + " est vaincu !");
                break;
            }

            // Tour de l'ennemi
            if (!fleeExit) {
                enemyTurn();
            }

            // Vérifier si le joueur est toujours en vie
            if (!player.isAlive()) {
                System.out.println(player.getName() + " est vaincu !");
                break;
            }
        }

        // Fin du combat
        if (player.isAlive() && !fleeExit) {
            player.addMoney(10);
            System.out.println("Vous avez gagné le combat !" + (!bossFight ? " Vous avez gagné 5$." : ""));
        } else if (fleeExit) {
            System.out.println("Vous avez fui le combat.");
        }
    }

    /**
     * Affiche les points de vie actuels du joueur et de l'ennemi.
     */
    private void displayHealthStatus() {
        System.out.println("\n--- Statut des points de vie ---");
        System.out.println(player.getName() + " : " + player.getHealth() + " PV");
        System.out.println(enemy.getName() + " : " + enemy.getHealth() + " PV");
        System.out.println("--------------------------------");
    }

    /**
     * Gère le tour du joueur et les actions qu'il peut effectuer :
     * attaquer, esquiver, défendre ou fuir.
     */
    private void playerTurn() {
        System.out.println("\n--- Tour du joueur ---");
        System.out.println("Choisissez une action :");
        System.out.println("1. Attaquer (" + (player.getAttack() - enemy.getArmor()) + " dégâts)");
        System.out.println("2. Esquiver (50% de chance de succès)");
        System.out.println("3. Se défendre (réduit les dégâts de 50%)");
        System.out.println("4. Fuir");

        int choice = -1; // Valeur par défaut pour détecter un choix invalide
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Votre choix : ");
            String input = scanner.nextLine(); // Lire l'entrée utilisateur en tant que chaîne
            try {
                choice = Integer.parseInt(input); // Essayer de convertir en entier
                validInput = true; // Si la conversion réussit, l'entrée est valide
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entre 1 et 4.");
            }
        }

        switch (choice) {
            case 1:
                attackEnemy();
                break;
            case 2:
                dodge();
                break;
            case 3:
                defend();
                break;
            case 4:
                flee();
                break;
            default:
                System.out.println("Choix invalide. Vous perdez votre tour.");
        }
    }

    /**
     * Gère l'attaque du joueur contre l'ennemi.
     * Tient compte du boost d'attaque si applicable.
     */
    private void attackEnemy() {
        int playerDamage = player.attack();
        if (this.isNextAttackBoosted) { // Ajouter le bonus de +2 si esquive réussie au tour précédent
            playerDamage += player.getBoostDamage();
            this.isNextAttackBoosted = false; // Reset du bonus après l'attaque
        }
        int damageToEnemy = Math.max(0, playerDamage - enemy.getArmor());
        enemy.setHealth(enemy.getHealth() - damageToEnemy);
        System.out.println(player.getName() + " inflige " + damageToEnemy + " dégâts à " + enemy.getName() + ".");
    }

    /**
     * Tente une esquive et applique un bonus à la prochaine attaque en cas de
     * succès.
     */
    private void dodge() {
        if (random.nextInt(100) < player.getDodgeChance()) {
            System.out.println("Vous avez réussi à esquiver ! Prochaine attaque avec boosté.");
            isNextAttackBoosted = true; // Active le bonus pour la prochaine attaque
        } else {
            System.out.println("L'esquive a échoué.");
            isNextAttackBoosted = false; // Pas de bonus si esquive échoue
        }
    }

    /**
     * Tente une défense pour réduire les dégâts ennemis au prochain tour.
     */
    private void defend() {
        if (random.nextInt(100) < player.getDefenseChance()) {
            isPlayerDefending = true;
            System.out.println("Défense réussie ! Dégâts ennemis divisés par 2 lors de la prochaine attaque.");
        } else {
            System.out.println("Défense échouée.");
            isPlayerDefending = false;
        }
    }

    /**
     * Tente une fuite du combat. Si c'est un combat de boss, la fuite est
     * impossible.
     */
    private void flee() {
        if (!bossFight && random.nextInt(100) < player.getFleeChance()) {
            System.out.println("Vous avez réussi à fuir le combat !");
            fleeExit = true;
        } else {
            System.out.println(bossFight ? "Ou penses-tu aller ? Viens te battre !" : "La fuite a échoué !");
        }
    }

    /**
     * Gère le tour de l'ennemi, infligeant des dégâts au joueur en tenant compte de
     * sa défense.
     */
    private void enemyTurn() {
        System.out.println("\n--- Tour de l'ennemi ---");

        if (isPlayerDodging) {
            System.out.println(enemy.getName() + " attaque, mais vous esquivez avec succès !");
            isPlayerDodging = false; // Reset l'état de l'esquive pour le prochain tour
            return;
        }

        int enemyDamage = enemy.attack();
        int damageToPlayer = enemyDamage;

        // Appliquer la défense si le joueur est en train de défendre
        if (isPlayerDefending) {
            damageToPlayer /= 2;
            isPlayerDefending = false; // Reset l'état de défense pour le prochain tour
        }

        player.takeDamage(damageToPlayer);
        System.out.println(enemy.getName() + " inflige " + damageToPlayer + " dégâts à " + player.getName() + ".");
    }
}
