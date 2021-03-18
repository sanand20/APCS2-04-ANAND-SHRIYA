public class Merge{
  public static mergesort(int[] data, int lo, int hi){
    if (lo < hi) {
        int x = lo+ (hi-l)/2;
        sort(arr, lo, x);
        sort(arr, x+ 1, hi);
        merge(arr, lo, x, hi);
    }
  }
}
