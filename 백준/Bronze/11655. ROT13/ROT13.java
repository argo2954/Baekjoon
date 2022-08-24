import java.io.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s= br.readLine();

    int len = s.length();
    for(int i=0; i<len; i++){
      char c = s.charAt(i);

      if('a'<=c && c<='z'){
        if((c+=13)>'z')
          bw.write((c-'z'+'a'-1));
        else
          bw.write(c);
      }
      else if('A'<=c && c<='Z'){
        if((c+=13)>'Z')
          bw.write((c-'Z'+'A'-1));
        else
          bw.write(c);
      }
      else
        bw.write(c);
    }
    
    bw.write("\n");
    br.close();
    bw.close();
  }

 
}