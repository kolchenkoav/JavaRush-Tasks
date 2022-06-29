package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения    d:\\file1.txt      d:\\file2.txt
d:\\file1.txt
d:\\file2.txt
*/

/*
        Правила объединения:

        Если строка в обоих файлах совпадает, то в результат она попадает с операцией (приставкой) SAME.
                Например, SAME строка1.
        Если строка есть в file1, но ее нет в file2, то считаем, что строку удалили и в результат она попадает с операцией (приставкой) REMOVED.
                Например, REMOVED строка2.
        Если строки нет в file1, но она есть в file2, то считаем, что строку добавили и в результат она попадает с операцией (приставкой) ADDED.
                Например, ADDED строка0.
        Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //System.out.print("Input file1 name: ");
        String fileName1 = bufferedReader.readLine();
        //System.out.print("Input file2 name: ");
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();


        List<String> oldFileLines = readFileLines(fileName1);
        List<String> newFileLines = readFileLines(fileName2);

        int oldCountLine = 0;
        int newCountLine = 0;

        while ((oldCountLine < oldFileLines.size()) && (newCountLine < newFileLines.size())) {

            if (oldFileLines.get(oldCountLine).equals(newFileLines.get(newCountLine))) {
                lines.add(new LineItem(Type.SAME, oldFileLines.get(oldCountLine)));
                oldCountLine++;
                newCountLine++;
            } else if ((newCountLine + 1 < newFileLines.size()) && oldFileLines.get(oldCountLine).equals(newFileLines.get(newCountLine + 1))) {
                lines.add(new LineItem(Type.ADDED, newFileLines.get(newCountLine)));
                newCountLine++;
            } else if ((oldCountLine + 1 < oldFileLines.size()) && oldFileLines.get(oldCountLine + 1).equals(newFileLines.get(newCountLine))) {
                lines.add(new LineItem(Type.REMOVED, oldFileLines.get(oldCountLine)));
                oldCountLine++;
            }
        }

        while (oldCountLine < (oldFileLines.size())) {
            lines.add(new LineItem(Type.REMOVED, oldFileLines.get(oldCountLine)));
            oldCountLine++;
        }
        while (newCountLine < (newFileLines.size())) {
            lines.add(new LineItem(Type.ADDED, newFileLines.get(newCountLine)));
            newCountLine++;
        }

        //lines.forEach(s->System.out.println(s.type+" "+s.line));
    }


    private static List<String> readFileLines(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        List<String> fileLines = new ArrayList<String>();
        String line;
        while (bufferedReader.ready()) {
            line = bufferedReader.readLine();
            fileLines.add(line);
        }
        bufferedReader.close();
        return fileLines;
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
