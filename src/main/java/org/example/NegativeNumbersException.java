package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class NegativeNumbersException extends RuntimeException {
    public NegativeNumbersException(List<Integer> input) {
        super("Found negative numbers in " +
                input.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

}
