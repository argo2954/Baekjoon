import java.io.*;
import java.util.ArrayList;

class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  
  public static void main(String[] args) throws IOException{
    int N = Integer.parseInt(br.readLine());
    MinHeap mh = new MinHeap(N);
    mh.operator();
  }
  
  static class MinHeap{
    int len;
    ArrayList<Integer> mheap;
    // 생성
    MinHeap(int len){
      this.len = len;
      mheap = new ArrayList<>();
      mheap.add(0);  // 첫 번째 힙 비움
    }
    // 삽입
    void insert(int val){
      mheap.add(val); // 마지막 노드에 데이터 추가
      int idx = mheap.size() -1;  // 마지막 노드의 index
      
      while(idx>1 && mheap.get(idx/2)<mheap.get(idx)){
        // index가 1보다 크고, 부모 노드의 데이터가 자식보다 작다면
        // 부모와 자식의 데이터 교환
        int parent = mheap.get(idx/2);  // 부모 노드의 데이터
        mheap.set(idx/2, val);
        mheap.set(idx, parent);

        // index를 부모의 index값으로 바꿈
        idx = idx/2;
      }
    }
    //삭제 및 반환
    int delete(){
      int size = mheap.size() -1;
      if(size == 0)
        return 0;

      int idx = 1;
      int deleteData = mheap.get(idx);
      mheap.set(idx, mheap.get(size));
      mheap.remove(size);
      
      while((idx*2)<size){
        // 자식 선택(작은 자식) -> 왼쪽 먼저 선택 후, 오른쪽 자식과 비교
        int cld = mheap.get(idx*2);
        int cldIdx = idx*2;

        if((cldIdx+1)<size && cld<mheap.get(cldIdx+1)){
          cld = mheap.get(cldIdx+1);
          cldIdx = cldIdx +1;
        }
  
        if(cld<mheap.get(idx)) // 부모가 자식보다 큰 경우 -> 정렬 끝
          break;

        // 부모 자식간 데이터 교환
        int tmp = mheap.get(idx);
        mheap.set(idx, cld);
        mheap.set(cldIdx, tmp);
        idx = cldIdx;
      }

      return deleteData;
    }

    void operator() throws IOException{
      for(int i=0; i<len; i++){
        int x = Integer.parseInt(br.readLine());
        
        if(x == 0)
          bw.write(delete() + "\n");
        
        else
          insert(x);
      }
      bw.flush();
    }
    
  }
}