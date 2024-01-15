package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class FactorialTest {

    @Test
    void whenException() {
        int num = -2;
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    factorial.calc(num);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }
}