/*
 * Course: CS2852 - 071
 * Spring 2019
 * Lab 1 - Dot 2 Dot Generator
 * Name: Brendan Ecker
 * Created: 3/5/2019
 */
package msoe.eckerb.lab01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Dot2Dot extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Dot2Dot.fxml"));
        primaryStage.setTitle("Dot to Dot");
        primaryStage.setScene(new Scene(root, 500, 530));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
