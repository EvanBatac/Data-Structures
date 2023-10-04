import java.util.Stack;
public class StacksPractice{
   public static void main(String[] args){
      
      // Stack LIFO data stucture. Last-in first-out
      // stores data into vertical order
      // push() to add to the top
      // pop() to remove from the top
      // peek(): Returns the element at the top of the stack without removing it. 
      // empty(): Checks if the stack is empty. Returns true if it's empty, false otherwise
      //search(Object o): Searches for the specified element in the stack and returns its position (1-based) from the top. If the element is not found, it returns -1.
      Stack<String> names = new Stack<String>();
      
      names.push("Evan");
      names.push("Gab");
      names.push("Nave");
      names.push("Eveau");
      
      //names.pop();
      //System.out.println(names.peek());
      System.out.print(names.contains("hayt"));
   }
}