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



      }
