package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    void empty_string_should_add_to_zero() {
        assertThat(new StringCalculator().add("")).isZero();
    }
}
