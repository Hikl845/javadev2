package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GsonRewriter {
    public static void main(String[] args) {
        String inputFile = "Task2.txt";   // файл з даними
        String outputFile = "user.json";  // файл для JSON

        List<User> users = new ArrayList<>();

        // try-with-resources автоматично закриває BufferedReader
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (isFirstLine) { // пропускаємо заголовок
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split("\\s+");
                if (parts.length >= 2) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    users.add(new User(name, age));
                }
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(users);

            // try-with-resources також для запису
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {
                writer.write(json);
            }

            System.out.println("Файл user.json успішно створено!");

        } catch (IOException e) {
            System.err.println("Помилка при роботі з файлами: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Помилка у форматі числа (вік): " + e.getMessage());
        }
    }
}
