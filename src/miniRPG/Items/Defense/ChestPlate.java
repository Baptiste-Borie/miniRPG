package miniRPG.Items.Defense;

/**
 * Classe ChestPlate représente une plastron dans le miniRPG.
 * Elle hérite de la classe abstraite {@link Defense}.
 * 
 * Le plastron offre une défense modérée pour un prix accessible.
 * 
 * @author Baptiste Borie
 */
public class ChestPlate extends Defense {

    /**
     * Valeur de défense offerte par le plastron.
     */
    private static final int DEFENSE = 10;

    /**
     * Prix du plastron en monnaie du jeu.
     */
    private static final int PRICE = 10;

    /**
     * Constructeur de la classe ChestPlate.
     * Initialise le plastron avec ses caractéristiques de défense, son nom, et son
     * prix.
     */
    public ChestPlate() {
        super(DEFENSE, "ChestPlate", PRICE);
    }
}
