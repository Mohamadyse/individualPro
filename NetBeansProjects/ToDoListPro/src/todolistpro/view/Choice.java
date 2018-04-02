/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.view;

/**
 *Representations for all the valid command for the application
 * along with a string .
 * @author mohamad
 */
public enum Choice {
    SHOW(1, " Show Task List."), ADD(2, " Add New Task."), EDIT(3, " Edit Task."), SORT(4, " Sort the list by date. "),FILTER(5," Filter tasks by project name"), SAQ(6, " Save and quit."),
    TITLE(7, " Change title"), PROJECT(8, " Change project name"), DATE(9, " Change todue date"), DESCRIPTION(10, " Change description"),
    MARK(11, " Mark a task as done "), REMOVE(12, " Remove a task. "), BACK(13, " Go back -> ");
    private String s;
    private int i;

    /**
     *  Initialise with the corresponding command string.
     * @param s the text which represents the order as a String.
    */
    Choice(int i, String s) {
        this.s = s;
        this.i = i;
    }

    public int getChoiceOrder() {
        return i;
    }
/**
 * 
 * @return  The command as a string.
 */
    @Override
     public String toString() {
        return s;
    }

}
