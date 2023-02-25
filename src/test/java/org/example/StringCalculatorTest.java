package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    void empty_string_should_add_to_zero() {
        assertThat(new StringCalculator().add("")).isZero();
    }

    @ParameterizedTest(name = "input numbers {0} add to {1}")
    @CsvSource({
            "1, 1",
            "2, 2",
            "10, 10",
            "2022, 2022",
    })
    void single_number_string_should_add_to_that_number(String input, int sumExpected) {
        assertThat(new StringCalculator().add(input)).isEqualTo(sumExpected);
    }
}
