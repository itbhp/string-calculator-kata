package org.example;

import java.util.Arrays;

public class StringCalculator {
    int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(",");
        return Arrays.stream(numbers)
                .mapToInt(StringCalculator::parse)
                .sum();
    }

    private static int parse(String input) {
        return Integer.parseInt(input);
    }
}
