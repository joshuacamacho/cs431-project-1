/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs431.project.pkg1;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Josh
 */
public class ShortestJobFirst extends ScheduleAlgorithm {

    public ShortestJobFirst(LinkedHashMap m) {
        super(m);
        LinkedHashMap<String, Integer> sorted = new LinkedHashMap<String, Integer>();
       this.m.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue()) 
        .limit(1000) 
        .forEach((entry)->{
            String[] split = entry.toString().split("=");
            sorted.put(split[0], Integer.parseInt(split[1]));
        }); 

       it = sorted.entrySet().iterator();
       this.m = sorted;
    }
    
    @Override
    void execute() {
        System.out.println("-------------------------\nShortestJobFirst");
        
        while(nextJob()){
            this.addToChart("["+getJob() + "]" + time); 
            while(getJobValue()>0){
                int value = getJobValue();
                this.addToChart("-");
                time++;
                value--;
                this.setJobValue(value);
            }
            this.addToChart(time+ " ");
            this.removeJob();
        }
        
        this.printStats();
    }
    
}
