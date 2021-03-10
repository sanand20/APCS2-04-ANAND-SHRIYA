public class Preliminary{

  public static int partition ( int [] data, int start, int end){
        //Math.random() * (end-start+2) + start;
        int pivot = 5;
        int [] less = new int [end-start+1];
        int [] more = new int [end-start+1];
        int counter1 = 0;
        int counter2 = 0;
        for (int i = start; i<=end; i++){
          if (data[i]<=data[pivot]){
            less[counter1] = data [i];
            counter1++;
          }
          else{
            more [counter2] = data [i];
            counter2++;
          }
        }

      }
}
