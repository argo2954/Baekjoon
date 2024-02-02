import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

	static List<String> result = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("::");

		if(input.length==2) {
			String[] left = input[0].split(":");
			String[] right = input[1].split(":");
			int sizeOfZero = 8-left.length-right.length;
			
			demux(left);
			for(int i=0; i<sizeOfZero;i++) result.add("0000");
			demux(right);

		} else if(input.length==1) {
			String[] split = input[0].split(":");
			demux(split);
			
			if(split.length<8) {
				int sizeOfZero = 8 - split.length;
				for(int i=0; i<sizeOfZero;i++) result.add("0000");
			}
		}
		
		print();
	}
	
	static void demux(String[] strs) {
		for(String str: strs) {
			int zero = 4-str.length();
			
			for(int i=0; i<zero; i++)
				str = "0"+str;
			
			result.add(str);
		}
	}

	static void print() {
		for(int i=0; i<7; i++) {
			System.out.print(result.get(i)+":");
		}
		System.out.println(result.get(7));
	}
}