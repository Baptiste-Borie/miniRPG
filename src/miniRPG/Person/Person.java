package miniRPG.Person;

import miniRPG.Items.Defense.Defense;
import miniRPG.Items.Weapon.Weapon;

/**
 * Classe abstraite Person représente un personnage dans le miniRPG.
 * Elle sert de classe de base pour les joueurs et les ennemis,
 * avec des attributs et des méthodes communs tels que les statistiques,
 * la position, et les équipements.
 * 
 * @author Baptiste Borie
 */
public abstract class Person {

    /**
     * Points de vie du personnage.
     */
    private int health;

    /**
     * Position X du personnage sur la grille.
     */
    private int X;

    /**
     * Position Y du personnage sur la grille.
     */
    private int Y;

    /**
     * Valeur d'attaque du personnage.
     */
    private int attack;

    /**
     * Valeur d'armure du personnage.
     */
    private int armor;

    /**
     * Équipement de défense du personnage.
     */
    private Defense defense;

    /**
     * Arme du personnage.
     */
    private Weapon weapon;

    /**
     * Nom du personnage.
     */
    private String name;

    /**
     * Représentation ASCII du personnage.
     */
    private String ascii;

    /**
     * Obtient la position X du personnage.
     *
     * @return La position X actuelle.
     */
    public int getX() {
        return this.X;
    }

    /**
     * Obtient la position Y du personnage.
     *
     * @return La position Y actuelle.
     */
    public int getY() {
        return this.Y;
    }

    /**
     * Obtient les points de vie actuels du personnage.
     *
     * @return Les points de vie actuels.
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Obtient le nom du personnage.
     *
     * @return Le nom du personnage.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Obtient la représentation ASCII du personnage.
     *
     * @return Le symbole ASCII du personnage.
     */
    public String getAscii() {
        return this.ascii;
    }

    /**
     * Obtient la valeur d'attaque du personnage.
     *
     * @return La valeur d'attaque actuelle.
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * Obtient la valeur d'armure du personnage.
     *
     * @return La valeur d'armure actuelle.
     */
    public int getArmor() {
        return this.armor;
    }

    /**
     * Définit une nouvelle position X pour le personnage.
     *
     * @param newX La nouvelle position X.
     */
    public void setX(int newX) {
        this.X = newX;
    }

    /**
     * Définit une nouvelle position Y pour le personnage.
     *
     * @param newY La nouvelle position Y.
     */
    public void setY(int newY) {
        this.Y = newY;
    }

    /**
     * Définit les points de vie du personnage.
     *
     * @param newHP Les nouveaux points de vie.
     */
    public void setHealth(int newHP) {
        this.health = newHP;
    }

    /**
     * Définit le nom du personnage.
     *
     * @param newName Le nouveau nom.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Définit la représentation ASCII du personnage.
     *
     * @param newAscii Le nouveau symbole ASCII.
     */
    public void setAscii(String newAscii) {
        this.ascii = newAscii;
    }

    /**
     * Définit la valeur d'attaque du personnage.
     *
     * @param newAttack La nouvelle valeur d'attaque.
     */
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }

    /**
     * Définit la valeur d'armure du personnage.
     *
     * @param newArmor La nouvelle valeur d'armure.
     */
    public void setArmor(int newArmor) {
        this.armor = newArmor;
    }

    /**
     * Applique des dégâts au personnage en réduisant ses points de vie.
     *
     * @param damageTaken La quantité de dégâts reçus.
     */
    public void takeDamage(int damageTaken) {
        this.health -= damageTaken;
    }

    /**
     * Représente le personnage sous forme de chaîne de caractères.
     *
     * @return Une chaîne contenant le nom, le symbole ASCII, et les points de vie.
     */
    @Override
    public String toString() {
        return this.name + " (" + this.ascii + ") : " + this.health + " HP";
    }

    /**
     * Vérifie si le personnage est toujours en vie.
     *
     * @return {@code true} si le personnage a des points de vie supérieurs à 0,
     *         {@code false} sinon.
     */
    public boolean isAlive() {
        return this.health > 0;
    }

    /**
     * Obtient la valeur d'attaque du personnage pour une action offensive.
     *
     * @return La valeur d'attaque actuelle.
     */
    public int attack() {
        return this.attack;
    }
}
