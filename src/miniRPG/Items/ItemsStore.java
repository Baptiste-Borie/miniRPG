package miniRPG.Items;

import java.util.ArrayList;
import miniRPG.Items.Weapon.Weapon;
import miniRPG.Items.Weapon.WeaponStore;
import miniRPG.Items.Defense.Defense;
import miniRPG.Items.Defense.DefenseStore;
import miniRPG.Items.Potions.Potions;
import miniRPG.Items.Potions.PotionsStore;

/**
 * Classe ItemsStore représente une boutique regroupant des armes et des
 * défenses.
 * Cette classe centralise la gestion des objets disponibles pour le joueur.
 * 
 * @author Baptiste Borie
 */
public class ItemsStore {

    /**
     * Liste des objets disponibles dans la boutique.
     */
    private ArrayList<Item> items;

    /**
     * Constructeur de la classe ItemsStore.
     * Initialise la boutique avec les objets provenant de {@link WeaponStore} et
     * {@link DefenseStore}.
     */
    public ItemsStore() {
        this.items = new ArrayList<Item>();
        WeaponStore weaponStore = new WeaponStore();
        DefenseStore defenseStore = new DefenseStore();
        PotionsStore potionsStore = new PotionsStore();
        this.addWeaponStore(weaponStore.getWeapons());
        this.addDefenseStore(defenseStore.getDefenses());
        this.addPotionsStore(potionsStore.getPotions());

    }

    /**
     * Ajoute une liste d'armes à la boutique.
     *
     * @param weapons Liste des armes à ajouter.
     */
    public void addWeaponStore(ArrayList<Weapon> weapons) {
        this.items.addAll(weapons);
    }

    /**
     * Ajoute une liste de défenses à la boutique.
     *
     * @param defenses Liste des défenses à ajouter.
     */
    public void addDefenseStore(ArrayList<Defense> defenses) {
        this.items.addAll(defenses);
    }

    /**
     * Ajoute une liste de potions à la boutique.
     *
     * @param potions Liste des potions à ajouter.
     */
    public void addPotionsStore(ArrayList<Potions> potions) {
        this.items.addAll(potions);
    }

    /**
     * Récupère un objet dans la boutique en fonction de son index.
     *
     * @param index L'index de l'objet dans la liste.
     * @return L'objet correspondant à l'index spécifié.
     */
    public Item getItem(int index) {
        return this.items.get(index);
    }

    /**
     * Affiche le contenu de la boutique.
     * Chaque objet est affiché avec son index, son type, sa puissance, son nom et
     * son prix.
     *
     * @return La liste des items dans la boutique avec leur prix.
     */
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.items.size(); i++) {
            res += i + " : " + this.items.get(i).getType() + "/" + this.items.get(i).getPower() + " - "
                    + this.items.get(i).getName() + " "
                    + this.items.get(i).getPrice() + " $" + "\n";
        }
        return res;
    }

    /**
     * Obtient le nombre total d'objets dans la boutique.
     *
     * @return Le nombre d'objets dans la boutique.
     */
    public int length() {
        return this.items.size();
    }

}
