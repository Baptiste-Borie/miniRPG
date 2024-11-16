package miniRPG.Event;

import java.util.Scanner;

import miniRPG.Items.*;
import miniRPG.Items.Defense.*;
import miniRPG.Items.Weapon.*;
import miniRPG.Person.*;

/**
 * Classe Trade représente un événement de commerce dans le miniRPG.
 * Elle permet au joueur d'acheter des objets (armes ou défenses) depuis une
 * boutique.
 * Le joueur peut interagir avec la boutique, acheter des objets selon son
 * budget, ou quitter le commerce.
 * 
 * @author Baptiste Borie
 */
public class Trade {

    /**
     * Le joueur participant au commerce.
     */
    private Joueur player;

    /**
     * La boutique contenant les objets disponibles à la vente.
     */
    private ItemsStore itemStore;

    /**
     * Indicateur de fin de commerce.
     */
    private boolean tradeOver;

    /**
     * Constructeur de la classe Trade.
     * Initialise l'événement de commerce avec un joueur et une boutique.
     *
     * @param player Le joueur participant au commerce.
     */
    public Trade(Person player) {
        this.player = (Joueur) player;
        this.itemStore = new ItemsStore();
        this.tradeOver = true;
    }

    /**
     * Démarre l'interaction de commerce.
     * Affiche les objets disponibles et permet au joueur d'acheter des objets
     * ou de quitter la boutique.
     */
    public void start() {
        System.out.println("Bienvenue dans la boutique !");
        System.out.println("Vous avez " + player.getMoney() + "$");
        System.out.println("Voici ce que j'ai pour vous :");
        System.out.println(itemStore);
        Scanner scanner = new Scanner(System.in);
        while (tradeOver) {
            System.out.println(
                    "Que voulez-vous faire ? (Entrez le numéro de l'item que vous voulez acheter ou q pour quitter)");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice < itemStore.length()) {
                    checkMoneyAndBuy(choice);
                }
            } catch (NumberFormatException e) {
                if (input.equals("q")) {
                    tradeOver = false;
                } else {
                    System.out.println("Choix invalide.");
                }
            }
        }
    }

    /**
     * Vérifie si le joueur a suffisamment d'argent pour acheter un objet.
     * Si le joueur peut acheter l'objet, il est appliqué au joueur (arme ou
     * défense).
     *
     * @param index L'index de l'objet dans la boutique.
     */
    public void checkMoneyAndBuy(int index) {
        Item item = itemStore.getItem(index);

        if (player.getMoney() >= item.getPrice()) {
            player.setMoney(player.getMoney() - item.getPrice());

            // Vérification du type de l'item pour l'appliquer au joueur
            if ("Weapon".equals(item.getType())) {
                player.setWeapon((Weapon) item);
                System.out.println("Vous avez acheté l'arme " + item.getName());
            } else if ("Defense".equals(item.getType())) {
                player.setDefense((Defense) item);
                System.out.println("Vous avez acheté la défense " + item.getName());
            }

            System.out.println("Il vous reste " + player.getMoney() + "$");
        } else {
            System.out.println("Vous n'avez pas assez d'argent pour acheter " + item.getName());
        }
    }
}
