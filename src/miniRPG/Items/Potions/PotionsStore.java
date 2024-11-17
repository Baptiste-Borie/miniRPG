package miniRPG.Items.Potions;

import java.util.*;

/**
 * Classe PotionStore représente une boutique ou un stockage de potions
 * disponibles dans le miniRPG.
 * Elle permet d'ajouter, de modifier, et de récupérer des potions pour les
 * joueurs ou ennemis.
 * 
 * @author Baptiste Borie
 */
public class PotionsStore {

    /**
     * Liste des potions disponibles dans le stockage.
     */
    private ArrayList<Potions> Potions;

    /**
     * Constructeur de la classe PotionStore.
     * Initialise le stockage avec une liste de potions par défaut :
     * {@link HealthPotion}.
     */
    public PotionsStore() {
        this.Potions = new ArrayList<Potions>();
        this.Potions.add(new HealthPotion());
    }

    /**
     * Récupère une potion spécifique du stockage en fonction de son index.
     *
     * @param index L'index de la potion à récupérer.
     * @return La potion correspondant à l'index.
     */
    public Potions getPotion(int index) {
        return this.Potions.get(index);
    }

    /**
     * Récupère la liste complète des potions disponibles dans le stockage.
     *
     * @return Une liste d'objets {@link Potion}.
     */
    public ArrayList<Potions> getPotions() {
        return this.Potions;
    }

    /**
     * Modifie une potion spécifique dans le stockage.
     *
     * @param index  L'index de la potion à modifier.
     * @param Potion La nouvelle potion à placer à cet index.
     */
    public void setPotion(int index, Potions Potion) {
        this.Potions.set(index, Potion);
    }

    /**
     * Affiche la liste des potions disponibles dans le stockage.
     * Chaque potion est affichée avec son index et ses détails.
     *
     * @return La liste des potions.
     */
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.Potions.size(); i++) {
            res += i + " : " + this.Potions.get(i);
        }
        return res;
    }
}
