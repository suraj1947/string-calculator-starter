package calculator;

class StringCalculator {
	
	private boolean Empty(String string) {
		return string.isEmpty();
	}
	
	private static int sum(String s1,String s2) {
		return Integer.parseInt(s1)+Integer.parseInt(s2);
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
    		return sum(s[0],s[1]);
    }
    
}