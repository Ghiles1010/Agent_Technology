package part_2.behaviours;


import com.google.gson.JsonObject;
import jade.core.AID;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import org.json.JSONObject;
import part_2.agents.Agency_Agent;

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


        String result = Agency_manipulations.raisonner(selected_base, content);


        ACLMessage message_to_send = new ACLMessage(ACLMessage.INFORM);
        message_to_send.setContent(result);
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
