package miniRPG.Items.Potions;

import miniRPG.Items.Item;
import miniRPG.Person.Joueur;

public abstract class Potions implements Item {

    private int effect;

    /**
     * Nom de l'arme.
     */
    private String name;

    /**
     * Prix de l'arme en monnaie du jeu.
     */
    private int price;

    /**
     * Constructeur de la classe Weapon.
     * Initialise les propriétés de base d'une arme.
     *
     * @param effect Les dégâts infligés par l'arme.
     * @param name   Le nom de l'arme.
     * @param price  Le prix de l'arme.
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
     * Obtient le nom de l'arme.
     *
     * @return Le nom de l'arme.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Obtient le prix de l'arme.
     *
     * @return Le prix de l'arme.
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Définit les dégâts de l'arme.
     *
     * @param damage Les nouveaux dégâts de l'arme.
     */
    public void setEffect(int damage) {
        this.effect = damage;
    }

    /**
     * Définit le nom de l'arme.
     *
     * @param name Le nouveau nom de l'arme.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Définit le prix de l'arme.
     *
     * @param price Le nouveau prix de l'arme.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Retourne le type de l'objet, ici "Weapon".
     *
     * @return Une chaîne représentant le type de l'objet.
     */
    @Override
    public String getType() {
        return "Potions";
    }

    /**
     * Retourne la puissance de l'arme, équivalente à ses dégâts.
     *
     * @return La puissance de l'arme.
     */
    @Override
    public int getPower() {
        return this.effect;
    }

    /**
     * Méthode abstraite représentant l'action d'attaque avec l'arme.
     * Doit être implémentée par les sous-classes.
     */
    public abstract void applyPotion(Joueur Joueur);

    /**
     * Représente l'arme sous forme de chaîne de caractères.
     *
     * @return Une chaîne décrivant l'arme avec son nom, ses dégâts, et son prix.
     */
    @Override
    public String toString() {
        return this.name + " : " + this.effect + " Effect ----- " + this.price + "$";
    }
}