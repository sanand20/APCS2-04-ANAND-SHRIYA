public class Merge{
  public static void mergesort(int[]data){
    mergesort(data, 0, data.length-1);
  }
  public static void mergesort(int[] data, int lo, int hi){
    if (lo < hi) {
        int x = lo+ (hi-lo)/2;
        mergesort(data, lo, x);
        mergesort(data, x+ 1, hi);
        merge(data, lo, x, hi);
    }
  }
  public static void merge(int[] data, int lo, int mid, int hi){
    int size1 = mid - lo + 1;
    int size2 = hi - mid;
    int[] loarr = new int [size1];
    int[] hiarr = new int [size2];
    for (int i = 0; i<size1; i++){
      loarr[i] =  data[lo+i];
    }
    for (int i = 0; i<size2; i++){
      hiarr[i] = data [mid + 1 + i];
    }
    int i = 0;
    int j = 0;
    int val = lo;
    while (i<size1 && j<size2){
      if (loarr[i]<=hiarr[j]){
        data[val] = loarr[i];
        i++;
      }
      else {
        data[val] = hiarr[j];
        j++;
      }
      val++;
    }
    while (i < size1) {
        data[val] = loarr[i];
        i++;
        val++;
    }
    while (j<size2){
      data[val] = hiarr[j];
      j++;
      val++;
    }
  }
  public static String toString(int[] data){
    String result = "";
    for (int i = 0; i<data.length-1; i++){
      result += data[i] + ", ";
    }
    result += data[data.length-1];
    return result;
  }
  public static void main(String[] args){
    int[] test = {38, 27, 43, 3,9, 82, 10};
    mergesort(test, 0, test.length-1);
    System.out.println (toString(test));
  }
}
