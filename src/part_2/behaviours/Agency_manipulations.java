package part_2.behaviours;

import org.json.JSONArray;
import org.json.JSONObject;
import part_2.raisoneur.Raisonneur;
import part_2.raisoneur.ReturnedInstance;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Agency_manipulations {

    static String base_folder = System.getProperty("user.dir") + File.separator + "src"+ File.separator + "part_2" + File.separator + "bases" + File.separator + "companies";

    public static JSONArray returnAgencies(){

    }

    public static JSONObject returnFlights(String Agency){

    }

    public static void addFlight(String Agency, JSONObject flight_infos){

    }

    public static void alterFlight(String Agency, JSONObject flight_infos){

    }

    public static String raisonner(HashMap<String, String> facts){
        ArrayList<JSONObject> companies = returnFileAgencies();
        ArrayList<ReturnedInstance> returned_instances = Raisonneur.raisonner(companies, facts);
        JSONArray jarray = Raisonneur.toJson(returned_instances);
        return jarray.toString();
    }

    private static ArrayList<JSONObject> returnFileAgencies(){


        ArrayList<JSONObject> files_content = new ArrayList<>();
        try {

            for(String file : Objects.requireNonNull(new File(base_folder).list())){

                Path path = Paths.get(base_folder + File.separator + file);
                String content = Files.readString(path, StandardCharsets.UTF_8);

                JSONObject jsonObject = new JSONObject(content);
                files_content.add(jsonObject);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return files_content;
    }
}
