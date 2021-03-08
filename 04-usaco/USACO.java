import java.io.*;
import java.util.*;
public class USACO{
  private static int R, C, E, Nb;
  private static int[][] landb, instructions;

  private static int N, M, T, R1, C1, R2, C2;
  private static char[][] silverland;

  public static int bronze(String filename){
    readfilebronze(filename);
    int ans = 0;
    for (int i = 0; i< Nb; i++){
      boolean ishighest = true;
      int row = instructions[i][0] - 1;
      int col = instructions[i][1] - 1;
      int dig = instructions[i][2];
      for (int x = row; x<3; x++){
        for (int y = col; y<3; y++){
          if (landb[x][y]>landb[row][col]){
            ishighest = false;
          }
        }
      }
      if (!ishighest){
        int z = landb[row][col]-dig;
        for (int x = row; x<3; x++){
          for (int y = col; y<3; y++){
            if (landb[x][y]-dig < landb[row][col]-dig && landb[x][y]>landb[row][col]){
              landb[x][y] = landb[row][col];
            }
            if (landb[x][y]-dig > landb[row][col]-dig){
              landb[x][y] = landb[x][y] - dig;
            }
          }
        }
      }
      else{
        int z = landb[row][col]-dig;
        for (int x = row; x<3; x++){
          for(int y = col; y<3; y++){
            if (landb[row][col]-dig>0){
              landb[x][y] = z;
            }
            else{
              landb[x][y] = 0;
            }
          }
        }
      }
    }
    for (int i = 0; i<R; i++){
      for (int j = 0; j<C; j++){
        if (E-landb[i][j] > 0){
          ans += (E-landb[i][j]);
        }
      }
    }
    System.out.println(toString(landb));
    return ans;
  }


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
