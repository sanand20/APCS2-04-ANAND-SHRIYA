public class Preliminary{

  public static int partition ( int [] data, int start, int end){
        //Math.random() * (end-start+2) + start;
        int pivot = 5;
        ArrayList<int> less = new ArrayList<int>;
        ArrayList<int> more = new ArrayList<int>;

        for (int i = start; i<=end; i++){
          if (data[i]<=data[pivot]){
            less.add(data[i]);
          }
          else{
            more.add(data[i]);
          }
        }

        for (int i = start; i-start< more.length; i++){
          data[i] = more.get(i-start);
        }
        
        for (int i = start + more.length+1; i <= end; i++){
          data[i] = less.get(i-start-more.length-1);
        }

      }
}
