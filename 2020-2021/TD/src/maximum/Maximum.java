package maximum;

/*
 * Algorithmique : squelettes TD1 M415
 *
 * MS version du 14 01 2019
 *
 */

import java.util.Arrays;

public class Maximum {

    /*
     * max
     *
     * Preconditions : tab est un tableau de n entiers quelconques
     *
     * Postconditions : le résultat est l'indice de l'élément le plus grand
     *
     */
    public static int max(int[] tab) {
        // todo
        return -1;
    }

    /*
     *
     * Preconditions : tab est un tableau de n entiers distincts avec une première
     * partie triée dans l'ordre croissant et une deuxième partie triée dans l'ordre
     * décroissant
     *
     * Postconditions : le résultat est l'indice de l'élément le plus grand
     *
     */
    public static int maxTrie(int[] tab) {
        // todo
        return -1;
    }

    /*
     * maxTrieDicho
     *
     * Preconditions : tab est un tableau de n entiers distincts avec une première
     * partie triée dans l'ordre croissant et une deuxième partie triée dans l'ordre
     * décroissant
     *
     * Postconditions : le résultat est l'indice de l'élément le plus grand
     *
     */
    public static int maxTrieDicho(int[] tab) {
        // todo
        return -1;
    }

    public static void main(String args[]) throws Exception {

        int[] t1 = {1, 2, 4, 6, 7, 12, 11, 8, 4, 1};
        System.out.println("t1 = " + Arrays.toString(t1) + " of length " + t1.length);
        System.out.println("max in t1 = " + t1[max(t1)]);
        System.out.println("maxTrie in t1 = " + t1[maxTrie(t1)]);
        System.out.println("maxTrieDicho in t1 = " + t1[maxTrieDicho(t1)]);
        System.out.println();
        int[][] tabtab = {{0}, {1, 2, 4, 12}, {12, 4, 2, 1}, {1, 2, 4, 12, 5, 3, 0}};
        for (int i = 0; i < tabtab.length; i++) {
            System.out.println(
                    "maxTrieDicho in " + Arrays.toString(tabtab[i]) + " = " + tabtab[i][maxTrieDicho(tabtab[i])]);
        }
    }
}
