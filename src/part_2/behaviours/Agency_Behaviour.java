package part_2.behaviours;

import com.google.gson.JsonObject;
import jade.core.AID;
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

public class Agency_Behaviour extends CyclicBehaviour {

    private JSONObject selected_base;

    public Agency_Behaviour(JSONObject selected_base) {

        this.selected_base = selected_base;

    }

    @Override
    public void action() {

        ACLMessage message = this.myAgent.blockingReceive();

        AID AID_sender = message.getSender();


        JSONObject content = new JSONObject(message.getContent());

        //JSONObject rules = selected_base.getJSONObject("rules");
        //String but  = selected_base.getString("but");
        //HashMap<String, String> values = get_values(content);

        //String result = main.raisoneur.Raisonneur.raisonner(rules, values, but);

        System.out.println(getAgent().getLocalName() + "\n" +
                "received : " + content.toString() + "\n");

        ACLMessage message_to_send = new ACLMessage(ACLMessage.INFORM);
        message_to_send.setContent("result of " + getAgent().getLocalName());
        message_to_send.addReceiver(new AID(AID_sender.getLocalName(), AID.ISLOCALNAME));

        getAgent().send(message_to_send);







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
