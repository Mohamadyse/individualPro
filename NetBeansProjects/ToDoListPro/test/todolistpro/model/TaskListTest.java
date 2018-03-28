/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.model;

import java.text.ParseException;
import java.util.ArrayList;
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
    static TaskList instance;
    
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
        instance = new TaskList();
        
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
        instance.add(title, dueDate, project, description);
        expected.getArrayList().add(task);
        assertArrayEquals(expected.getArrayList().toArray(), instance.getArrayList().toArray());
    }
    
    
    /**
     * Test of removeTask method, of class TaskList.
     */
    @Test
    public void testRemoveTask() throws ParseException {
        System.out.println("removeTask");
        Task task=new Task(title, dueDate, project, description);
        instance.add(title, dueDate, project, description);
            int index = 0;
        instance.removeTask(index);
        TaskList expected = new TaskList();
        assertArrayEquals(expected.getArrayList().toArray(), instance.getArrayList().toArray());
    }

    /**
     * Test of setAsDoneTask method, of class TaskList.
     */
    @Test
    public void testSetAsDoneTask() throws ParseException {
        System.out.println("setAsDoneTask");
        instance.add(title, dueDate, project, description);
        Task task = new Task(title, dueDate, project, description);
        instance.setAsDoneTask(0);
        boolean status = instance.getArrayList().get(0).isDone();
        assertTrue(status);
    }
    /**
     * Test of showTask method, of class TaskList.
     */
    @Test
    public void testShowTask() throws ParseException {
        System.out.println("showTask");
        instance.add(title, dueDate, project, description);
        String expResult = title + "," + "undone" + "," + "11.11.1111" + "," + project + "," + description;
        String result = instance.showTask(0);
        assertEquals(expResult, result);
    }
    /**
     * Test of getSize method, of class TaskList.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    public void testGetSizeWihtOneTask() throws ParseException {
        System.out.println("getSize");
        instance.add(title, dueDate, project, description);
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }
    /**
     * Test of sortListByDate method, of class TaskList.
     */
//    @Test
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
//        instance.add(title, dueDate, project, description);
//        ArrayList<Task> expResult = new ArrayList<>();
//        expResult.add(new Task( title, dueDate, project, description));
//        ArrayList<Task> result = instance.getArrayList();
//        assertArrayEquals(expResult.toArray(), result.toArray());
//    }

    /**
     * Test of accountDoneTasks method, of class TaskList.
     */
    @Test
    public void testAccountDoneTasks() {
        System.out.println("accountDoneTasks");
        int expResult = 0;
        int result = instance.accountDoneTasks();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAccountDoneTasksContainsOneTask() throws ParseException {
        System.out.println("accountDoneTasks");
        instance.add(title, dueDate, project, description);
        int expResult = 0;
        int result = instance.accountDoneTasks();
        
        assertEquals(expResult, result);
    }
     @Test
    public void testAccountDoneTasksContainsDoneOneTask() throws ParseException {
        System.out.println("accountDoneTasks");
        instance.add(title, dueDate, project, description);
        instance.setAsDoneTask(0);
        int expResult = 1;
        int result = instance.accountDoneTasks();
        
        assertEquals(expResult, result);
    }
}
