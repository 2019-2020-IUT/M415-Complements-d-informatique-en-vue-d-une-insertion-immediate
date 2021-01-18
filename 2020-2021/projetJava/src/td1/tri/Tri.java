package tri;

/*
 * Algorithmique
 *
 * MS version du 08 01 2018
 *
 */

import java.util.Arrays;
import java.util.Random;

public class Tri {

    // générateur aléatoire
    private static final Random RAND = new Random(System.currentTimeMillis());

    /**
     * Crée un tableau de la taille donnée et le remplit avec des entiers positifs
     * aléatoires
     */
    public static int[] creeTableauAleatoire(int taille, int max) {
        int[] tab = new int[taille];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = RAND.nextInt(max);
        }
        return tab;
    }

    /**
     * triSelection : trier un tableau de n éléments
     * <p>
     * Preconditions :
     * <p>
     * Postconditions :
     */
    public static void triSelection(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            // A1 : tab[0..i-1] est trié
            int indiceMin = i;
            for (int j = i + 1; j < tab.length; j++) {
                // A2 : tab[indiceMin] <= tab[k] pour tout i <= k <j
                if (tab[indiceMin] > tab[j]) {
                    indiceMin = j;
                }
            }
            int aux = tab[i];
            tab[i] = tab[indiceMin];
            tab[indiceMin] = aux;
        }
    }

    /**
     * triBulle : trier un tableau de n éléments
     * <p>
     * Preconditions :
     * <p>
     * Postconditions :
     */
    public static void triBulle(int[] tab) {
        int j = tab.length - 1;
        while (j > 0) {
            for (int i = 0; i < j; i++) {
                if (tab[i] > tab[i + 1]) {
                    int tmp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = tmp;
                }
            }
            // A1 :
            // A2 :
            // A3 :
            j--;
        }
    }

    public static void main(String args[]) throws Exception {

        System.out.println("Exercice 2 : tri par sélection\n");
        int[] tab = {3, 25, 50, 8, 1, 3, 49};
        System.out.println("tab      : " + Arrays.toString(tab) + "\n");
        triSelection(tab);
        System.out.println("\ntab trié : " + Arrays.toString(tab));

    }
}
