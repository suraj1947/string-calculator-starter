package calculator;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.SubstringMatcher;

import exception.NegativeValueException;


class StringCalculator
{	
	private String input;
	private String delimiter;
	private int calledCount = 0;
    private void setInput(String inPut)
    {
    	input = inPut;
    }
    
	private void setDelimiter()
	{
		if(input.startsWith("//["))
		{
			delimiter = input.split("]\n")[0].substring(3);
			setInput(input.substring(delimiter.length()+5));
			if(delimiter.contains("]["))
				delimiter = delimiter.replace("][", "|");
		}
		else if(input.startsWith("//"))
		{
    		delimiter = input.split("\n")[0].substring(2);
    		setInput(input.substring(4));
    	}
    	else
    		delimiter = "[,\n]";
	}
	
	public int getCalledCount()
	{
		return this.calledCount;
	}
	
	public int add(String inPut) throws NegativeValueException
	{
		calledCount += 1;
		setInput(inPut);	
    	setDelimiter();
    	String stringNumbers[] = input.split(delimiter);
    	
    	if(input == "")
    		return 0;
		else if(input.length() == 1)
       		return Integer.parseInt(stringNumbers[0]);
		else
		{ 
			if(input.startsWith("M*")) {
				String s = input.substring(2);
				String stringNumber[] = s.split(delimiter);
				System.out.println(s);
				for (String string : stringNumber) {
					System.out.println(string);
				}
				int Msum = 0;
				List<Integer> integerList = conversionAndTesting(stringNumber);
				for (Integer integer : integerList) {
					Msum += integer*3;
				}
				return Msum;
				
			}
			List<Integer> integerList = conversionAndTesting(stringNumbers);
			int result = 0;
			for(Integer I : integerList)
				result += I > 1000 ? 0 : I;
			return result;
		}
    }
	
    private List<Integer> conversionAndTesting(String stringNumbers[]) throws NegativeValueException
    {
    	List<Integer> integerList = new ArrayList<>();
    	for(String S : stringNumbers)
    		integerList.add(Integer.parseInt(S));
    	List<Integer> negativeIntegerList = new ArrayList<>();
    	for(Integer I : integerList)
    	{
    		if(I < 0)
    			negativeIntegerList.add(I);
    	}
    	if(negativeIntegerList.size() > 0)
    	{
    		StringBuilder Message = new StringBuilder("Negatives not allowed.\nNegative passed:");
    		for(Integer I : negativeIntegerList)
    			Message.append(" "+I);
    		throw new NegativeValueException(Message.toString());
    	}
    	return integerList;
    }
}