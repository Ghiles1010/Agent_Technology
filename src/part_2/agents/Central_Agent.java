package part_2.agents;

import com.google.gson.Gson;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import part_1.controllers.Rules_Controller;
import part_2.Main;
import part_2.behaviours.Central_Behaviour;
import part_2.controllers.Main_Controller;
import part_2.controllers.Validation_Controller;
import part_2.utils.Form;
import part_2.utils.GUI;

public class Central_Agent extends GuiAgent {

    Central_Behaviour behaviour;

    protected void setup(){

        GUI.central_agent  = this;

        this.behaviour = new Central_Behaviour();

        addBehaviour(behaviour);

    }

    @Override
    protected void onGuiEvent(GuiEvent guiEvent) {

        String scene = (String) guiEvent.getParameter(0);

        switch (scene) {
            case Main_Controller.ID:

                Form form = (Form) guiEvent.getParameter(1);
                Validation_Controller controller = (Validation_Controller) guiEvent.getParameter(2);

                this.behaviour.setController(controller);

                String message_text = new Gson().toJson(form);

                diffuse_message(message_text);
                break;

            case Validation_Controller.ID:

                break;
        }
    }

    private void diffuse_message(String message_text){


        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.setContent(message_text);

        // send to all services of type "Agency"
        DFAgentDescription t = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("Agency");
        t.addServices(sd);
        try {
            DFAgentDescription[] R = DFService.search(this, t);

            for (DFAgentDescription dfAgentDescription : R) {

                String local_name = dfAgentDescription.getName().getLocalName();
                message.addReceiver(new AID(local_name, AID.ISLOCALNAME));
            }

        } catch (FIPAException e) {
            e.printStackTrace();
        }



        this.send(message);


    }



}
