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
public class Transaction {
    
    private String type;
    private int value;
    private String [] history = new String[5];
    private int index;
    private int nextindex;
    
    public Transaction(){
        index =-1;
        value=0;
        nextindex=0;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
    
    public void writetransaction(String string){
        if(index +1 >4){
            for(int i=0;i<4;i++){
                history[i]=history[i+1];
            }
            history[4]=string;
        }
        else{
          index++;
          history[index]=string;
          nextindex++;
        }
       
   }
    
    public String gettransaction(){
        
        return history[index];
    }
     public String previoushistory(){
        
        return history[--index];
    }
      public String nexthistory(){
        
        return history[++ index];
    }
      public boolean testnextbtn(){
        if (index +1 >=nextindex)
            return false;
        else
            return true;      
    }
    public boolean testprevbtn(){
        if(this.index -1 <0)
            return false;
        else
            return true;
    }

    public int getIndex() {
        return index;
    }
    
    

}
