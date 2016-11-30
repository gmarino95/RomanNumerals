package RomanConversion;
import exceptions.IllegalCharacterException;
import exceptions.IllegalSubtractionException;
import exceptions.TooMuchSymbolRepetitionsException;

public class RomanNumerals {
	public static int convertToInteger(String romanNum) throws IllegalSubtractionException, TooMuchSymbolRepetitionsException, IllegalCharacterException {
		
		int decimal = 0;
		int lastNumber = 0;
		int numberToSum = 0;
		
		int counterI = 0;
		int counterC = 0;
		int counterX = 0;
		int counterM = 0;
		int counterD = 0;
		int counterL = 0;
		int counterV = 0;
		
		
		String romanNumeral = romanNum.toUpperCase();
		
		//Processo la stringa da sinistra verso destra
		for(int i = romanNumeral.length() - 1; i >= 0; i--){
			
			 //Estraggo i caratteri romani uno per uno
			char charToConvert = romanNum.charAt(i);
			
			switch(charToConvert){
				
				case 'M':
					if(counterM < 3){
						/*
						 *  Se l'ultima operazione è stata una sottrazione ed il prossimo
						 * ha un valore minore o uguale a quello sottratto inprecedenza
						 * si tratta di due sottrazione consecutive (illegale)
						 */
						if(numberToSum < 0 && Math.abs(addOrSubtract(1000, lastNumber)) <= lastNumber)
							throw new IllegalSubtractionException();
						
						numberToSum = addOrSubtract(1000, lastNumber);
						decimal += numberToSum;
						lastNumber = 1000;
						counterM++;
					} else {
						
						throw new TooMuchSymbolRepetitionsException();
					}
					break;
					
				case 'D':
					if(counterD < 1){
						if(numberToSum < 0 && Math.abs(addOrSubtract(500, lastNumber)) <= lastNumber)
							throw new IllegalSubtractionException();
						
						numberToSum = addOrSubtract(500, lastNumber);
						decimal += numberToSum;
						lastNumber = 500;
						counterD++;
					} else {
						
						throw new TooMuchSymbolRepetitionsException();
					}
					break;
					
				case 'C':
					if(counterC < 3){
						if(numberToSum < 0 && Math.abs(addOrSubtract(100, lastNumber)) <= lastNumber)
							throw new IllegalSubtractionException();
						
						numberToSum = addOrSubtract(100, lastNumber);
						decimal += numberToSum;
						lastNumber = 100;
						counterC++;
					} else {
						
						throw new TooMuchSymbolRepetitionsException();
					}
					break;
					
				case 'L':
					if(counterL < 1){
						if(numberToSum <0 && Math.abs(addOrSubtract(50, lastNumber)) >= lastNumber)
							throw new IllegalSubtractionException();
						
						numberToSum = addOrSubtract(50, lastNumber);
						decimal += numberToSum;
						lastNumber = 50;
						counterL++;
					} else {
						
						throw new TooMuchSymbolRepetitionsException();
					}
					break;
					
				case 'X':
					if(counterX < 3){
						if(numberToSum < 0 && Math.abs(addOrSubtract(10,lastNumber)) <= lastNumber)
							throw new IllegalSubtractionException();
						
						numberToSum = addOrSubtract(10,lastNumber);
						decimal += numberToSum;
						lastNumber = 10;
						counterX++;
					} else {
						
						throw new TooMuchSymbolRepetitionsException();
					}
					break;
					
				case 'V':
					if(counterV < 1){
						if(numberToSum < 0 && Math.abs(addOrSubtract(5, lastNumber)) <= lastNumber)
							throw new IllegalSubtractionException();
						
						numberToSum = addOrSubtract(5, lastNumber);
						decimal += numberToSum;
						lastNumber = 5;
						counterV++;
					} else {
						
						throw new TooMuchSymbolRepetitionsException();
					}
					break;
					
				case 'I':
					if(counterI < 3){
						if(numberToSum < 0 && Math.abs(addOrSubtract(1, lastNumber)) <= lastNumber)
							throw new IllegalSubtractionException();
						
						numberToSum = addOrSubtract(1, lastNumber);
						decimal += numberToSum;
						lastNumber = 1;
						counterI++;
					} else {
						
						throw new TooMuchSymbolRepetitionsException();
					}
					break;
					
				default:
					
					throw new IllegalCharacterException();		
			} //fine switch
		} //fine for
		
		return decimal;
	}
	
	private static int addOrSubtract(int actualNumber, int previousNumber) throws IllegalSubtractionException {	
		/*
		 * Nel caso in cui il valore del carattere da processare è minore del
		 * valore del carattere più a destra viene sottratto al numero calcolato
		 * finore. altrimenti viene sommato.
		 */
		if(actualNumber < previousNumber){
			
			//I numeri con il '5' ('V', 'L' e 'D') non potranno mai essere sotratti.
			if(actualNumber == 5 || actualNumber == 50 || actualNumber == 500)
				throw new IllegalSubtractionException();
			
			/*
			 * I numeri con l' '1' ('I', 'X' e 'C') possono essere sotratti solo
			 * con il secondo valore successivo più alto ('IV' e 'IX', 'XL' e 'XC',
			 * 'CD' e 'CM').
			 */
			if((actualNumber == 1 && previousNumber != 5 && previousNumber != 10) 
				|| (actualNumber == 10 && previousNumber != 50 && previousNumber != 100) 
			    || (actualNumber == 100 && previousNumber != 500 && previousNumber != 1000)){
			    	
				throw new IllegalSubtractionException();
			}
			
			return -actualNumber;
		} else {
			return actualNumber;
		}
	}
}