/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package todolistpro.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;
import todolistpro.integration.Dbhandler;
import todolistpro.model.TaskList;
import todolistpro.view.Choice;
import static todolistpro.view.Choice.SAQ;

/**
 *
 * @author mohamad
 */
public  class Controller {

    private static  Dbhandler db;
    private TaskList taskList;
    private final HashMap <Integer, Choice> choices;
  
  
  
public Controller() throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {

    Controller.db = new Dbhandler();
    this.taskList = db.readFromFile();
    if (this.taskList == null) { //null pointer
        this.taskList = new TaskList();
    }
    choices = new HashMap<>();
    for (Choice c : Choice.values()) {
        choices.put(c.getChoiceOrder(), c);
    }

    welcome();
    calling();
    }

    public void invokeChoice(Choice aChoice) throws IOException, ParseException {
       
       
       
            switch (aChoice) {
                case ADD:
                   taskList.addTask();
                    break;
                case SORT:
                    taskList.showList();//sen ska sortera
                    break;
                case EDIT:
                    nextChoice();
                    break;
                case SAQ:
                    db.saveToFile(this.taskList);
                    break;
            }
    
    }
    
    public void calling() throws IOException, ParseException {
        Choice aChoice;
        do {
            printAlternatives(1, 4);
            aChoice = getChoice();
            invokeChoice(aChoice);
        } while (!(aChoice ==Choice.SAQ));
        System.out.println("bye bye...");
    }
                

    private void nextChoice() throws IOException, ParseException {
        printAlternatives(5, 8);
        Choice aChoice = getChoice();
        switch (aChoice) {
            case UPDATE:
                taskList.showList();
                break;
            case MARK:
                taskList.setAsDoneTask();
                break;
            case REMOVE:
                taskList.removeTask();
                break;
            case BACK:
                calling();
                break;

        }
 }
    

    public Choice getChoice() {
        int input;
        Scanner reader = new Scanner(System.in);

        do {
            input = reader.nextInt();
        } while (!choices.containsKey(input));
        return choices.get(input);
    }
 
    
     private void welcome() {
        System.out.printf(">> Welcome to ToDoly. \n You have %d tasks are done and %d tasks todo!",taskList.accountDoneTasks(),taskList.getSize()-taskList.accountDoneTasks() );
        System.out.println(">> Pick an option:");
    }
    private void printAlternatives(int min, int max){
        for(int i=min; i<=max;i++ ){
             System.out.println( choices.get(i));
        }
     }
}
