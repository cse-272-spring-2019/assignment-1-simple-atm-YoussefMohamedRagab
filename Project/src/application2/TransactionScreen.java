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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class TransactionScreen {
    
    Stage stage;
    Scene scene;
    HomeScreen homescreen;
    AtmAccount account;
    Transaction transaction;
    
    public TransactionScreen(Stage stage){
        this.stage = stage;
    }
    
    public void preparescene(){
        account = new AtmAccount();
        transaction= new Transaction();
        
        //Drawing..................................................
        Label welcomelabel = new Label("Enter Your Desired Amount !!");
        TextField textfield = new TextField();
        Button num0 = new Button("0");
        Button num1 = new Button("1");
        Button num2 = new Button("2");
        Button num3 = new Button("3");
        Button num4 = new Button("4");
        Button num5 = new Button("5");
        Button num6 = new Button("6");
        Button num7 = new Button("7");
        Button num8 = new Button("8");
        Button num9 = new Button("9");        
        Button submit = new Button("  Submit  ");
       Button clearall = new Button("ClearAll");  
       Button back = new Button("Back");
        textfield.setEditable(false);
        
       
        //ALERTS....................................................
         Alert alertsucc = new Alert(Alert.AlertType.INFORMATION);
                alertsucc.setTitle("Successful transaction");
                alertsucc.setHeaderText(null);
                alertsucc.setContentText("Successful transaction !!");
                
        Alert alertfail = new Alert(Alert.AlertType.INFORMATION);
                alertfail.setTitle("Unsuccessful transaction");
                alertfail.setHeaderText(null);
                alertfail.setContentText("Something went wrong while doing your transaction ");
        
        
       GridPane grid = new GridPane();
        grid.add(num0, 1, 3);
        grid.add(num1, 0, 0);
        grid.add(num2, 1, 0);
        grid.add(num3, 2, 0);
        grid.add(num4, 0, 1);
        grid.add(num5, 1, 1);
        grid.add(num6, 2, 1);
        grid.add(num7, 0, 2);
        grid.add(num8, 1, 2);
        grid.add(num9, 2, 2);
        
        
        StackPane root = new StackPane();
        root.setAlignment(Pos.TOP_LEFT);
        root.getChildren().add(grid);
        StackPane.setMargin(grid, new  Insets (50,15,15,0));
        root.getChildren().addAll(submit);
        StackPane.setMargin(submit, new  Insets (150,15,15,0));
        root.getChildren().addAll(welcomelabel,textfield,clearall,back);
        StackPane.setMargin(textfield,new Insets (20,15,15,0));
        StackPane.setMargin(clearall,new Insets (50,15,15,220));
        StackPane.setMargin(back,new Insets (275,15,15,0));
        
        
       
        //End of Drawing..............................................................
        
        //Actions.....................................................................
        num0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + num0.getText();    
                textfield.setText(textFieldNewString);
            }
        });
        num1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + num1.getText();    
                textfield.setText(textFieldNewString);
            }
        });
        num2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + num2.getText();    
                textfield.setText(textFieldNewString);
            }
        });
        num3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + num3.getText();    
                textfield.setText(textFieldNewString);
            }
        });
        num4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + num4.getText();    
                textfield.setText(textFieldNewString);
            }
        });
        num5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + num5.getText();    
                textfield.setText(textFieldNewString);
            }
        });
        num6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + num6.getText();    
                textfield.setText(textFieldNewString);
            }
        });
        num7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + num7.getText();    
                textfield.setText(textFieldNewString);
            }
        });
        num8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + num8.getText();    
                textfield.setText(textFieldNewString);
            }
        });
        num9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + num9.getText();    
                textfield.setText(textFieldNewString);
            }
        });
        
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(homescreen.transaction.getType().equals("deposit")){
                    int balance = Integer.parseInt(textfield.getText());
                    homescreen.transaction.setValue(balance);
                    homescreen.account.setBalance(balance);
                    homescreen.transaction.writetransaction("Type: " +homescreen.transaction.getType() + 
                            ",Value : " + homescreen.transaction.getValue());
                    alertsucc.showAndWait();
                    textfield.clear();
                    stage.setScene(homescreen.getscene());
                }
                else{
                    int balance = Integer.parseInt(textfield.getText());
                    if(homescreen.account.withdrawValidation(balance)) {                   
                    homescreen.transaction.setValue(balance);
                    homescreen.account.setBalance(- balance);
                    homescreen.transaction.writetransaction("Type: " +homescreen.transaction.getType() + 
                            ",Value : " + homescreen.transaction.getValue());
                    alertsucc.showAndWait();
                    textfield.clear();
                    stage.setScene(homescreen.getscene());
                    
                }
                    else{
                        alertfail.setContentText("Something went wrong while doing your transaction: No enough balance ");
                        alertfail.showAndWait();
                        textfield.clear();
                       
                    }
                                      
                }
            }
        });
        
        clearall.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               textfield.clear();
            }
        });
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(homescreen.getscene());
            }
        });

//End of Actions........................................
        
       scene = new Scene(root,300, 300);
    }

    public void setHomescreen(HomeScreen homescreen) {
        this.homescreen = homescreen;
    }

    public Scene getScene() {
        return this.scene;
    }
    
    
    
    
    
    
    
}
