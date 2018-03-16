/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

 
/**
 *
 * @author mohamad
 */
public class Task implements Comparable<Task>, Serializable {

    private String title;
    public Date dueDate;
    private String project;
    private boolean isDone;
    public String description;

    public Task(String title, String dueDate, String project, String description) throws ParseException {// add the description as param
        this.title = title;
        this.dueDate = new SimpleDateFormat("dd.MM.yyyy").parse(dueDate);
        this.project = project;
        this.isDone = false;
        this.description = description;
        setDueDate(dueDate);
    }

    public String replaceDescription() { //we can put the new desc as param
        System.out.println("Type your task");
        Scanner descriptions = new Scanner(System.in);
        return this.description = descriptions.nextLine();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(String dueDate) throws ParseException {
        this.dueDate = new SimpleDateFormat("dd.MM.yyyy").parse(dueDate);
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setAsDone() {
        this.isDone = true;
    }

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
      return new SimpleDateFormat("dd.MM.yyyy").format(dueDate);
        
    }

    public String getProject() {
        return project;
    }

    public boolean isDone() {
        return isDone;
    }
    
    @Override
    public int compareTo(Task task){
        int comparsion;
        comparsion = this.dueDate.compareTo(task.dueDate);
        if (comparsion != 0) {
            return comparsion;
        }
        comparsion = this.project.compareTo(task.getProject());
        if (comparsion != 0) {
            return comparsion;
        }
        comparsion = this.title.compareTo(task.getTitle());
        return comparsion;

        
    }

}
