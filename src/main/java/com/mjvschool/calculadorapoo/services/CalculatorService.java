package com.mjvschool.calculadorapoo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorService {

    public Long add(Long num1, Long num2) {
        return Math.addExact(num1, num2);
    }

    public Long subtract(Long num1, Long num2) {
        return Math.subtractExact(num1, num2);
    }

    public Long multiply(Long num1, Long num2) {
        return Math.multiplyExact(num1, num2);
    }

    public Long divide(Long num1, Long num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }

}
