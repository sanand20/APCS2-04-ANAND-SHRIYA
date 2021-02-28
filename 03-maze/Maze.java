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

      }
