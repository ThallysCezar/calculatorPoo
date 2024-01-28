package com.mjvschool.calculadorapoo.utils;

import com.mjvschool.calculadorapoo.exceptions.InvalidInputException;
import org.springframework.stereotype.Component;

@Component
public class CalculatorUtils {
    public static void validateInput(Long num1, Long num2) throws InvalidInputException{
        if (!isValidNumber(num1) || !isValidNumber(num2)) {
            throw new InvalidInputException("Invalid numbers. Make sure you enter valid numbers.");
        }
    }

    private static boolean isValidNumber(Long number) {
        return number != null;
    }

}
