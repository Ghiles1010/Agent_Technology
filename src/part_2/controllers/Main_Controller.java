package part_2.controllers;

import jade.gui.GuiEvent;
import jade.wrapper.AgentController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import part_1.controllers.Rules_Controller;
import part_2.Main;
import part_2.agents.Central_Agent;
import part_2.utils.Form;
import part_2.utils.GUI;


import java.io.IOException;
import java.net.URL;
import java.security.PublicKey;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;

public class Main_Controller implements Initializable {

    public static final String ID = "MAIN_SCENE";


    private Central_Agent central_agent;

    @FXML
    private TextField depart_field;
    @FXML
    private TextField arrival_field;
    @FXML
    private DatePicker depart_date;
    @FXML
    private DatePicker return_date;
    @FXML
    private TextField num_tickets_field;
    @FXML
    private TextField num_babies_field;
    @FXML
    private TextField num_kids_field;
    @FXML
    private TextField num_elders_field;



    private Form get_form(){

        Form form = new Form();

        form.setFrom(depart_field.getText().toLowerCase());
        form.setTo(arrival_field.getText().toLowerCase());

        String date = depart_date.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        form.setDate_depart(date);

        date = return_date.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        form.setDate_return(date);

        form.setNumber_tickets(num_tickets_field.getText());
        form.setNumber_babies(num_babies_field.getText());
        form.setNumber_kids(num_kids_field.getText());
        form.setNumber_elders(num_elders_field.getText());

        return form;
    }

    @FXML
    private void search() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        System.out.println(System.getProperty("user.dir"));
        loader.setLocation(getClass().getResource("../fxml/Validation_Scene.fxml"));
        Parent rules_scene = loader.load();

        Validation_Controller controller = loader.getController();

        Stage window = (Stage) depart_field.getScene().getWindow();
        window.setScene(new Scene(rules_scene));

        GuiEvent ge = new GuiEvent(this, 0);
        ge.addParameter(Main_Controller.ID);
        ge.addParameter(get_form());
        ge.addParameter(controller);
        central_agent.postGuiEvent(ge);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.central_agent = GUI.central_agent;

    }
}
