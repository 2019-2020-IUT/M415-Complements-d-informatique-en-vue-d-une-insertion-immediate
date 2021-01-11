package tests;

/*
 * Algorithmique
 *
 * MS version du 08 01 2019
 *
 */

import fusion.Fusion;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FusionTest {

    @Test
    public void testFusionTrie() throws Exception {
        int[] tab1 = {2, 4, 8, 10, 12, 17, 19, 20}; // une séquence normale
        int[] tab2 = {}; // la séquence vide
        int[] tab3 = {2}; // un singleton
        int[] tab4 = {2, 3, 5, 7}; // nombre pair d'éléments
        int[] tab5 = {2, 3, 5, 7, 9}; // nombre impair d'éléments

        int[] tab12 = new int[tab1.length + tab2.length];
        System.arraycopy(tab1, 0, tab12, 0, tab1.length);
        System.arraycopy(tab2, 0, tab12, tab1.length, tab2.length);
        System.out.println("ftab12 = " + Arrays.toString(tab12));
        Arrays.sort(tab12);
        assertArrayEquals(tab12, Fusion.fusionTrie(tab1, tab2));
        assertArrayEquals(tab12, Fusion.fusionTrie(tab2, tab1));

        int[] tab34 = IntStream.concat(Arrays.stream(tab3), Arrays.stream(tab4)).toArray();
        Arrays.sort(tab34);
        assertArrayEquals(tab34, Fusion.fusionTrie(tab3, tab4));
        assertArrayEquals(tab34, Fusion.fusionTrie(tab4, tab3));

        int[] tab45 = IntStream.concat(Arrays.stream(tab4), Arrays.stream(tab5)).toArray();
        Arrays.sort(tab45);
        assertArrayEquals(tab45, Fusion.fusionTrie(tab4, tab5));
        assertArrayEquals(tab45, Fusion.fusionTrie(tab5, tab4));
    }
}
