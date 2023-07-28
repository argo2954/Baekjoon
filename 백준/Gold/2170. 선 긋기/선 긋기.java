import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // input | N -> int
    int N = Integer.parseInt(br.readLine());

    // input | X & Y -> priorityQueue<pair<int, int>>
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((pq1, pq2)->{
        return pq1.a!=pq2.a? pq1.a-pq2.a: pq1.b-pq2.b;
    });
    for(int i=0; i<N; i++){
        String[] S = br.readLine().split(" ");
        pq.add(new Pair(Integer.parseInt(S[0]), Integer.parseInt(S[1])));
    }

    // solve | 이전 선의 끝 지점을 기억해, 이번 선과 연결되는지 확인
    int answer = 0;
    int preEnd = Integer.MIN_VALUE;
    
    while(!pq.isEmpty()){
        Pair pair = pq.poll();
        int start = pair.a;
        int end = pair.b;

        if(start<=preEnd){  // 선이 이어질 때
            if(preEnd<end){
                answer += end-preEnd;       
                preEnd = end;
            }
        } else{ // 선이 이어지지 않을 때
            answer += end-start;
            preEnd = end;
        }
    }

    System.out.println(answer);
  }

  // class | 선의 정보 저장
  static class Pair{
    int a;
    int b;

    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
  }
}