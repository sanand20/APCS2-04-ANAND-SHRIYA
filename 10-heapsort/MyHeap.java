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
 public static void main(String[] args) {
    int [] test = new int[] {100,1,36,17,3,25,1,2,7};
    pushDown(test,9,1);
    System.out.println(toString(test));
 }
}
