package png;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

	@Override
	public List<Integer> generate(int startingValue, int endingValue) {
		// flip start and end value if needed to accommodate inverse ranges
		int rangeStart = startingValue <= endingValue ? startingValue : endingValue;
		int rangeEnd = startingValue <= endingValue ? endingValue : startingValue;
		
		return IntStream.range(rangeStart, rangeEnd).filter(this::isPrime).boxed().collect(Collectors.toList());
	}

	@Override
	public boolean isPrime(int value) {
		// negative numbers, 0, and 1 are non-prime
		if (value < 2) {
			return false;
		}
		
		if (value == 2) {
			return true;
		}
		
		// all multiples of 2 (even numbers) are non-prime
		if (value % 2 == 0) {
			return false;
		}
		
		// iterate over possible divisors
		for (int i=3; i < value; i++) {
			// if the value has another divisor, it is non-prime
			if (value % i == 0) {
				return false;
			}
		}
		
		return true;
	}

}
