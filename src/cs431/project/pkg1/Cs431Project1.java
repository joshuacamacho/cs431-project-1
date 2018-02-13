package cs431.project.pkg1;

import java.util.LinkedHashMap;

/**
 * CS431 Project 1 - Scheduling Algorithms
 * @author Joshua Camacho
 */
public class Cs431Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedHashMap<String,Integer> m = new LinkedHashMap<String, Integer>();
        m.put("job1", 4);
        m.put("job2", 1);
        m.put("job3", 10);
        m.put("job4", 7);
        ScheduleAlgorithm test = new FirstComeFirstServe(m);
        test.execute();
        
    }
    
}
