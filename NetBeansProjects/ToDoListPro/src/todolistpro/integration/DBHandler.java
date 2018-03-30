/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolistpro.integration;



import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author mohamad
 */
public class DBHandler<T > {

    public static String fileName = "toDoList.bin"; 
//    private TaskList taskList;
    private File theFile;
    private T task;
    
    public DBHandler() throws IOException   {
       theFile= new File(fileName);
        if (!theFile.exists()) {
           theFile.createNewFile();
      }
    }
      
    public ArrayList<T> readFromFile() throws FileNotFoundException, ParseException, IOException, ClassNotFoundException {
        if (theFile.length() == 0) {
            return new ArrayList<>();
        } else {
            ArrayList created = new ArrayList<>();
            FileInputStream fi = new FileInputStream(theFile);
            ObjectInputStream oi = new ObjectInputStream(fi);
            while (fi.available() > 0) {
                T task = (T) oi.readObject();
                created.add(task);
            }
            oi.close();
            return created;
        }
    }

    public void save(ArrayList<T> taskListToSave) {
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(theFile);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            for (T i : taskListToSave) {
                oos.writeObject(i);
            }
            oos.close();
            JOptionPane.showMessageDialog(null, "saved successfullly");
        } catch (HeadlessException | IOException e) {
             JOptionPane.showMessageDialog(null,"the file hasn't been saved"+e.getMessage());
        }
    }
          
//    public ArrayList<Task> readFromFile() throws FileNotFoundException, ParseException, IOException    {
//      if (theFile.length() == 0)
//           return new ArrayList<>();
//        ArrayList created = new ArrayList<>();
//        FileReader fr = new FileReader(theFile);
//        BufferedReader br=new BufferedReader(fr);
//        Stream<String> lines= br.lines();
//        Iterator it=lines.iterator();
//        it.next();
//        while(it.hasNext()){
//            String  splitstring = it.next().toString();
//            String[] split= splitstring.split(",");
//            Task t=new Task(split[0],split[2],split[3], split[4]);
//              if (split[2].equals("done")) {
//                  t.setIsDone(true);
//              }
//              created.add(t);
//          }
//        br.close();
//        fr.close();
//        return created;
//      }
    
    
    
  
    
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
    
//      
     
     

  
        
        
          



//    public void save(ArrayList<Task> taskListToSave)  {
//        try{
//        FileWriter fw=new FileWriter(fileName,false);
//        BufferedWriter bw=new BufferedWriter(fw);
//        PrintWriter pw= new PrintWriter(bw);
//        
//        pw.println("Title, Status, Date, Project, Description");
//              for(Task i: taskListToSave){//remove the get Array
// 
////        for(Task i: taskListToSave.getArray()){//remove the get Array
//            pw.println(i);
//        }
//        pw.flush();
//        pw.close();
//        JOptionPane.showMessageDialog(null,"saved successfullly");
//         }
//        catch (IOException e){ 
//            JOptionPane.showMessageDialog(null,"the file hasn't been saved"+e.getMessage());
//        }
//    }
    
}
        
        
    
 
          