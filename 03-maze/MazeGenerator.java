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
    public static boolean backtrack(int row, int col){
      if (thismaze[row][col]==' '){
        return true;
      }
      return false;
    }
    public static void generate(char[][] maze, int rows, int cols, int startrow, int startcol){
      double srow = Math.random()*(maze.length-2) + 1;
      double scol = Math.random()*(maze[0].length-2) +1;
      generator(maze, rows, cols,(int)srow, (int)scol);
      maze[(int)startrow][(int)startcol]= 'S';
      maze[erow][ecol]='E';
      thismaze = maze;
      for (int i = 0; i<maze.length; i++){
        for (int j = 0; j<maze[0].length; j++){
            if (maze[i][j]=='.'){
              maze[i][j]=' ';
            }
          }
        }

    }
    public static void generator(char[][] maze, int rows, int cols, int startrow, int startcol){
      thismaze = maze;
      double place = Math.random()*5 -1;
      if ((int)place == 0){
        if (works(startrow,startcol-1)){
          maze[startrow][startcol-1] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow, startcol-1);
        }
        else if (works(startrow,startcol+1)){
          maze[startrow][startcol+1] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow, startcol+1);
        }
        else if (works(startrow-1,startcol)){
          maze[startrow-1][startcol] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow-1, startcol);
        }
        else if (works(startrow+1,startcol)){
          maze[startrow+1][startcol] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow+1, startcol);
        }
      }
      if ((int)place == 1){
        if (works(startrow,startcol+1)){
          maze[startrow][startcol+1] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow, startcol+1);
        }
        else if (works(startrow-1,startcol)){
          maze[startrow-1][startcol] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow-1, startcol);
        }
        else if (works(startrow+1,startcol)){
          maze[startrow+1][startcol] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow+1, startcol);
        }
        else if (works(startrow,startcol-1)){
          maze[startrow][startcol-1] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow, startcol-1);
        }
      }
      if ((int)place == 2){
        if (works(startrow-1,startcol)){
          maze[startrow-1][startcol] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow-1, startcol);
        }
        else if (works(startrow+1,startcol)){
          maze[startrow+1][startcol] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow+1, startcol);
        }
        else if (works(startrow,startcol-1)){
          maze[startrow][startcol-1] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow, startcol-1);
        }
        else if (works(startrow,startcol+1)){
          maze[startrow][startcol+1] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow, startcol+1);
        }
      }

      if ((int)place == 3){
        if (works(startrow+1,startcol)){
          maze[startrow+1][startcol] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow+1, startcol);
        }
        else if (works(startrow,startcol-1)){
          maze[startrow][startcol-1] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow, startcol-1);
        }
        else if (works(startrow,startcol+1)){
          maze[startrow][startcol+1] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow, startcol+1);
        }
        else if (works(startrow-1,startcol)){
          maze[startrow-1][startcol] = ' ';
          thismaze=maze;
          generator(maze, rows, cols, startrow-1, startcol);
        }
      }
      else if (!ehere){
        erow = startrow;
        ecol = startcol;
        ehere = true;
      }

        else if (backtrack(startrow,startcol-1)){
          maze[startrow][startcol]= '.';
          thismaze = maze;
          generator(maze, rows, cols, startrow,startcol-1);
        }
        else if (backtrack(startrow,startcol+1)){
          maze[startrow][startcol]= '.';
          thismaze = maze;
          generator(maze, rows, cols, startrow,startcol+1);
        }
        else if (backtrack(startrow-1,startcol)){
          maze[startrow][startcol]= '.';
          thismaze = maze;
          generator(maze, rows, cols, startrow-1,startcol);
        }
        else if (backtrack(startrow+1,startcol)){
          maze[startrow][startcol]= '.';
          thismaze = maze;
          generator(maze, rows, cols, startrow+1,startcol);
        }

    }

}
