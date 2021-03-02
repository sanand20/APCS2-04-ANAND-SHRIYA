public class MazeGenerator{
  private char[][]maze;
  private int erow;
  private int ecol;
  private int rows;
  private int cols;
  private boolean ehere;
  public MazeGenerator(int row, int col){
    maze = new char[row][col];
    rows = row;
    cols = col;
    double startrow = Math.random()*(maze.length-2) + 1;
    double startcol = Math.random()*(maze[0].length-2) +1;

    for (int i = 0; i<maze.length; i++){
      for (int j = 0; j<maze[0].length; j++){
        if(i == 0  || i == maze.length-1 || j == 0  || j == maze[0].length-1){
          maze[i][j]='@';
        }
          maze[i][j] = '#';
        }
      }

      generate(maze, row, col,(int)startrow, (int)startcol);
      maze[(int)startrow][(int)startcol]= 'S';
      maze[erow][ecol]='E';

      for (int i = 0; i<maze.length; i++){
        for (int j = 0; j<maze[0].length; j++){
            if (maze[i][j]=='.'){
              maze[i][j]=' ';
            }
          }
        }
  }


}
