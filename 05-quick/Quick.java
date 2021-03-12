import java.util.*;
public class Quick{
  public static int partition ( int [] data, int start, int end){

        int pivot = (int) (Math.random() * (end-start+1) + start);
        int p = data[pivot];
        ArrayList<Integer> less = new ArrayList<Integer>();
        ArrayList<Integer> more = new ArrayList<Integer>();

        for (int i = start; i<=end; i++){
          if (i!=pivot){
          if (data[i]<=p){
            less.add(data[i]);
          }
          else{
            more.add(data[i]);
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


   public static void main (String[] args){
     int [] test = {999,999,999,4,3,2,1,0,999,999,999};
     System.out.println(quickselect(test, 5));
   }
}
