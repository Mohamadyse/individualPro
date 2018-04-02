/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.model;

import java.text.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tmp-sda-1166
 */
public class TaskListTest {
    static String title;
    static String dueDate;
    static String project;
    static String description;
    static TaskList taskList;
    
    public TaskListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
      
    
    public void setUp() {
        title = "bla";
        dueDate = "11.11.1111";
        project = "bla";
        description = "bla";
        taskList = new TaskList();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class TaskList.
     */
    @Test
    public void testAdd() throws ParseException  {
        System.out.println("add");
        TaskList expected = new TaskList();
        Task task=new Task(title, dueDate, project, description);
        taskList.add(title, dueDate, project, description);
        expected.getArrayList().add(task);
        assertEquals(expected.getArrayList() , taskList.getArrayList() );
    }
    
    
    /**
     * Test of removeTask method, of class TaskList.
     */
    @Test
    public void testRemoveTask() throws ParseException {
        System.out.println("removeTask");
        Task task=new Task(title, dueDate, project, description);
        taskList.add(title, dueDate, project, description);
            int index = 0;
        taskList.removeTask(index);
        TaskList expected = new TaskList();
        assertEquals(expected.getArrayList(), taskList.getArrayList());
    }

    /**
     * Test of setAsDoneTask method, of class TaskList.
     */
    @Test
    public void testSetAsDoneTask() throws ParseException {
        System.out.println("setAsDoneTask");
        taskList.add(title, dueDate, project, description);
        Task task = new Task(title, dueDate, project, description);
        taskList.setAsDoneTask(0);
        boolean status = taskList.getArrayList().get(0).isDone();
        assertTrue(status);
    }
    /**
     * Test of showTask method, of class TaskList.
     */
    @Test
    public void testShowTask() throws ParseException {
        System.out.println("showTask");
        taskList.add(title, dueDate, project, description);
        String expResult = title + "," + "undone" + "," + "11.11.1111" + "," + project + "," + description;
        String result = taskList.showTask(0);
        assertEquals(expResult, result);
    }
    /**
     * Test of getSize method, of class TaskList.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = 0;
        int result = taskList.getSize();
        assertEquals(expResult, result);
    }

    public void testGetSizeWihtOneTask() throws ParseException {
        System.out.println("getSize");
        taskList.add(title, dueDate, project, description);
        int expResult = 1;
        int result = taskList.getSize();
        assertEquals(expResult, result);
    }
    /**
     * Test of sortListByDate method, of class TaskList.
     */
//  
    /**
     * Test of accountDoneTasks method, of class TaskList.
     */
    @Test
    public void testAccountDoneTasks() {
        System.out.println("accountDoneTasks");
        int expResult = 0;
        int result = taskList.accountDoneTasks();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAccountDoneTasksContainsOneTask() throws ParseException {
        System.out.println("accountDoneTasks");
        taskList.add(title, dueDate, project, description);
        int expResult = 0;
        int result = taskList.accountDoneTasks();
        
        assertEquals(expResult, result);
    }
     @Test
    public void testAccountDoneTasksContainsDoneOneTask() throws ParseException {
        System.out.println("accountDoneTasks");
        taskList.add(title, dueDate, project, description);
        taskList.setAsDoneTask(0);
        int expResult = 1;
        int result = taskList.accountDoneTasks();
        assertEquals(expResult, result);
    }

 //@Test
//    public void testSortListByDate() {
//        System.out.println("sortListByDate");
//        TaskList instance = new TaskList();
//        ArrayList<Task> expResult = null;
//        ArrayList<Task> result = instance.sortListByDate();
//        assertEquals(expResult, result);
//        
//    }

    /**
     * Test of getArrayList method, of class TaskList.
     */
//    @Test
//    public void testGetArrayList() throws ParseException  {
//        System.out.println("getArrayList");
//        taskList.add(title, dueDate, project, description);
//        ArrayList<Task> expResult = new ArrayList<>();
//        expResult.add(new Task( title, dueDate, project, description));
//        ArrayList<Task> result = taskList.getArrayList();
//        System.out.println(result.size());
//        assertEquals(expResult, taskList.getArrayList());
//    }
}
