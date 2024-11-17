package miniRPG.Items.Potions;

import miniRPG.Person.Joueur;

/**
 * Classe HealthPotion représente une potion de soin dans le miniRPG.
 * Elle hérite de la classe abstraite {@link Potions} et implémente
 * le comportement spécifique des potions.
 * 
 * Cette potion rend toute sa vie au personnage.
 * 
 * @author Baptiste Borie
 */
public class HealthPotion extends Potions {

    /**
     * Montant soigné par la potion.
     */
    private static final int EFFECT = 120;

    /**
     * Prix de la potion en monnaie du jeu.
     */
    private static final int PRICE = 5;

    /**
     * Constructeur de la classe HealthPotion.
     * Initialise la potion avec ses effets, son nom, et son prix.
     */
    public HealthPotion() {
        super(EFFECT, "Potion de soin", PRICE);
    }

    /**
     * Action spécifique de la potion lors de l'achat de la potion.
     * Affiche un message indiquant que la potion est utilisée.
     */
    @Override
    public void applyPotion(Joueur joueur) {
        joueur.setHealth(this.getEffect());
    }
}
