package miniRPG.Items.Defense;

import java.util.*;

/**
 * Classe DefenseStore représente une boutique ou un stockage de défenses
 * disponibles dans le miniRPG.
 * Elle permet d'ajouter, de modifier, et de récupérer des objets de défense
 * pour les joueurs ou ennemis.
 * 
 * La boutique est initialisée avec une sélection par défaut de défenses.
 * 
 * @author Baptiste Borie
 */
public class DefenseStore {

    /**
     * Liste des défenses disponibles dans le stockage.
     */
    private ArrayList<Defense> defenses;

    /**
     * Constructeur de la classe DefenseStore.
     * Initialise le stockage avec une liste de défenses par défaut :
     * {@link Shield}, {@link ChestPlate}, et {@link Armor}.
     */
    public DefenseStore() {
        this.defenses = new ArrayList<Defense>();
        this.defenses.add(new Shield());
        this.defenses.add(new ChestPlate());
        this.defenses.add(new Armor());
    }

    /**
     * Récupère une défense spécifique du stockage en fonction de son index.
     *
     * @param index L'index de la défense à récupérer.
     * @return La défense correspondant à l'index.
     */
    public Defense getDefense(int index) {
        return this.defenses.get(index);
    }

    /**
     * Récupère la liste complète des défenses disponibles dans le stockage.
     *
     * @return Une liste d'objets {@link Defense}.
     */
    public ArrayList<Defense> getDefenses() {
        return this.defenses;
    }

    /**
     * Modifie une défense spécifique dans le stockage.
     *
     * @param index   L'index de la défense à modifier.
     * @param defense La nouvelle défense à placer à cet index.
     */
    public void setDefense(int index, Defense defense) {
        this.defenses.set(index, defense);
    }

    /**
     * Affiche la liste des défenses disponibles dans le stockage.
     * Chaque défense est affichée avec son index et ses détails.
     *
     * @return La liste des objets de defenses).
     */
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.defenses.size(); i++) {
            res += i + " : " + this.defenses.get(i);
        }
        return res;
    }

}
