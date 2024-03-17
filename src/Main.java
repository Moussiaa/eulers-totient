import java.util.ArrayList;
import java.util.List;

/**
 * Java program to take a number and return all values that do not
 * share a divisor with it (excluding 1)
 *
 * @param <T> generic type
 * @author Moussia Adry
 */

public class Main {

    public static void main(String[] args) {
        for (int num = 10; num <= 50; num++) {
            double ef = eulerPhi(num);
            System.out.println("phi(" + num + ") = " + Math.round(ef));
        }
    }

    // function to return all Primes Smaller than
    // or equal to N using Sieve of Eratosthenes
    private static List<Integer> sieve(int num) {
        boolean[] prime = new boolean[num + 1];
        for (int i = 0; i <= num; i++) {
            prime[i] = true;
        }

        int p = 2;
        while (p * p <= num) {
            if (prime[p]) {
                for (int i = p * p; i <= num; i += p) {
                    prime[i] = false;
                }
            }
            p++;
        }

        // make an array list to collect all prime numbers
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static double eulerPhi(int n) {
        List<Integer> primeCandidates = sieve(n);
        double phi = n;
        for (int prime : primeCandidates) {
            if (n % prime == 0) {
                phi *= ((prime - 1) / (double) prime);
            }
        }
        return phi;
    }


}
