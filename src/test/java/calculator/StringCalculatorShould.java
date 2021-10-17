package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {
	private StringCalculator stringCalculator = new StringCalculator();
	
    @Test
    void empty_string_should_return_0() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        assertEquals(1, stringCalculator.add("1"));
    }
    @Test
    void string_with_two_numbers_should_return_sum_as_int() {
    	assertEquals(3, stringCalculator.add("1,2"));
    }
    
    @Test
    void string_with_three_numbers_should_return_sum_as_int() {
    	assertEquals(6, stringCalculator.add("1,2,3"));
    }
    
    @Test
    void string_with_newLine_delimiter() {
    	assertEquals(3, stringCalculator.add("1\n2"));
    }
}
