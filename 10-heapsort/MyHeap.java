public class MyHeap{
/*Swap the element at the provided index downward into the correct position.
  This will swap with the larger of the child nodes provided thatchild is larger.
  This stops when a leaf is reached, or neither child is larger.
 *@param size the number of heap elements in the data array.
         This is needed to allow a partially full array to be provided.
 *@precondition the children of data[index] are valid heaps.
 *@precondition index is between 0 and size-1 inclusive
 *@precondition size is between 0 and data.length-1 inclusive.
 */
 private static void pushDown(int[]data, int size, int index){
   boolean leftinbounds = 2*index + 1 < size;
   boolean rightinbounds = 2*index + 2 < size;
   int temp = data[index];
   if ((leftinbounds&&data[index]<data[2*index + 1]) || (rightinbounds && data[index]<data[2*index + 2])){
    if (leftinbounds && rightinbounds && data[index]<data[2*index + 1] && data[index]<data[2*index + 2]){
     if (data[2*index + 1]>data[2*index + 2]){
       data[index] = data[2*index + 1];
       data[2*index + 1] = temp;
       index = 2*index + 1;
     }
     else{
        data[index] = data[2*index + 2];
        data[2*index + 2] = temp;
        index = 2*index + 2;
     }
   }
   else if (leftinbounds && data[index]<data[2*index + 1]){
     data[index] = data[2*index + 1];
     data[2*index + 1] = temp;
     index = 2*index + 1;
   }
   else if(rightinbounds && data[index]<data[2*index + 2]){
     data[index] = data[2*index + 2];
     data[2*index + 2] = temp;
     index = 2*index + 2;
   }
   pushDown(data, size, index);
  }
 }
 public static String toString(int[] data){
   String result = "";
   for (int i = 0; i<data.length; i++){
     result+= data[i] + " ";
   }
   return result;
 }

  /*Reorder the provided array to be a valid heap.
  *@param data is the array to be modified
  */
 //public static void buildHeap(int[]data);//We will discuss this today:
 public static void buildHeap(int[]data){
   for (int i = data.length-1; i>=0; i--){
     pushDown(data, data.length, i);
   }
 }
 /*Swap the root node with the element at the provided index.
   *Then push the new root down, but not past the index that it swapped with.
   *@precondition: size is between 0 and data.length inclusive.
   */
  private static void remove(int[]data,int size){
    int temp = data[0];
    data[0] = data[size-1];
    data[size-1] = temp;
    pushDown(data, size-1, 0);
  }

  /*Sort the provided array
   *@param data is the array to be sorted
   */
  public static void heapsort(int[]data){
    buildHeap(data);
    int j = data.length;
    for (int i=0; i<data.length; i++){
      remove(data,j);
      j--;
    }
  }//We will discuss this next time!:

 public static void main(String[] args) {
    int [] test = new int[] {3, 4, 5, 6, 7, 8, 9, 10};
    pushDown(test,8,7);
    System.out.println(toString(test));
    pushDown(test,8,6);
    System.out.println(toString(test));
    pushDown(test,8,5);
    System.out.println(toString(test));
    pushDown(test,8,4);
    System.out.println(toString(test));
    pushDown(test,8,3);
    System.out.println(toString(test));
    pushDown(test,8,2);
    System.out.println(toString(test));
    pushDown(test,8,1);
    System.out.println(toString(test));
    pushDown(test,8,0);
    System.out.println(toString(test));
   }
}
