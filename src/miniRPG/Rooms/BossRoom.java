package miniRPG.Rooms;

import miniRPG.Person.*;

/**
 * La classe BossRoom représente une salle de boss dans le mini-RPG.
 * Elle contient une disposition spécifique de la grille avec un boss positionné
 * au centre.
 * Cette salle constitue le défi final pour le joueur.
 * 
 * @author Baptiste Borie
 */
public class BossRoom extends Room {

    /** Grille ASCII représentant la salle de boss. */
    private String[][] grid;

    /** Largeur de la salle de boss. */
    private int width;

    /** Hauteur de la salle de boss. */
    private int height;

    /** Coordonnées de l'entrée de la salle de boss. */
    private int[] entrance;

    /** Coordonnées de la sortie de la salle de boss. */
    private int[] exit;

    /** Le boss présent dans la salle. */
    private Boss boss;

    /**
     * Constructeur de la classe BossRoom.
     * Initialise les dimensions, l'entrée, la sortie, et place un boss spécifique.
     */
    public BossRoom() {
        super(20, 7);
        this.width = super.getWidth();
        this.height = super.getHeight();
        this.grid = super.getGrid();
        this.entrance = new int[] { 3, 0 };
        this.exit = super.getExit();
        this.boss = new Boss(); // Instancie un boss spécifique
    }

    /**
     * Méthode permettant de créer la grille spécifique à la salle de boss.
     * La disposition inclut des ennemis, des obstacles et un boss.
     * 
     * @param joueur Le joueur qui sera initialement placé dans la salle.
     * @throws IllegalArgumentException Si la taille de la grille ne correspond pas
     *                                  à la disposition définie.
     */
    public void createGrid(Person joueur) {
        // Disposition spéciale pour la salle de boss

        String[][] bossRoomLayout = {
                { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" },
                { "▫", "▵", ".", "▵", ".", "▵", ".", "▵", ".", "▵", ".", "▵", ".", "▵", ".", "▵", ".", ".", ".", "▫" },
                { ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
                { ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
                { ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
                { "▫", "▵", ".", "▵", ".", "▵", ".", "▵", ".", "▵", ".", "▵", ".", "▵", ".", "▵", ".", ".", ".", "▫" },
                { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" }
        };

        // Initialisation de la grille avec la taille de la salle de boss
        this.height = bossRoomLayout.length;
        this.width = bossRoomLayout[0].length;

        if (bossRoomLayout.length != this.height || bossRoomLayout[0].length != this.width) {
            throw new IllegalArgumentException(
                    "La taille de la pièce ne correspond pas à la grille." + bossRoomLayout.length + "/" + this.height
                            + "||" + bossRoomLayout[0].length + "/" + this.width);
        }
        // Remplir la grille avec la disposition de la pièce
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.grid[i][j] = bossRoomLayout[i][j];
            }
        }

        joueur.setX(entrance[0]);
        joueur.setY(entrance[1]);
        this.grid[entrance[0]][entrance[1]] = joueur.getAscii(); // Position de l'entrée

        // Positionner le boss au centre de la salle
        int bossX = this.height / 2;
        int bossY = this.width - 3;
        boss.setX(bossX);
        boss.setY(bossY);
        this.grid[bossX][bossY] = boss.getAscii(); // Position du boss

    }

}
