import java.io.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int answer = n;    
    while(n-->0){
      String s= br.readLine();
      int[] count = new int[26];
      for(int i=0; i<26; i++) count[i] = 100;
      int len = s.length();

      for(int i=0; i<len; i++){
        char c = s.charAt(i);
        if(count[c-'a']!=100){
          if(count[c-'a']!=i-1){
            answer--;
            break;
          }
        }
        count[c-'a'] = i;
      }
    }
    
    bw.write(answer + "\n");
    br.close();
    bw.close();
  }

 
}