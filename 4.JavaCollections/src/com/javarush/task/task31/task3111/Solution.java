package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/* 
Продвинутый поиск файлов
*/

public class Solution {
    private static String strPartOfName = "amigo";
    private static String strPartOfContent = "programmer";
    private static int minSize = 500;
    private static int maxSize = 10000;
    private static String folderForSearch = "D:/SecretFolder";

    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

        searchFileVisitor.setPartOfName(strPartOfName);
        searchFileVisitor.setPartOfContent(strPartOfContent);
        searchFileVisitor.setMinSize(minSize);
        searchFileVisitor.setMaxSize(maxSize);

        Files.walkFileTree(Paths.get(folderForSearch), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }

}
