import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input | dwarfs -> list, sum -> int
        List<Integer> dwafs = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<9; i++){
            dwafs.add(Integer.parseInt(br.readLine()));
            sum += dwafs.get(i);
        }

        // sort | dwafs -> asc
        Collections.sort(dwafs);

        // solve | find liar
        all: for(int i=0; i<8; i++){
                for(int j=i+1; j<9; j++){
                    int liar1 = dwafs.get(i);
                    int liar2 = dwafs.get(j);
                    int height = sum - liar1 - liar2;
                    
                    if(height == 100){
                        dwafs.remove(i);
                        dwafs.remove(j-1);
                        break all;
                    }
                }
        }

        // print
        for(int dwaf: dwafs)
            System.out.println(dwaf);
    }
}
