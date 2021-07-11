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

    public static void addFlight(String data){
        JSONObject json = new JSONObject( data );

        String Agency = json.getString("agency");
        int numFlight = json.getInt("num_flight");
        JSONObject flight_infos = json.getJSONObject("flight_infos");
    }

    public static void alterFlight(String data ){
        JSONObject json = new JSONObject( data );

        String Agency = json.getString("agency");
        int numFlight = json.getInt("num_flight");
        JSONObject flightUpdate = json.getJSONObject("flight_infos");
    }

    public static void ConfirmReservation(String data){
        JSONObject json = new JSONObject( data );

        String Agency = json.getString("agency");
        int numFlight = json.getInt("num_flight");
        int nb_place_reserver = json.getInt("nb_places");

    }


    public static String raisonner(JSONObject baseDeFaits, JSONObject facts){

        ArrayList<ReturnedInstance> returned_instances = Raisonneur.raisonner(baseDeFaits, facts);
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
