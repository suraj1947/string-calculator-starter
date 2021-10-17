package calculator;

import exception.NegativeValueException;

class StringCalculator {
	private static final String delimiter = ",|\n";
	private boolean Empty(String string) {
		return string.isEmpty();
	}
	
	private static int sum(String input) throws NegativeValueException {
		String[] s1 = stringToInt(input); 
		String negativeValues = null;
		int result = 0;
		boolean flag = false;
		for (String string : s1) {
			int temp = Integer.parseInt(string);
			if(temp<0) {
				flag = true;
				negativeValues += temp+" ";
			}
			else
			result += temp;
		}
		if(flag)
			throw new NegativeValueException("value cannot be negative"+negativeValues);
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

	public static Integer getCount() {
		// TODO Auto-generated method stub
		return null;
	}
    
}