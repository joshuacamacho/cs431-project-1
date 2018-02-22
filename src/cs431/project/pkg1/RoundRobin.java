/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs431.project.pkg1;

import java.util.LinkedHashMap;

/**
 *
 * @author Josh
 */
public class RoundRobin extends ScheduleAlgorithm{
    private int slice;
    int count = 0;
    public RoundRobin(LinkedHashMap m, int slice) {
        super(m);
        this.slice = slice;
    }

    @Override
    void execute() {
        System.out.println("-------------------------\nRound Robin with time slice = "+slice);
        
        while(nextJob()){
            this.addToChart("["+getJob() + "]" + time); 
            while(getJobValue()>0 && count<slice){
                int value = getJobValue();
                this.addToChart("-");
                time++;
                value--;
                this.setJobValue(value);
                count++;
            }
            this.addToChart(time+ " ");
            count=0;
            if(getJobValue()==0) this.removeJob();
        }
        
        this.printStats();
    }
    
}
