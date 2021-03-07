import java.io.*;
import java.util.*;
public class USACO{
  private static int R, C, E, Nb;
  private static int[][] landb, instructions;

  private static int N, M, T, R1, C1, R2, C2;
  private static char[][] silverland;

  
  public static void main (String[] args){
    readfilesilver("silverprob.txt");
    System.out.println(silver("silverprob.txt"));
    //System.out.println(bronze("bronzeprob.txt"));
  }

}
