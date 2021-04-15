import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private static int TREE = 2;
  private static int FIRE = 1;
  private static int ASH = 3;
  private static int SPACE = 0;
  private Queue<int[]>Frontier;


  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ )
      for(int c=0; c<map[r].length; c++ )
        if(Math.random() < density)
           map[r][c]=2;


    start();//set the left column on fire.
  }

  /*Determine if the simulation is still burning
   *@return true if any fires are still burning, false otherwise
   */
   public boolean done(){
     //YOU MUST IMPLEMENT THIS
     if (Frontier.size()==0){
       return true;
     }
     return false;
   }


   /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
    *All existing fires spread new fires, and turn to ash
    *new fires should remain fire, and not spread.
    */
   public void tick(){
     ticks++;
     //YOU MUST IMPLEMENT THIS
     if (!done()){
       int iterations = Frontier.size();
       for (int i = 0; i < iterations; i++){
       int[] firehere = Frontier.peek();
       int r = firehere[0];
       int c = firehere[1];

           if (r+1<map.length&& map[r+1][c]==2){
             int [] newfire = new int[]{r+1,c};
             map[r+1][c]=1;
             Frontier.add(newfire);
           }
           if (r-1>=0 && map[r-1][c]==2){
             int [] newfire = new int[]{r-1,c};
             map[r-1][c]=1;
             Frontier.add(newfire);
           }
           if (c+1<map[r].length&& map[r][c+1]==2){
             int [] newfire = new int[]{r,c+1};
             map[r][c+1]=1;
             Frontier.add(newfire);
           }
           if (c-1>=0 && map[r][c-1]==2){
             int [] newfire = new int[]{r,c-1};
             map[r][c-1]=1;
             Frontier.add(newfire);
           }
           map[r][c]=3;
           Frontier.remove();
     }

   }
   }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    Frontier = new ArrayDeque<int[]>();
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        int[] firehere = new int []{i,0};
        Frontier.add(firehere);
      }
    }

  }





  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }
  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }


  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


  public static void main(String[]args)  throws InterruptedException{
    int WIDTH = 10000;
    int HEIGHT = 10000;
    int DELAY = 200;
    double DENSITY = 1;
    if(args.length > 1){
      WIDTH = Integer.parseInt(args[0]);
      HEIGHT = Integer.parseInt(args[1]);
      DENSITY = Double.parseDouble(args[2]);
    }
    if(args.length > 3){
      DELAY = Integer.parseInt(args[3]);
    }
    BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);
  long start = System.currentTimeMillis();
  double totalTime = 0;
  double totalSteps = 0;
  totalSteps += b.run();
  totalTime += System.currentTimeMillis()-start;

    	System.out.println("Executed in " + (totalTime)/1000.0 + " seconds in " + totalSteps + " ticks.");
  //System.out.println(b.animate(DELAY));//animate all screens and print the final answer
  //System.out.println(b.outputAll());//print all screens and the final answer
  }


}
