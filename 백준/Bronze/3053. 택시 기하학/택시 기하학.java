import java.util.*;
class Main {
  public static void main(String[] args) {
    double pi = 3.14159265358979323846;
    double pi2 = 2.0;
    Scanner in = new Scanner(System.in);
    int R = in.nextInt();

    System.out.println(String.format("%.6f", pi*R*R));
    System.out.println(String.format("%.6f", pi2*R*R));
  }
}