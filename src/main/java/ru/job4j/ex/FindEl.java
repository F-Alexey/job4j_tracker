package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Элемент не найден");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] word = {"a", "b", "c", "d", "e"};
        String letter = "l";
        try {
            indexOf(word, letter);
        } catch (ElementNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
