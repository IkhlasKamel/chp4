/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home_work4_registration;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author LapCity
 */
public class RegistrationController implements Initializable {

    @FXML
    private JFXTextField idstudant;
    @FXML
    private JFXTextField idcourse;
    @FXML
    private JFXTextField semester;
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
        // TODO
    }    

    @FXML
    private void saveHandel(ActionEvent event) throws SQLException {
        
              
                    int IDs =Integer.parseInt(idstudant.getText());
                     int IDc =Integer.parseInt(idcourse.getText());
                     int Sem=Integer.parseInt(semester.getText());
                      String sql = "Insert Into registration(studentid  ,courseid  ,semester ) values(" + IDs + ",'" +IDc + "','" 
                + Sem + "')";
                          this.statement.executeUpdate(sql);
               
    }
    
}
