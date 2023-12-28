package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int temp = -1;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product == null) {
                temp = i;
                break;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        System.out.println(indexOfNull(products));
    }
}
