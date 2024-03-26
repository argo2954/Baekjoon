import java.util.*;
import java.lang.Math;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList <Integer> Count=new ArrayList <Integer> ();
        int[] days=new int[progresses.length];
        /*
        for(int i=0;i<days.length;i++){
            days[i]=(int)Math.ceil((double)((100-progresses[i])/speeds[i]));
        }*/
        for(int i=0; i<days.length; i++){
        days[i]=(100-progresses[i])/speeds[i];
        if((100-progresses[i])%speeds[i]>0)
            days[i]++;
        }
        int count=1;
        int temp=days[0];
        for(int i=1;i<days.length;i++)
        {
            if(temp>=days[i]){
                count++; 
            }
            else{
                Count.add(count);
                count=1;
                temp=days[i];
            }
        }Count.add(count);
        int[] answer = new int[Count.size()];
        for(int i=0;i<answer.length;i++)
        {
            answer[i]=Count.get(i).intValue();
        }
        return answer;
    }
}