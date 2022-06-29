package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
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

    public static void main(String[] args)  throws Exception {
        if (args.length == 0) {return;}

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        List<Product> products = new ArrayList<>();

        getListProductFromFilename(fileName, products);

        int id;
        switch (args[0]) {
            case "-u": {
                id = Integer.parseInt(args[1]);
                updateProduct(id, products, args);
                break;
            }
            case "-d": {
                id = Integer.parseInt(args[1]);
                deleteProduct(id, products);
                break;
            }
            case "-l": {
                listProduct(products);
                break;
            }
        }

        // перезаписываем файл
        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            for (Product product : products) {
                fileWriter.write(product.toString());
                fileWriter.write("\n");
            }
        }
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

    public static Product getProduct(String string) {
        String id = string.substring(0, 8).trim();
        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id), name, price, quantity);
    }

    public static void listProduct(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public static void updateProduct(int id, List<Product> products, String[] args) {
        String name = "";
        for (int i = 2; i < args.length - 2; i++) {
            name += args[i] + " ";
        }
        if (name.length() > 30) {
            name = name.substring(0, 30);
        }
        String price = args[args.length - 2];
        if (price.length() > 8) {
            price = price.substring(0, 8);
        }
        String quantity = args[args.length - 1];
        if (quantity.length() > 4) {
            quantity = quantity.substring(0, 4);
        }
        Product productToUpdate = null;
        for (Product product : products) {
            if (product.id == id) productToUpdate = product;
        }
        if (productToUpdate != null) {
            productToUpdate.name = name;
            productToUpdate.price = price;
            productToUpdate.quantity = quantity;
        }
    }

    public static  void deleteProduct(int id, List<Product> products) {
        Product productToDelete = null;
        for (Product product : products) {
            if (product.id == id) productToDelete = product;
        }
        if (productToDelete != null) products.remove(productToDelete);
    }
}
