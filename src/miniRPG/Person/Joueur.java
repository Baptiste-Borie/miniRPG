package miniRPG.Person;

import miniRPG.Items.Weapon.*;
import miniRPG.Items.Defense.*;

/**
 * Classe Joueur représente le personnage principal contrôlé par le joueur.
 * Cette classe hérite de {@link Person} et ajoute des attributs spécifiques
 * comme l'argent, les chances d'esquive, de défense, de fuite, et un boost de
 * dégâts.Le joueur peut choisir parmi différentes classes ayant des
 * caractéristiques uniques.
 * 
 * @author Baptiste Borie
 */
public class Joueur extends Person {

    /**
     * Chance d'esquiver une attaque.
     */
    private int dodgeChance;

    /**
     * Chance d'utiliser une défense.
     */
    private int defenseChance;

    /**
     * Chance de fuir un combat.
     */
    private int fleeChance;

    /**
     * Multiplicateur de dégâts bonus.
     */
    private int boostDamage;

    /**
     * Points de vie initiaux du joueur.
     */
    private static final int LIFE = 120;

    /**
     * Position X du joueur sur la grille.
     */
    private int X;

    /**
     * Position Y du joueur sur la grille.
     */
    private int Y;

    /**
     * Argent du joueur.
     */
    private int money;

    /**
     * Équipement de défense du joueur.
     */
    private Defense defense;

    /**
     * Arme du joueur.
     */
    private Weapon weapon;

    /**
     * Classe du joueur (Barbare, Troll, ou Voleur).
     */
    private ClasseType classe;

    /**
     * Enumération pour les types de classes disponibles.
     */
    public enum ClasseType {
        BARBARE,
        TROLL,
        VOLEUR
    }

    /**
     * Constructeur de la classe Joueur.
     *
     * @param nom    Le nom du joueur.
     * @param classe La classe choisie par le joueur ({@link ClasseType}).
     */
    public Joueur(String nom, ClasseType classe) {
        super();
        setName(nom);
        setAscii("@");
        this.setHealth(LIFE);
        this.weapon = new Sword();
        this.defense = new Shield();
        this.classe = classe;
        this.setWeapon(this.weapon);
        this.setDefense(this.defense);
        this.X = 0;
        this.Y = 1;
        this.money = 35;

        // Initialisation des attributs en fonction de la classe choisie
        switch (classe) {
            case BARBARE:
                this.dodgeChance = 60;
                this.defenseChance = 40;
                this.fleeChance = 90;
                this.boostDamage = 2;
                break;
            case TROLL:
                this.dodgeChance = 40;
                this.defenseChance = 85;
                this.fleeChance = 80;
                this.boostDamage = 2;
                break;
            case VOLEUR:
                this.dodgeChance = 75;
                this.defenseChance = 35;
                this.fleeChance = 100;
                this.boostDamage = 8;
                break;
        }
    }

    // Méthodes de mouvement

    /**
     * Déplace le joueur vers le haut.
     */
    public void moveUp() {
        this.setY(Y--);
    }

    /**
     * Déplace le joueur vers le bas.
     */
    public void moveDown() {
        this.setY(Y++);
    }

    /**
     * Déplace le joueur vers la gauche.
     */
    public void moveLeft() {
        this.setX(X--);
    }

    /**
     * Déplace le joueur vers la droite.
     */
    public void moveRight() {
        this.setX(X++);
    }

    /**
     * Obtient l'argent actuel du joueur.
     *
     * @return Le montant d'argent du joueur.
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Définit l'argent du joueur.
     *
     * @param money Le montant d'argent à définir.
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Ajoute de l'argent au joueur.
     *
     * @param money Le montant d'argent à ajouter.
     */
    public void addMoney(int money) {
        this.money += money;
    }

    /**
     * Obtient l'arme actuelle du joueur.
     *
     * @return L'arme du joueur.
     */
    public Weapon getWeapon() {
        return this.weapon;
    }

    /**
     * Définit une nouvelle arme pour le joueur.
     * Met à jour la valeur d'attaque en fonction des dégâts de l'arme.
     *
     * @param weapon La nouvelle arme à équiper.
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.setAttack(weapon.getDamage());
    }

    /**
     * Définit une nouvelle défense pour le joueur.
     * Met à jour la valeur d'armure en fonction de la défense.
     *
     * @param defense La nouvelle défense à équiper.
     */
    public void setDefense(Defense defense) {
        this.defense = defense;
        this.setArmor(defense.getDefense());
    }

    /**
     * Obtient la chance d'esquive du joueur.
     *
     * @return La chance d'esquive .
     */
    public int getDodgeChance() {
        return this.dodgeChance;
    }

    /**
     * Obtient la chance de défense du joueur.
     *
     * @return La chance de défense .
     */
    public int getDefenseChance() {
        return this.defenseChance;
    }

    /**
     * Obtient la chance de fuite du joueur.
     *
     * @return La chance de fuite .
     */
    public int getFleeChance() {
        return this.fleeChance;
    }

    /**
     * Obtient le boost de dégâts du joueur.
     *
     * @return Le multiplicateur de dégâts bonus.
     */
    public int getBoostDamage() {
        return this.boostDamage;
    }

    /**
     * Obtient la classe du joueur sous forme de chaîne.
     *
     * @return Le type de classe ({@link ClasseType}) en chaîne de caractères.
     */
    public String getClasseType() {
        return this.classe.toString();
    }
}
