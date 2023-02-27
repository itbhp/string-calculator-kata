package org.example;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

public class StringCalculator {

    record SeparatorStrategy(String suffix, Function<String, String> escape) {
    }

    private final Map<String, SeparatorStrategy> strategyMap = Map.of(
            "//[", new SeparatorStrategy("]\n", Pattern::quote),
            "//", new SeparatorStrategy("\n", Function.identity())
    );

    int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return strategyMap.entrySet().stream()
                .filter(entry -> input.startsWith(entry.getKey()))
                .findFirst()
                .map(entry -> {
                    var prefix = entry.getKey();
                    var strategy = entry.getValue();
                    int endIndex = input.indexOf(strategy.suffix);
                    var separator = input.substring(prefix.length(), endIndex);
                    String substring = input.substring(endIndex + prefix.length() - 1);
                    return sumNumbers(strategy.escape.apply(separator), substring);
                }).orElseGet(() -> sumNumbers("[\\n,]", input));
    }

    private static int sumNumbers(String separator, String input) {
        var numbers = input.split(separator);
        List<Integer> parsedNumbers = stream(numbers)
                .map(Integer::parseInt)
                .toList();
        validate(parsedNumbers);
        return parsedNumbers.stream().mapToInt(value -> value).sum();
    }

    private static void validate(List<Integer> parsedNumbers) {
        boolean containsNegative = parsedNumbers.stream().anyMatch(n -> n < 0);
        if (containsNegative) {
            throw new NegativeNumbersException(parsedNumbers);
        }
    }
}
