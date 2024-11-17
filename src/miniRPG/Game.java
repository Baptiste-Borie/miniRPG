package miniRPG;

import java.util.*;

import miniRPG.Event.*;
import miniRPG.Person.*;
import miniRPG.Rooms.*;

/**
 * La classe Game représente le moteur principal du mini-RPG.
 * Elle gère les interactions entre le joueur, les salles, et les événements
 * dans le jeu.
 * Le jeu est basé sur une grille ASCII et propose des combats, des échanges, et
 * des explorations.
 * 
 * @author Borie Baptiste
 */

public class Game {

    /** Indique si le jeu est en cours d'exécution. */
    private boolean gameRunning;

    /** Représente le type d'événement déclenché par le joueur. */
    private char caseEvent;

    /** La salle actuelle où se trouve le joueur. */
    private Room currentRoom;

    /** Le personnage contrôlé par le joueur. */
    private Person player;

    /** Gère les déplacements du joueur. */
    private Movement movement;

    /** Représente la grille de jeu actuelle. */
    private String[][] grid;

    /**
     * Constructeur de la classe Game.
     * Initialise les variables du jeu, crée la salle de départ et démarre la boucle
     * principale.
     */
    public Game() {
        this.gameRunning = true;
        this.currentRoom = new BaseRoom();
        this.player = new Joueur("Joueur", Joueur.ClasseType.BARBARE);
        this.currentRoom.createGrid(this.player);
        this.movement = new Movement(this.player, this.currentRoom);
        this.grid = currentRoom.getGrid();
        this.caseEvent = '▵';

        Scanner scanner = new Scanner(System.in);
        System.out.println(loadIntroduction());
        System.out.println((Joueur) player);
        while (this.gameRunning && player.isAlive()) {
            System.out.println(this.currentRoom);

            String input = scanner.nextLine();
            boolean event = false;

            switch (input) {
                case "d":
                    event = moveAndCheckEvent(0, 1);
                    break;
                case "z":
                    event = moveAndCheckEvent(-1, 0);
                    break;
                case "s":
                    event = moveAndCheckEvent(1, 0);
                    break;
                case "q":
                    event = moveAndCheckEvent(0, -1);
                    break;
                case "i":
                    System.out.println(player);
                    break;
                case "e":
                    gameRunning = false;
                    break;
                case "":
                    break;
                default:
                    System.out.println("Commande non reconnue : " + input);
            }

            if (event) {
                handleEvent();
            }
        }
        System.out.println("Fin du jeu.");
        scanner.close();
    }

    /**
     * Gère le déplacement du joueur et vérifie si un événement est déclenché à la
     * nouvelle position.
     * 
     * @param dx Déplacement sur l'axe X.
     * @param dy Déplacement sur l'axe Y.
     * @return true si un événement est déclenché, false sinon.
     */
    private boolean moveAndCheckEvent(int dx, int dy) {
        int newX = player.getX() + dx;
        int newY = player.getY() + dy;

        if (isEvent(newX, newY)) {
            // Déplacer le joueur avant de lancer l'événement
            movement.move(dx, dy);
            return true;
        } else {
            movement.move(dx, dy);
            return false;
        }
    }

