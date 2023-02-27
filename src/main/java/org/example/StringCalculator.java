package org.example;

import java.util.List;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

public class StringCalculator {

    int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (input.startsWith("//[")) {
            int endIndex = input.indexOf("]\n");
            var separator = input.substring(3, endIndex);
            String substring = input.substring(endIndex + 2);
            return sumNumbers(Pattern.quote(separator), substring);
        }
        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\n");
            var separator = input.substring(2, endIndex);
            String substring = input.substring(endIndex + 1);
            return sumNumbers(separator, substring);
        }
        return sumNumbers("[\\n,]", input);
    }

    private static int sumNumbers(String separator, String input) {
        var numbers = input.split(separator);
        List<Integer> parsedNumbers = stream(numbers)
                .map(Integer::parseInt)
                .toList();
        validate(parsedNumbers);
        return  parsedNumbers.stream().mapToInt(value -> value).sum();
    }

    private static void validate(List<Integer> parsedNumbers) {
        boolean containsNegative = parsedNumbers.stream().anyMatch(n -> n < 0);
        if (containsNegative){
            throw new NegativeNumbersException(parsedNumbers);
        }
    }

}
