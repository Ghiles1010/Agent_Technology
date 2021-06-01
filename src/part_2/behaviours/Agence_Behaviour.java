package part_2.behaviours;

import com.google.gson.JsonObject;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import org.json.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Agence_Behaviour extends CyclicBehaviour {

    private JSONObject selected_base;

    public Agence_Behaviour(JSONObject selected_base) {

        this.selected_base = selected_base;

    }

    @Override
    public void action() {

        ACLMessage message = this.myAgent.blockingReceive();

        JSONObject content = new JSONObject(message.getContent());

        JSONObject rules = selected_base.getJSONObject("rules");
        String but  = selected_base.getString("but");
        HashMap<String, String> values = get_values(content);

        String result = main.raisoneur.Raisonneur.raisonner(rules, values, but);

        System.out.println(result);
    }



    // get the values from the json text we received
    private HashMap<String, String> get_values(JSONObject content){


        HashMap<String, String> values = new HashMap<>();

        for(String key : content.keySet()){

            values.put(key, content.getString(key));

        }
        return values;
    }
}
