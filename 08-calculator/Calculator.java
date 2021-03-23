public class Calculator{
           /*Evaluate a postfix expression stored in s.
            *Assume valid postfix notation, of ints doubles and operators separated by spaces.
            *Valid operators are + - / * and % (remainder not modulo)
            *All results are doubles even if the operands are both int.
            *@throws IllegalArgumentException when there are too many or too few operands.
            *        Use the string parameter of your exception to indicate what happened.
            */
           public static double eval(String s){
              Stack<Double> str = new Stack<Double> ();
              Scanner x = new Scanner(s);
              while (x.hasNext()) {
         			    if (x.hasNextDouble()) {
         				        str.push(x.nextDouble());
             			}
                  else {
         				       Double secNum = str.pop();
         				       Double firNum = str.pop();
         				       String op = x.next();

         				       if (op.equals("+")) {
         					        str.push(firNum + secNum);
              			   }
                       else if (op.equals("-")) {
         					        str.push(firNum - secNum);
                				}
                       else if (op.equals("*")) {
                         str.push(firNum * secNum);
                       }
                       else {
                         str.push(firNum / secNum);
                       }
         			   }
         		  }
           }
       }
