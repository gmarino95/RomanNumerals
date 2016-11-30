package test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import RomanConversion.RomanNumerals;
import exceptions.IllegalCharacterException;
import exceptions.IllegalSubtractionException;
import exceptions.TooMuchSymbolRepetitionsException;

@RunWith(Parameterized.class)
public class TestSymbolRepetitionException{

	@Parameters
	public static Collection<Object> data(){
		return Arrays.asList(new Object[] {"MMMM", "DD", "CCCC", "LL", "XXXX", "VV", "IIII"});
	};
	
	private String input;
	
	public TestSymbolRepetitionException(String input){
		this.input = input;
	}
	
	@Test (expected = TooMuchSymbolRepetitionsException.class)
	public void test() throws  IllegalCharacterException, TooMuchSymbolRepetitionsException, IllegalSubtractionException{
		//Act
		RomanNumerals.convertToInteger(input);
	}
	
}
