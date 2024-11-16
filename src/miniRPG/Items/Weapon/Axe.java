package miniRPG.Items.Weapon;

/**
 * Classe Axe représente une hache dans le miniRPG.
 * Elle hérite de la classe abstraite {@link Weapon} et implémente
 * le comportement spécifique de l'attaque avec une hache.
 * 
 * La hache est caractérisée par des dégâts modérés et un prix raisonnable.
 * 
 * @author Baptiste Borie
 */
public class Axe extends Weapon {

    /**
     * Dégâts infligés par la hache.
     */
    private static final int DAMAGE = 15;

    /**
     * Prix de la hache en monnaie du jeu.
     */
    private static final int PRICE = 20;

    /**
     * Constructeur de la classe Axe.
     * Initialise la hache avec ses dégâts, son nom, et son prix.
     */
    public Axe() {
        super(DAMAGE, "Axe", PRICE);
    }

    /**
     * Action spécifique de la hache lors d'une attaque.
     * Affiche un message indiquant que la hache est utilisée.
     */
    @Override
    public void attack() {
        System.out.println("Swing axe");
    }
}
