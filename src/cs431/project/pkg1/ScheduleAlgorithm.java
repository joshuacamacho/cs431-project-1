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
    protected Map m;
    private String jobName;
    private int jobWeight;
    protected Iterator it;
    protected int totalCompletionTime;
    protected int totalProccessingTime;
    private int totalJobs;
    protected int time;
    private String chart;
    protected int totalWaitTime;
    ScheduleAlgorithm(LinkedHashMap m){
        this.m = m;
        it = m.entrySet().iterator();
        time=0;
        chart = "";
        totalJobs=m.size();
        totalCompletionTime=0;
        totalProccessingTime=0;
        totalWaitTime=0;
        for(Object value: m.values()){
            totalProccessingTime+= (int)value;
        }
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
       totalCompletionTime+=time;
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
   
   public float getAverageProcessingTime() {
       return (float)this.totalProccessingTime/(float)totalJobs;
   }
   abstract void execute();
   
   public void printStats(){
       String chart = this.getChart();
       boolean flag=false;
       for(int i=0; i<chart.length(); i++){
           if(i%100==0 && i!=0) flag = true;
           if(!flag || chart.charAt(i)!=' '){
               System.out.print(chart.charAt(i));
           }else {
               System.out.print("\n(continued)=> ");
               flag=false;
           }
       }
       System.out.println("\nAve Processing time = "+this.getAverageProcessingTime());
       System.out.println("Ave Turnaround time = "+ this.getAverage()
               +"\nAverage Waiting Time = "+ (this.getAverage() - this.getAverageProcessingTime())
               +"\n--------------------------\n");
   }
}
