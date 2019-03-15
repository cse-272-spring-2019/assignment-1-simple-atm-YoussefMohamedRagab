/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application2;

import javafx.application.Application;
import javafx.stage.Stage;






public class AtmBuilder extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
   
    @Override
    public void start(Stage primaryStage) throws Exception {
        
          primaryStage.setTitle("ATM");
        
       LoginForm loginform = new LoginForm(primaryStage);
       HomeScreen homescreen = new HomeScreen(primaryStage);
       TransactionScreen transactionscreen = new TransactionScreen(primaryStage);
       
       loginform.PrepareScene();
       homescreen.PrepareScene();
       transactionscreen.preparescene();
       
       loginform.setHomescreen(homescreen);
       homescreen.setLoginform(loginform);
       
       homescreen.setTransactionscreen(transactionscreen);
       transactionscreen.setHomescreen(homescreen);
        
       primaryStage.setScene(loginform.getscene());
        primaryStage.show();
        
        
        
    }
    
}
