package miniRPG.Rooms;

import java.util.Random;

/**
 * EnumRooms représente un ensemble de salles prédéfinies pour le miniRPG.
 * Chaque salle est représentée par une matrice de chaînes de caractères
 * où différents symboles représentent les éléments de la pièce (murs, espaces
 * vides, ennemis, etc.).
 * Cette énumération permet également de choisir une salle aléatoire et
 * d'y placer des squelettes à des emplacements aléatoires.
 * 
 * @author Baptiste Borie
 */
public enum EnumRooms {

    ROOM1(placeSkeletons(new String[][] {
            { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" },
            { ".", ".", ".", "▫", ".", ".", ".", ".", ".", ".", ".", ".", "▫", ".", ".", ".", ".", "▫", ".", "▫" },
            { "▫", ".", "▫", "▫", ".", "▫", "▫", "▫", "▫", "▫", ".", ".", ".", "▫", ".", "▫", ".", ".", ".", "▫" },
            { "▫", ".", "▫", ".", ".", ".", ".", ".", ".", "▫", ".", "▫", ".", "▫", ".", "▫", ".", "▫", ".", "▫" },
            { "▫", ".", "▫", "▫", ".", "▫", "▫", "▫", "▫", "▫", ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
            { "▫", ".", ".", ".", ".", ".", ".", "▫", "▫", "▫", ".", "▫", "▫", "▫", "▫", "▫", "▫", ".", ".", "⊕" },
            { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" }
    })),

    ROOM2(placeSkeletons(new String[][] {
            { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" },
            { ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫", ".", ".", ".", ".", "▫", ".", "▫" },
            { "▫", ".", ".", "▫", ".", ".", ".", ".", "▫", "▫", ".", "▫", ".", "▫", ".", "▫", ".", ".", ".", "▫" },
            { "▫", ".", "▫", ".", ".", ".", ".", ".", ".", ".", ".", "▫", ".", "▫", ".", "▫", ".", "▫", ".", "▫" },
            { "▫", ".", "▫", "▫", "▫", ".", "▫", "▫", "▫", "▫", ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
            { "▫", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫", "▫", "▫", "▫", "▫", "▫", ".", ".", "⊕" },
            { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", ".", "▫" }
    })),

    ROOM3(placeSkeletons(new String[][] {
            { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" },
            { ".", ".", ".", "▫", ".", ".", ".", ".", ".", ".", ".", ".", "▫", ".", ".", ".", ".", "▫", ".", "▫" },
            { "▫", ".", "▫", "▫", ".", "▫", "▫", "▫", "▫", "▫", ".", ".", ".", "▫", ".", "▫", ".", ".", ".", "▫" },
            { "▫", ".", ".", ".", ".", ".", ".", ".", ".", "▫", ".", "▫", ".", "▫", ".", "▫", ".", "▫", ".", "▫" },
            { "▫", ".", ".", "▫", ".", "▫", ".", ".", "▫", "▫", ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
            { "▫", ".", ".", ".", ".", ".", ".", "▫", ".", ".", ".", "▫", ".", ".", ".", "▫", ".", ".", ".", "⊕" },
            { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" }
    })),

    ROOM4(placeSkeletons(new String[][] {
            { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" },
            { ".", ".", ".", "▫", ".", ".", ".", ".", ".", ".", ".", ".", "▫", ".", ".", ".", ".", "▫", ".", "▫" },
            { "▫", ".", "▫", "▫", ".", ".", ".", "▫", "▫", "▫", ".", ".", ".", ".", ".", "▫", ".", ".", ".", "▫" },
            { "▫", ".", "▫", ".", ".", ".", ".", ".", ".", "▫", ".", "▫", ".", ".", ".", "▫", ".", "▫", ".", "▫" },
            { "▫", ".", "▫", "▫", ".", "▫", ".", ".", "▫", "▫", ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
            { "▫", ".", ".", ".", ".", ".", ".", ".", "▫", "▫", ".", "▫", "▫", "▫", ".", "▫", "▫", ".", ".", "⊕" },
            { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" }
    })),

    ROOM5(placeSkeletons(new String[][] {
            { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" },
            { ".", ".", ".", "▫", ".", ".", ".", ".", ".", ".", ".", ".", "▫", ".", ".", ".", ".", "▫", ".", "▫" },
            { "▫", ".", "▫", "▫", ".", "▫", "▫", "▫", "▫", "▫", ".", ".", ".", "▫", ".", "▫", ".", ".", ".", "▫" },
            { "▫", ".", "▫", ".", ".", ".", ".", ".", ".", "▫", ".", "▫", ".", "▫", ".", "▫", ".", "▫", ".", "▫" },
            { "▫", ".", "▫", "▫", ".", "▫", "▫", "▫", "▫", "▫", ".", ".", ".", ".", ".", ".", ".", ".", ".", "▫" },
            { "▫", ".", ".", ".", ".", ".", ".", "▫", "▫", "▫", ".", "▫", "▫", "▫", "▫", "▫", "▫", ".", ".", "⊕" },
            { "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫", "▫" }
    }));

    /**
     * Représentation en matrice de la disposition de la salle.
     */
    private final String[][] layout;

    /**
     * Constructeur de l'énumération EnumRooms.
     *
     * @param layout Matrice représentant la disposition de la salle.
     */
    EnumRooms(String[][] layout) {
        this.layout = layout;
    }

    /**
     * Obtient la disposition de la salle.
     *
     * @return Une matrice de chaînes de caractères représentant la salle.
     */
    public String[][] getLayout() {
        return layout;
    }

    /**
     * Sélectionne une salle aléatoire parmi les salles disponibles.
     *
     * @return Une instance d'EnumRooms représentant une salle aléatoire.
     */
    public static EnumRooms getRandomRoom() {
        Random random = new Random();
        int index = random.nextInt(EnumRooms.values().length);
        return EnumRooms.values()[index];
    }

    /**
     * Place un nombre aléatoire de squelettes (entre 2 et 5) dans une salle donnée.
     * Les squelettes sont représentés par le symbole "▵" et placés uniquement dans
     * des emplacements vides (symbolisés par ".").
     *
     * @param layout Matrice représentant la salle.
     * @return Une nouvelle matrice avec les squelettes placés.
     */
    private static String[][] placeSkeletons(String[][] layout) {
        Random random = new Random();
        int skeletonCount = random.nextInt(4) + 2; // Entre 2 et 5 squelettes

        for (int i = 0; i < skeletonCount; i++) {
            int x, y;
            do {
                x = random.nextInt(layout.length - 2) + 1; // éviter les bords
                y = random.nextInt(layout[0].length - 2) + 1; // éviter les bords
            } while (!layout[x][y].equals("."));
            layout[x][y] = "▵";
        }

        return layout;
    }
}
