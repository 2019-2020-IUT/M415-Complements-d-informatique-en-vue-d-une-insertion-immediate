/*
 * M415 2019-2020: additional algorithmics
 */
package M415.td4.progdyn;

import java.util.HashMap;

/**
 * Computes and prints the first N Fibonacci numbers.
 * <p>
 * WARNING: this program is spectacularly inefficient and is meant to illustrate
 * a performance leak, e.g., set N = 45.
 * <p>
 * REMARKS: the 93rd Fibonacci number would overflow a long, but this will take
 * so long to compute with this function that we don't bother to check for
 * overflow.
 * <p>
 * you may use http://www.miniwebtool.com/list-of-fibonacci-numbers/?number=93
 * to check you results
 * <p>
 * Wikipedia: In the Liber Abaci (1202), Fibonacci introduced the so-called
 * modus Indorum (method of the Indians), today known as Arabic numerals (Sigler
 * 2003; Grimm 1973). The book advocated numeration with the digits 0�9 and
 * place value. The book showed the practical importance of the new numeral
 * system by applying it to commercial bookkeeping, conversion of weights and
 * measures, the calculation of interest, money-changing, and other
 * applications. The book was well received throughout educated Europe and had a
 * profound impact on European thought. Liber Abaci also posed, and solved, a
 * problem involving the growth of a population of rabbits based on idealized
 * assumptions. The solution, generation by generation, was a sequence of
 * numbers later known as Fibonacci numbers. The number sequence was known to
 * Indian mathematicians as early as the 6th century, but Fibonacci's Liber
 * Abaci contains the earliest known description of the sequence outside of
 * India.
 * <p>
 * Fibonacci did not speak about the golden ratio as the limit of the ratio of
 * consecutive numbers in this sequence, ie F(n)/F(n-1) -> (1 + sqrt(5))/2
 */

public class Nfibonacci {
    private static long nb = 0;
    private static HashMap<Integer, Long> mem;
    
    private static long nFibonacci(int n) {
        if(n == 0) {
        	nb++;
        	return 0;
        } else if (n == 1) {
        	nb++;
        	return 1;
        } else {
        	nb++;
        	return nFibonacci(n-1) + nFibonacci(n-2);
        }   	
    }

    private static long mFibonacci(int n) {
    	nb++;
    	if(mem.get(n) > 0) {
    		return mem.get(n);
    	} else if(n == 0) {
        	return 0;
        } else if (n == 1) {
        	return mem.put(1, (long) 1);
        } else {
        	return mem.put(n, mFibonacci(n-1) + mFibonacci(n-2));
        	
        }
    }

    public static void main(String[] args) {

        int N = 40; // 91;// Integer.parseInt(args[0]);
        for (int i = 1; i <= N; i++) {
            long lStartTime = System.currentTimeMillis();
            long res = nFibonacci(i);
            long lEndTime = System.currentTimeMillis();
            // Fibo(n-2) + Fibo(n-1) + 1 =~ 3,2360 * Fibo(n) grows slowly
            System.out.println(i + ": " + res + "(" + (lEndTime - lStartTime) + " ms) / " + nb + " calls");
            nb = 0;
        }
        System.out.println("Prog dyn");
        long res92 = mFibonacci(92);
        System.out.println("92: " + res92 + " / " + nb + " calls");
        nb = 0;
        for (int i = 1; i <= N; i++) {
            long res = mFibonacci(i);
            System.out.println(i + ": " + res + " / " + nb + " calls");
            nb = 0;
        }
    }
}
