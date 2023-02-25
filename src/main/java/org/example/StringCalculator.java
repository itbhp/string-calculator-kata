package org.example;

public class StringCalculator
{
    int add(String numbers) {
        if(!numbers.isEmpty()){
            return Integer.parseInt(numbers);
        }
        return 0;
    }
}
