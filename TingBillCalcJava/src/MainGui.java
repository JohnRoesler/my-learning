/**
 * Created by john on 8/8/16.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.Stack;


public class MainGui extends Application {

    Button button;
    Stage window;
    Scene importData;

    public static void main (String [] args){

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Label label1 = new Label("Welcome to the Ting bill calculator\nplease press the import button\nto begin");
        Button button1 = new Button("Import");
        button1.setOnAction(e -> System.out.println("Yay"));

        //layout 1 - laid out in vertical column
        VBox layout1 = new VBox(20);
        //layout1.setPadding(new Insets(250));
        layout1.setAlignment(Pos.CENTER);

        layout1.getChildren().addAll(label1,button1);
        importData = new Scene(layout1, 500, 200);

        window.setTitle("Ting Bill Calculator");
        window.setScene(importData);
        window.show();

    }


}
