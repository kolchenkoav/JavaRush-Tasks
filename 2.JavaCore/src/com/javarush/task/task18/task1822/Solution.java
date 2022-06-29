package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static class Product {
        int id;
        String name;
        String price;
        String quantity;

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
        }

        public Product(int id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {return;}

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str;
        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            while ((str = bufferedFileReader.readLine()) != null) {
                if (str.startsWith(args[0] + " ")) {
                    System.out.println(str);
                    break;
                }
            }
        }

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Введите имя файла: ");
//        String fileName = reader.readLine();
//
//        List<Product> products = new ArrayList<>();
//        getListProductFromFilename(fileName, products);
//
//        int id = Integer.parseInt(args[0]);
//        listProduct(id, products);

    }
    private static void getListProductFromFilename(String fileName, List<Product> products) throws FileNotFoundException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                String s = fileReader.readLine();
                if (s.length() > 1) {
                    Product product = getProduct(s);
                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listProduct(int id, List<Product> products) {
        for (Product product : products) {
            if ((product.id == id)) {
                System.out.println(product.toString());
            }

        }
    }

    public static Product getProduct(String string) {
        String id = string.substring(0, 8).trim();
        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id), name, price, quantity);
    }
}
