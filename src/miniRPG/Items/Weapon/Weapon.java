package miniRPG.Items.Weapon;

import miniRPG.Items.Item;

/**
 * Classe abstraite Weapon représente une arme dans le miniRPG.
 * Elle implémente l'interface {@link Item} et fournit les propriétés et
 * comportements communs
 * à toutes les armes, telles que les dégâts, le nom, et le prix.
 * Chaque sous-classe doit définir la méthode abstraite {@code attack()}.
 * 
 * @author Baptiste Borie
 */
public abstract class Weapon implements Item {

    /**
     * Dégâts infligés par l'arme.
     */
    private int damage;

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
     * @param damage Les dégâts infligés par l'arme.
     * @param name   Le nom de l'arme.
     * @param price  Le prix de l'arme.
     */
    public Weapon(int damage, String name, int price) {
        this.damage = damage;
        this.name = name;
        this.price = price;
    }

    /**
     * Obtient les dégâts infligés par l'arme.
     *
     * @return Les dégâts de l'arme.
     */
    public int getDamage() {
        return this.damage;
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
    public void setDamage(int damage) {
        this.damage = damage;
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
        return "Weapon";
    }

    /**
     * Retourne la puissance de l'arme, équivalente à ses dégâts.
     *
     * @return La puissance de l'arme.
     */
    @Override
    public int getPower() {
        return this.damage;
    }

    /**
     * Méthode abstraite représentant l'action d'attaque avec l'arme.
     * Doit être implémentée par les sous-classes.
     */
    public abstract void attack();

    /**
     * Représente l'arme sous forme de chaîne de caractères.
     *
     * @return Une chaîne décrivant l'arme avec son nom, ses dégâts, et son prix.
     */
    @Override
    public String toString() {
        return this.name + " : " + this.damage + " DMG ----- " + this.price + "$";
    }
}
