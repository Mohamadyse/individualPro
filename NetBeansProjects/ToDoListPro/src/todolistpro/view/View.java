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
    
    private void invokeChoice() throws IOException, ParseException {
        Choice aChoice;
        do {
            printAlternatives(1, 4);
            aChoice = getChoice();
            match1(aChoice);
        } while (aChoice != Choice.SAQ);
        System.out.println("bye bye...");
    }

    private void match1(Choice aChoice) throws IOException, ParseException {
        switch (aChoice) {
            case ADD:
                addTask();
                break;
            case SHOW:
                 showList();
                break;
            case EDIT:
                match2();
                break;
            case SAQ:
                proccesser.save();
                break;
        }

    }

    private void match2() throws IOException, ParseException {
        printAlternatives(5, 8);
        Choice aChoice = getChoice();
        switch (aChoice) {
            case SORT:
               proccesser.sort();
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

    private void setAsDone() {
        int i = getIndex();
        proccesser.setAsDoneTask(i);
        System.out.println("the task "+  i + " is done now");
    }

    private void removeTask() {
        int i = getIndex();
        proccesser.remove(i);
    }

    private int getIndex() {
        System.out.println("write the number of the task");
        int in = 0;
        do {
            String input = reader.nextLine();
            if (isValidNumber(input)) {
                in = Integer.parseInt(input);
                if ((in <= 0) || (in > size())) {
                    System.out.println("no task with such a number");
                }
            }

        } while ((in <= 0) || (in > size()));

        return in - 1;
    }
       
    private void addTask() throws ParseException {
     //   reader.nextLine();
        System.out.println("Write the title of the task");
        String  title = reader.nextLine();//question3 doesnt read title
        System.out.println("Write the  due date of the task in form \"dd.MM.yyyy\" ");
        String dueDate = dateMatching();
        System.out.println("Write the project of the task");
        String project = reader.nextLine();
        System.out.println("Write the description of the task");
        String description = reader.nextLine();

        proccesser.add(title, dueDate, project, description);
    }

    private String dateMatching() {
        String pattern = "\\d{2}.\\d{2}.\\d{4}";
        do {
            String dueDate = reader.nextLine();
            if (dueDate.matches(pattern)) {
                return dueDate;
            } else {
                System.out.println("Please enter the date in form DD.MM.YYYY");
            }
        } while (true);
    }

    private void printAlternatives(int min, int max) {
        for (int i = min; i <= max; i++) {
            System.out.println(choices.get(i));
        }
    }

    private Choice getChoice() {
        int in = 0;
        do {
            String input = reader.nextLine();
            if (isValidNumber(input)) {
                in = Integer.parseInt(input);
                if (!choices.containsKey(in)) {
                    System.out.println("not vaild number, try again.");
                }
            } else {
                System.out.println("not vaild choice, try again.");
            }

        } while (!choices.containsKey(in));
        return choices.get(in);
    }
    
    private boolean isValidNumber(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }
 
    private void welcome() {
        System.out.printf(">> Welcome to ToDoly. \n You have %d tasks are done and %d tasks todo!\n", proccesser.accountDoneTasks(), size() - proccesser.accountDoneTasks());
        System.out.println("  >> Pick an option:");
    }
  
    private int size() {
        return proccesser.getListSize();
    }
    
    private void showList(){ 
    if ((size()==0)) System.out.println(" The list is still empty ");
     for (int i=0; i< size();i++)
         System.out.println(i+1+".  "+ proccesser.showTask(i));
         System.out.println("********************************");
    }

}

