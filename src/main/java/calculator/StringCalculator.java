package calculator;

class StringCalculator {
	
	private boolean Empty(String string) {
		return string.isEmpty();
	}
	
	private static int sum(String input) {
		String[] s1 = stringToInt(input); 
		int result = 0;
		for (String string : s1) {
			result += Integer.parseInt(string);
		}
		return result;
	}
	
	private static String[] stringToInt(String string) {
		String[] s = string.split(",");
		return s;
	}
	
    public int add(String input) {
    	if(Empty(input)) 
    		return 0;
    	else if(input.length()==1)
    		return Integer.parseInt(input);
    	//String[] s = stringToInt(input);
    	return sum(input);
    }
    
}