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
            printAlternatives(1, 5);
            aChoice = getChoice(1,5);
            homeMenu(aChoice);
        }
        while (aChoice != Choice.SAQ);
        System.out.println("bye bye...");
    }

    private void homeMenu(Choice aChoice) throws IOException, ParseException {
        switch (aChoice) {
            case ADD:
                addTask();
                break;
            case SHOW:
                 showList();
                break;
            case SORT:
               proccesser.sort();
               showList();
               break;
            case EDIT:
                editeMenu();
                break;
            case SAQ:
                proccesser.save();
                break;
        }

    }

    private void editeMenu() throws IOException, ParseException {
        printAlternatives(6, 12);
        Choice aChoice = getChoice(6,12);
        switch (aChoice) {
            case TITLE:
                setTitle();
                break;
            case PROJECT:
                setProject();
                break;
            case DATE:
                setDate();
                break;
            case DESCRIPTION:
                setDescription();
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
    
    private void setTitle() {
        int i = getIndex();
        String replacement= getReplacement("title");
        proccesser.setTitle(i,replacement);
    }

    private void setDate() throws ParseException {
        int i = getIndex();
        String replacement = dateMatching();
        proccesser.setDate(i, replacement);
    }

    private void setProject() {
        int i = getIndex();
        String replacement = getReplacement("project");
        proccesser.setProject(i, replacement);
    }

    private void setDescription() {
        int i = getIndex();
         String replacement= getReplacement("description");
        proccesser.setDescription(i,replacement);
    }

    private void removeTask() {
        int i = getIndex();
        proccesser.remove(i);
    }

    private int getIndex() {
        System.out.println("write the number of the task");
        int in = 0;
        do {
            String input = tokenizer();
            if (isValidNumber(input)) {
                in = Integer.parseInt(input);
                if ((in <= 0) || (in > size())) {
                    System.out.println("no task with such a number");
                }} else System.out.println("unvalid input");
            
        } while ((in <= 0) || (in > size()));
        return in - 1;
    }
  
    private String tokenizer(){
        String input=null;
    while ((input == null) || (input.trim().isEmpty())) {
             input = reader.nextLine();
        }
  
    return input;
    }
    
    private String getReplacement(String word) {
        System.out.println("Write the new " + word + " you want instead");
        return reader.nextLine();
    }
       
    private void addTask() throws ParseException {
     //   reader.nextLine();
        System.out.println("Write the title of the task");
        String  title = reader.nextLine();//question3 doesnt read title
        String dueDate = dateMatching();
        System.out.println("Write the project of the task");
        String project = reader.nextLine();
        System.out.println("Write the description of the task");
        String description = reader.nextLine();

        proccesser.add(title, dueDate, project, description);
    }

    private String dateMatching() {
        System.out.println("Write the  due date of the task in form \"dd.MM.yyyy\" ");
        String pattern = "\\d{2}.\\d{2}.\\d{4}";
        do {
            String dueDate = tokenizer();
            if (dueDate.matches(pattern)) {
                return dueDate;
            } else {
                System.out.println("Please enter the date in form DD.MM.YYYY");
            }
        } while (true);
    }

    private void printAlternatives(int min, int max) {
        for (int i = min; i <= max; i++) {
            int optionNo=i-min+1;
            System.out.println("<"+optionNo+"> "+choices.get(i).toString());
        }
    }

    private Choice getChoice(int min, int max) {
        int optionNo = 0;
       
        do {
            
            
            String input = tokenizer();
            if (isValidNumber(input)) {
                optionNo = Integer.parseInt(input);
            } else {
                System.out.println("not valid choice, try again.");
            }
//                if (((!choices.containsKey(optionNo+min-1))||(optionNo>max))||(optionNo<min))  {
            if (!choices.containsKey(optionNo + min - 1)) {
                System.out.println("not valid number, try again.");
            }
        } while (!choices.containsKey(optionNo + min - 1));
        return choices.get(optionNo + min - 1);
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
    
    private void showList() {
        if ((size() == 0)) {
            System.out.println(" The list is still empty ");
        }
        for (int i = 0; i < size(); i++) {
            System.out.println(i + 1 + ".  " + proccesser.showTask(i));
        }
        System.out.println("********************************");
    }

}

