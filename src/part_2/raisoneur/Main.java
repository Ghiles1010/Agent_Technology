package part_2.raisoneur;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {


        String content = Files.readString(Paths.get("src" + File.separator + "part_2" + File.separator + "bases" + File.separator +
                "companies" + File.separator + "Air_Algerie.json"), StandardCharsets.UTF_8);

        JSONObject jsonObject = new JSONObject(content);
        HashMap<String, String> facts = new HashMap<>();
        facts.put("departure", "alger");
        facts.put("arrival", "paris");

        facts.put("personnes", "5");
        facts.put("departure date", "10/02/2021");
        facts.put("return date", "28/02/2021");
        facts.put("Babies", "1");
        facts.put("kids", "2");
        facts.put("Elders", "1");

        ArrayList<ReturnedInstance> rt = Raisonneur.raisonner(jsonObject, facts);
        System.out.println();
    }
}