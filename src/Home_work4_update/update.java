/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home_work4_update;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author LapCity
 */
public class update extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane update= FXMLLoader.load(getClass().getResource("update.fxml"));

        Scene scene = new Scene(update);
        
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
