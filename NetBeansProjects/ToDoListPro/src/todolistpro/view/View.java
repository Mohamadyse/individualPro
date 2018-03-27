/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;
import todolistpro.controller.Controller;




/**
 *in this class we should have Scanner and method getChoice.
 * @author mohamad
 */
public class View {


     private final HashMap<Integer, Choice> choices;
    private Controller proccesser;
   private Scanner reader;
    
    public View() throws IOException, FileNotFoundException, ClassNotFoundException, ParseException{    
           proccesser= new Controller();
           choices = new HashMap<>();
           reader = new Scanner(System.in);
        
        
            for (Choice c : Choice.values()) {
                choices.put(c.getChoiceOrder(), c);
            }
    
    welcome();
    invokeChoice();
    
    }
    
    
    
       public void invokeChoice() throws IOException, ParseException {
        Choice aChoice;
        do {
            printAlternatives(1, 4);
            aChoice = getChoice();
            match(aChoice);
        } while (aChoice !=Choice.SAQ);
        System.out.println("bye bye...");
    }
 
     public void match(Choice aChoice) throws IOException, ParseException {
       
       
       
            switch (aChoice) {
                case ADD:
                   addTask();
                    break;
                case SORT:
                    proccesser.show();//sen ska sortera
                    break;
                case EDIT:
                    nextChoice();
                    break;
                case SAQ:
                    proccesser.save();
                    break;
            }
    
    }
     
     
  
     
     private void nextChoice() throws IOException, ParseException {
        printAlternatives(5, 8);
        Choice aChoice = getChoice();
        switch (aChoice) {
            case UPDATE:
                 proccesser.show();;
                break;
            case MARK:
                setAsDone();
                break;
            case REMOVE:
                removeTask();
                break;
            case BACK:
                invokeChoice();
                break;

        }
 }
     
     private void setAsDone(){
         int i= getIndex();
         proccesser.setAsDoneTask(i);
     }
     
     
     private void removeTask(){
     int i= getIndex();
     proccesser.remove(i);
     }
     
     
 private int getIndex() {
        int input = reader.nextInt();
        while ((input <= 0) || (input > size())) {
            System.out.println("no task with such a number");
            input = reader.nextInt();
        }
        return input-1 ;
    }
     
     
 private void addTask() throws ParseException{
        System.out.println("Write the title of the task");
        String title = reader.nextLine();

        System.out.println("Write the  due date of the task in form \"dd.MM.yyyy\" ");// do while
        String dueDate = dateMatching();

        System.out.println("Write the project of the task");
        String project = reader.nextLine();
        System.out.println("Write the description of the task");
        String description = reader.nextLine();

        proccesser.add(title, dueDate, project, description);
       }
      
     
 private String dateMatching(){
        String pattern="\\d{2}.\\d{2}.\\d{4}";
       do{
        String dueDate = reader.nextLine();
        if (dueDate.matches(pattern)) {
           return dueDate;
        }
        else System.out.println("Please enter the date in form DD.MM.YYYY");
       }while (true);
    }
     
     
  private void printAlternatives(int min, int max) {
        for (int i = min; i <= max; i++) {
            System.out.println(choices.get(i));
        }
    }
 
  public Choice getChoice() {
        int input;
        do {
            input = reader.nextInt();
        } while (!choices.containsKey(input));
        return choices.get(input);
    }
 
  private void welcome() {
        System.out.printf(">> Welcome to ToDoly. \n You have %d tasks are done and %d tasks todo!\n",proccesser.accountDoneTasks(), size() - proccesser.accountDoneTasks());
      System.out.println("  >> Pick an option:");
    }
  
  private int size(){
     return proccesser.getListSize();
  }
     }

