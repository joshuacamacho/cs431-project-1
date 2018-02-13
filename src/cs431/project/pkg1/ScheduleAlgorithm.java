package cs431.project.pkg1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Josh
 */
public abstract class ScheduleAlgorithm {
    private Map m;
    private String jobName;
    private int jobWeight;
    private Iterator it;
    protected int totalCompletionTime;
    private int totalJobs;
    protected int time;
    private String chart;
    ScheduleAlgorithm(LinkedHashMap m){
        this.m = m;
        it = m.entrySet().iterator();
        time=0;
        chart = "";
        totalJobs=m.size();
        totalCompletionTime=0;
    }
   public boolean nextJob(){
       if(!it.hasNext()) {
           it = m.entrySet().iterator();
       }
       
       if(it.hasNext()){
           Map.Entry pair = (Map.Entry)it.next();
           jobName = (String)pair.getKey();
           jobWeight = (int)pair.getValue();
           return true; 
       }else{
           return false;
       }
       
   }    
   public String getJob(){
        return jobName;
   }
   
   public int getJobValue(){
       return jobWeight;
   }
   
   public void setJobValue(int value){
       m.put(jobName, value);
       jobWeight = (int)m.get(jobName);
   }
   
   public void removeJob(){
       it.remove();
   }
   
   public float getAverage(){
           return (float)totalCompletionTime/(float)totalJobs;
   }
   
   public void addToChart(String s){
       chart = chart.concat(s);
   }
   
   public String getChart(){
       return chart;
   }
   
   void printSet(){
       while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }
   }
   abstract void execute();
}
