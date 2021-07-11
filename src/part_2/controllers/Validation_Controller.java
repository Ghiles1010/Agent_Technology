package part_2.controllers;

import com.google.gson.JsonObject;
import jade.gui.GuiEvent;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import part_2.agents.Central_Agent;
import part_2.utils.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class Validation_Controller implements Initializable{

    public static final String ID = "VALIDATION_SCENE";

    private Central_Agent central_agent;


    @FXML
    private VBox tickets_container;


    @FXML
    private void Back() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/Main_Scene.fxml"));
        Parent rules_scene = loader.load();

        Stage window = (Stage) tickets_container.getScene().getWindow();
        window.setScene(new Scene(rules_scene));
    }

    private void buy_ticket(int x){

        System.out.println("Hi "+x);

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(null);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setAlignment(Pos.CENTER);
        dialogVbox.getChildren().add(new Text("Vous avez reservé vos places !"));
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();

    }


    private void add_item(JSONObject offer){
        Insets space = new Insets(5,25,5,20);

        HBox item = new HBox();
        item.setPadding(space);
        item.getStyleClass().add("item");

        VBox item_left = new VBox();
        item_left.setPrefWidth(300);

        VBox item_right = new VBox();
        item_right.setAlignment(Pos.CENTER_RIGHT);
        item_right.setPrefWidth(300);

        String company_text = (String) offer.get("company_name");
        Text company_name = new Text(company_text.replace("_", " "));
        company_name.getStyleClass().add("company_text");

        String price =  "Prix : " + offer.get("price") + " DA";
        Text price_text = new Text(price);
        price_text.getStyleClass().add("info_text");

        String date_depart =  "Date de départ : " + offer.get("departure_date");
        Text depart_text = new Text(date_depart);
        depart_text.getStyleClass().add("info_text");

        String date_retour =  "Date de retour : " + offer.get("return_date");
        Text retour_text = new Text(date_retour);
        retour_text.getStyleClass().add("info_text");

        JSONArray escales_arr =  (JSONArray)offer.get("escales");
        String escales = escales_arr.isEmpty() ? "Pas d'escales" : escales_arr.join(" ");
        Text escales_text = new Text(escales);
        escales_text.getStyleClass().add("info_text");



        Button valider_btn = new Button();
        valider_btn.setUserData(98);
        valider_btn.setText("Valider");
        valider_btn.setOnAction(event -> {
                    int x = (int) valider_btn.getUserData();
                    buy_ticket(x);
                }
        );


        item_left.getChildren().add(company_name);
        item_left.getChildren().add(price_text);
        item_left.getChildren().add(depart_text);
        item_left.getChildren().add(retour_text);
        item_left.getChildren().add(escales_text);
        item_right.getChildren().add(valider_btn);


        item.getChildren().add(item_left);
        item.getChildren().add(item_right);

        tickets_container.getChildren().add(item);
    }

    private void update_iteckets_ui(JSONArray tickets){

        System.out.println(tickets.toString());
        tickets_container.getChildren().clear();

        for(Object obj : tickets){

            JSONObject offer = (JSONObject) obj;
            add_item(offer);
        }




    }

    public void update_tickets(JSONArray tickets){


        Platform.runLater(new Runnable() {
            @Override public void run() {

                update_iteckets_ui(tickets);

            }
        });



    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.central_agent = central_agent;
    }
}
