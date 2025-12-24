package org.example;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class NumbOfWords {

    public static void countWordFrequency() {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/home/vkyslytsya/IdeaProjects/homework109/resources/Task3.txt"))) {
            String line;

            // Читаємо файл построчно
            while ((line = br.readLine()) != null) {
                // Розділяємо слова за пробілами (один або кілька)
                String[] words = line.trim().split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
            return;
        }

        // Сортування: спочатку за спаданням частоти, потім за алфавітом
        List<Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCount.entrySet());
        sortedEntries.sort((a, b) -> {
            int freqCompare = b.getValue().compareTo(a.getValue());
            return (freqCompare != 0) ? freqCompare : a.getKey().compareTo(b.getKey());
        });

        // Вивід результату
        for (Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        countWordFrequency();
    }
}

