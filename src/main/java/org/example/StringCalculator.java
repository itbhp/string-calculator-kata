package org.example;

public class StringCalculator
{
    int add(String input) {
        if (input.contains(",")){
            String[] numbers = input.split(",");
            return parse(numbers[0]) + parse(numbers[1]);
        }
        if(!input.isEmpty()){
            return parse(input);
        }
        return 0;
    }

    private static int parse(String input) {
        return Integer.parseInt(input);
    }
}
