import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int five = N/5;
		int third = N%5/3;
		
		while((five*5 + third*3)!=N && five>=0) {
			five--;
			third = (N-(five*5))/3;
		}
		
		int result = five>=0? five+third: -1;
		System.out.println(result);
	}
}