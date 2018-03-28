/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.integration;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import todolistpro.model.Task;


/**
 *
 * @author mohamad
 */
public class Handler {

    public static String fileName = "toDoList.txt"; 
//    private TaskList taskList;
    private File theFile;
    
    public Handler() throws IOException   {
       theFile= new File(fileName);
        if (!theFile.exists()) {
           theFile.createNewFile();
      }
    }
      

  
    
//    public ArrayList<Task> readFromFile() throws FileNotFoundException, ParseException   {
//            if (theFile.length() == 0)
//            return new ArrayList<>();
//        ArrayList created = new ArrayList<>();
//        Scanner sc = new Scanner(theFile);
//          sc.nextLine();
//        while (sc.hasNext()) {
//             String line = sc.nextLine();
//            String[] split = line.split(",");
//            Task t = new Task(split[0], split[2], split[3], split[4]);
//            if (split[2].equals("done")) 
//                t.setIsDone(true);
//            created.add(t);
//        }
//        sc.close();
//        return created;
//    }
//        
    
      public ArrayList<Task> readFromFile() throws FileNotFoundException, ParseException, IOException    {
      if (theFile.length() == 0)
           return new ArrayList<>();
        ArrayList created = new ArrayList<>();
        FileReader fr = new FileReader(theFile);
        BufferedReader br=new BufferedReader(fr);
        Stream<String> lines= br.lines();
        Iterator it=lines.iterator();
        it.next();
        while(it.hasNext()){
            String  splitstring = it.next().toString();
            String[] split= splitstring.split(",");
            Task t=new Task(split[0],split[2],split[3], split[4]);
            if (split[2].equals("done"))
            t.setIsDone(true);
            created.add(t);
           }
        br.close();
        fr.close();
        return created;
      }
        
    public void save(ArrayList<Task> taskListToSave)  {
        try{
        FileWriter fw=new FileWriter(fileName,false);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw= new PrintWriter(bw);
        
        pw.println("Title, Status, Date, Project, Description");
              for(Task i: taskListToSave){//remove the get Array
 
//        for(Task i: taskListToSave.getArray()){//remove the get Array
            pw.println(i);
        }
        pw.flush();
        pw.close();
        JOptionPane.showMessageDialog(null,"saved successfullly");
         }
        catch (IOException e){ 
            JOptionPane.showMessageDialog(null,"the file hasn't been saved"+e.getMessage());
        }
    }
    
}
        
        
    
 
          