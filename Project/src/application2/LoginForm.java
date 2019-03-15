/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class LoginForm {
    Stage stage;
    Scene scene;
    AtmAccount account;
    HomeScreen homescreen;

    public LoginForm(Stage stage){
        this.stage = stage;
    }
   
    
    
    public void PrepareScene(){
       
        account = new AtmAccount();
        
        // drawing...................................................
       
        Label welcomelabel = new Label("Please enter your PinCode");
        PasswordField passwordfield = new PasswordField();
        Button submit = new Button("Submit");
              
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Wrong user name or password");
                  
        StackPane root = new StackPane();
        root.setAlignment(Pos.TOP_LEFT);
        root.getChildren().addAll(welcomelabel,passwordfield,submit);
        StackPane.setMargin(passwordfield,new Insets (20,15,15,0));
        StackPane.setMargin(submit, new  Insets (50,15,15,0));
                      
        // end of drawing................................................
        
        //LoginActions................................................
                
       submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                String pin= passwordfield.getText();
                boolean valid = account.pinValidation(pin);
                if(valid){
                    passwordfield.clear();
                    stage.setScene(homescreen.getscene());
                }
                else
                {           
                    alert.showAndWait();
                }                
            }
        });
            
        scene = new Scene(root, 300, 300);
    }
    
    public Scene getscene(){
        return this.scene;
    }

    public void setHomescreen(HomeScreen homescreen) {
        this.homescreen = homescreen;
    }

    

    
    
    
}
