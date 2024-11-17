package miniRPG.Items.Potions;

import miniRPG.Person.Joueur;

/**
 * Classe Axe représente une hache dans le miniRPG.
 * Elle hérite de la classe abstraite {@link Weapon} et implémente
 * le comportement spécifique de l'attaque avec une hache.
 * 
 * La hache est caractérisée par des dégâts modérés et un prix raisonnable.
 * 
 * @author Baptiste Borie
 */
public class HealthPotion extends Potions {

    /**
     * Dégâts infligés par la hache.
     */
    private static final int EFFECT = 120;

    /**
     * Prix de la hache en monnaie du jeu.
     */
    private static final int PRICE = 5;

    /**
     * Constructeur de la classe Axe.
     * Initialise la hache avec ses dégâts, son nom, et son prix.
     */
    public HealthPotion() {
        super(EFFECT, "Potion de soin", PRICE);
    }

    /**
     * Action spécifique de la hache lors d'une attaque.
     * Affiche un message indiquant que la hache est utilisée.
     */
    @Override
    public void applyPotion(Joueur joueur) {
        joueur.setHealth(this.getEffect());
    }
}
