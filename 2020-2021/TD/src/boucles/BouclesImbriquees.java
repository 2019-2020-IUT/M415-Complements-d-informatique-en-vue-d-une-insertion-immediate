package boucles;

/*
 * Algorithmique
 * 
 * MS version du 12 01 2019
 *
 */

public class BouclesImbriquees {

	/**
	 * Bonjour1 :
	 * 

	 * 
	 */
	public static void bonjour1(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(i + " " + j + " Bonjour 1");
			}
		}
	}

	public static void bonjour2(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.println(j + " Bonjour 2");
			}
		}
	}

	public static void main(String args[]) throws Exception {

		System.out.println("Exercice 1 : boucles imbriquées\n");
		bonjour1(5);
		System.out.println();
		bonjour2(5);
	}
}
