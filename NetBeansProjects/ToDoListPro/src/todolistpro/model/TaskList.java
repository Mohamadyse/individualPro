/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.model;


 
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.util.Collections;


/**
 *
 * @author mohamad
 */
public  class TaskList   {

    private static ArrayList<Task> taskList;
 //   private static Scanner reader;
   
    
    public TaskList() {
        taskList = new ArrayList<>();
  //      reader= new Scanner(System.in);
    }
    
     public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    
    public void add(String title,String dueDate,String project,String description) throws ParseException  {
        taskList.add(new Task(title, dueDate, project, description));
    }
    
   
    
    private int getIndex() {
        Scanner reader=new Scanner(System.in);
        int input = reader.nextInt();
        while ((input <= 0) || (input > taskList.size())) {
            System.out.println("no task with such a number");
            input = reader.nextInt();
        }
        return input;
    }
    

    
    public void removeTask(int index) {
        
        taskList.remove(index);
    }
    
    public void setAsDoneTask(int index) {
       taskList.get(index).setAsDone();
    }
    
    public void showList(){ 
    if ((taskList == null) || (taskList.isEmpty())) System.out.println(" The list is still empty ");
     for (int i=0; i< taskList.size();i++)
         System.out.println(i+1+"-.  "+ taskList.get(i));
         System.out.println("********************************");
    }
    
    public int getSize() {
        
        return taskList.size();
    }

//     public void sortListByProject(){
    public ArrayList<Task> sortListByDate() {
        if ((taskList == null) || (taskList.isEmpty())) {
            return new ArrayList<>();
        }
        Collections.sort(taskList);
        return taskList;
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
    
 public ArrayList<Task> getArray(){
     return  taskList;
 }   
    
    
    
}
