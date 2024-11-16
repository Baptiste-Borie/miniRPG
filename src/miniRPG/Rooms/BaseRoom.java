package miniRPG.Rooms;

import miniRPG.Person.*;

/**
 * Représente une pièce de base (BaseRoom) pour le miniRPG.
 * Cette classe hérite de {@link Room} et permet de générer une grille basée sur
 * une disposition aléatoire choisie dans {@link EnumRooms}.
 * La pièce contient une entrée, une sortie, et peut être peuplée d'éléments
 * tels qu'un joueur ou des ennemis.
 */
public class BaseRoom extends Room {

    /**
     * Grille représentant la disposition de la pièce.
     */
    private String[][] grid;

    /**
     * Largeur de la pièce.
     */
    private int width;

    /**
     * Hauteur de la pièce.
     */
    private int height;

    /**
     * Coordonnées de l'entrée de la pièce.
     */
    private int[] entrance;

    /**
     * Coordonnées de la sortie de la pièce.
     */
    private int[] exit;

    /**
     * Constructeur de la classe BaseRoom.
     * Initialise les dimensions et les attributs de la pièce en se basant sur la
     * classe parent {@link Room}.
     */
    public BaseRoom() {
        super(20, 7);
        this.width = super.getWidth();
        this.height = super.getHeight();
        this.grid = super.getGrid();
        this.entrance = super.getEntrance();
        this.exit = super.getExit();
    }

    /**
     * Génère une grille pour la pièce en utilisant une disposition aléatoire
     * d'{@link EnumRooms}.
     * Cette méthode configure également les positions du joueur, de la sortie et
     * des autres éléments.
     *
     * @param joueur Le joueur à positionner dans la pièce. Son symbole ASCII est
     *               utilisé pour le représenter.
     * @throws IllegalArgumentException Si la taille de la pièce choisie ne
     *                                  correspond pas
     *                                  aux dimensions de la grille actuelle.
     */
    public void createGrid(Person joueur) {
        // Choisir une pièce aléatoire
        EnumRooms randomRoom = EnumRooms.getRandomRoom();
        String[][] roomLayout = randomRoom.getLayout();
        this.height = roomLayout.length;
        this.width = roomLayout[0].length;

        if (roomLayout.length != this.height || roomLayout[0].length != this.width) {
            throw new IllegalArgumentException(
                    "La taille de la pièce ne correspond pas à la grille." + roomLayout.length + "/" + this.height
                            + "||" + roomLayout[0].length + "/" + this.width);
        }
        // Remplir la grille avec la disposition de la pièce
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.grid[i][j] = roomLayout[i][j];
            }
        }

        // Définir la sortie, l'ennemi et le joueur
        this.grid[exit[0]][exit[1]] = "❂";

        // Initialiser la position du joueur
        this.grid[entrance[0]][entrance[1]] = joueur.getAscii(); // Position de l'entrée

    }

}
