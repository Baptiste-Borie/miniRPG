package miniRPG.Items.Potions;

import java.util.*;

/**
 * Classe PotionStore représente une boutique ou un stockage d'armes
 * disponibles dans le miniRPG.
 * Elle permet d'ajouter, de modifier, et de récupérer des armes pour les
 * joueurs ou ennemis.
 * 
 * @author Baptiste Borie
 */
public class PotionsStore {

    /**
     * Liste des armes disponibles dans le stockage.
     */
    private ArrayList<Potions> Potions;

    /**
     * Constructeur de la classe PotionStore.
     * Initialise le stockage avec une liste d'armes par défaut :
     * {@link Fists}, {@link Sword}, {@link Axe}, {@link Hammer}.
     */
    public PotionsStore() {
        this.Potions = new ArrayList<Potions>();
        this.Potions.add(new HealthPotion());
    }

    /**
     * Récupère une arme spécifique du stockage en fonction de son index.
     *
     * @param index L'index de l'arme à récupérer.
     * @return L'arme correspondant à l'index.
     */
    public Potions getPotion(int index) {
        return this.Potions.get(index);
    }

    /**
     * Récupère la liste complète des armes disponibles dans le stockage.
     *
     * @return Une liste d'objets {@link Potion}.
     */
    public ArrayList<Potions> getPotions() {
        return this.Potions;
    }

    /**
     * Modifie une arme spécifique dans le stockage.
     *
     * @param index  L'index de l'arme à modifier.
     * @param Potion La nouvelle arme à placer à cet index.
     */
    public void setPotion(int index, Potions Potion) {
        this.Potions.set(index, Potion);
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
        for (int i = 0; i < this.Potions.size(); i++) {
            res += i + " : " + this.Potions.get(i);
        }
        return res;
    }
}
