package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void empty_string_should_add_to_zero() {
        assertThat(calculator.add("")).isZero();
    }

    @ParameterizedTest(name = "input numbers {0} add to {1}")
    @CsvSource({
            "1, 1",
            "2, 2",
            "10, 10",
            "2022, 2022",
    })
    void single_number_string_should_add_to_that_number(String input, int sumExpected) {
        assertThat(calculator.add(input)).isEqualTo(sumExpected);
    }

    @Test
    void adding_two_numbers_should_return_their_sum() {
        assertThat(calculator.add("12,23")).isEqualTo(35);
    }

    @Test
    void adding_unknown_number_of_numbers() {
        assertThat(calculator.add("1,2,3,4,5,6,7,8,9")).isEqualTo(45);
    }

    @Test
    void accept_new_line_as_separator() {
        assertThat(calculator.add("1\n2,3")).isEqualTo(6);
    }

    @Test
    void accept_custom_separator() {
        assertThat(calculator.add("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void negative_numbers_are_not_allowed() {
        assertThatThrownBy(() -> calculator.add("1,-2,-3"))
                .withFailMessage(() -> "Found negative numbers in 1,-2,-3")
                .isInstanceOf(NegativeNumbersException.class);
    }
}
