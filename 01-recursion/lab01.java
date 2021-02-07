public class lab01{
  public static double sqrt(int num){
    return sqrt(num, 1.0);
  }
  public static double sqrt(int num, double n){
    if (Math.abs(n * n - num)<= 0.00001 * num){
      return n;
    }
    return sqrt(num, (num / n + n)/2);
  }
  public static void main(String[] args){
    System.out.println(sqrt(2));
  }
}
