package png;

import java.util.List;

/**
 * Interface for a prime number generator that can generate a list of prime numbers in a given range, and check whether a given number is prime.
 * 
 * @author Matt
 */
public interface PrimeNumberGenerator {
	
	/**
	 * Generates an ordered list of all prime numbers in a given range of integers (inclusive of the endpoints).
	 * Inverse ranges are handled such that 1-10 and 10-1 are equivalent.
	 * 
	 * @param startingValue the start value of the range
	 * @param endingValue the end value of the range
	 * @return a list of all prime numbers between {@code startingValue} and {@code endingValue}
	 */
	List<Integer> generate(int startingValue, int endingValue);

	/**
	 * Checks if a given integer is a prime number.
	 * 
	 * @param value the number to evaluate
	 * @return true if the number is prime, false otherwise
	 */
	boolean isPrime(int value);
	
}
