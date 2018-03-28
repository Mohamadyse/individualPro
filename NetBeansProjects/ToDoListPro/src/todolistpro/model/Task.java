/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

 
/**
 *
 * @author mohamad
 */
public class Task<T> implements Comparable<Task>{

    private T title;
    private Date dueDate;
    private T project;
    private boolean isDone;
    private T description;
    
    public Task(T title, Date dueDate, T project, T description) throws ParseException {// add the description as param
        this.title = title;
        this.isDone = false;
        this.dueDate = dueDate;
        this.project = project;
        this.description = description;
    }
    
    public Task(String title, String dueDate, String project, String description) throws ParseException {// add the description as param
        this.title = (T) title;
        this.isDone = false;
        setDueDate(dueDate);
        this.project = (T) project;
        this.description = (T) description;

    }

    public void setDescription(T description) { //we can put the new desc as param
        this.description = description;
    }

    public void setTitle(T title) {
        this.title = title;
    }

    private void setDueDate(String dueDate) throws ParseException {
        this.dueDate = new SimpleDateFormat("dd.MM.yyyy").parse(dueDate);
    }

    public void setProject(T project) {
        this.project = project;
    }
    
    public void setIsDone(boolean isDone){
        this.isDone=isDone;
    }
 
    public void setAsDone() {
        this.isDone = true;
    }

    public T getTitle() {
        return title;
    }
    
    public String getDueDate() {
        return new SimpleDateFormat("dd.MM.yyyy").format(dueDate);

    }

    public T getProject() {
        return project;
    }

    public boolean isDone() {
        return isDone;
    }
    
    @Override
    public int compareTo(Task task) {
        int comparsion;
        comparsion = this.dueDate.compareTo(task.dueDate);
        if (comparsion != 0) {
            return comparsion;
        }
        String castedProject=(String)project;
        String castedGottenProject  =(String)task.getProject();
        comparsion = castedProject.compareTo(castedGottenProject);
        if (comparsion != 0) {
            return comparsion;
        }
         String castedTitle=(String)title;
        String castedGottenTitle  =(String)task.getTitle(); 
        
        comparsion = castedTitle.compareTo(castedGottenTitle);
        return comparsion;

    }
    @Override
    public String toString() {//printf for better output
        String status;
        status = isDone ? "done" : "undone";
        return title + "," + status + "," + getDueDate() + "," + project + "," + description;
    }
    
}
