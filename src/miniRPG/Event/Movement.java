package miniRPG.Event;

import miniRPG.Person.*;
import miniRPG.Rooms.Room;

/**
 * Classe Movement gère les déplacements d'un personnage dans une pièce.
 * Elle contrôle la logique de mouvement en tenant compte des limites de la
 * grille,
 * des murs, de l'entrée et de la sortie.
 * 
 * @author Baptiste Borie
 */
public class Movement {

    /**
     * Le personnage qui effectue les déplacements.
     */
    private Person joueur;

    /**
     * La pièce dans laquelle le personnage se déplace.
     */
    private Room room;

    /**
     * Grille représentant la pièce.
     */
    private String[][] grid;

    /**
     * Largeur de la grille.
     */
    private int width;

    /**
     * Hauteur de la grille.
     */
    private int height;

    /**
     * Coordonnées de l'entrée de la pièce.
     */
    private int[] entree;

    /**
     * Coordonnées de la sortie de la pièce.
     */
    private int[] sortie;

    /**
     * Constructeur de la classe Movement.
     * Initialise la gestion des déplacements pour un personnage dans une pièce
     * donnée.
     *
     * @param joueur Le personnage qui se déplace.
     * @param room   La pièce dans laquelle le personnage se trouve.
     */
    public Movement(Person joueur, Room room) {
        this.joueur = joueur;
        this.room = room;
        this.grid = room.getGrid();
        this.width = room.getWidth();
        this.height = room.getHeight();
        this.entree = room.getEntrance();
        this.sortie = room.getExit();
    }

    /**
     * Vérifie si une position donnée est dans les limites de la grille.
     *
     * @param x La position X.
     * @param y La position Y.
     * @return {@code true} si la position est dans les limites, {@code false}
     *         sinon.
     */
    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < height && y >= 0 && y < width;
    }

    /**
     * Vérifie si une position donnée correspond à l'entrée de la pièce.
     *
     * @param x La position X.
     * @param y La position Y.
     * @return {@code true} si la position est l'entrée, {@code false} sinon.
     */
    public boolean isEntrance(int x, int y) {
        return x == entree[0] && y == entree[1];
    }

    /**
     * Vérifie si une position donnée correspond à la sortie de la pièce.
     *
     * @param x La position X.
     * @param y La position Y.
     * @return {@code true} si la position est la sortie, {@code false} sinon.
     */
    public boolean isExit(int x, int y) {
        return x == sortie[0] && y == sortie[1];
    }

    /**
     * Déplace le personnage vers la droite s'il n'y a pas de mur ou si c'est une
     * entrée/sortie.
     */
    public void moveRight() {
        int x = this.joueur.getX();
        int y = this.joueur.getY();

        if (isWithinBounds(x, y + 1) && !this.room.isWall(x, y + 1) || isEntrance(x, y + 1) || isExit(x, y + 1)) {
            grid[x][y] = "."; // Vider la position actuelle
            this.joueur.setY(y + 1); // Déplacer vers la droite
            grid[x][y + 1] = this.joueur.getAscii(); // Mettre à jour la nouvelle position
        }
    }

    /**
     * Déplace le personnage vers la gauche s'il n'y a pas de mur ou si c'est une
     * entrée/sortie.
     */
    public void moveLeft() {
        int x = this.joueur.getX();
        int y = joueur.getY();

        if (isWithinBounds(x, y - 1) && !this.room.isWall(x, y - 1) || isEntrance(x, y - 1) || isExit(x, y - 1)) {
            grid[x][y] = "."; // Vider la position actuelle
            joueur.setY(y - 1); // Déplacer vers la gauche
            grid[x][y - 1] = this.joueur.getAscii(); // Mettre à jour la nouvelle position
        }
    }

    /**
     * Déplace le personnage vers le bas s'il n'y a pas de mur ou si c'est une
     * entrée/sortie.
     */
    public void moveDown() {
        int x = this.joueur.getX();
        int y = this.joueur.getY();

        if (isWithinBounds(x + 1, y) && !this.room.isWall(x + 1, y) || isEntrance(x + 1, y) || isExit(x + 1, y)) {
            grid[x][y] = "."; // Vider la position actuelle
            joueur.setX(x + 1); // Déplacer vers le bas

            grid[x + 1][y] = this.joueur.getAscii(); // Mettre à jour la nouvelle position
        }
    }

    /**
     * Déplace le personnage vers le haut s'il n'y a pas de mur ou si c'est une
     * entrée/sortie.
     */
    public void moveUp() {
        int x = this.joueur.getX();
        int y = this.joueur.getY();
        if (isWithinBounds(x - 1, y) && !this.room.isWall(x - 1, y) || isEntrance(x - 1, y) || isExit(x - 1, y)) {
            grid[x][y] = "."; // Vider la position actuelle
            this.joueur.setX(x - 1); // Déplacer vers le haut
            grid[x - 1][y] = this.joueur.getAscii(); // Mettre à jour la nouvelle position
        }
    }

    /**
     * En fonction de la direction du mouvement lance la fonction adéquate afin de
     * déplacer le joueur.
     * 
     * @param dx Mouvement sur l'axe X.
     * @param dy Mouvement sur l'axe Y.
     */
    public void move(int dx, int dy) {
        if (dx == 0 && dy == 1) {
            moveRight();
        } else if (dx == 0 && dy == -1) {
            moveLeft();
        } else if (dx == 1 && dy == 0) {
            moveDown();
        } else if (dx == -1 && dy == 0) {
            moveUp();
        } else {
            System.out.println("Mouvement non autorisé");
        }
    }

    /**
     * Met à jour la pièce dans laquelle le personnage se déplace.
     * 
     * @param room La nouvelle pièce.
     */
    public void setRoom(Room room) {
        this.room = room;
        this.grid = room.getGrid();
        this.width = room.getWidth();
        this.height = room.getHeight();
        this.entree = room.getEntrance();
        this.sortie = room.getExit();
    }
}
