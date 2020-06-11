/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home_work4_update;

import Home_work4_Delet.DeletController;
import Home_work4_Delet.datastudant;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LapCity
 */
public class UpdateController implements Initializable {

    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField major;
    @FXML
    private JFXTextField grade;
    @FXML
    private TableColumn<datastudant, Integer> tcid;
    @FXML
    private TableColumn<datastudant, String> tcname;
    @FXML
    private TableColumn<datastudant, String> tcmajor;
    @FXML
    private TableColumn<datastudant, String> tcgrade;
    @FXML
    private TableView<datastudant> tableview;
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
         tableview.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedstudant() );
          ResultSet rs;
        try {
            rs = this.statement.executeQuery("Select * From student");
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
       
        // TODO
    }    

    @FXML
    private void updataHandel(ActionEvent event) throws SQLException {
                   Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                    String Name =name.getText();
        alert.setTitle("Update ");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure want Update Data studant: "+tableview.getSelectionModel().getSelectedItem().getName());
           Optional<ButtonType> x=alert.showAndWait();
        if(x.get()==ButtonType.OK ){
          Integer Id = Integer.parseInt(id.getText());
       
        String Major= major.getText();
        Double Grade = Double.parseDouble(grade.getText());
        String sql = "Update student Set name='" + Name + "', major='" + 
                Major + "', grade=" + Grade + " Where id=" +Id;
        this.statement.executeUpdate(sql);
        showe();
    }
    
}
     private void showSelectedstudant(){
        datastudant studant = tableview.getSelectionModel().getSelectedItem();
        if(studant != null){
        id.setText(String.valueOf(studant.getId()));
       name.setText(studant.getName());
        major.setText(studant.getMajor());
        grade.setText(String.valueOf(studant.getGrade()));
        }
}
     public  void showe(){
            ResultSet rs;
        try {
                        rs = this.statement.executeQuery("Select * From student");
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
