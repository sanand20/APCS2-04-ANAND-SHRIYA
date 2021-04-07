import java.util.NoSuchElementException;
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
    if(size == 0){
      return "{}";
    }

    if(size == 1){
      return "{" + data[start] + "}";
    }

    String result = "{";

    if(end > start){
      for(int i = start; i <= end; i++){
        result += data[i];
        if(i != end){
          result += ", ";
        }
      }
    }
    else{
      for(int i = start; i < data.length; i++){
        result = result + data[i] + ", ";
      }
      for(int j = 0; j <= end; j++){
        result += data[j];
        if(j != end){
          result += ", ";
        }
      }
    }
    return result + "}";
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
    if(start == data.length-1 && start!=end){
      start = 0;
    }
    else{
      if (start!=end){
        start++;
      }
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
    if(end == 0 && start!=end){
      end = data.length-1;
    }
    else{
      if (start != end){
        end--;
      }
    }
    size--;
    return result;
  }

  public E getFirst() throws NoSuchElementException{
    if(size == 0){
      throw new NoSuchElementException("empty deque");
    }
    return data[start];
  }
  public E getLast() throws NoSuchElementException{
    if(size == 0){
      throw new NoSuchElementException("empty deque");
    }
    return data[end];
  }

  private void resize(){
    int tempsize = 10;

    if(data.length != 0){
      tempsize = 1 + size * 2;
    }

    @SuppressWarnings("unchecked")
    E[] temparray = (E[])new Object[tempsize];
    int x = data.length-start;

    for(int i = 0; i < x; i++){
      temparray[temparray.length/2 + i] = data[start + i];
    }

    for(int j = 0; j < start; j++){
      temparray[temparray.length/2 + x + j] = data[j];
    }

    start = temparray.length/2;
    data = temparray;
    end = start + size;
  }


}
