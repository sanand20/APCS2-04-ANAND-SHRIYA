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
      result += data[i] + ", "
    }
    result += data[data.length-1]+ "}";
    return result;
  }
  public void addFirst(E element){
    canAdd();
        if (head == 0) {
            head = data.length -
            data[head] = element;
        } else {
            head == (head-1)%data.length;
            data[head] = element;
        }

        size++;
  }
  public void addLast(E element){
    canAdd();
    head = (head + size + 1) % data.length;
    data[head] = element;
    size++
  }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
  private void canAdd(E element){
    if (data.length == size){
      throw new IllegalStateException("no space left");
    }
  }
}
