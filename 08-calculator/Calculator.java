import java.util.*;
public class Calculator{
           /*Evaluate a postfix expression stored in s.
            *Assume valid postfix notation, of ints doubles and operators separated by spaces.
            *Valid operators are + - / * and % (remainder not modulo)
            *All results are doubles even if the operands are both int.
            *@throws IllegalArgumentException when there are too many or too few operands.
            *        Use the string parameter of your exception to indicate what happened.
            */
           public static double eval(String s){
              Deque<Double> str = new ArrayDeque<Double> ();
              Scanner x = new Scanner(s);
              try{
                while (x.hasNext()) {
                  if (!x.hasNextDouble()){
                    if (str.size()<2){
                      throw new IllegalArgumentException("too many or too less operands");
                    }
                    Double secNum = str.removeFirst();
                    Double firNum = str.removeFirst();
                    String op = x.next();

                    if (op.equals("+")) {
                       str.addFirst(firNum + secNum);
                    }
                    else if (op.equals("-")) {
                       str.addFirst(firNum - secNum);
                     }
                    else if (op.equals("*")) {
                      str.addFirst(firNum * secNum);
                    }
                    else {
                      str.addFirst(firNum / secNum);
                    }
                  }
                  if (x.hasNextDouble()) {
         				        str.addFirst(x.nextDouble());
             			}

         		  }
                return str.removeFirst();
            }
            catch(NoSuchElementException e){
              throw new IllegalArgumentException("too many or too less operands");
            }
           }


           public static void main(String[] args) {
      System.out.println(eval("9 9 +")); //18.0
      System.out.println(eval("10 2.0 +")); //12.0
      System.out.println(eval("11 3 - 4 + 2.5 *")); //30.0
      System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); //893.0
      System.out.println(eval("1 2 3 4 5 + * - -")); //26.0
      System.out.println(eval("9 8 -")); //1.0

    }
       }
