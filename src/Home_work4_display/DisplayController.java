/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home_work4_display;

import Home_work4_Delet.DeletController;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LapCity
 */
public class DisplayController implements Initializable {

    @FXML
    private TableView<reg> tableview;
    @FXML
    private TableColumn<reg, Integer> tcids;
    @FXML
    private TableColumn<reg, Integer> tcsemestar;
    @FXML
    private TableColumn<reg,Integer> tcidc;
   Statement statement;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // TODO
         try {
         
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","");
                       
                                              
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        tcids.setCellValueFactory(new PropertyValueFactory("studantid"));
        tcidc.setCellValueFactory(new PropertyValueFactory("courseid"));
        tcsemestar.setCellValueFactory(new PropertyValueFactory("semstar"));
       
          ResultSet rs;
        try {
            rs = this.statement.executeQuery("Select * From registration");
             tableview.getItems().clear();
        while(rs.next()){
            reg r = new reg();
            r.setStudantid(rs.getInt("studentid"));
            r.setCourseid(rs.getInt("courseid"));
            r.setSemstar(rs.getInt("semester"));
            tableview.getItems().add(r);
        }
        } catch (SQLException ex) {
            Logger.getLogger(DeletController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }    
    
}
