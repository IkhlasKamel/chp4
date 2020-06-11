/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home_work4_query;

import Home_work4_Delet.DeletController;
import Home_work4_Delet.datastudant;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LapCity
 */
public class QueryController implements Initializable {

    @FXML
    private TableView<datastudant> tableview;
    @FXML
    private TableColumn<datastudant, Integer> tcid;
    @FXML
    private TableColumn<datastudant, String> tcname;
    @FXML
    private TableColumn<datastudant, String> tcmajor;
    @FXML
    private TableColumn<datastudant, String> tcgrade;
    @FXML
    private TextArea gu;
    Statement statement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","");
                       
                                              
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
          
        tcid.setCellValueFactory(new PropertyValueFactory("id"));
        tcname.setCellValueFactory(new PropertyValueFactory("name"));
        tcmajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcgrade.setCellValueFactory(new PropertyValueFactory("grade"));
    }    

    @FXML
    private void excuteHandel(ActionEvent event) {
            ResultSet rs;
        try {
            rs = this.statement.executeQuery(gu.getText());
             tableview.getItems().clear();
        while(rs.next()){
            datastudant studant = new datastudant();
            studant.setId(rs.getInt("id"));
            studant.setName(rs.getString("name"));
            studant.setMajor(rs.getString("major"));
            studant.setGrade(rs.getDouble("grade"));
            tableview.getItems().add(studant);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DeletController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
