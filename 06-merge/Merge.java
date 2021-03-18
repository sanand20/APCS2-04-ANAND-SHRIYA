public class Merge{
  public static void mergesort(int[] data, int lo, int hi){
    if (lo < hi) {
        int x = lo+ (hi-l)/2;
        sort(arr, lo, x);
        sort(arr, x+ 1, hi);
        merge(arr, lo, x, hi);
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
      hiarr[j] = data [mid + 1 + j];
    }
    int i = 0;
    int j = 0;
    int val = lo;
    while (i<size && j<size2){
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

    while (j<size2){
      data[val] = hiarr[j];
      j++;
      val++;
    }
  }
}
