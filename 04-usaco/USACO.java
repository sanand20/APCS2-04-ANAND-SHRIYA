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
      int row = (instructions[i][0] - 1);
      int col = (instructions[i][1] - 1);
      int dig = instructions[i][2];
      int max = landb[row][col];
      for (int x = row; x<row+3; x++){
        for (int y = col; y<col+3; y++){
          if (landb[x][y]>landb[row][col]){
            ishighest = false;
            max = landb[x][y];
          }
        }
      }

        helpermethod(landb,row,col,dig);
    }
    for (int i = 0; i<R; i++){
      for (int j = 0; j<C; j++){
        if (E-landb[i][j] > 0){
          ans += (E-landb[i][j]);
        }
      }
    }

    return ans;
  }
  public static void helpermethod(int[][] arr, int row, int col, int dig) {
  
  }
  public static int silver(String filename){
    int[][] tracker1 = new int[N][M];
    tracker1[R1][C1]=1;
    int[][] tracker2 = new int[N][M];
    for (int i = 0; i<T; i++){
      for (int x = 0; x<N; x++){
        for (int y = 0; y<M; y++){
         if(silverland[x][y]!='*'){
          if(works(x-1,y)){
            tracker2[x][y] += tracker1[x-1][y];
          }
          if(works(x+1,y)){
            tracker2[x][y] += tracker1[x+1][y];
          }
          if(works(x,y-1)){
            tracker2[x][y] += tracker1[x][y-1];
          }
          if(works(x,y+1)){
            tracker2[x][y] += tracker1[x][y+1];
          }
        }
        }
      }
      for (int x = 0; x<N; x++){
        for (int y = 0; y<M; y++){
          tracker1[x][y]=tracker2[x][y];
        }
      }
      for (int x = 0; x<N; x++){
        for (int y = 0; y<M; y++){
          tracker2[x][y]=0;
        }
      }

    }

    return tracker1[R2][C2];
  }
  public static boolean works(int row, int col){
    if (row<0 || row>=N || col<0 || col>=M || silverland[row][col]=='*'){
      return false;
    }
    return true;
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
      System.out.println(R);
      System.out.println(C);
      System.out.println(E);
      System.out.println(Nb);
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

    }
    catch(FileNotFoundException e){
      System.out.println("File not found:"+ filename);
    }
  }

  public static void readfilesilver( String filename){
    try{
      File f = new File(filename);
      Scanner wholefile = new Scanner(f);
      Scanner line1 = new Scanner (wholefile.nextLine());
      N = line1.nextInt();
      M = line1.nextInt();
      T = line1.nextInt();
      silverland = new char[N][M];

      for (int i = 0; i<N; i++){
        String row = (wholefile.nextLine());
        for (int j = 0; j <row.length(); j++){
          silverland[i][j] = row.charAt(j);
        }

      }

      R1 = wholefile.nextInt()-1;
      C1 = wholefile.nextInt()-1;
      R2 = wholefile.nextInt()-1;
      C2 = wholefile.nextInt()-1;



    }
    catch(FileNotFoundException e){
      System.out.println("File not found: "+ filename);
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
  public static String toString(char[][] array){
    String result = "";
    for (int i = 0; i<array.length; i++){
      for (int j = 0; j<array[0].length; j++){
        result+=array[i][j];
      }
      result += "\n";
    }
    return result;
  }

  public static void main (String[] args){
      //System.out.println(toString(landb));
      //readfilebronze("btest.txt");
      //System.out.println(toString(landb));

    //readfilesilver("silverprob.txt");
  //  System.out.println(silver("silverprob.txt"));
    System.out.println(bronze("btest.txt"));
  }

}
