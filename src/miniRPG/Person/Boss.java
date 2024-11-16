package miniRPG.Person;

/**
 * Classe Boss représente le boss du jeu.
 * Cette classe hérite de {@link Person} et initialise un boss avec des
 * caractéristiques prédéfinies (vie, attaque, défense et représentation ASCII).
 * 
 * @author Baptiste Borie
 */
public class Boss extends Person {

    /**
     * Points de vie initiaux du boss.
     */
    private static final int LIFE = 150;

    /**
     * Valeur d'attaque du boss.
     */
    private static final int ATTACK = 40;

    /**
     * Valeur de défense du boss.
     */
    private static final int DEFENSE = 20;

    /**
     * Constructeur de la classe Boss.
     * Initialise un boss avec un nom, des statistiques (vie, attaque, défense)
     * et un symbole ASCII pour sa représentation visuelle.
     */
    public Boss() {
        this.setName("BOSS");
        this.setHealth(LIFE);
        this.setAttack(ATTACK);
        this.setArmor(DEFENSE);
        this.setAscii("☠");
    }

}
