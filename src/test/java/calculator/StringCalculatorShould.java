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
    	assertThrows(Exception.class,()->stringCalculator.add("//;\n1;-2"));
    }
    
    @Test
    void string_with_multiple_negative_number() {
    	assertThrows(Exception.class,()->stringCalculator.add("//;\n-1;-2;-3"));
    }
}
