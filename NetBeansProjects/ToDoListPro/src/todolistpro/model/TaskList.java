/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.model;

import java.util.ArrayList;
import java.text.ParseException;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * This class holds an arraylist of instances of Task class.
 * @author mohamadˆ
 */
public class TaskList {

    private ArrayList<Task> taskList;

    /**
     * initialises the arrayList.
     */
    public TaskList() {
        taskList = new ArrayList<>();
    }

    /**
     * to create an instance of the class by passing arraylist of tasks
     * @param taskList
     */
    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * add a new task to the arraylist
     * @param title
     * @param dueDate
     * @param project
     * @param description
     * @throws ParseException
     */
    public void add(String title, String dueDate, String project, String description) throws ParseException {
        taskList.add(new Task(title, dueDate, project, description));
    }

    /**
     * to remove a task whose index is passed
     *
     * @param index is the index of task to remove
     */
    public void removeTask(int index) {
        taskList.remove(index);
    }

    /**
     * to replace the task's project
     *
     * @param index is the index of task
     * @param replacement is the new project name
     */
    public void setProject(int index, String replacement) {
        taskList.get(index).setProject(replacement);
    }

    /**
     * to mark a task as done.
     *
     * @param index is the index of task
     */
    public void setAsDoneTask(int index) {
        taskList.get(index).setAsDone();
    }

    /**
     * to replace the task's todue date
     *
     * @param index is the index of task
     * @param replacement
     * @throws ParseException
     */
    public void setDate(int index, String replacement) throws ParseException {
        taskList.get(index).setDueDate(replacement);
    }

    /**
     * to replace the task's title
     *
     * @param index is the index of task
     * @param replacement
     */
    public void setTitle(int index, String replacement) {
        taskList.get(index).setTitle(replacement);
    }

    /**
     * to replace the task's description.
     *
     * @param index is the index of task
     * @param replacement
     */
    public void setDescription(int index, String replacement) {
        taskList.get(index).setDescription(replacement);
    }

    /**
     * intermediate tostring to task
     *
     * @param index is the index of task to print
     * @return a string of task data.
     */
    public String showTask(int index) {
        return taskList.get(index).toString();
    }

    /**
     *
     * @return the size of the arraylist
     */
    public int getSize() {
        return taskList.size();
    }

    /**
     * to sort hte array by the date
     *
     * @return a sorted arraylist by date
     */
    public ArrayList<Task> sortListByDate() {
        if ((taskList == null) || (taskList.isEmpty())) {
            return new ArrayList<>();
        }
        Collections.sort(taskList);
        return taskList;
    }

    /**
     * to filter the arraylist by a passed project name
     *
     * @param project is the name of the project to filter by
     * @return a stream of strings of tasks' data
     */
    public Stream<String> filterByProject(String project) {
        Stream<String> tasks;
        Stream<Task> stm = taskList.stream();
        tasks = stm.filter(x -> x.getProject().equals(project)).map(x -> x.toString());
        return tasks;

    }
    /**
     * to get the arraylist of tasks
     * @return the arraylist.
     */
    public ArrayList<Task> getArrayList() {
        return taskList;
    }

    /**
     * to count the number of done tasks
     *
     * @return a number of done tasks
     */
    public int accountDoneTasks() {
        int counter = 0;
        if (taskList == null) {
            return 0;
        }
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).isDone()) {
                counter++;
            }
        }
        return counter;
    }

}
