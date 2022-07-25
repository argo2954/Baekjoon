import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while(true){
      int[] arr = Arrays.stream(in.nextLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();
      if(arr[0]==0) break;
      Arrays.sort(arr);
      if(arr[0]*arr[0]+arr[1]*arr[1]==arr[2]*arr[2])
        System.out.println("right");
      else
        System.out.println("wrong");
    }
  }
}