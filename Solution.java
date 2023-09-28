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

        MyMutableInteger filesCount = new MyMutableInteger(0);
        MyMutableInteger foldersCount = new MyMutableInteger(0);
        MyMutableLong totalSize = new MyMutableLong(0L);

        if (Files.isDirectory(path)) {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    foldersCount.increment();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    filesCount.increment();
                    totalSize.add(attrs.size());
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Всего папок - " + (foldersCount.getValue() - 1));
            System.out.println("Всего файлов - " + filesCount.getValue());
            System.out.println("Общий размер - " + totalSize);
        } else {
            System.out.println(pathString + " - не папка");
        }
    }
}
