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
    if (size >0){
      if (start<end){
        for (int i = start; i<end; i++){
        result += data[i] + ", ";
        }
        result += data[end];
      }
      else {
        for (int i = start; i<data.length; i++){
        result += data[i] + ", ";
        }
        for (int i = 0; i<end; i++){
        result += data[i] + ", ";
        }
        result+= data[end];
      }
    }
    result += "}";
    return result;
  }
  public void addFirst(E element){
    canAdd();
    if (element == null){
      throw new NullPointerException("element is null");
    }
    if (start == 0){
      start = data.length - 1;
      data[start] = element;
    }
    else{
      start--;
      data[start] = element;
    }

  }
  public void addLast(E element){
    if (element == null){
      throw new NullPointerException("element is null");
    }
    canAdd();
    if (end == data.length-1){
      end = 0;

    }
    else{
      end++;
      data[end] = element;
    }
    size++;

  }
  public E removeFirst(){
    canRemove();
    E result = data[start];
    if (start == data.length - 1){
      start = 0;
    }
    else{
      start++;
    }
    size--;
    return result;
  }
  public E removeLast(){
    E result = data[end];
    if (end == 0){
      end = data.length-1;
    }
    else{
      end--;
    }
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
