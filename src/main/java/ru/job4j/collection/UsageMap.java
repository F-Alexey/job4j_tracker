package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("fedossev.a@gmail.com", "Fedoseev Aleksey");
        map.put("testmail@gmail.com", "Test User");
        map.put("company.help@gmail.com", "Company Engineer");
        System.out.println("Вывод всех элементов коллекции:");
        int i = 0;
        for (String key: map.keySet()) {
            String value = map.get(key);
            System.out.println(i++ + ". " + key + " " + value);
        }

    }
}
