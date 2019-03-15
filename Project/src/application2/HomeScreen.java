/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class HomeScreen {
    Stage stage;
    Scene scene;
    LoginForm loginform;
    AtmAccount account;
    TransactionScreen transactionscreen;
    Transaction transaction;
    
    public HomeScreen(Stage stage){
       this.stage = stage;
    }
    
    
    public void PrepareScene(){
        account = new AtmAccount();
        transaction = new Transaction();
        
        // Drawing.........................................................
        Button deposit = new Button("Deposit");
        Button withdraw = new Button("Withdraw");
        Button balanceinquiry = new Button("BalanceInquiry");
        Button previous = new Button("Previous");
        Button next = new Button("Next");
        Button logout = new Button("Logout");
        Label separator = new Label("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Label showlabel = new Label();
             
// ALERTS..................................................
                  
        Alert alertfail = new Alert(Alert.AlertType.INFORMATION);
                alertfail.setTitle("Unsuccessful transaction");
                alertfail.setHeaderText(null);
                alertfail.setContentText("Something went wrong! ");
        
                      
        GridPane grid = new GridPane();
      
        grid.add(deposit, 0, 0);
        grid.add(withdraw, 0, 1);
        grid.add(balanceinquiry, 0, 2);
        grid.add(showlabel, 1, 2);
        grid.add(previous, 0, 3);
        grid.add(next, 0, 4);
        grid.add(separator, 0, 5);
        grid.add(logout, 0, 6);
               
        // end of drawing...........................................
        
        
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {        
                stage.setScene(loginform.getscene());                
            }
        });
        
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {               
                transaction.setType("deposit");
                stage.setScene(transactionscreen.getScene());
                
            }
        }); 
        
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {               
               transaction.setType("withdraw");               
               stage.setScene(transactionscreen.getScene());
            }
        });
        
        balanceinquiry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {               
               showlabel.setText("Your Balance is : " + account.getBalance());
               transaction.writetransaction("Type:BalanceInquiry,Value: " + account.getBalance());
            }
        });
         
        
        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(transaction.testprevbtn())
                    showlabel.setText(transaction.previoushistory());
                else 
                    alertfail.showAndWait();
            }
        });
        
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(transaction.testnextbtn()){                
                showlabel.setText(transaction.nexthistory());
                }
                else
                    
                    alertfail.showAndWait();
                
                
            }
        });
    
                        
        scene = new Scene(grid, 300, 300);
        
        
    }
    public Scene getscene(){
        return scene;
    }

    public void setLoginform(LoginForm loginform) {
        this.loginform = loginform;
    }

    public void setTransactionscreen(TransactionScreen transactionscreen) {
        this.transactionscreen = transactionscreen;
    }

   
    
    
    
   
}
