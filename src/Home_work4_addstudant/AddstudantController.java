/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home_work4_addstudant;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author LapCity
 */
public class AddstudantController implements Initializable {

    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField major;
    @FXML
    private JFXTextField grade;
    @FXML
    private JFXButton save;
    
    Statement statement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","");
            
            this.statement = connection.createStatement();
            // TODO
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }    

    @FXML
    private void saveHandel(ActionEvent event) throws SQLException {
        
        int ID =Integer.parseInt(id.getText());
        String Name =this.name.getText();
        String Major=this.major.getText();
        double Grade=Double.parseDouble( grade.getText());
               String sql = "Insert Into student(id ,name ,major ,grade) values(" + ID + ",'" +Name + "','" 
                + Major + "','" + Grade + "')";
        this.statement.executeUpdate(sql);
        
        
    }
    }    
        // TODO
        
    

