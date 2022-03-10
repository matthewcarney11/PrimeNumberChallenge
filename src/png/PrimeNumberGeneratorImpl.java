package png;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Implementation of the interface {@link PrimeNumberGenerator}
 * 
 * @author Matt
 */
public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Integer> generate(int startingValue, int endingValue) {
		// flip start and end value if needed to accommodate inverse ranges
		int rangeStart = startingValue <= endingValue ? startingValue : endingValue;
		int rangeEnd = startingValue <= endingValue ? endingValue : startingValue;
		
		return IntStream.rangeClosed(rangeStart, rangeEnd).filter(this::isPrime).boxed().collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isPrime(int value) {
		// negative numbers, 0, and 1 are non-prime
		if (value < 2) {
			return false;
		}
		
		// all multiples of 2 (even numbers) are non-prime, except 2 itself
		if (value % 2 == 0) {
			return value == 2;
		}
		
		// iterate over possible divisors
		for (int i=3; i <= Math.sqrt(value); i+=2) {
			// if the value has a divisor in the range, it is non-prime
			if (value % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Main method to allow running the prime number generator from the command line.
	 * 
	 * @param args the command line arguments, which are ignored.
	 */
	public static void main(String args[]) {
		System.out.println("This program will print an ordered list of all prime numbers within the given range of integers.");
	    
	    try (Scanner in = new Scanner(System.in)) {
	    	
			System.out.println("Please enter the range start:");
			int rangeStart = 0;
			try {
				rangeStart = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("The input was not an integer. The program will exit now.");
				System.exit(0);
			}
			
			System.out.println("Please enter the range end:");
			int rangeEnd = 0;
			try {
				rangeEnd = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("The input was not an integer. The program will exit now.");
				System.exit(0);
			}
			
			final PrimeNumberGenerator png = new PrimeNumberGeneratorImpl();
			System.out.printf("Prime numbers within range: %s", png.generate(rangeStart, rangeEnd));
		}	      
	}

}
