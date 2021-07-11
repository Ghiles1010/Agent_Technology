package part_2.raisoneur;

import org.json.JSONArray;
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
                 "Air_Algerie.json"), StandardCharsets.UTF_8);

        JSONObject jsonObject = new JSONObject(content);
        JSONObject facts = new JSONObject();
        facts.put("from", "alger");
        facts.put("to", "paris");

        facts.put("number_tickets", "5");
        facts.put("date_depart", "10/02/2021");
        facts.put("date_return", "28/02/2021");
        facts.put("number_babies", "1");
        facts.put("number_kids", "2");
        facts.put("number_elders", "1");

        ArrayList<ReturnedInstance> rt = Raisonneur.raisonner(jsonObject, facts);
        JSONArray j = Raisonneur.toJson(rt);
        System.out.println(j );

    }
}
