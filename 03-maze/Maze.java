import java.util.*;
      import java.io.*;
      public class Maze{

        private char[][]maze;
        private boolean animate;//false by default



        /*Constructor loads a maze text file, and sets animate to false by default.
          When the file is not found then:
             throw a FileNotFoundException

          You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
          '#' - Walls - locations that cannot be moved onto
          ' ' - Empty Space - locations that can be moved onto
          'E' - the location of the goal (exactly 1 per file)
          'S' - the location of the start(exactly 1 per file)

          You may also assume the maze has a border of '#' around the edges.
          So you don't have to check for out of bounds!
        */
        public Maze(String filename) throws FileNotFoundException{
          int maxline = 0;
          int numoflines= 0;
          int plus = 0;
            File f = new File(filename);  //can combine
            Scanner input = new Scanner(f);  //into one line
            //NOW read the file here and process it
            while(input.hasNextLine()){
              String line = input.nextLine();
              if (line.length()>maxline){
                maxline= line.length();
              }
              numoflines++;
              }
            maze= new char [numoflines][maxline];

            input = new Scanner(f);
              while(input.hasNextLine()){
                String line = input.nextLine();
                for (int j = 0; j<maxline; j++){
                  maze[plus][j]= line.charAt(j);
              }
              plus++;
            }
          }




        private void wait(int millis){
             try {
                 Thread.sleep(millis);
             }
             catch (InterruptedException e) {
             }
         }

        public void setAnimate(boolean b){
            animate = b;
        }

        public static void clearTerminal(){
            //erase terminal
            System.out.println("\033[2J");
        }
        public static void gotoTop(){
          //go to top left of screen
          System.out.println("\033[1;1H");
        }

        /*Return the string that represents the maze.
         It should look like the text file with some characters replaced.
        */
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

        /*Wrapper Solve Function returns the helper function
          Note the helper function has the same name, but different parameters.
          Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
        */
        public int solve(){
                //only clear the terminal if you are running animation
                if(animate){
                  clearTerminal();
                }
                //start solving at the location of the s.
                //return solve(???,???);
                int x = 0;
                int y = 0;
                for (int i = 0; i<maze.length; i++){
                  for (int j = 0; j<maze[0].length; j++){
                    if(maze[i][j]=='S'){
                      x = i;
                      y = j;
                    }
                  }
                }
                return solve(x,y);
        }
        /*
          Recursive Solve function:

          A solved maze has a path marked with '@' from S to E.

          Returns the number of @ symbols from S to E when the maze is solved,
          Returns -1 when the maze has no solution.

          Postcondition:
            The 'S' is replaced with '@'
            The 'E' remain the same
            All visited spots that were not part of the solution are changed to '.'
            All visited spots that are part of the solution are changed to '@'
        */
        private int solve(int row, int col){ //you can add more parameters since this is private
            //automatic animation! You are welcome.
            if(animate){
                gotoTop();
                System.out.println(this);
                wait(50);
            }

            int counter = 0;

            boolean leftempty = row<maze.length && col-1>=0 && maze[row][col - 1] == ' ';
            boolean rightempty = row<maze.length && col+1<maze[0].length && maze[row][col + 1] == ' ';
            boolean upempty = row<maze.length && row-1>=0 && maze[row-1][col] == ' ';
            boolean downempty = row<maze.length && row+1<maze[0].length && maze[row+1][col] == ' ';

            boolean leftworks = row<maze.length && col-1>=0 && maze[row][col - 1] != '#' &&  maze[row][col - 1] != '.' &&  maze[row][col - 1] != 'S';
            boolean rightworks = row<maze.length && col+1<maze[0].length && maze[row][col + 1] != '#' && maze[row][col + 1] != '.' && maze[row][col + 1] != 'S';
            boolean upworks = row<maze.length && col-1>=0 && maze[row-1][col] != '#' && maze[row-1][col] != '.'  && maze[row-1][col] != 'S';
            boolean downworks = row<maze.length && col+1<maze[0].length && maze[row+1][col] != '#' && maze[row+1][col] != '.' && maze[row+1][col] != 'S';

            boolean anshere = maze[row+1][col] == 'E' || maze[row-1][col] == 'E'  || maze[row][col+1] == 'E'  || maze[row][col-1] == 'E' ;
            if (anshere){
              return 1;
            }

            

            else if (leftworks){

              if (maze[row][col] == '@'){
                maze[row][col] = '.';
                counter += solve(row, col-1) - 1;
              }
            }
            else if (rightworks){

              if (maze[row][col] == '@'){
                maze[row][col] = '.';
                counter += solve(row, col + 1) - 1;
              }
            }
            else if (upworks){

              if (maze[row][col] == '@'){
                maze[row][col] = '.';
                counter += solve(row-1, col) - 1;
              }
            }
            else if (downworks){

              if (maze[row][col] == '@'){
                maze[row][col] = '.';
                counter += solve(row+1,col) - 1;
              }
            }
            //COMPLETE SOLVE
            if (!anshere && !leftworks && !rightworks && !upworks && !downworks){
              return -2;
            }
            else{return counter;} //so it compiles
        }

      }
