package part_2.behaviours;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
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
            System.out.println(message);

            AID AID_sender = message.getSender();

            //JSONObject content = new JSONObject(message.getContent());

            //JSONObject rules = selected_base.getJSONObject("rules");
            //String but  = selected_base.getString("but");
            //HashMap<String, String> values = get_values(content);

            //String result = main.raisoneur.Raisonneur.raisonner(rules, values, but);

            System.out.println("received central: " + message.getContent() + "\n");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Hello", "there");

            this.controller.update_tickets(jsonObject);
        }

    }




}
