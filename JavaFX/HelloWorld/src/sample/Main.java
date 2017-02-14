package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

////        Manually create grid pane node to replace fxml file
//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
////        Horizontal and vertical gap between columns/rows in grid
//        root.setVgap(10);
//        root.setHgap(10);

//        Label greeting = new Label("Welcome to JavaFX!");
//        root.getChildren().add(greeting);
//
//        greeting.setTextFill(Color.GREEN);
//        greeting.setFont(Font.font("Times New Roman", FontWeight.BOLD, 70));

        primaryStage.setTitle("Hello JavaFX!");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
