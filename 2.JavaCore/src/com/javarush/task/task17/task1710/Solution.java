package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws ParseException {
        //напишите тут ваш код
        Person person;

        String name;
        String sex;
        Date birthdayDate;
        int id;

//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//        }

        if (args.length > 0) {
            if (args[0].equals("-c")) {                  // добавление человека
                name = args[1];
                sex = args[2];
                birthdayDate = simpleDateFormat.parse(args[3]);
                if (sex.equals("м")) {
                    allPeople.add(Person.createMale(name, birthdayDate));       //    id=2
                } else if (sex.equals("ж")) {
                    allPeople.add(Person.createFemale(name, birthdayDate));     //    id=2
                } else {
                    System.out.println("Неверно задан пол (должен быть м  ж)");
                }
                System.out.println(allPeople.size() - 1);

            } else if (args[0].equals("-r")) {           // возврат инфы
                id = Integer.valueOf(args[1]);
                System.out.println(allPeople.get(id).getName() + " " +
                        (allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж") + " " +
                        simpleDateFormat2.format(allPeople.get(id).getBirthDate()));

            } else  if (args[0].equals("-u")) {          // обновление данных
                id = Integer.valueOf(args[1]);
                name = args[2];
                sex = args[3];
                birthdayDate = simpleDateFormat.parse(args[4]);


                person = allPeople.get(id);
                if (person == null) {
                    throw new IllegalArgumentException();
                }
                person.setSex(getSex(args[3]));
                person.setBirthDate(birthdayDate);
                person.setName(name);
                allPeople.set(id, person);

            } else if (args[0].equals("-d")) {           // логическое удаление
                id = Integer.valueOf(args[1]);
                person = allPeople.get(id);
                if (person == null) {
                    throw new IllegalArgumentException();
                }
                person.setSex(null);
                person.setBirthDate(null);
                person.setName(null);
                allPeople.set(id, person);
            } else {
                System.out.println("Неправильный первый параметр: " + args[0] + " (должен быть -c  - r  -u  -d)");
            }
        }

//        System.out.println("=======================================");
//        try {
//            for (int i = 0; i < allPeople.size(); i++) {
//                System.out.println(allPeople.get(i).getName() + " " +
//                        (allPeople.get(i).getSex() == Sex.MALE ? "м" : "ж") + " " +
//                        simpleDateFormat2.format(allPeople.get(i).getBirthDate()));
//
//            }
//        } catch (Exception e) {
//
//        }

    }

    private static Sex getSex(String sexParam) {
        return sexParam.equals("м") ? Sex.MALE : Sex.FEMALE;
    }
}
