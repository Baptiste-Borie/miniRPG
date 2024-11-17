package miniRPG.Items.Weapon;

/**
 * Classe Hammer représente un marteau dans le miniRPG.
 * Elle hérite de la classe abstraite {@link Weapon} et implémente
 * le comportement spécifique de l'attaque avec un marteau.
 * 
 * Le marteau est caractérisé par des dégâts élevés et un prix supérieur.
 * 
 * @autor Baptiste Borie
 */
public class Hammer extends Weapon {

    /**
     * Dégâts infligés par le marteau.
     */
    private static final int DAMAGE = 30;

    /**
     * Prix du marteau en monnaie du jeu.
     */
    private static final int PRICE = 30;

    /**
     * Constructeur de la classe Hammer.
     * Initialise le marteau avec ses dégâts, son nom, et son prix.
     */
    public Hammer() {
        super(DAMAGE, "Hammer", PRICE);
    }

    /**
     * Action spécifique du marteau lors d'une attaque.
     * Affiche un message indiquant que le marteau est utilisé.
     */
    @Override
    public void attack() {
        System.out.println("Swing hammer");
    }
}
