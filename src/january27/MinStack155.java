package january27;

import java.util.Stack;

/**
 * @author PAUL QI
 *
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.
 */

public class MinStack155 {
	// The point is if some after value is larger than the before value, then we don't care, because until it
	// pop, the min value cannot be it
	private Stack<Integer> value = new Stack<Integer>();
	private Stack<Integer> min = new Stack<Integer>();
    public void push(int x) {
        value.push(x);
        if(min.size() == 0){
        	min.push(x);
        }
        else{
        	if(x<=min.peek()){
        		min.push(x);
        	}
        }
    }

    public void pop() {
        int x = value.pop();
        if(x == min.peek()){
        	min.pop();
        }
    }

    public int top() {
        return value.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

class MinStack{
	private int min = Integer.MAX_VALUE;
	Stack<Integer> stack  = new Stack<Integer>();
	// it is a chance to only use one stack???
    public void push(int x) {
        if(x<=min){
        	stack.push(min);
        	min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if(x == min){
        	min = stack.pop();
        }
        if(stack.isEmpty()){
        	min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
