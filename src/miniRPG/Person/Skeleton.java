package miniRPG.Person;

/**
 * Classe Skeleton représente un squelette, un ennemi de base dans le miniRPG.
 * Cette classe hérite de {@link Person} et initialise un squelette avec des
 * caractéristiques prédéfinies (vie, attaque, défense et représentation ASCII).
 * 
 * @author Baptiste Borie
 */
public class Skeleton extends Person {

    /**
     * Points de vie initiaux du squelette.
     */
    private static final int LIFE = 30;

    /**
     * Valeur d'attaque du squelette.
     */
    private static final int ATTACK = 8;

    /**
     * Valeur de défense du squelette.
     */
    private static final int DEFENSE = 2;

    /**
     * Constructeur de la classe Skeleton.
     * Initialise un squelette avec un nom, des statistiques (vie, attaque, défense)
     * et un symbole ASCII pour sa représentation visuelle.
     */
    public Skeleton() {
        this.setName("Skeleton");
        this.setHealth(LIFE);
        this.setAttack(ATTACK);
        this.setArmor(DEFENSE);
        this.setAscii("▵");
    }

}
