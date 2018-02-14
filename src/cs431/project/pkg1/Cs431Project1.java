package cs431.project.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * CS431 Project 1 - Scheduling Algorithms
 * @author Joshua Camacho
 */
public class Cs431Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        LinkedHashMap<String,Integer> m = new LinkedHashMap<String, Integer>();
        // pass the path to the file as a parameter
        File file = new File("testdata1.txt");
        Scanner sc = new Scanner(file);
 
        while (sc.hasNextLine()){
            String jobName = sc.nextLine();
            int jobVal = Integer.parseInt(sc.nextLine());
            m.put(jobName, jobVal);
        }
        
        ScheduleAlgorithm test = new FirstComeFirstServe((LinkedHashMap)m.clone());
        test.execute();
        
        test = new ShortestJobFirst((LinkedHashMap)m.clone());
        test.execute();
        
        test = new RoundRobin((LinkedHashMap)m.clone(),2);
        test.execute();
        
        test = new RoundRobin((LinkedHashMap)m.clone(),5);
        test.execute();
    }
    
}
