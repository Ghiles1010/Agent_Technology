package part_2.raisoneur;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class ReturnedInstance {

    private String company;

    private String departure, arrival;
    private String departureDate, returnDate;
    private int price;

    private ArrayList<String> escales;
    private HashMap<String, Promotion> promotions;

    public ReturnedInstance(String company, JSONObject flight) {
        this.company = company;
        this.departure = flight.getString("from");
        this.arrival = flight.getString("to");
        String p = flight.getString("price");
        this.price = Integer.parseInt(p);

        this.departureDate = flight.getJSONObject("departure date").getInt("day") + "/" + flight.getJSONObject("departure date").getInt("month") + "/" + flight.getJSONObject("departure date").getInt("year");
        this.returnDate = flight.getJSONObject("arrival date").getInt("day") + "/" + flight.getJSONObject("arrival date").getInt("month") + "/" + flight.getJSONObject("arrival date").getInt("year");

        this.escales = new ArrayList<>(  );
        for (int i=0; i<flight.getJSONArray("escales").length(); i++){
            this.escales.add( (String) flight.getJSONArray("escales").get(i));
        }
        this.promotions = new HashMap<>(  );
    }

    public ReturnedInstance(String company, JSONObject flight, JSONObject promos, HashMap<String, String> facts) {
        this(company, flight);
        this.addPromotions(promos, facts);
    }

    public void addPromotions(JSONObject promos, HashMap<String, String> facts){

        if ( Integer.parseInt(facts.get("Babies")) >= 1){
            this.promotions.put("Babies", new Promotion(Integer.parseInt(facts.get("Babies")), promos.getString("Babies")));
        }

        if ( Integer.parseInt(facts.get("kids")) >= 1){
            this.promotions.put("kids", new Promotion(Integer.parseInt(facts.get("kids")), promos.getString("kids")));
        }

        if ( Integer.parseInt(facts.get("Elders")) >= 1){
            this.promotions.put("Elders", new Promotion(Integer.parseInt(facts.get("Elders")), promos.getString("Elders")));
        }

        if (checkEstivalPeriod(facts.get("departure date"), facts.get("return date"))){
            this.promotions.put("Periode Estivale", new Promotion(Integer.parseInt(facts.get("personnes")), promos.getString("Periode Estivale")));
        }

        if (Integer.parseInt(facts.get("personnes")) >= 4){
            this.promotions.put("plus de 4 places", new Promotion(1, promos.getString("plus de 4 places")));
        }

        if (!this.escales.isEmpty()){
            this.promotions.put("escale", new Promotion(Integer.parseInt(facts.get("personnes")), promos.getString("escale")));
        }
    }

    private static Date strToDate(String strDate){
        String[] str = strDate.split("/");
        int day = Integer.parseInt(str[0]);
        int year = Integer.parseInt(str[2]);
        int month = Integer.parseInt(str[1]) - 1;
        return new GregorianCalendar( year, month, day).getTime();
    }

    private static boolean checkEstivalPeriod(String departure, String arrival){
        Date arrivalDate = strToDate(arrival);
        Date departureDate = strToDate(departure);
        return checkEstivalPeriod(departureDate, arrivalDate);
    }

    private static boolean checkEstivalPeriod(Date departure, Date arrival){
        Date EstivalPeriodeBegining = new GregorianCalendar(2021, Calendar.JULY, 15).getTime();
        Date EstivalPeriodeending = new GregorianCalendar(2021, Calendar.AUGUST, 30).getTime();
        return departure.after(EstivalPeriodeBegining) && arrival.before(EstivalPeriodeending);
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<String> getEscales() {
        return escales;
    }

    public HashMap<String, Promotion> getPromotions() {
        return promotions;
    }

    public JSONObject toJson(){
        JSONObject json =  new JSONObject();

        json.put("company_name", this.company);
        json.put("price", this.price);
        json.put("departure_date", this.departureDate);
        json.put("return_date", this.returnDate);

        JSONArray array = new JSONArray();
        for (String escale: this.escales){
            array.put(escale);
        }
        json.put("escales", array);

        JSONObject promos =  new JSONObject();
        for (String promo_indexes: this.promotions.keySet()){
            promos.put(promo_indexes, this.promotions.get(promo_indexes));
        }
        json.put("promotions", promos);
        return json;
    }
}
