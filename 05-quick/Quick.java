import java.util.*;
public class Quick{
  public static int partition ( int [] data, int start, int end){

        int pivot = (int) (Math.random() * (end-start+1) + start);
        //int pivot = (int) ((start+end)/2);
        int p = data[pivot];
        ArrayList<Integer> less = new ArrayList<Integer>();
        ArrayList<Integer> more = new ArrayList<Integer>();

        for (int i = start; i<=end; i++){
          if (i!=pivot){
          if (data[i]<p){
            less.add(data[i]);
          }
          else if (data[i]>p){
            more.add(data[i]);
          }
          else {
            if ((int)(Math.random()*2) == 1){
              less.add(data[i]);
            }
            else{
              more.add(data[i]);
            }
          }
        }
        }

        for (int i = start; i-start< less.size(); i++){
          data[i] = less.get(i-start);
        }
        data[start+less.size()] = p;
        for (int i = start + less.size()+1; i <= end; i++){
          data[i] = more.get(i-start-less.size()-1);
        }
        return less.size()+start;
      }

  public static String toString(int [] data){
        String result = "";
        for (int i = 0; i<data.length; i++){
          result += (data[i]);
          result += " ";
        }
        return result;
      }

  public static int quickselect(int []data, int k){
    int start = 0;
    int end = data.length-1;
    int run = partition(data, start, end);

    while (run!=k){
      if (run < k){
        start = run+1;
        run = partition (data, start, end);
      }
      if (run > k){
        end = run-1;
        run = partition (data, start, end);
      }
    }

    return data[k];
   }

   public static void quicksort(int[] data){
      for (int i=0; i<data.length; i++){
        quickselect(data, data.length-1);
      }
      //quicksort (data, 0, data.length-1);
   }
   /*public static void quicksort(int[] data, int start, int end){
      if (end - start > 1){
        int x = partition (data, start, end);
        quicksort(data, 0, x);
        quicksort(data, x, end);
      }

   }*/


   public static void main (String[] args){
     int [] test = {12345, 56341, 3461, 1, 3, 2, 12, 4, 23,4 ,324,235,425345,4352,413,3235,2345,234,26547,658,457,65846,8,45653,4534,523,6457,6574,4,54,6,7};
     //int [] test = {0,1,2,3,4,5,6,7,8,9,12,23,234,2345,2346,12345,12346,12347,12348,12349,13334,13784,734890, 234, 123,3243,235,436,457,3423,42354,635,76473432,423,3123,123,12,343,24};
     //int [] test = {10,3,8,2};
     quicksort(test);
     System.out.println(toString(test));
   }
}
