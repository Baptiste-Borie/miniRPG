package miniRPG.Items.Defense;

import miniRPG.Items.Item;

/**
 * Classe abstraite Defense représente un objet de défense dans le miniRPG.
 * Elle implémente l'interface {@link Item} et fournit les propriétés et
 * comportements communs
 * à toutes les défenses, telles que la valeur de défense, le nom, et le prix.
 * 
 * Chaque sous-classe peut ajouter des comportements spécifiques.
 * 
 * @author Baptiste Borie
 */
public abstract class Defense implements Item {

    /**
     * Valeur de défense offerte par l'objet.
     */
    private int defense;

    /**
     * Nom de l'objet de défense.
     */
    private String name;

    /**
     * Prix de l'objet en monnaie du jeu.
     */
    private int price;

    /**
     * Constructeur de la classe Defense.
     * Initialise un objet de défense avec sa valeur, son nom, et son prix.
     *
     * @param defense La valeur de défense de l'objet.
     * @param name    Le nom de l'objet.
     * @param price   Le prix de l'objet.
     */
    public Defense(int defense, String name, int price) {
        this.defense = defense;
        this.name = name;
        this.price = price;
    }

    /**
     * Obtient la valeur de défense de l'objet.
     *
     * @return La valeur de défense.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Obtient le nom de l'objet.
     *
     * @return Le nom de l'objet.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtient le prix de l'objet.
     *
     * @return Le prix de l'objet.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Définit une nouvelle valeur de défense pour l'objet.
     *
     * @param defense La nouvelle valeur de défense.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Définit un nouveau nom pour l'objet.
     *
     * @param name Le nouveau nom.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Définit un nouveau prix pour l'objet.
     *
     * @param price Le nouveau prix.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Retourne le type de l'objet, ici "Defense".
     *
     * @return Une chaîne représentant le type de l'objet.
     */
    @Override
    public String getType() {
        return "Defense";
    }

    /**
     * Retourne la puissance de l'objet, équivalente à sa valeur de défense.
     *
     * @return La puissance de l'objet.
     */
    @Override
    public int getPower() {
        return this.defense;
    }

    /**
     * Représente l'objet sous forme de chaîne de caractères.
     *
     * @return Une chaîne décrivant l'objet avec son nom, sa valeur de défense, et
     *         son prix.
     */
    @Override
    public String toString() {
        return this.name + " : " + this.defense + " DEF ----- " + this.price + "$";
    }
}
