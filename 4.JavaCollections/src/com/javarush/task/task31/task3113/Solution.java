package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {
    private static long totalFolders = 0;
    private static long totalFiles = 0;
    private static long totalSize = 0;
    private static Path directory;

    private static class SearchFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.SKIP_SUBTREE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (!dir.equals(directory)) {
               totalFolders++;
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            totalFiles++;
            totalSize = totalSize + attrs.size();
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("путь к папке (например: d:\\)  : ");
        String dirName = reader.readLine();

        directory = Paths.get(dirName);

        if (!Files.isDirectory(directory)) {
            System.out.println(directory + " - не папка");
            return;
        }

        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();
        Files.walkFileTree(directory, searchFileVisitor);
        printResult();
    }

    private static void printResult() {
        System.out.println("Параметры папки " + directory.toString() + ":");
        System.out.println("Всего папок - " + totalFolders);
        System.out.println("Всего файлов - " + totalFiles);
        System.out.println("Общий размер - " + formattedSize(totalSize));
    }

    public static String formattedSize(long size) {
        String[] array = {"bytes", "Kb", "Mb", "Gb", "Tb", "Pb"};
        int i = 0;
        double x = size;
        while ((x > 1024) && (i < 5)) {
            x = x / 1024;
            i++;
        }
        return String.format("%.2f", x) + " " + array[i];
    }
}
