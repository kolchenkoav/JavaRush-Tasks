package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {return;}
        String fileInput = args[0];
        String fileOutput = args[1];

        ArrayList<String> fileContent = new ArrayList<String>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileInput))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                fileContent.add(line);
            }
        }

        StringBuffer sbLine = new StringBuffer();
        for (String line : fileContent) {
            String[] splitedLine = line.split(" ");
            for (String word : splitedLine) {
                if (word.length() > 6)
                    sbLine.append(word).append(" ");
            }
        }

        String resultLine = sbLine.toString().trim().replaceAll(" ", ",");
        try (FileWriter fileWriter = new FileWriter(fileOutput)) {
            fileWriter.write(resultLine);
        } catch (IOException ignore) {
            /* NOP */
        }

    }
}
