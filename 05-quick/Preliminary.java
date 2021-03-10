import java.util.*;
public class Preliminary{

  public static int partition ( int [] data, int start, int end){
        //Math.random() * (end-start+2) + start;
        int pivot = 4;
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
  public static void main (String[] args){
    int [] test = {999,999,999,0,1,2,3,4,999,999,999};
    System.out.println(partition(test, 3, 7));
    System.out.println(toString(test));
  }
}
