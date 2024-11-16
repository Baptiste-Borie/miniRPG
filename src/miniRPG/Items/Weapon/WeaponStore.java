package miniRPG.Items.Weapon;

import java.util.*;

/**
 * Classe WeaponStore représente une boutique ou un stockage d'armes
 * disponibles dans le miniRPG.
 * Elle permet d'ajouter, de modifier, et de récupérer des armes pour les
 * joueurs ou ennemis.
 * 
 * @author Baptiste Borie
 */
public class WeaponStore {

    /**
     * Liste des armes disponibles dans le stockage.
     */
    private ArrayList<Weapon> weapons;

    /**
     * Constructeur de la classe WeaponStore.
     * Initialise le stockage avec une liste d'armes par défaut :
     * {@link Fists}, {@link Sword}, {@link Axe}, {@link Hammer}.
     */
    public WeaponStore() {
        this.weapons = new ArrayList<Weapon>();
        this.weapons.add(new Fists());
        this.weapons.add(new Sword());
        this.weapons.add(new Axe());
        this.weapons.add(new Hammer());
    }

    /**
     * Récupère une arme spécifique du stockage en fonction de son index.
     *
     * @param index L'index de l'arme à récupérer.
     * @return L'arme correspondant à l'index.
     */
    public Weapon getWeapon(int index) {
        return this.weapons.get(index);
    }

    /**
     * Récupère la liste complète des armes disponibles dans le stockage.
     *
     * @return Une liste d'objets {@link Weapon}.
     */
    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    /**
     * Modifie une arme spécifique dans le stockage.
     *
     * @param index  L'index de l'arme à modifier.
     * @param weapon La nouvelle arme à placer à cet index.
     */
    public void setWeapon(int index, Weapon weapon) {
        this.weapons.set(index, weapon);
    }

    /**
     * Affiche la liste des armes disponibles dans le stockage.
     * Chaque arme est affichée avec son index et ses détails.
     *
     * @return La liste des armes.
     */
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.weapons.size(); i++) {
            res += i + " : " + this.weapons.get(i);
        }
        return res;
    }
}
