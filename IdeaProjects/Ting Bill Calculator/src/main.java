/**
 * Created by john on 7/29/16.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

// this was initially used to handle the button click ...extends Application...implements EventHandler<ActionEvent>

public class main extends Application {

    Button button;

    public static void main (String [] args){

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Title of the window");

        button = new Button();
        button.setText("Click me");

        button.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /* This was initially used to handle the button click

    @Override
    public void handle(ActionEvent event){
        if(event.getSource() == button){
            System.out.println("Way to push that button!");
        }
    } */

}
