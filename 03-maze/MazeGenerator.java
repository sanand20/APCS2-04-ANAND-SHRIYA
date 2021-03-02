public class MazeGenerator{
  public static int erow;
  public static int ecol;
  public static int rownum;
  public static int colnum;
  public static boolean ehere;
  public static char[][] thismaze;



  public static boolean works(int row, int col){
    if (row<=0 || row>=thismaze.length-1 || col<=0 || col>=thismaze[0].length-1 || thismaze[row][col]=='S'){
      return false;
    }
    int spaces = 0;
    if (col>0 && (thismaze[row][col - 1]==' ' || thismaze[row][col - 1]=='.')){
      spaces++;
    }
    if (col<thismaze[0].length-1 && (thismaze[row][col + 1]==' ' || thismaze[row][col + 1]=='.')){
      spaces++;
    }
    if (row > 0 && (thismaze[row-1][col]==' ' || thismaze[row-1][col]=='.')){
      spaces++;
    }
    if (row<thismaze.length-1 && (thismaze[row+1][col]==' ' || thismaze[row+1][col]=='.')){
      spaces++;
    }
    if (spaces<2 &&(thismaze[row][col]!='.' && thismaze[row][col]!='S')){
      return true;
    }
    return false;
  }
    /

}
