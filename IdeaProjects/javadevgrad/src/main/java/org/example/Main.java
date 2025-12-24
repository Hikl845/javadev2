package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    Map<String, String> person = Map.of(
            "name", "Vitalii",
            "lastName", "Kyslytsya"
    );

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

System.out.println(gson.toJson(person));
}
}