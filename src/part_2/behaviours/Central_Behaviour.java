package part_2.behaviours;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import org.json.JSONArray;
import org.json.JSONObject;
import part_2.controllers.Validation_Controller;

import java.util.HashMap;

public class Central_Behaviour  extends CyclicBehaviour {

    Validation_Controller controller;
    public Central_Behaviour() {

    }

    public void setController(Validation_Controller controller) {
        this.controller = controller;
    }

    @Override
    public void action() {

        ACLMessage message = this.myAgent.receive();

        if(message != null) {


            // AID AID_sender = message.getSender();



            JSONArray jsonArray = new JSONArray(message.getContent());

            this.controller.update_tickets(jsonArray);
        }

    }




}
