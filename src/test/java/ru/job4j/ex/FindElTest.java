package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class FindElTest {

    @Test
    void whenIndexIsCorrect() throws ElementNotFoundException {
        String[] word = {"a", "b", "c", "d", "e"};
        String letter = "c";
        int result = FindEl.indexOf(word, letter);
        int expected = 2;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenIndexIsNotCorrect() {
        String[] word = {"a", "b", "c", "d", "e"};
        String letter = "l";
        ElementNotFoundException exception = assertThrows(
                ElementNotFoundException.class,
                () -> FindEl.indexOf(word, letter));
        assertThat(exception.getMessage()).isEqualTo("Элемент не найден");
    }
}