import java.io.*;
import java.util.Stack;
class Main {
  public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
  
  public static String s;

  public static void main(String[] args) throws IOException{
    s = in.readLine();
    
    if(f()) out.write("PPAP" + "\n");
    else out.write("NP" + "\n");
    
    in.close();
    out.close();
  }
  static boolean f(){
    int len = s.length();
    int pcnt = 0;
    for(int i=0; i<len; i++){
      if(s.charAt(i)=='A'){
        if(pcnt<2 || i==len-1) return false;
        else if(s.charAt(i+1)=='A') return false;
        
        pcnt--;
        i++;
      }
      else pcnt++;
    }
    if(pcnt==1) return true;
    return false;
  }
}