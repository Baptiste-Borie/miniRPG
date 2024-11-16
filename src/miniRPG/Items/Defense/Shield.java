package miniRPG.Items.Defense;

/**
 * Classe Shield représente un bouclier dans le miniRPG.
 * Elle hérite de la classe abstraite {@link Defense}.
 * 
 * Le bouclier offre une défense modérée pour un coût raisonnable.
 * 
 * @author Baptiste Borie
 */
public class Shield extends Defense {

    /**
     * Valeur de défense offerte par le bouclier.
     */
    private static final int DEFENSE = 10;

    /**
     * Prix du bouclier en monnaie du jeu.
     */
    private static final int PRICE = 5;

    /**
     * Constructeur de la classe Shield.
     * Initialise le bouclier avec ses caractéristiques de défense, son nom, et son
     * prix.
     */
    public Shield() {
        super(DEFENSE, "shield", PRICE);
    }
}
