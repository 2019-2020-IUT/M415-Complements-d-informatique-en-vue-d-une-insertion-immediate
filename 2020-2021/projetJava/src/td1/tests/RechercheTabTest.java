package tests;

/*
 * Algorithmique
 * 
 * MS version du 12 01 2019
 *
 */

import org.junit.jupiter.api.Test;
import recherche.RechercheTab;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RechercheTabTest {

	@Test
	public void testRechercheVite() throws Exception {
		int[] tab1 = { 2, 4, 8, 10, 12, 17, 19, 20 }; // une séquence normale
		int[] tab2 = {}; // la séquence vide
		int[] tab3 = { 2 }; // un singleton
		int[] tab4 = { 2, 3, 5, 7 }; // nombre pair d'éléments
		int[] tab5 = { 2, 3, 5, 7, 9 }; // nombre impair d'éléments

		assertEquals(RechercheTab.rechercheVite(tab1, 0), -1);
		assertEquals(RechercheTab.rechercheVite(tab1, 6), -1);
		assertEquals(RechercheTab.rechercheVite(tab1, 50), -1);
		assertEquals(RechercheTab.rechercheVite(tab1, 2), 0);
		assertEquals(RechercheTab.rechercheVite(tab1, 8), 2);
		assertEquals(RechercheTab.rechercheVite(tab1, 20), 7);

		assertEquals(RechercheTab.rechercheVite(tab2, 6), -1);

		assertEquals(RechercheTab.rechercheVite(tab3, 0), -1);
		assertEquals(RechercheTab.rechercheVite(tab3, 6), -1);
		assertEquals(RechercheTab.rechercheVite(tab3, 2), 0);

		assertEquals(RechercheTab.rechercheVite(tab4, 0), -1);
		assertEquals(RechercheTab.rechercheVite(tab4, 6), -1);
		assertEquals(RechercheTab.rechercheVite(tab4, 50), -1);
		assertEquals(RechercheTab.rechercheVite(tab4, 2), 0);
		assertEquals(RechercheTab.rechercheVite(tab4, 7), 3);
		assertEquals(RechercheTab.rechercheVite(tab4, 5), 2);

		assertEquals(RechercheTab.rechercheVite(tab5, 0), -1);
		assertEquals(RechercheTab.rechercheVite(tab5, 6), -1);
		assertEquals(RechercheTab.rechercheVite(tab5, 50), -1);
		assertEquals(RechercheTab.rechercheVite(tab5, 2), 0);
		assertEquals(RechercheTab.rechercheVite(tab5, 7), 3);
		assertEquals(RechercheTab.rechercheVite(tab5, 5), 2);

	}
}
