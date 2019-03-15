/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application2;


/**
 *
 * @author USER
 */
public class AtmAccount {
    
    
    private final String CardPin = "20465";
    private int balance;
    
    
    public AtmAccount(){
        balance = 0;
       
    }
   

    public String getCardPin() {
        return CardPin;
    }

    public void setBalance(int balance) {
        this.balance = this.balance+ balance;
    }

    public int getBalance() {
        return balance;
    }
    
    public boolean pinValidation (String pin){
        
        if(pin.equals(CardPin))
            return true;
        else
            return false;
    
}
    
      
    public boolean withdrawValidation(int withdrawal){
        if(balance > withdrawal)
            return true;
        else
            return false;
    }
    
   
   
}
