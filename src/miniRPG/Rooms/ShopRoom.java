package miniRPG.Rooms;

import miniRPG.Person.*;

/**
 * La classe ShopRoom représente une salle de boutique dans le mini-RPG.
 * Elle contient une disposition spécifique de la grille et inclut un marchand.
 * Cette salle permet au joueur d'interagir avec un marchand pour des échanges
 * ou des achats.
 * 
 * @author Baptiste Borie
 */

public class ShopRoom extends Room {
    /** Grille ASCII représentant la salle de la boutique. */
    private String[][] grid;

    /** Largeur de la salle de la boutique. */
    private int width;

    /** Hauteur de la salle de la boutique. */
    private int height;

    /** Coordonnées de l'entrée de la salle de la boutique. */
    private int[] entrance;

    /** Coordonnées de la sortie de la salle de la boutique. */
    private int[] exit;

    /**
     * Constructeur de la classe ShopRoom.
     * Initialise les dimensions, l'entrée, et la sortie de la salle,
     * ainsi que la grille avec des valeurs par défaut.
     */
    public ShopRoom() {
        super(10, 7);
        this.width = super.getWidth();
        this.height = super.getHeight();
        this.grid = super.getGrid();
        this.entrance = new int[] { 3, 0 };
        this.exit = super.getExit();
    }

    /**
     * Méthode permettant de créer la grille spécifique à la salle de la boutique.
     * 
     * @param joueur Le joueur qui sera initialement placé dans la salle.
     * @throws IllegalArgumentException Si la taille de la grille ne correspond pas
     *                                  à la disposition définie.
     */
    public void createGrid(Person joueur) {

        String[][] shopRoomLayout = {
                { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" },
                { "▫", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
                { ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
                { ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
                { ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
                { "▫", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
                { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" }
        };

        this.height = shopRoomLayout.length;
        this.width = shopRoomLayout[0].length;

        if (shopRoomLayout.length != this.height || shopRoomLayout[0].length != this.width) {
            throw new IllegalArgumentException(
                    "La taille de la pièce ne correspond pas à la grille." + shopRoomLayout.length + "/" + this.height
                            + "||" + shopRoomLayout[0].length + "/" + this.width);
        }
        // Remplir la grille avec la disposition de la pièce
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.grid[i][j] = shopRoomLayout[i][j];
            }
        }

        this.grid[exit[0]][exit[1]] = "⊕";

        joueur.setX(entrance[0]);
        joueur.setY(entrance[1]);
        this.grid[entrance[0]][entrance[1]] = joueur.getAscii(); // Position de l'entrée

        // Place merchant
        int merchantX = this.height / 2;
        int merchantY = this.width / 2;
        this.grid[merchantX][merchantY] = "€"; // Position du marchand

    }

}
