package calculator;

import exception.NegativeValueException;

class StringCalculator {
	private static final String delimiter = ",|\n";
	private boolean Empty(String string) {
		return string.isEmpty();
	}
	
	private static int sum(String input) throws NegativeValueException {
		String[] s1 = stringToInt(input); 
		int result = 0;
		for (String string : s1) {
			int temp = Integer.parseInt(string);
			if(temp<0)
				throw new NegativeValueException("negative number not allowed");
			result += temp;
		}
		return result;
	}
	
	private static String[] stringToInt(String string) {
		String[] s = string.split(delimiter);
		return s;
	}
	
    public int add(String input) throws NegativeValueException {
    	if(Empty(input)) 
    		return 0;
    	else if(input.length()==1)
    		return Integer.parseInt(input);
    	//String[] s = stringToInt(input);
    	return sum(input);
    }
    
}