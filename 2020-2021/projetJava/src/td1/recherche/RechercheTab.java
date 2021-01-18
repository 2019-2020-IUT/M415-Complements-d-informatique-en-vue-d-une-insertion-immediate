package recherche;

/*
 * Algorithmique
 * 
 * MS version du 12 01 2019
 *
 */

import java.util.Arrays;
import java.util.Random;

public class RechercheTab {

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
	 * rechercheVite : rechercher l'indice d'un élément dans un tableau de n
	 * éléments distincts ordonnés
	 * 
	 * Preconditions : tab est un tableau de n entiers distincts ordonnés par ordre
	 * croissant, x est un entier
	 * 
	 * Postconditions : renvoie i si tab[i] == x, -1 si x n'est pas dans le tableau
	 *
	 */
	public static int rechercheVite(int[] tab, int x) {
		int gauche = 0;
		int droite = tab.length - 1;
		int milieu = 0;
		while (gauche <= droite) {
			milieu = (gauche + droite) / 2;
			// A1 : pour j < gauche tab[j ]!=x
			// pour j > droite tab[j ]!=x
			if (x == tab[milieu]) {
				// A2 : x est à l'indice milieu
				return milieu;
			}
			if (x < tab[milieu]) {
				// droite = milieu boucle
				droite = milieu - 1;// -1
			} else {
				gauche = milieu + 1;
			}
		}
		// A3 : x n'est pas dans le tableau
		return -1;
	}

	public static void main(String args[]) throws Exception {

		System.out.println("Exercice 3 : recherche dichotomique\n");

		int[] tab = { 3, 6, 15, 21, 30, 33, 35, 40 }; // , 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
		System.out.println("tab = " + Arrays.toString(tab));

		System.out.println("rechercheVite de 17 dans tab :" + rechercheVite(tab, 17));

	}
}
