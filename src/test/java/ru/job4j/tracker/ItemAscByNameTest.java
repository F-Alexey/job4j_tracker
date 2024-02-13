package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class ItemAscByNameTest {

    @Test
    void whenCompareByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("4"));
        items.add(new Item("3"));
        items.add(new Item("2"));
        items.add(new Item("1"));
        items.sort(new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("1"));
        expected.add(new Item("2"));
        expected.add(new Item("3"));
        expected.add(new Item("4"));
        assertThat(items.toString()).isEqualTo(expected.toString());
    }

    @Test
    void whenCompareDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("1"));
        items.add(new Item("2"));
        items.add(new Item("3"));
        items.add(new Item("4"));
        items.sort(new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("4"));
        expected.add(new Item("3"));
        expected.add(new Item("2"));
        expected.add(new Item("1"));
        assertThat(items.toString()).isEqualTo(expected.toString());
    }
}