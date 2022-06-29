package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length == 0) {
            System.out.println("Должно быть два параметра. Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.");
            return;
        }
        String path = args[0];
        String resultFileAbsolutePath = args[1];


        File resultFile = new File(resultFileAbsolutePath);
        File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
        if (FileUtils.isExist(dest)) {
            FileUtils.deleteFile(dest);
        }
        FileUtils.renameFile(resultFile, dest);

        Map<String, byte[]> fileTree = getFileTree(path);
        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        fileTree.forEach((s, b) -> {
            try {
                writeInFile(s, b, fileOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private static void writeInFile(String s, byte[] b, FileOutputStream fileOutputStream) throws IOException {
        //System.out.println(s);
        fileOutputStream.write(b);
        fileOutputStream.write("\n".getBytes());
    }


    public static Map<String, byte[]> getFileTree(String root) throws IOException {
        Map<String, byte[]> result = new TreeMap<>();

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));

        return result;
    }

    private static class GetFiles extends SimpleFileVisitor<Path> {
        private Map<String, byte[]> result;

        public GetFiles(Map<String, byte[]> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            File file = path.toFile();
            if (file.isFile()) {
                if (file.length() <= 50) {
                    result.put(path.getFileName().toString(), Files.readAllBytes(path));
                }
            }
            return super.visitFile(path, basicFileAttributes);
        }
    }
}
