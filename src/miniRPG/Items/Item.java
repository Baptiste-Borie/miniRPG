package miniRPG.Items;

/**
 * Interface Item représente un objet générique dans le miniRPG.
 * Les objets implémentant cette interface doivent définir des méthodes
 * permettant de récupérer les informations essentielles de l'objet, telles que
 * son nom, son prix, son type, et sa puissance.
 * 
 * @author Baptiste Borie
 */
public interface Item {

    /**
     * Récupère le nom de l'objet.
     *
     * @return Le nom de l'objet.
     */
    public String getName();

    /**
     * Récupère le prix de l'objet.
     *
     * @return Le prix de l'objet.
     */
    public int getPrice();

    /**
     * Récupère le type de l'objet (par exemple, "Arme" ou "Défense").
     *
     * @return Le type de l'objet.
     */
    public String getType();

    /**
     * Récupère la puissance de l'objet.
     *
     * @return La puissance de l'objet.
     */
    public int getPower();
}
