package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
//        HashSet<String> setH = new HashSet<>();
//        String file = "d:\\PersonsDB.txt";
//        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner(new File(file)));
//
//        while (personScannerAdapter.fileScanner.hasNextLine()) {
//            Person person = personScannerAdapter.read();
//            setH.add(person.toString());
//        }
//        setH.forEach(System.out::println);
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String str = fileScanner.nextLine();
            String[] split = str.split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(split[5]), Integer.parseInt(split[4]) - 1, Integer.parseInt(split[3]));
            Date date = calendar.getTime();
            Person person = new Person(split[1], split[2], split[0], date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
