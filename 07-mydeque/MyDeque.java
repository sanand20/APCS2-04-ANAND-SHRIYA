import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    data = (E[])new Object[10];
    start = 0;
    end = 0;
    size = 0;
  }
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    start = 0;
    end = 0;
    size = 0;
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
    data[start] = element;
    start = (start+1)%data.length;
    size++;
  }
  public void addLast(E element){
    canAdd();
    data[end] = element;
    end = (end-1)%data.length;
    size++;

  }
  public E removeFirst(){
    canRemove();
    E result = data[start];
    start = (start-1)%data.length;
    size--;
    return result;
  }
  public E removeLast(){
    E result = data[end];
    end = (end+1)%data.length;
    size--;
    return result;
  }
  public E getFirst(){
    E result = data[start];
    return result;
  }
  public E getLast(){
    E result = data[end];
    return result;
  }
  private void canAdd(){
    if (data.length == size){
      throw new IllegalStateException("no space left");
    }
  }
  private void canRemove() {
        if (size == 0) {
            throw new NoSuchElementException("deque is empty");
        }
    }

}
