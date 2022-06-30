package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.Random;

/* 
Генератор паролей
*/

//        Требования к паролю:
//        1) 8 символов.
//        2) только цифры и латинские буквы разного регистра.
//        3) обязательно должны присутствовать цифры, и буквы разного регистра.
//        Все сгенерированные пароли должны быть уникальные.
//          wMh7smNu
//"ayzAYZ0123456789".chars().forEach(s->System.out.print(s + " "));
//a  z   A  Z  0  1  2  3  4  5  6  7  8  9
//97 122 65 90 48 49 50 51 52 53 54 55 56 57

public class Solution {
    private static byte[] ab = new byte[62];

    public static void main(String[] args) {
        generationArrayByte();
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    private static void generationArrayByte() {
        int i = 0;

        for (byte j = 97; j <= 122; j++, i++) {
            ab[i] = j;
        }
        for (byte j = 65; j <= 90; j++, i++) {
            ab[i] = j;
        }
        for (byte j = 48; j <= 57; j++, i++) {
            ab[i] = j;
        }
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
        while (true) {
            byteAOS.reset();
            for (int i = 0; i < 8; i++) {
                byteAOS.write((char) ab[getRandom()]);
            }
            if (passwordValid(byteAOS.toString())) {
                return byteAOS;
            }
        }
    }

    private static boolean passwordValid(String passwd) {
        //String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}"; // специальный символ должен появляться по крайней мере один раз
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
        //        (?=.*[0-9]) цифра должна появляться по крайней мере один раз
        //        (?=.*[a-z]) строчная буква должна появляться как минимум раз
        //        (?=.*[a-z]) письмо с верхним регистром должно происходить по крайней мере один раз
        //        (?=.*[@#$%^&+=]) специальный символ должен появляться по крайней мере один раз
        //        (?=\\S+$) пробелы не разрешены во всей строке
        //        .{8,} не менее 8 символов
        return passwd.matches(pattern);
    }

    public static int getRandom() {
        Random rn = new Random();
        int answer = rn.nextInt(62);
        return answer;
    }
}


/*
//package com.javarush.task.task32.task3204;

//import java.io.ByteArrayOutputStream;


//Генератор паролей


public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password);
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream is = new ByteArrayOutputStream();
        Basket[] baskets = new Basket[3];
        baskets[0] = new Basket('0', '9');
        baskets[1] = new Basket('a', 'z');
        baskets[2] = new Basket('A', 'Z');
        int i = 0;
        for (; i < 5; i++) {
            int index = (int) (Math.random() * 3);
            generateChar(is, baskets, index);
        }
        for (int j = 0; j < baskets.length; j++) {
            generateChar(is, baskets, j);
            i++;
        }

        while (i < 8) {
            int index = (int) (Math.random() * 3);
            generateChar(is, baskets, index);
            i++;
        }
        return is;
    }

    private static void generateChar(ByteArrayOutputStream is, Basket[] baskets, int index) {
        Basket basket = baskets[index];
        is.write((char) basket.getRandom());
    }

    public static class Basket {
        int begin;
        int quantity;

        private Basket(char begin, char end) {
            this.begin = begin;
            this.quantity = end - begin + 1;
        }

        public int getRandom() {
            return (int) (Math.random() * quantity) + begin;
        }
    }
}
*/
