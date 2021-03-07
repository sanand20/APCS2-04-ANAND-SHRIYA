import java.io.*;
import java.util.*;
public class USACO{
  private static int R, C, E, Nb;
  private static int[][] landb, instructions;

  private static int N, M, T, R1, C1, R2, C2;
  private static char[][] silverland;


  public static String toString(int[][] array){
    String result = "";
    for (int i = 0; i<array.length; i++){
      for (int j = 0; j<array[0].length; j++){
        result+=array[i][j];
        result += " ";
      }
      result += "\n";
    }
    return result;
  }


  public static void main (String[] args){
    readfilesilver("silverprob.txt");
    System.out.println(silver("silverprob.txt"));
    //System.out.println(bronze("bronzeprob.txt"));
  }

}
