package miniRPG.Rooms;

import miniRPG.Person.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe abstraite Room représente une salle dans le mini-RPG.
 * Elle contient une grille ASCII ainsi que les dimensions, l'entrée, et la
 * sortie de la salle.
 * Les sous-classes doivent implémenter la méthode abstraite `createGrid` pour
 * définir le contenu de la salle.
 * 
 * @author Baptiste Borie
 */

public abstract class Room {
    /** Grille ASCII représentant la salle. */
    private String[][] grid;

    /** Largeur de la salle. */
    private int width;

    /** Hauteur de la salle. */
    private int height;

    /** Coordonnées de l'entrée de la salle. */
    private int[] entrance;

    /** Coordonnées de la sortie de la salle. */
    private int[] exit;

    /**
     * Constructeur de la classe Room.
     * Initialise les dimensions, l'entrée, et la sortie de la salle, ainsi que la
     * grille.
     * 
     * @param width  Largeur de la salle.
     * @param height Hauteur de la salle.
     */
    public Room(int width, int height) {
        this.width = width;
        this.height = height;
        this.entrance = new int[] { 1, 0 };
        this.exit = new int[] { height - 2, width - 1 };
        this.grid = new String[height][width];
    }

    /**
     * Retourne la largeur de la salle.
     * 
     * @return Largeur de la salle.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Retourne la hauteur de la salle.
     * 
     * @return Hauteur de la salle.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Retourne les coordonnées de l'entrée de la salle.
     * 
     * @return Coordonnées de l'entrée de la salle.
     */
    public int[] getEntrance() {
        return this.entrance;
    }

    /**
     * Retourne les coordonnées de la sortie de la salle.
     * 
     * @return Coordonnées de la sortie de la salle.
     */
    public int[] getExit() {
        return this.exit;
    }

    /**
     * Retourne la grille ASCII de la salle.
     * 
     * @return Grille ASCII de la salle.
     */
    public String[][] getGrid() {
        return this.grid;
    }

    /**
     * Définit une nouvelle largeur pour la salle.
     * 
     * @param newWidth Nouvelle largeur.
     */
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }

    /**
     * Définit une nouvelle hauteur pour la salle.
     * 
     * @param newHeight Nouvelle hauteur.
     */
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    /**
     * Définit de nouvelles coordonnées pour l'entrée de la salle.
     * 
     * @param newEntrance Nouvelles coordonnées de l'entrée.
     */
    public void setEntrance(int[] newEntree) {
        this.entrance = newEntree;
    }

    /**
     * Définit de nouvelles coordonnées pour la sortie de la salle.
     * 
     * @param newExit Nouvelles coordonnées de la sortie.
     */
    public void setExit(int[] newSortie) {
        this.exit = newSortie;
    }

    /**
     * Définit une nouvelle grille pour la salle.
     * 
     * @param newGrid Nouvelle grille.
     */
    public void setGrid(String[][] newGrid) {
        this.grid = newGrid;
    }

    /**
     * Crée la grille de la salle.
     * 
     * @param joueur Joueur qui se trouve dans la salle.
     */
    public abstract void createGrid(Person joueur);

    /**
     * Convertit la grille ASCII en chaîne de caractères pour l'affichage.
     * 
     * @return Représentation de la grille sous forme de chaîne.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result.append(grid[i][j]);
            }
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * Vérifie si une case de la grille est un mur.
     * 
     * @param x Coordonnée X dans la grille.
     * @param y Coordonnée Y dans la grille.
     * @return true si la case est un mur ('▯' ou '▫'), false sinon.
     */
    public boolean isWall(int x, int y) {
        // Vérifie si les coordonnées sont dans les limites de la grille
        if (x < 0 || x >= this.grid.length || y < 0 || y >= this.grid[x].length) {
            return false;
        }
        return grid[x][y].equals("▯") || grid[x][y].equals("▫");
    }

}
