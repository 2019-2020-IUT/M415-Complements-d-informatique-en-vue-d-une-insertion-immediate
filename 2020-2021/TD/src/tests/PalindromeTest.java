package tests;

import org.junit.jupiter.api.Test;
import palindrome.Palindrome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {

	@Test
	public void testPalindrome() throws Exception {
		assertTrue(Palindrome.palindrome(""));
		assertTrue(Palindrome.palindrome("a"));
		assertTrue(Palindrome.palindrome("aba"));
		assertTrue(Palindrome.palindrome("abba"));
		assertTrue(Palindrome.palindrome("eluparcettecrapule"));

		assertFalse(Palindrome.palindrome("ab"));
		assertFalse(Palindrome.palindrome("ab a"));
		assertFalse(Palindrome.palindrome("ababab"));
	}

}
