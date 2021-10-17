package calculator;

class StringCalculator {

    public int add(String input) {
    	if(input.length()!=0) {
    		int a = Integer.parseInt(input);
    		return a;
    	}
    	return 0;
    }

}