package calculator;

import java.util.StringTokenizer;

import exception.NegativeValueException;

class StringCalculator {
	private static final String delimiter = "\n|;|,|%";
	//StringTokenizer stk = new StringTokenizer(delimiter);
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
			else if(temp>1000)
				continue;
			result += temp;
		}
		if(flag)
			throw new NegativeValueException("negative values not allowed"+negativeValues);
		return result;
	}
	
	private static String[] stringToInt(String input) {
		//String[] s = string.split(delimiter);
		String[] values = null;
		StringBuilder dl = new StringBuilder("\\n,");
        StringBuilder ainput = new StringBuilder();
        if ( input.startsWith("//") ){
            dl.append(input, input.indexOf("//")+2, input.indexOf("\n")); // String between // and \n
            ainput.append( input.substring(input.indexOf("\n")) );
        }else{
            ainput.append(input);
        }
        
        values = ainput.toString().split("["+dl+"]");
        
		return values;
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