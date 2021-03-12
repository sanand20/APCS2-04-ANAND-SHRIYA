import java.util.*;
public class Quick{
  public static int partition ( int [] data, int start, int end){

        int pivot = (int) Math.random() * (end-start+1) + start;
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

        for (int i = start; i-start< more.size(); i++){
          data[i] = more.get(i-start);
        }
        data[start+more.size()] = p;
        for (int i = start + more.size()+1; i <= end; i++){
          data[i] = less.get(i-start-more.size()-1);
        }
        return more.size()+start;
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
    partition(data, 0, data.length);
    return 1;
   }

   public static void main (String[] args){
     int [] test = {999,999,999,4,3,2,1,0,999,999,999};
     System.out.println(quickselect(test, 3)); 
   }
}
