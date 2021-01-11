package fusion;

/*
 * Algorithmique
 *
 * MS version du 08 01 2019
 *
 */

import java.util.Arrays;
import java.util.Random;

public class Fusion {

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

    /*
     * fusionTrie
     *
     * Preconditions : deux tableaux d'entiers triés, tab1 de taille n1 et tab2 de
     * taille n2
     *
     * Postconditions : un tableau d'entiers trié tab3 de taille n1+n2 contenant
     * tous les éléments de tab1 et tab2
     *
     */
    public static int[] fusionTrie(int[] tab1, int[] tab2) {
        int[] tab3 = new int[tab1.length + tab2.length];
        return tab3;
    }

    public static void main(String args[]) throws Exception {

        System.out.println("Exercice 5 : fusion\n");

        int[] t1 = creeTableauAleatoire(15, 100);
        System.out.println("t1 = " + Arrays.toString(t1) + " of length " + t1.length);
        Arrays.sort(t1);
        System.out.println("t1 = " + Arrays.toString(t1));

        int[] t2 = creeTableauAleatoire(12, 100);
        System.out.println("t2 = " + Arrays.toString(t2) + " of length " + t2.length);
        Arrays.sort(t2);
        System.out.println("t2 = " + Arrays.toString(t2));

        int[] t3 = fusionTrie(t1, t2);
        System.out.println("t3  = " + Arrays.toString(t3));

    }
}
