package org.example;

import java.io.*;

public class NumberChecker implements numbCh {

    public NumberChecker() {
        try (BufferedReader fileReader = new BufferedReader(
         new FileReader("/home/vkyslytsya/IdeaProjects/homework10/Task1.txt"))) {

            String line;
            while ((line = fileReader.readLine()) != null) {
                if (checker(line)) {
                    System.out.println("Telephone = " + line);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public boolean checker(String phone) {
        String regex = "[0-9]{3}-[0-9]{3}-[0-9]{4}|\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}";
        return phone.matches(regex);
    }

    public static void main(String[] args) {
        new NumberChecker(); // викликає конструктор
    }
}
