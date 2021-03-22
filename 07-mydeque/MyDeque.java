import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 5;
    end = 5;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = initialCapacity/2;
    end = start;
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
    if(element == null){
      throw new NullPointerException("element null");
    }
    if((start == end && size != 0 && size != 1) || (size == data.length)){
      resize();
      end--;
    }
    else if(size == 0){
      start++;
    }
    if(start == 0){
      start = data.length-1;
    }
    else{
      start--;
    }
    data[start] = element;
    size++;
  }

  public void addLast(E element){
    if(element == null){
      throw new NullPointerException("element null");
    }
    if((start == end && size != 0 && size != 1) || (size == data.length)){
      resize();
      end--;
    }
    else if(size == 0){
      end--;
    }
    if(end == data.length-1){
      end = 0;
    }
    else{
      end++;
    }
    data[end] = element;
    size++;
	}

  public E removeFirst(){
    if(size == 0){
      throw new NoSuchElementException("empty deque");
    }
    E result = data[start];
    data[start] = null;
    if(start == data.length-1){
      start = 0;
    }
    else{
      start++;
    }
    size--;
    return result;
  }

  public E removeLast(){
    if(size == 0){
      throw new NoSuchElementException("empty deque");
    }
    E result = data[end];
    data[end] = null;
    if(end == 0){
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
      resize();
    }
  }

 private void resize(){
    E[] temp = (E[]) new Object[size() * 2 + 1];
    int index = start;
    for (int i=0; i<size; i++){
      temp[i] = data[(start+i) % data.length];

    }
    start=0;
    end=size;
    data=temp;
  }

}
