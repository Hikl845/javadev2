package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class gsonRewriter {
        public static void main(String[] args) {
            String inputFile = "Task2.txt";   // файл з даними
            String outputFile = "user.json"; // файл для JSON

            try {
                List<String> lines = Files.readAllLines(Paths.get(inputFile));
                List<User> users = new ArrayList<>();

                // Пропускаємо заголовок (перший рядок)
                for (int i = 1; i < lines.size(); i++) {
                    String line = lines.get(i).trim();
                    if (line.isEmpty()) continue; // пропускаємо порожні рядки

                    String[] parts = line.split("\\s+"); // розділяємо по пробілах
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);

                    users.add(new User(name, age));
                }

                // Перетворюємо список у JSON
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(users);

                // Записуємо у файл
                Files.write(Paths.get(outputFile), json.getBytes());

                System.out.println("Файл user.json успішно створено!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }