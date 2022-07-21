class Main {
  static int MAX = 10001;  
  static boolean[] check = new boolean[MAX]; //셀프넘버 = 0

  static void f(int i){
    int sum = i;
    while(i>0){
      sum += i%10;
      i /= 10;
    }
    if(sum<MAX) check[sum] = true;
  }
  
  public static void main(String[] args) {
    for(int i=1; i<MAX; i++)
      f(i);
    
    for(int i=1; i<MAX; i++)
      if(!check[i]) System.out.println(i);
    
    
  }
}