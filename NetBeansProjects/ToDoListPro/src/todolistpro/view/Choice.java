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
  SORT(1,"Show Task List"),ADD(2, "Add New Task"),EDIT(3,"Edit Task"),SAQ(4,"Save and quit"),UPDATE(5 ,"Mark a task as done " ),MARK(6 , "Remove a task " ),REMOVE( 7," "  ),BACK(8 ," "  );
     private String s;
     private int i;
 
    
    Choice(int i,String s) {
        this.s=s;
        this.i=i;
    }
    
   public int getChoiceOrder(){
        return i;
    }
   

    public String toString() {
        return  " <<"+i+">>"+s;
    }

}
