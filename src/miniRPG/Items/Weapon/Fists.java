package miniRPG.Items.Weapon;

/**
 * Classe Fists représente les poings nus dans le miniRPG.
 * Elle hérite de la classe abstraite {@link Weapon} et implémente
 * le comportement spécifique d'une attaque avec les poings.
 * 
 * Les poings ont des dégâts faibles mais sont gratuits.
 * 
 * @author Baptiste Borie
 */
public class Fists extends Weapon {

    /**
     * Dégâts infligés par les poings.
     */
    private static final int DAMAGE = 5;

    /**
     * Prix des poings (gratuit).
     */
    private static final int PRICE = 0;

    /**
     * Constructeur de la classe Fists.
     * Initialise les poings avec leurs dégâts et leur prix.
     */
    public Fists() {
        super(DAMAGE, "Fists", PRICE);
    }

    /**
     * Action spécifique des poings lors d'une attaque.
     * Affiche un message indiquant que les poings sont utilisés.
     */
    @Override
    public void attack() {
        System.out.println("Fist bump");
    }
}
