package part_2.raisoneur;

import org.json.JSONArray;
import org.json.JSONObject;
import part_1.raisoneur.Condition;

import java.util.*;


public class Raisonneur {

    public static ArrayList<ReturnedInstance> raisonner(JSONObject agencyInformations, HashMap<String, String> facts){

        JSONArray flights = agencyInformations.getJSONArray("flights");

        ArrayList<JSONObject> listFlights = new ArrayList<>(); // the list of lights that match the destination and departure
        for (int i=0; i<flights.length(); i++){
            JSONObject jsonFlight = flights.getJSONObject(i);
            String from = jsonFlight.getString("from");
            String to = jsonFlight.getString("to");

            if (from.equals(facts.get("departure")) && to.equals(facts.get("arrival"))){
                listFlights.add(jsonFlight);
            }
        }

        if (listFlights.isEmpty()){
            return new ArrayList<>();
        }

        ArrayList<ReturnedInstance> returnFlights = new ArrayList<>();

        for (JSONObject flight : listFlights){
            returnFlights.add(new ReturnedInstance(flight, agencyInformations.getJSONObject("promotions"), facts));
        }
        return returnFlights;
    }

}
