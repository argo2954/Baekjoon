import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //입력
    int n = Integer.parseInt(br.readLine());
    String[] s = br.readLine().split(" ");
    //입력 값 int 배열로 전환
    int[] arr = new int[n];
    for(int i=0; i<n; i++)
      arr[i] = Integer.parseInt(s[i]);
      
    //소수 연산
    //b[index]==true -> 소수X
    //b[index]==false -> 소수O    
    boolean[] b = new boolean[1001];
    b[0] = b[1] = true;
    for(int i=2; i*i<=1000; i++){
      if(b[i]) continue;
      for(int j=i+i; j<=1000; j+=i)
        b[j] = true;
    }
    //입력된 수 소수판단
    int ans = 0;
    for(int i=0; i<n; i++)
      if(!b[arr[i]])
        ans++;
    //출력
    bw.write(ans + "\n");
    bw.close();
    br.close();
  }
}