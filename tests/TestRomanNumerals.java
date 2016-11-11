import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {
	
	private int decimal;
	private String romanNum;
	private RomanNumerals roman= new RomanNumerals();

	@Test
	public void testonecharacter() throws IllegalOccurrenceLetter {
		
		romanNum = "V";
		decimal = roman.convertToInteger(romanNum);
		
		assertEquals(5, decimal);
	}
	
	@Test
	public void testthreecharacter() throws IllegalOccurrenceLetter{
		
		romanNum = "III";
		decimal = roman.convertToInteger(romanNum);
		
		assertEquals(3, decimal);
	}
	
	@Test
	public void testNumber() throws IllegalOccurrenceLetter{
		
		romanNum = "MMXV";
		decimal = roman.convertToInteger(romanNum);
		
		assertEquals(2015, decimal);
	}
	
	@Test(expected = IllegalOccurrenceLetter.class)
	public void testIllegalOccurenceLetterException() throws IllegalOccurrenceLetter {
		
		romanNum = "IIII";
		decimal= roman.convertToInteger(romanNum);
	}

}
