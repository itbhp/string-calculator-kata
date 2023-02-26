package org.example;

import static java.util.Arrays.stream;

public class StringCalculator {

    int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if(input.startsWith("//")){
            int endIndex = input.indexOf("\n");
            var separator = input.substring(2, endIndex);
            String substring = input.substring(endIndex + 1);
            return sumNumbers(separator, substring);
        }
        return sumNumbers("[\\n,]", input);
    }

    private static int sumNumbers(String separator, String substring) {
        var numbers = substring.split(separator);
        return stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
