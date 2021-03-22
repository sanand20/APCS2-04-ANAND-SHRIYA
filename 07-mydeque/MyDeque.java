public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){  }
  public MyDeque(int initialCapacity){
    data = new int [initialCapacity];
  }
  public int size(){
    return size;
  }
  public String toString(){
    String result = "{";
    for (int i = 0; i<data.length-1; i++){
      result += data[i] + ", ";
    }
    result += data[data.length-1]+ "}";
    return result;
  }
  public void addFirst(E element){
    canAdd();
        if (start == 0) {
            start = data.length -
            data[start] = element;
        } else {
            start--;
            data[(start-1)%data.length] = element;
        }

        size++;
  }
  public void addLast(E element){
    canAdd();
    size++;
    data[(start + size)%data.length] = element;

  }
  public E removeFirst(){
    canRemove();

        int result = data[start];
        start = (start + 1) % data.length;
        size--;
        return result;
  }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
  private void canAdd(E element){
    if (data.length == size){
      throw new IllegalStateException("no space left");
    }
  }
}
