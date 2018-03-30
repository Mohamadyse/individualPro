/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package todolistpro.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import todolistpro.integration.DBHandler;
import todolistpro.model.Task;
import todolistpro.model.TaskList;

/**
 *
 * @author mohamad
 */
public  class Controller {

    private static  DBHandler< Task> db;
    private TaskList taskList;



    public Controller() throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {
        Controller.db = new DBHandler();
        this.taskList = new TaskList(db.readFromFile());
    }

    public void add(String title, String dueDate, String project, String description) throws ParseException {
        taskList.add(title, dueDate, project, description);
    }

    public void save() {
        db.save(taskList.getArrayList());
    }
   public void sort(){
       taskList.sortListByDate();
   }
   
    public void setAsDoneTask(int index) {
        taskList.setAsDoneTask(index);
    }
   
    public void remove(int index) {
        taskList.removeTask(index);
    }
    public String showTask(int index){
        return taskList.showTask(index);
    }
 
    public int accountDoneTasks() {
        return taskList.accountDoneTasks();
    }

    public void setTitle(int index,String replacement){
          taskList.setTitle(index,replacement);
    }
    
    public void setProject(int index, String replacement) {
        taskList.setProject(index, replacement);
    }
    
     public void setDate(int index,String replacement) throws ParseException{
            taskList.setDate(index,replacement);
     }
    
    public void  setDescription(int index,String replacement){
        taskList.setDescription(index,replacement);
    }
    
    public int getListSize() {
        return taskList.getSize();
    }



}
