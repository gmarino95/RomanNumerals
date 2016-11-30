package test;
import static org.junit.Assert.*;

import org.junit.Test;

import RomanConversion.RomanNumerals;
import exceptions.*;

public class TestRomanNumerals {

	@Test
	public void testConversionOfValidString() throws IllegalCharacterException,  TooMuchSymbolRepetitionsException, IllegalSubtractionException {
		//Act
		int number = RomanNumerals.convertToInteger("MCMLXXXIV");
		//Assert
		assertTrue(number == 1984);
	}
	
	@Test
	public void convertAnEmptyStringReturnsZero() throws IllegalCharacterException, TooMuchSymbolRepetitionsException, IllegalSubtractionException{
		//Assert
		assertEquals(0,RomanNumerals.convertToInteger(""));
	}
	
	@Test (expected = IllegalCharacterException.class)
	public void stringContainingAnIllegalCharactersShouldRiseAnException() throws IllegalCharacterException, TooMuchSymbolRepetitionsException, IllegalSubtractionException{
		//Act
		RomanNumerals.convertToInteger("BIV");
	}
	
	@Test (expected = IllegalSubtractionException.class)
	public void stringContainingAnIllegalCharacterShouldRiseException() throws IllegalCharacterException, TooMuchSymbolRepetitionsException, IllegalSubtractionException{
		//Act
		RomanNumerals.convertToInteger("IIV");
	}
	
	@Test (expected = IllegalSubtractionException.class)
	public void subtractingA1SymbolfromATooHighValueShouldRiseAnException() throws IllegalCharacterException, TooMuchSymbolRepetitionsException, IllegalSubtractionException{
		//Act
		RomanNumerals.convertToInteger("XM");
	}
}