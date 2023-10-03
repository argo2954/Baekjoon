import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        // 
        if(N==number) return 1;
            
        // init | numberOfTimes->LinkedList<Integer>[9]
        int consecutive = N; // make for (N, NN, NNN, ---, NNNNNNNN)
        Set<Integer>[] numberOfTimes = new TreeSet[9];
        for(int i=1; i<=8; i++){
            numberOfTimes[i] = new TreeSet<>();
            numberOfTimes[i].add(consecutive); // fill (N, NN ....)
            consecutive  = consecutive*10 + N;
        }
        
        // init | rest of numberOfTimes
        for(int i=2; i<=8; i++){
            for(int j=1; j<=i/2; j++){
                Set<Integer> left = numberOfTimes[j];
                Set<Integer> right = numberOfTimes[i-j];
                
                Set<Integer> target = numberOfTimes[i];
                for(int l: left){
                    for(int r: right){
                        int plus = l+r;
                        int minus1 = l-r;
                        int minus2 = r-l;
                        int mul = r*l;
                        int div1 = l/r;
                        int div2 = r/l;
                        
                        if(plus>0) target.add(plus);
                        if(mul>0) target.add(mul);
                        if(minus1>0) target.add(minus1);
                        if(minus2>0) target.add(minus2);
                        if(div1>0) target.add(div1);
                        if(div2>0) target.add(div2);
                    }
                }
                if(target.contains(number))
                    return i;
            }
        }
        return answer;
    }
    

    
}