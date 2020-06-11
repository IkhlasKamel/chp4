/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home_work4_addcourse;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author LapCity
 */
public class CourseController implements Initializable {

    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField room;
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
        int ID=Integer.parseInt(id.getText());
        String Name=this.name.getText();
        String Room=room.getText();
                   String sql = "Insert Into course(id ,name ,room ) values(" + ID + ",'" +Name + "','" 
                + Room + "')";
        this.statement.executeUpdate(sql);
    }
    
}
