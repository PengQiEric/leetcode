package jan2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Paul Qi
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class ValidParentheses20 {

    public static boolean isValid(String s) {
    	Deque<Character> stack = new ArrayDeque<Character>();
    	for(int i=0; i<s.length(); i++){
    		char c = s.charAt(i);
    		Character p = stack.peekFirst();
    		if(c == ')' && p!=null && p == '('){
    			stack.pop();
    		}
    		else if(c == ']' && p!=null && p == '['){
    			stack.pop();
    		}
    		else if(c== '}' && p!=null && p == '{'){
    			stack.pop();
    		}
    		else{
    			//Pushes an element onto the stack represented by this deque.  In other
    		    // words, inserts the element at the front of this deque.
    			stack.push(c);
    		}
    	}
    	return stack.isEmpty();
    }
    
    public static void main(String[] ars){
    	System.out.println(isValid("([])"));
    }
	
}
