package com.javarush.task.task17.task1711;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
       // allPeople.add(Person.createFemale("Иванова Марина", new Date()));  //сегодня родился    id=2
       // allPeople.add(Person.createFemale("Петрова Полина", new Date()));  //сегодня родился    id=3
    }

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws ParseException {

        if (args == null || args.length < 1) {
            System.out.println("Введите параметры -c -u -d -i");
            throw new RuntimeException();
        }

        Date birthdayDate;
        Person person;
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 3) {
                        birthdayDate = simpleDateFormat.parse(args[i + 2]);

                        if (args[i + 1].equals("м")) {
                            person = Person.createMale(args[i], birthdayDate);
                        } else {
                            person = Person.createFemale(args[i], birthdayDate);
                        }

                        allPeople.add(person);
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        person = allPeople.get(id);
                        System.out.print(person.getName() + " ");
                        System.out.print(person.getSex().equals(Sex.MALE) ? "м " : "ж ");
                        System.out.println(simpleDateFormat2.format(person.getBirthDate()));
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) {
                        int id = Integer.parseInt(args[i]);
                        String name = args[i + 1];
                        String sex = args[i + 2];
                        Date date = simpleDateFormat.parse(args[i + 3]);
                        allPeople.get(id).setName(name);
                        allPeople.get(id).setSex("м".equals(sex) ? Sex.MALE : Sex.FEMALE);
                        allPeople.get(id).setBirthDate(date);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                    }
                }
                break;
        }

//        System.out.println("=======================================");
//        for (int i = 0; i < allPeople.size(); i++) {
//            String s = "";
//            String s1 = "";
//            if (allPeople.get(i).getSex() != null) {
//                s1 = (allPeople.get(i).getSex() == Sex.MALE ? "м" : "ж");
//            }
//            try {
//                s = simpleDateFormat2.format(allPeople.get(i).getBirthDate());
//
//            } catch (Exception e) {
//            }
//
//            System.out.println(allPeople.get(i).getName() + " " +
//                    s1 + " " + s);
//        }
//        System.out.println("=======================================");
    }

    private static Sex getSex(String sexParam) {
        return sexParam.equals("м") ? Sex.MALE : Sex.FEMALE;
    }
}
