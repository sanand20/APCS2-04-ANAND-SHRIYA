import java.io.*;
import java.util.*;
public class USACO{
  private static int R, C, E, Nb;
  private static int[][] landb, instructions;

  private static int N, M, T, R1, C1, R2, C2;
  private static char[][] silverland;


  public static void readfilebronze( String filename){
    try{
      File f = new File(filename);
      Scanner wholefile = new Scanner(f);
      Scanner line1 = new Scanner (wholefile.nextLine());
      R = line1.nextInt();
      C = line1.nextInt();
      E = line1.nextInt();
      Nb = line1.nextInt();
      landb = new int[R][C];
      instructions = new int[Nb][3];
      for (int i = 0; i<R; i++){
        Scanner row = new Scanner (wholefile.nextLine());
        for (int j = 0; j<C; j++){
          landb[i][j] = row.nextInt();
        }
      }

      for (int i = 0; i<Nb; i++){
        Scanner row = new Scanner (wholefile.nextLine());
        for (int j = 0; j<3; j++){
          instructions[i][j] = row.nextInt();
        }
      }
      System.out.println(R);
      System.out.println(toString(instructions));
    }
    catch(FileNotFoundException e){
      System.out.println("File not found:"+ filename);
    }
  }


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
