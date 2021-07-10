package part_2.controllers;

import com.google.gson.JsonObject;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.json.JSONObject;
import part_2.agents.Central_Agent;
import part_2.utils.GUI;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;



public class Validation_Controller implements Initializable{

    private Central_Agent central_agent;

    @FXML
    private VBox tickets_container;

    private void update_iteckets_ui(JSONObject tickets){

        System.out.println(tickets.toString());
        tickets_container.getChildren().clear();

        Insets space = new Insets(5,5,5,10);

        HBox item = new HBox();
        item.setPadding(space);
        item.getStyleClass().add("item");

        VBox item_left = new VBox();
        item_left.setPrefWidth(300);

        VBox item_right = new VBox();
        item_right.setAlignment(Pos.CENTER_RIGHT);
        item_right.setPrefWidth(300);

        Text company_name = new Text("Air Algérie");
        company_name.getStyleClass().add("company_text");

        Text price_text = new Text("10 000 DA");
        price_text.getStyleClass().add("price_text");

        Button valider_btn = new Button();
        valider_btn.setText("Valider");


        item_left.getChildren().add(company_name);
        item_left.getChildren().add(price_text);
        item_right.getChildren().add(valider_btn);

        item.getChildren().add(item_left);
        item.getChildren().add(item_right);

        tickets_container.getChildren().add(item);

    }

    public void update_tickets(JSONObject tickets){


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
