public class Recursion{
  public static String reverse(String s){
    if (s.length()==0){
      return s;
    }
    return reverse(s.substring(1))+s.charAt(0);
  }
  public static long countNoDoubleLetterWords(int length,String word){
    if (length == 0){
      return 1;
    }


    for (int i = 0; i<26; i++){
      char x = (char)('a'+ i);
      if (word.length()==0){
        return countNoDoubleLetterWords(length-1, word + x) *26;

      }
      else if (word.charAt(word.length()-1) != x){
        return countNoDoubleLetterWords(length-1, word + x) *25;
    }
  }
    return countNoDoubleLetterWords(length-1, word);

  }

  public static double sqrt(double num){
    return sqrt(num, 1.0);
  }
  public static double sqrt(double num, double n){
    if (Math.abs(n * n - num)<= 0.00001 * num){
      return n;
    }
    return sqrt(num, (num / n + n)/2);
  }
  
}
