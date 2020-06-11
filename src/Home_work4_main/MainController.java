/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home_work4_main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author LapCity
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addstudant(ActionEvent event) throws IOException {
       loadwindow("/Home_work4/addstudant/Addstudant.fxml","Add new Studant" );

    
    }

    @FXML
    private void addcourse(ActionEvent event) throws IOException {
               loadwindow("/Home_work4/addcourse/course.fxml","Add new Studant" );

    }

    @FXML
    private void update(ActionEvent event) throws IOException {
                       loadwindow("/Home_work4/update/update.fxml","Add new Studant" );

    }

    @FXML
    private void remove(ActionEvent event) throws IOException {
            loadwindow("/Home_work4/Delet/delet.fxml","Add new Studant" );

    }

    @FXML
    private void regist(ActionEvent event) throws IOException {
                    loadwindow("/Home_work4/registration/registration.fxml","Add new Studant" );

    }

    @FXML
    private void display(ActionEvent event) throws IOException {
                            loadwindow("/Home_work4/display/display.fxml","Add new Studant" );

    }
    

    @FXML
    private void showeQuriy(ActionEvent event) throws IOException {
        loadwindow("/Home_work4/query/query.fxml","" ); 
    }
     void loadwindow(String window ,String title) throws IOException{
          Pane pane= FXMLLoader.load(getClass().getResource(window));
        
        Scene scene = new Scene(pane);
        Stage  primaryStage= new Stage(StageStyle.DECORATED);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();

}
}