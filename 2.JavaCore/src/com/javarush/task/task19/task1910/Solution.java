package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileInput;
        String fileOutput;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileInput = bufferedReader.readLine();
            fileOutput = bufferedReader.readLine();
        }

        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader bReader = new BufferedReader(new FileReader(fileInput))) {
            while (bReader.ready()) {
                arrayList.add(bReader.readLine());
            }
        }

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileOutput))) {
            for (String s: arrayList) {
                String newS = s.replaceAll("\\p{P}", "");
                bWriter.write(newS);
            }
        }

    }
}