    /**
     * Vérifie si une position donnée déclenche un événement.
     * 
     * @param x Coordonnée X de la grille.
     * @param y Coordonnée Y de la grille.
     * @return true si un événement est présent sur cette position, false sinon.
     */
    private boolean isEvent(int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            // Vérifier si le joueur arrive sur une sortie ou un ennemi
            if (grid[x][y].equals("⊕")) {
                this.caseEvent = '⊕';
                return true; // Lancer la salle de boss
            } else if (grid[x][y].equals("▵")) {
                this.caseEvent = '▵';
                return true; // Lancer un combat normal
            } else if (grid[x][y].equals("☠")) {
                this.caseEvent = '☠';
                return true;
            } else if (grid[x][y].equals("❂")) {
                this.caseEvent = '❂';
                return true;
            } else if (grid[x][y].equals("€")) {
                this.caseEvent = '€';
                return true;
            }
        }
        return false;
    }

    /**
     * Gère l'événement déclenché par le joueur en fonction de la case sur laquelle
     * il se trouve.
     * 
     * Peut inclure des combats, des boutiques ou des interactions spéciales.
     */
    private void handleEvent() {
        System.out.println("Un événement se produit !");
        if (this.caseEvent == '⊕') {
            loadBossRoom();
        } else if (this.caseEvent == '▵') {
            Person skeleton = new Skeleton();
            Combat combat = new Combat(player, skeleton); // Créez une instance Combat avec le joueur et l'ennemi
            combat.start(); // Déclencher le combat
        } else if (this.caseEvent == '☠') {
            Person boss = new Boss();
            Combat combat = new Combat(player, boss, true);
            boolean victory = combat.start();
            if (victory) {
                System.out.println("Félicitations ! Vous avez vaincu le boss !");
                gameRunning = false; // Fin du jeu
            } else {
                System.out.println("Le boss vous a vaincu...");
                gameRunning = false; // Fin du jeu, mais le joueur a perdu
            }
        } else if (this.caseEvent == '❂') {
            loadShopRoom();
        } else if (this.caseEvent == '€') {
            Trade trade = new Trade(player);
            trade.start();
        } else {
            System.out.println("Erreur : événement inconnu");
        }

        // Après le combat, modifier la grille pour enlever l'ennemi
        grid[player.getX()][player.getY()] = "@";
    }

    /**
     * Charge une salle de boss et met à jour la grille et le contexte de jeu.
     */
    private void loadBossRoom() {
        this.currentRoom = new BossRoom();
        this.currentRoom.createGrid(this.player);
        this.movement.setRoom(currentRoom); // Positionner le joueur dans la salle de boss
        this.grid = currentRoom.getGrid();

        System.out.println("Vous êtes entré dans la salle de boss ! Préparez-vous au combat final.");
        if (!player.isAlive()) {
            System.out.println("Vous avez été vaincu par le boss...");
            gameRunning = false; // Fin du jeu
        }

    }

    /**
     * Charge une salle de boutique et met à jour la grille et le contexte de jeu.
     */
    private void loadShopRoom() {
        this.currentRoom = new ShopRoom();
        this.currentRoom.createGrid(this.player);
        this.movement.setRoom(currentRoom);
        this.grid = currentRoom.getGrid();

        System.out.println("Vous êtes entré dans la salle de la boutique !");
    }

    /**
     * Charge le texte d'introduction du jeu et présente les instructions de base.
     * 
     * @return Une chaîne contenant le message d'introduction.
     */
    private String loadIntroduction() {
        chooseCharacter();
        System.out.println("Bienvenue dans le mini-RPG !\n"
                + "Vous incarnez un " + ((Joueur) this.player).getClasseType()
                + " qui doit explorer un donjon et en battre le boss afin de sortir.\n"
                + "Déplacez-vous avec les touches ZQSD, et appuyez sur E pour quitter le jeu.\n"
                + "A tout moment, appuyez sur I pour afficher les informations de votre personnage.\n"
                + "Trouvez la salle du boss pour terminer le jeu !\n");

        return "Vous êtes prêt à commencer l'aventure !";
    }

    /**
     * Permet au joueur de choisir son personnage en entrant son nom et en
     * sélectionnant une classe.
     */
    public void chooseCharacter() {

        System.out.println("Choisissez le nom de votre personnage :");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        System.out.println(
                "\nBienvenue dans le donjon, aventurier " + name + " !\n\n");
        System.out
                .println(
                        "\nAfin que vous puissiez choisir votre personnage, voici les règles de combat dans le donjon : \n");
        attendreEntree(scanner);
        System.out.println(
                "\n- Un combat se déclenche que vous rencontrez un ennemi symbolisé par '▵' ou '☠'");
        attendreEntree(scanner);
        System.out.println(
                "\n- Un combat se termine par la mort du personnage principal ou de l'ennemi.");
        attendreEntree(scanner);
        System.out.println("\n- Vous avez 120 points de vie au début du jeu.");
        attendreEntree(scanner);
        System.out.println("\n- En combat 4 choix s'offre à vous.");
        attendreEntree(scanner);
        System.out.println(
                "\n      1. Attaquer : inflige des dégâts à l'ennemi.\nLes dégâts infligés sont égaux à votre attaque moins la défense de l'ennemi.\nAcheter des armes pour augmenter votre attaque.");
        attendreEntree(scanner);
        System.out.println(
                "\n      2. Esquiver : vous avez une chance d'éviter les dégâts de l'ennemi. Cette chance dépend de la classe choisie. Si vous réussissez, vous infligez des dégats supplémentaires à votre prochain coup.");
        attendreEntree(scanner);
        System.out.println(
                "\n      3. Se défendre : Vous avez une chance de réduire les dégâts de l'ennemi de 50%. Cette chance dépend de la classe choisie.");
        attendreEntree(scanner);
        System.out.println(
                "\n      4. Fuir : vous avez une de chance de fuir le combat. Cette chance dépend de la classe choisie. Si vous réussissez, vous ne gagnez pas d'argent.");
        attendreEntree(scanner);
        System.out.println(
                "\n- Vous gagnez 10$ à chaque combat gagné.");
        attendreEntree(scanner);
        System.out.println("    1. Barbare \n " +
                "Le barbare est un gerrier brutal qui est très polyvalent." +
                "Il a une chance de 60% d'esquiver les attaques ennemies, 40% de se défendre et 90% de fuir le combat. Si il réussi à esquiver, il inflige 2 points de dégâts supplémentaires.");
        attendreEntree(scanner);
        System.out.println("    2. Troll\n" +
                "Le troll est un guerrier robuste qui est très résistant." +
                "Il a une chance de 40% d'esquiver les attaques ennemies, 85% de se défendre et 80% de fuir le combat. Si il réussi à esquiver, il inflige 2 points de dégâts supplémentaires.");
        attendreEntree(scanner);
        System.out.println("    3. Voleur\n" +
                "Le voleur est un guerrier agile qui est très rapide." +
                "Il a une chance de 75% d'esquiver les attaques ennemies, 35% de se défendre et 100% de fuir le combat. Si il réussi à esquiver, il inflige 8 points de dégâts supplémentaires.");

        System.out.println("\nChoisissez votre classe en entrant le nombre correspondant :");

        int choice = -1; // Valeur par défaut pour détecter un choix invalide
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Votre choix : ");
            String input = scanner.nextLine(); // Lire l'entrée utilisateur en tant que chaîne
            try {
                choice = Integer.parseInt(input); // Essayer de convertir en entier
                if (choice < 1 || choice > 3) {
                    throw new NumberFormatException(); // Lancer une exception si le choix est invalide
                }
                validInput = true; // Si la conversion réussit, l'entrée est valide
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entre 1 et 3.");
            }
        }
        switch (choice) {
            case 1:
                this.player = new Joueur(name, Joueur.ClasseType.BARBARE);
                this.movement = new Movement(this.player, this.currentRoom);
                break;
            case 2:
                this.player = new Joueur(name, Joueur.ClasseType.TROLL);
                this.movement = new Movement(this.player, this.currentRoom);
                break;
            case 3:
                this.player = new Joueur(name, Joueur.ClasseType.VOLEUR);
                this.movement = new Movement(this.player, this.currentRoom);
                break;
            default:
                System.out.println("Classe invalide.");
        }
        this.player.setX(1);
        this.player.setY(0);
    }

    /**
     * Attend que le joueur appuie sur la touche Entrée pour continuer. Et permet de
     * clear le buffer
     */
    private void attendreEntree(Scanner scanner) {
        scanner.nextLine();
    }

    /**
     * Point d'entrée principal du programme.
     * Démarre le jeu.
     * 
     * @param args Les arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        Game game = new Game();
    }

}
