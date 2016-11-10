
public class RomanNumerals {
	public int convertToInteger(String romanNum) {
		
		int decimal = 0;
		int lastNumber = 0;
		
		String romanNumeral = romanNum.toUpperCase();
		
		for(int i = romanNumeral.length() - 1; i >= 0; i--){
			
			char convertToDecimal = romanNum.charAt(i);
			
			switch (convertToDecimal){
				case'M': 
					decimal = processDecimal(1000, lastNumber, decimal);
					lastNumber = 1000;
					break;
				
				case 'D':
					decimal = processDecimal(500, lastNumber, decimal);
					lastNumber = 500;
					break;
					
				case 'C':
					decimal = processDecimal(100, lastNumber, decimal);
					lastNumber = 100;
					break;
					
				case 'L':
					decimal = processDecimal(50, lastNumber, decimal);
					lastNumber = 50;
					break;
					
				case 'X':
					decimal = processDecimal(10, lastNumber, decimal);
					lastNumber = 10;
					break;
					
				case 'V':
					decimal = processDecimal(5, lastNumber, decimal);
					lastNumber = 5;
					break;
					
				case 'I':
					decimal = processDecimal(1, lastNumber,decimal);
					lastNumber = 1;
					break;
			}	
		}
		return decimal;	
	}
	
	public int processDecimal(int decimal, int lastNumber, int lastDecimal){
		
		if(lastNumber > decimal){
			return lastDecimal;
		}
		else{
			return lastDecimal + decimal;
		}
	}
}
