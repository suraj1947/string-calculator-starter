package calculator;

import org.junit.jupiter.api.Test;

import exception.NegativeValueException;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {
	private StringCalculator stringCalculator = new StringCalculator();
	
    @Test
    void empty_string_should_return_0() throws NegativeValueException {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() throws NegativeValueException {
        assertEquals(1, stringCalculator.add("1"));
    }
    @Test
    void string_with_two_numbers_should_return_sum_as_int() throws NegativeValueException {
    	assertEquals(3, stringCalculator.add("1,2"));
    }
    
    @Test
    void string_with_three_numbers_should_return_sum_as_int() throws NegativeValueException {
    	assertEquals(6, stringCalculator.add("1,2,3"));
    }
    
    @Test
    void string_with_newLine_delimiter() throws NegativeValueException {
    	assertEquals(3, stringCalculator.add("1\n2"));
    }
    
    void string_with_diffrent_delimiters() throws NegativeValueException {
    	assertEquals(3, stringCalculator.add("//;\n1;2"));
    }
    @Test
    void string_with_negative_number() {
    	assertThrows(Exception.class,()->stringCalculator.add("//[;]\n1;-2"));
    }
    
    @Test
    void string_with_multiple_negative_number() {
    	assertThrows(Exception.class,()->stringCalculator.add("//;\n-1;-2;-3"));
    }
    
    @Test 
    void string_called_count_add(){
    	assertEquals(0, stringCalculator.getCalledCount());
    }
    
    @Test
    void string_ignore_numbers_greater_than_1000() throws NegativeValueException {
    	assertEquals(30, stringCalculator.add("//[,]\n10,20,1001"));
    }
    
    @Test
    void string_multiple_delimiters() throws NegativeValueException {
    	assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
    }
    
    @Test
    void string_with_many_delimiters() throws NegativeValueException {
    	assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }
    @Test
    void string_with_many_multiple_delimiters() throws NegativeValueException {
    	assertEquals(6, stringCalculator.add("//[**][%%]\n1**2%%3"));
    }
    @Test
    void if_input_starts_with_M() throws NegativeValueException {
    	assertEquals(18, stringCalculator.add("M*1,2,3"));
    }
}
