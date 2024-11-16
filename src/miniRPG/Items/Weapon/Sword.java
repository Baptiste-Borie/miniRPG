package miniRPG.Items.Weapon;

/**
 * Classe Sword représente une épée dans le miniRPG.
 * Elle hérite de la classe abstraite {@link Weapon} et implémente
 * le comportement spécifique de l'attaque avec une épée.
 * 
 * L'épée est caractérisée par des dégâts fixes et un prix défini.
 * 
 * @author Baptiste Borie
 */
public class Sword extends Weapon {

    /**
     * Dégâts infligés par l'épée.
     */
    private static final int DAMAGE = 10;

    /**
     * Prix de l'épée en monnaie du jeu.
     */
    private static final int PRICE = 10;

    /**
     * Constructeur de la classe Sword.
     * Initialise l'épée avec ses dégâts, son nom, et son prix.
     */
    public Sword() {
        super(DAMAGE, "Sword", PRICE);
    }

    /**
     * Action spécifique de l'épée lors d'une attaque.
     * Affiche un message indiquant que l'épée est utilisée.
     */
    @Override
    public void attack() {
        System.out.println("Swing sword");
    }
}
