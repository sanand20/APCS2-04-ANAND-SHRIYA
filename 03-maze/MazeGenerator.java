public class MazeGenerator{
  private char[][]maze;
  private int erow;
  private int ecol;
  private int rownum;
  private int colnum;
  private boolean ehere;
  public MazeGenerator(int row, int col){
    maze = new char[row][col];
    rownum = row;
    colnum = col;


    for (int i = 0; i<maze.length; i++){
      for (int j = 0; j<maze[0].length; j++){
        if(i == 0  || i == maze.length-1 || j == 0  || j == maze[0].length-1){
          maze[i][j]='@';
        }
          maze[i][j] = '#';
        }
      }


  }

  public String toString(){
    String result = "";
    for (int i = 0; i<maze.length; i++){
      for (int j = 0; j<maze[0].length; j++){
        result += maze[i][j];
      }
      result += "\n";
    }
    return result;
  }


}
