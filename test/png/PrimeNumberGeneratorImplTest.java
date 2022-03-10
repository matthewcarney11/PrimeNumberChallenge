package png;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class PrimeNumberGeneratorImplTest {
	
	@ParameterizedTest
	@ValueSource(ints = {-9, -8, -6, -4, -1, 0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16})
	void isPrimeTestInvalidIntegers(int value) {
		final PrimeNumberGenerator png = new PrimeNumberGeneratorImpl();
		assertThat(png.isPrime(value), is(false));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
			37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, Integer.MAX_VALUE})
	void isPrimeTestValidIntegers(int value) {
		final PrimeNumberGenerator png = new PrimeNumberGeneratorImpl();
		assertThat(png.isPrime(value), is(true));
	}
	
	@Test
	void generateTestLowRange () {
		final PrimeNumberGenerator png = new PrimeNumberGeneratorImpl();
		assertThat(png.generate(0, 101), contains(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
				37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101));
	}
	
	@Test
	void generateTestLowRangeInverse () {
		final PrimeNumberGenerator png = new PrimeNumberGeneratorImpl();
		assertThat(png.generate(101, 0), contains(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
				37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101));
	}
	
	@Test
	void generateTestHighRange () {
		final PrimeNumberGenerator png = new PrimeNumberGeneratorImpl();
		assertThat(png.generate(7900, 7920), contains(7901, 7907, 7919));
	}
	
	@Test
	void generateTestHighRangeInverse () {
		final PrimeNumberGenerator png = new PrimeNumberGeneratorImpl();
		assertThat(png.generate(7920, 7900), contains(7901, 7907, 7919));
	}
	
	@Test
	void generateTestNegativeRangeStartAndEnd () {
		final PrimeNumberGenerator png = new PrimeNumberGeneratorImpl();
		assertThat(png.generate(-102, -2), is(empty()));
	}
	
	@Test
	void generateTestNegativeRangeStart () {
		final PrimeNumberGenerator png = new PrimeNumberGeneratorImpl();
		assertThat(png.generate(-102, 102), contains(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
				37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101));
	}
	
	@Test
	void generateTestNegativeRangeEnd () {
		final PrimeNumberGenerator png = new PrimeNumberGeneratorImpl();
		assertThat(png.generate(102, -102), contains(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
				37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101));
	}

}
