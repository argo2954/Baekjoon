import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int size = (int)Math.pow(10, N/2+1);
        boolean[] isNotPrimeNumber = new boolean[size+1];

        int sqrt = (int)Math.sqrt(size);
        for(int i=2; i<sqrt; i++){
            if(isNotPrimeNumber[i])
                continue;

            int primeNumber = i;
            while(primeNumber+i <= size){
                isNotPrimeNumber[primeNumber+i] = true;
                primeNumber += i;
            }
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for(int i=2; i<=size; i++){
            if(!isNotPrimeNumber[i]){
                primeNumbers.add(i);
            }
        }

        findSpecialPrimeNumber(2, 1, N, primeNumbers);
        findSpecialPrimeNumber(3, 1, N, primeNumbers);
        findSpecialPrimeNumber(5, 1, N, primeNumbers);
        findSpecialPrimeNumber(7, 1, N, primeNumbers);
    }

    static void findSpecialPrimeNumber(int number, int index, int depth, List<Integer> primeNumbers){
        for(Integer i: primeNumbers){
            if(number==i){
                break;
            }
            else if(number%i==0){
                return;
            }
        }

        if(index==depth){
            System.out.println(number);
            return;
        }

        for(int i=1; i<=9; i++){
            findSpecialPrimeNumber(number*10+i, index+1, depth, primeNumbers);
        }
    }
}

