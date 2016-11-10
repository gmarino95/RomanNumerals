import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {
	
	private int decimal;
	private String romanNum;
	private RomanNumerals roman= new RomanNumerals();

	@Test
	public void testonecharacter() {
		
		romanNum = "V";
		decimal = roman.convertToInteger(romanNum);
		
		assertEquals(5, decimal);
	}
	
	@Test
	public void testthreecharacter(){
		
		romanNum = "III";
		decimal = roman.convertToInteger(romanNum);
		
		assertEquals(3, decimal);
	}
	
	@Test
	public void testNumber(){
		
		romanNum = "MMXV";
		decimal = roman.convertToInteger(romanNum);
		
		assertEquals(2015, decimal);
	}

}
