package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathString = reader.readLine();
        Path path = Paths.get(pathString);
        final long[] size = {0, 0, 0};
        if (Files.isDirectory(path)) {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    size[0]++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    size[1]++;
                    size[2] += attrs.size();
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Всего папок - " + (size[0] - 1));
            System.out.println("Всего файлов - " + size[1]);
            System.out.println("Общий размер - " + size[2]);
        } else {
            System.out.println(pathString + " - не папка");
        }
    }
}
