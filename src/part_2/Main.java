package part_2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import part_2.agents.Central_Agent;

public class Main extends Application {

    String base_file_Air_Algeria = "Air_Algeria";



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/Main_Scene.fxml"));
        primaryStage.setTitle("Book Flight");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private static void launch_agents(){
        String[] jade_args = new String[2];

        jade_args[0] = "-gui";

        jade_args[1] = "Central_Agent:part_2.agents.Central_Agent;"
                + "Air_Algeria:part_2.agents.Agency_Agent(Air_Algerie.json);"
                + "Air_France:part_2.agents.Agency_Agent(Air_France.json);"
                + "Air_Belgique:part_2.agents.Agency_Agent(Air_Belgique.json);"
                + "US_Airlines:part_2.agents.Agency_Agent(US_Airlines.json);";


        jade.Boot.main(jade_args);
    }


    public static void main(String[] args) {

        launch_agents();
        launch(args);

    }





}
