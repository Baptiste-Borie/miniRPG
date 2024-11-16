package miniRPG.Items.Defense;

/**
 * Classe Armor représente une armure dans le miniRPG.
 * Elle hérite de la classe abstraite {@link Defense}.
 * 
 * L'armure offre une défense élevée pour un coût conséquent.
 * 
 * @author Baptiste Borie
 */
public class Armor extends Defense {

    /**
     * Valeur de défense offerte par l'armure.
     */
    private static final int DEFENSE = 20;

    /**
     * Prix de l'armure en monnaie du jeu.
     */
    private static final int PRICE = 35;

    /**
     * Constructeur de la classe Armor.
     * Initialise l'armure avec ses caractéristiques de défense, son nom, et son
     * prix.
     */
    public Armor() {
        super(DEFENSE, "Armor", PRICE);
    }
}
