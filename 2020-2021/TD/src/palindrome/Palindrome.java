package palindrome;

/*
 * Algorithmique
 *
 * MS version du 12 01 2019
 *
 */

public class Palindrome {

    /**
     * palindrome
     * <p>
     * Preconditions : c une chaîne de n caractères
     * <p>
     * Postconditions : renvoie vrai si c est un palindrome
     */
    public static boolean palindrome(String c) {
        int i = 0;
        int j = c.length() - 1;
        //while ((i < j) && ... ) {
        // A1 : si C1 est la sous-chaîne de c allant de l’indice 0 à
        // l’indice i
        // : si C2 est la sous-chaîne de c allant de l’indice j à l’indice
        // c.length()-1
        // : alors C1C2 est un palindrome
        //...;
        //...;
        //}
        return false; //return ...;
    }

    public static void main(String args[]) throws Exception {

        System.out.println("Exercice 6 : palindrome");
        System.out.println();
        System.out.println("palindrome(\"aaabbaaa\") : " + palindrome("aaabbaaa"));
        System.out.println("palindrome(\"aabbaaa\") : " + palindrome("aabbaaa"));
    }
}
