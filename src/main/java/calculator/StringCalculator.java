package calculator;

class StringCalculator {
	
	private boolean Empty(String string) {
		return string.isEmpty();
	}
	private String[] stringToInt(String string) {
		String[] s = string.split(",");
		return s;
	}
    public int add(String input) {
    	if(Empty(input)) 
    		return 0;
    	else if(input.length()==1)
    		return Integer.parseInt(input);
    	String[] s = stringToInt(input);
    		return Integer.parseInt(s[0])+Integer.parseInt(s[1]);
    }
    
}