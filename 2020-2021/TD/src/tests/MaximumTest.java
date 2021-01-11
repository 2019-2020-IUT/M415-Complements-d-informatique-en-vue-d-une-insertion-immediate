package tests;

/*
 * Algorithmique
 *
 * MS version du 08 01 2019
 *
 */

import maximum.Maximum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumTest {


    int[] tabVide = {};
    int[][] tabtab = {{0}, {1, 2, 4, 12}, {12, 4, 2, 1}, {1, 2, 4, 12, 5, 3, 0},
            {1, 2, 3, 4, 5, 6, 12, 5, 3, 0}};
    int[] max = {0, 12, 12, 12, 12};

    @Test
    public final void testMax() {
        assertEquals(Maximum.max(tabVide), -1);
        assertEquals(Maximum.maxTrie(tabVide), -1);
        assertEquals(Maximum.maxTrieDicho(tabVide), -1);
        for (int i = 0; i < max.length; i++) {
            assertEquals(tabtab[i][Maximum.max(tabtab[i])], max[i]);
            assertEquals(tabtab[i][Maximum.maxTrie(tabtab[i])], max[i]);
            assertEquals(tabtab[i][Maximum.maxTrieDicho(tabtab[i])], max[i]);
        }
    }

}
