/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.view;

import java.util.HashMap;

/**
 *
 * @author mohamad
 */
public enum Choice {
  SHOW(1," Show Task List."),ADD(2, " Add New Task."),EDIT(3," Edit Task."),SAQ(4," Save and quit."),SORT(5 ," Sort the list by date. " ),MARK(6 , " Mark a task as done " ),REMOVE( 7," Remove a task. "  ),BACK(8 ," Go back -> "  );
     private String s;
     private int i;
  
    
    Choice(int i,String s) {
        this.s=s;
        this.i=i;
    }
  
      
      
   public int getChoiceOrder(){
        return i;
    }
   
   
   
//public static Choice valueOf(int index){ //question1 method doesnt compile
//
//for (Choice achoice: values())
//    if ((achoice.i==index)) //question2 equals doesnt work
//      return achoice;
//}

public String toString() {
        return  " <<"+i+">>"+s;
    }

}
