package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        if (args.length == 0) return;
        TreeMap<String, Double> salary = new TreeMap<>();
        String fileName = args[0];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                addPeople(line);
                //System.out.println(line);
            }
        } catch (IOException ignore) {
            /*NOP */
        }
        //PEOPLE.forEach(s->System.out.println(s.getName()+" "+s.getBirthDate()));
    }

    private static void addPeople(String line) {
        String[] stringArray = line.split(" ");
        if (stringArray.length < 4) {System.out.println("Ошибка в данных: "+line);}

        // get name
        StringBuffer name = new StringBuffer();
        for (int i = 0; i < stringArray.length - 3; i++) {
            name.append(stringArray[i]).append(" ");
        }
        // get birthDay
        int year = Integer.parseInt(stringArray[stringArray.length - 1]);
        int month = Integer.parseInt(stringArray[stringArray.length - 2]) - 1; //January == 0.
        int day = Integer.parseInt(stringArray[stringArray.length - 3]);
        Calendar birthDay = new GregorianCalendar(year, month, day);

        PEOPLE.add(new Person(name.toString().trim(), birthDay.getTime()));
    }
}
