package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private List<Path> foundFiles = new ArrayList<>();
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // check if file name contains search string
        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) return FileVisitResult.CONTINUE;

        //check size of file
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        if ((maxSize > 0 && content.length > maxSize) || (minSize > 0 && content.length < minSize)) return FileVisitResult.CONTINUE;

        // check contents of file
        if (partOfContent != null && !partOfContent.isEmpty()) {
            String contentString = new String(content);
            if (!contentString.contains(partOfContent)) return FileVisitResult.CONTINUE;
        }

        // if all checks are passed, add file to result list
        foundFiles.add(file);
        return super.visitFile(file, attrs);
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String name) {
        this.partOfName = name;
    }

    public void setPartOfContent(String cont) {
        this.partOfContent = cont;
    }

    public void setMinSize(int i) {
        this.minSize = i;
    }

    public void setMaxSize(int i) {
        this.maxSize = i;
    }
}
