package tests;

/*
 * Algorithmique
 * 
 * MS version du 08 01 2018
 *
 */

import org.junit.jupiter.api.Test;
import tri.Tri;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TriTest {

	int[][] tabtab = { {}, { 0 }, { 1, 2, 4, 12, 0, 1, 5 }, { 1, 2, 4, 12, 0 }, { 8, 7, 6, 5, 4, 3, 2, 1, 0 } };

	@Test
	public void testTriSelection() throws Exception {
		/*
		 * trois fois le même exemple pour comparer les résultats avec triInsertion et
		 * sort
		 */

		int[][] tabtabTrie = Arrays.stream(tabtab).map(x -> x.clone()).toArray(int[][]::new);
		/*
		 * JavaSE-1.8, sinon utiliser la méthode de copie suivante
		 */

		int[][] tabtabSorted = new int[tabtab.length][];
		for (int i = 0; i < tabtab.length; i++) {
			tabtabSorted[i] = Arrays.copyOf(tabtab[i], tabtab[i].length);
		}

		/*
		 * On compare les tableaux résultants de Arrays.sort et de triInsertion. On peut
		 * aussi simplement vérifier l'ordre dans le résultat.
		 */
		for (int i = 0; i < tabtab.length; i++) {
			Tri.triSelection(tabtabTrie[i]);
			Arrays.sort(tabtabSorted[i]);
			assertArrayEquals(tabtabTrie[i], tabtabSorted[i]);
		}
	}

	@Test
	public void testTriBulle() throws Exception {
		/*
		 * trois fois le même exemple pour comparer les résultats avec triBulle et sort
		 */

		int[][] tabtabTrie = Arrays.stream(tabtab).map(x -> x.clone()).toArray(int[][]::new);
		/* JavaSE-1.8, sinon utiliser la méthode de copie suivante */
		int[][] tabtabSorted = new int[tabtab.length][];
		for (int i = 0; i < tabtab.length; i++) {
			tabtabSorted[i] = Arrays.copyOf(tabtab[i], tabtab[i].length);
		}

		/*
		 * On compare les tableaux résultants de Arrays.sort et de triBulle. On peut
		 * aussi simplement vérifier l'ordre dans le résultat.
		 */
		for (int i = 0; i < tabtab.length; i++) {
			Tri.triBulle(tabtabTrie[i]);
			Arrays.sort(tabtabSorted[i]);
			assertArrayEquals(tabtabTrie[i], tabtabSorted[i]);
		}

	}

}
