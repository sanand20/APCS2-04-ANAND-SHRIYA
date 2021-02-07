public class Recursion{
  public static String reverse(String s){
    if (s.length()==0){
      return s;
    }
    return reverse(s.substring(1))+s.charAt(0);
  }
  public static void main (String[] args){
    System.out.println(reverse(""));
  }
}
