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

    
    public void addTask() throws ParseException   {
     Scanner reader=new Scanner(System.in);
        System.out.println("Write the title of the task");
        String title = reader.nextLine();

        System.out.println("Write the  due date of the task in form \"dd.MM.yyyy\" ");// do while
        String dueDate = dateMatching();

        System.out.println("Write the project of the task");
        String project = reader.nextLine();
        System.out.println("Write the description of the task");
        String description = reader.nextLine();

        taskList.add(new Task(title, dueDate, project, description));
    }
    private String dateMatching(){
        String pattern="\\d{2}.\\d{2}.\\d{4}";
       Scanner reader=new Scanner(System.in);
       do{
        String dueDate = reader.nextLine();
        if (dueDate.matches(pattern)) {
           return dueDate;
        }
        else System.out.println("Please enter the date in form DD.MM.YYYY");
       }while (true);
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
