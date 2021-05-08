package main.raisoneur;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Raisonneur {


    public static String raisonner(JSONObject JSONrules, HashMap<String, String> facts){
        Rules activeRules = new Rules(JSONrules);
        return "Hi";
    }

}
