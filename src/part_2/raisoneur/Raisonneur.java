package part_2.raisoneur;

import org.json.JSONArray;
import org.json.JSONObject;
import part_1.raisoneur.Condition;

import java.util.*;


public class Raisonneur {

    public static ArrayList<ReturnedInstance> raisonner(JSONObject agencyInformations, JSONObject facts){

        ArrayList<ReturnedInstance> returnFlights = new ArrayList<>();
        JSONArray flights = agencyInformations.getJSONArray("flights");

        ArrayList<JSONObject> listFlights = new ArrayList<>(); // the list of lights that match the destination and departure
        for (int i=0; i<flights.length(); i++){
            JSONObject jsonFlight = flights.getJSONObject(i);

            if (checkValidity(jsonFlight, facts)){
                listFlights.add(jsonFlight);
            }
        }

        if (listFlights.isEmpty()){
            return new ArrayList<>();
        }

        for (JSONObject flight : listFlights){
            returnFlights.add(new ReturnedInstance(agencyInformations.getString("company_name"), flight, agencyInformations.getJSONObject("promotions"), facts));
        }

        return returnFlights;
    }

    private static boolean checkValidity(JSONObject jsonFlight, JSONObject facts) {
        String from = jsonFlight.getString("from");
        String to = jsonFlight.getString("to");
        int nb_places = jsonFlight.getInt("seats");
        JSONObject departure = jsonFlight.getJSONObject("departure date");
        JSONObject arrival = jsonFlight.getJSONObject("arrival date");


        return from.equals(facts.get("from")) && to.equals(facts.get("to")) && (nb_places >= Integer.parseInt(facts.getString("number_tickets")))
                && (sameMonth(departure, arrival, facts.getString("date_depart"), facts.getString("date_return")));
    }

    private static boolean sameMonth(JSONObject departureDate, JSONObject returnDate, String clientDeparture, String Clientreturn) {

        int departureMonth = departureDate.getInt("month");
        int returnMonth = returnDate.getInt("month");
        int departureYear = departureDate.getInt("year");
        int returnYear = departureDate.getInt("year");

        String[] str = clientDeparture.split("-");
        int month = Integer.parseInt(str[1]);
        int year = Integer.parseInt(str[2]);
        if (departureMonth == month && departureYear == year){
            str = Clientreturn.split("-");
            month = Integer.parseInt(str[1]);
            year = Integer.parseInt(str[2]);
            if (returnMonth == month && returnYear == year){
                return true;
            } else{
                return false;
            }
        } else {
            return false;
        }
    }

    public static JSONArray toJson(ArrayList<ReturnedInstance> returnedInstances){
        JSONArray jarray = new JSONArray();
        for (ReturnedInstance returnedInstance: returnedInstances){
            jarray.put(returnedInstance.toJson());
        }
        return jarray;
    }

}
