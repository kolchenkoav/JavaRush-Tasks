package com.javarush.task.task18.task1810;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String inputFile = reader.readLine();

            try (FileInputStream fileInputStream = new FileInputStream(inputFile)) {

                if (fileInputStream.available() < 1000) {
                    //System.out.println("DownloadException  file size < 1000 bytes");
                    throw new DownloadException();
                }
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
