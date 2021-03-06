package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
//
//        File file = new File("d:\\readme.txt");
//        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
//        Solution savedObject = new Solution(13);
//        outputStream.writeObject(savedObject);
//        Solution loadedObject = (Solution) inputStream.readObject();
//        System.out.println(savedObject.equals(loadedObject));

        File filename = new File("D:\\javafile");
        Solution savedObject = new Solution(4);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(savedObject);
        oos.close();
        System.out.println("Сохранено: " + savedObject);
        Solution loadedObject = new Solution(15);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        loadedObject = (Solution) ois.readObject();
        ois.close();
        System.out.println("Загружено: " + loadedObject);
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }


}
