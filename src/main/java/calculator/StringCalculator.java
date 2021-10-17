package calculator;

import exception.NegativeValueException;

class StringCalculator {
	private static final String delimiter = ",|\n|;";
	private static int counter=0;
	private boolean Empty(String string) {
		return string.isEmpty();
	}
	
	private int sum(String input) throws NegativeValueException {
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
			throw new NegativeValueException("negative values not allowed"+negativeValues);
		return result;
	}
	
	private static String[] stringToInt(String string) {
		String[] s = string.split(delimiter);
		return s;
	}
	
	public int getCount() {
		System.out.println(counter);
		return counter;
	}
    
	
    public int add(String input) throws NegativeValueException {
    	counter+=1;
    	if(Empty(input)) 
    		return 0;
    	else if(input.length()==1)
    		return Integer.parseInt(input);
    	//String[] s = stringToInt(input);
    	return sum(input);
    }

}