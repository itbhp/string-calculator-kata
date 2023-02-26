package org.example;

import static java.util.Arrays.stream;

public class StringCalculator {

    int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        var numbers = input.split(",");
        return stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
