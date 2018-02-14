package cs431.project.pkg1;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author Josh
 */
public class FirstComeFirstServe extends ScheduleAlgorithm{

    public FirstComeFirstServe(LinkedHashMap m) {
        super(m);
    }
    
    @Override
    void execute() {
        System.out.println("-------------------------\nFirst Come First Serve");
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
        System.out.println(this.getChart());
        System.out.println("Ave Completion time = "+ this.getAverage()
                +"\n--------------------------\n");
    }
    
}
