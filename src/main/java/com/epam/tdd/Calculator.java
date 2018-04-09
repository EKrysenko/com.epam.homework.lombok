package com.epam.tdd;

public class Calculator {

    public long factorial(int number) {
        if (number <= 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    public int multiply(int...nums) {
        int result = 1;
        for (int num: nums) {
            result *= num;
        }
        return result;
    }

    public double divide(int a, int b){
        if (b == 0){
            throw new ArithmeticException();
        }
        return (double) a / b;
    }
}

