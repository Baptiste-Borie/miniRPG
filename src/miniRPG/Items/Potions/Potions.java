package miniRPG.Items.Potions;

import miniRPG.Items.Item;
import miniRPG.Person.Joueur;

public abstract class Potions implements Item {

    private int effect;

    /**
     * Nom de la potion.
     */
    private String name;

    /**
     * Prix de la potion en monnaie du jeu.
     */
    private int price;

    /**
     * Constructeur de la classe Potions.
     * Initialise les propriétés de base d'une arme.
     *
     * @param effect Les effets dela potion.
     * @param name   Le nom de la potion.
     * @param price  Le prix de la potion.
     */
    public Potions(int effect, String name, int price) {
        this.effect = effect;
        this.name = name;
        this.price = price;
    }

    /**
     * Obtient les effets de la potion.
     *
     * @return Les effets de la potions.
     */
    public int getEffect() {
        return this.effect;
    }

    /**
     * Obtient le nom de la potion.
     *
     * @return Le nom de la potion.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Obtient le prix de la potion.
     *
     * @return Le prix de la potion.
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Définit les effets de la potion.
     *
     * @param effects Les nouveaux effets de la potion.
     */
    public void setEffect(int effects) {
        this.effect = effects;
    }

    /**
     * Définit le nom de la potion.
     *
     * @param name Le nouveau nom de la potion.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Définit le prix de la potion.
     *
     * @param price Le nouveau prix de la potion.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Retourne le type de l'objet, ici "Potion".
     *
     * @return Une chaîne représentant le type de l'objet.
     */
    @Override
    public String getType() {
        return "Potions";
    }

    /**
     * Retourne la puissance de la potion, équivalente à ses effets.
     *
     * @return La puissance de la potion.
     */
    @Override
    public int getPower() {
        return this.effect;
    }

    /**
     * Méthode abstraite représentant l'action de consommer une potion.
     * Doit être implémentée par les sous-classes.
     */
    public abstract void applyPotion(Joueur Joueur);

    /**
     * Représente la potion sous forme de chaîne de caractères.
     *
     * @return Une chaîne décrivant la potion avec son nom, ses effets, et son prix.
     */
    @Override
    public String toString() {
        return this.name + " : " + this.effect + " Effect ----- " + this.price + "$";
    }
}
