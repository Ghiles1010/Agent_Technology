package part_2.raisoneur;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {


        String content = Files.readString(Paths.get("src\\part_2\\bases\\companies\\Air_Algerie.json"), StandardCharsets.UTF_8);

        JSONObject jsonObject = new JSONObject(content);
        HashMap<String, String> facts = new HashMap<>();
        facts.put("departure", "alger");
        facts.put("arrival", "paris");

        facts.put("personnes", "5");
        facts.put("departure date", "10/08/2021");
        facts.put("return date", "31/07/2021");
        facts.put("Babies", "1");
        facts.put("kids", "2");
        facts.put("Elders", "1");

        Raisonneur.raisonner(jsonObject, facts);
        System.out.println( "rr" );
    }
}
