/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author mohamad
 */
public  class TaskList implements Serializable {

    private static List<Task> taskList;
    private static Scanner reader;
   
    
    public TaskList() {
        taskList = new ArrayList<>();
        reader= new Scanner(System.in);
    }

    
    public void addTask() throws ParseException   {
    
        
            
        System.out.println("Write the title of the task");
                String title= reader.nextLine();
         System.out.println("Write the  due date of the task in form \"dd.MM.yyyy\" ");// do while
                String dueDate = reader.nextLine();
        System.out.println("Write the project of the task" );
                String project= reader.nextLine();
        System.out.println("Write the description of the task");
                String description = reader.nextLine();
 
        taskList.add(new  Task( title, dueDate,  project,  description));
    }
    
    
    private int getIndex() {
        int input = reader.nextInt();
        while ((input <= 0) || (input > taskList.size())) {
            System.out.println("no task with such a number");
            input = reader.nextInt();
        }
        return input;
    }
    
    public Task getTask(){
          System.out.println("enter the number of the task");
        int index = getIndex();
        
        return taskList.get(index-1);
    }
    
    public void removeTask() {//makecondition if task not null
        taskList.remove(getTask());
    }
    
    public void setAsDoneTask() {
        getTask().setAsDone();
    }
    
    public void showList(){ 
     for (int i=0; i< taskList.size();i++)
         System.out.println(i+1+"-"+ taskList.get(i));
    }
    
    public int getSize() {
        
        return taskList.size();
    }

    // public void sortListByProject(){
    public TaskList sortListByDate() {
        Collections.sort(taskList);
        return (TaskList) taskList;
    }
    
    public int accountDoneTasks() {
        int counter = 0;
 //       if (taskList==null) return 0;
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).isDone()) {
                counter++;
            }
        }
        return counter;
    }
//    public int accountUndoneTasks(){
//    return taskList.size()- accountDoneTasks();
//    }
}
