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

 
/**
 *This class represents the task, it holds the data about task.
 * all methods in this class are getters and sitters besides overritten toString and compareTo. 
 * we skip document the getters and sitters.
 * @author mohamad
 */
public class Task implements Comparable<Task>, Serializable{

    private String title;
    private Date dueDate;
    private String project;
    private boolean isDone;
    private String description;
    

    
    public Task(String title, String dueDate, String project, String description) throws ParseException {// add the description as param
        this.title = title;
        this.isDone = false;
        setDueDate(dueDate);
        this.project =   project;
        this.description =  description;

    }

    public void setDescription(String description) { //we can put the new desc as param
        this.description = description;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(String dueDate) throws ParseException {
        this.dueDate = new SimpleDateFormat("dd.MM.yyyy").parse(dueDate);
    }

    /**
     *
     * @param project
     */
    public void setProject(String project) {
        this.project = project;
    }
    
    /**
     *
     * @param isDone
     */
    public void setIsDone(boolean isDone){
        this.isDone=isDone;
    }
 
    /**
     *
     */
    public void setAsDone() {
        this.isDone = true;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }
  
    /**
     *
     * @return
     */
    public String getDueDate() {
        return new SimpleDateFormat("dd.MM.yyyy").format(dueDate);

    }

    /**
     *
     * @return
     */
    public String getProject() {
        return project;
    }

    /**
     *
     * @return
     */
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
       
       
    @Override
    public String toString() {//printf for better output
        String status;
        status = isDone ? "done" : "undone";
        return title + "," + status + "," + getDueDate() + "," + project + "," + description;
    }
    
}
