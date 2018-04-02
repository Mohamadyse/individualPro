package todolistpro.controller;


import todolistpro.integration.DBHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.stream.Stream;
import todolistpro.model.Task;
import todolistpro.model.TaskList;

/**
 * This class retrieve the previous version of the program by creating an
 * instance of BDHandler of task type and connect the Viewer with the TaskList
 * class in the model package.
 * @author mohamad
 */
public class Controller {

    private static DBHandler< Task> db;
    private TaskList taskList;

    /**
     * initialises the lists of tasks.
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws ParseException
     */
    public Controller() throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {
        Controller.db = new DBHandler();
        this.taskList = new TaskList(db.readFromFile());
    }

    /**
     * intermediates add method in the class TaskList and in Viewe.it adds a new
     * task to the TaskList.
     *
     * @param title
     * @param dueDate
     * @param project
     * @param description
     * @throws ParseException
     */
    public void add(String title, String dueDate, String project, String description) throws ParseException {
        taskList.add(title, dueDate, project, description);
    }

    /**
     * intermediates the save method in DBHandler. It saves the version of the
     * program.
     */
    public void save() {
        db.save(taskList.getArrayList());
    }

    /**
     * intermediates sort method in TaskList class
     */
    public void sort() {
        taskList.sortListByDate();
    }

    /**
     * set a task as done
     *
     * @param index is the index of the element task in the arrayList.
     */
    public void setAsDoneTask(int index) {
        taskList.setAsDoneTask(index);
    }

    /**
     * intermediate method to remove the task
     *
     * @param index is the index of the element task in the arrayList.
     */
    public void remove(int index) {
        taskList.removeTask(index);
    }

    /**
     * intermediate method to diplay a specific task.
     *
     * @param index is the index of the element task in the arrayList.
     * @return
     */
    public String showTask(int index) {
        return taskList.showTask(index);
    }

    /**
     * indermediates method to count the number of done tasks.
     *
     * @return account the number of done tasks.
     */
    public int accountDoneTasks() {
        return taskList.accountDoneTasks();
    }

    /**
     * intermediate method to assign a new title to the task whose index is
     * passed
     *
     * @param index is the index of the element task in the arrayList.
     * @param replacement the new title is instead
     */
    public void setTitle(int index, String replacement) {
        taskList.setTitle(index, replacement);
    }

    /**
     * intermediate method to assign a new project name to the task whose index
     * is passed
     *
     * @param index is the index of the element task in the arrayList.
     * @param replacement the new project name.
     */
    public void setProject(int index, String replacement) {
        taskList.setProject(index, replacement);
    }

    /**
     * intermediate method to assign a new todue date to the task whose index is
     * passed
     *
     * @param index is the index of the element task in the arrayList.
     * @param replacement the new date
     * @throws ParseException
     */
    public void setDate(int index, String replacement) throws ParseException {
        taskList.setDate(index, replacement);
    }

    /**
     * intermediate method to assign a new description to the task whose index
     * is passed
     *
     * @param index is the index of the element task in the arrayList.
     * @param replacement the description
     */
    public void setDescription(int index, String replacement) {
        taskList.setDescription(index, replacement);
    }
    /**
     * intermediate method which filter task according to the name of project.
     * @param project that the task is filtered by.
     * @return stream of tasks' names whose project is passed.
     */
    public Stream<String> filterByProject(String project) {
        return taskList.filterByProject(project);
    }

    /**
     * intermediate method to interdmediates the size method in the TaskList
     * @return the size of the arraylist of tasks.
     */
    public int getListSize() {
        return taskList.getSize();
    }

}
