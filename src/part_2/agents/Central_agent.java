package part_2.agents;

import com.google.gson.Gson;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import part_2.utils.Form;

public class Central_agent extends Agent {

    protected void setup(){

        Form form =  new Form();

        form.setFrom("Algiers");
        form.setTo("New York");
        form.setDate_depart("01/01/2021");
        form.setDate_return("01/20/2021");
        form.setNumber_persons("2");
        form.setNumber_kids(null);
        form.setNumber_elders(null);

        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.addReceiver(new AID("A0",AID.ISLOCALNAME));

        String message_text = new Gson().toJson(form);
        message.setContent(message_text);


        this.send(message);

    }
}
