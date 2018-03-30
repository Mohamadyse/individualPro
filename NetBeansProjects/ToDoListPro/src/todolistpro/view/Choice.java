/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.view;

/**
 *
 * @author mohamad
 */
public enum Choice {
  SHOW(1," Show Task List."),ADD(2, " Add New Task."),EDIT(3," Edit Task."),SORT(4 ," Sort the list by date. " ),SAQ(5," Save and quit."),
  TITLE(6," Change title"), PROJECT(7," Change project name"), DATE(8," Change todue date"),DESCRIPTION(9," Change description"),    
  MARK(10 , " Mark a task as done " ),REMOVE( 11," Remove a task. "  ),BACK(12 ," Go back -> "  );
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
        return  "<<"+i+">> "+s;
    }

}
