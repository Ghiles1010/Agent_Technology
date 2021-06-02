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

        jade_args[1] = "Central_Agent:part_2.agents.Central_Agent;" +
                       "Air_Algeria:part_2.agents.Agency_Agent(Hello);";


        jade.Boot.main(jade_args);
    }


    public static void main(String[] args) {

        launch_agents();
        launch(args);

    }





}

/*
public class Main {

    public static int[] T = new int[12];




    public static void main(String[] args) {




        String jade_args[] = new String[2];
        jade_args[0] = "-gui";
        jade_args[1] = "";

        String agent = "Central_Agent:mini_projet.src.part_2.agents.Central_Agent;";

        jade_args[1] = agent



        jade.Boot.main(jade_args);

    }


}


 */