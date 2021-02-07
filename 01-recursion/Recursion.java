public class Recursion{
  public static String reverse(String s){
    if (s.length()==0){
      return s;
    }
    return reverse(s.substring(1))+s.charAt(0);
  }
  public static long countNoDoubleLetterWords(int length,String word){
    if (length == 0){
      return 26;
    }
    else{

    for (int i = 0; i<26; i++){
      char x = (char)('a'+ i);
      if (word.charAt(word.length()-2) != x){
        return countNoDoubleLetterWords(length-1, word + x) *25;

      }
    }
  }
  }

  public static double sqrt(int num){
    return sqrt(num, 1.0);
  }
  public static double sqrt(int num, double n){
    if (Math.abs(n * n - num)<= 0.00001 * num){
      return n;
    }
    return sqrt(num, (num / n + n)/2);
  }
  public static void main (String[] args){
    System.out.println(countNoDoubleLetterWords(3));
  }
}
