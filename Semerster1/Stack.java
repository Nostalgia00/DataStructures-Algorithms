public class Stack{
	
	private int maxSize;        // size of stack array
	private String[] stackArray;
	private int top;            // top of stack
	
	public Stack(int s){         // constructor
		maxSize = s;             // set array size
		stackArray = new String[maxSize]; // create array
		top =-1;                // no items yet
	}      
	
	public void push(String j) {    // put item on top of stack
		top++;
		stackArray[top] = j;   // increment top, insert item
	}      
	public String pop() {           // take item from top of stack
		return stackArray[top--]; //access item, decrement top
	}      
	public String peek() {          // peek at top of stack
		return stackArray[top];
	}  
	public boolean isEmpty() {   // true if stack is empty
		return (top ==-1);
	}      
	public boolean isFull() {     // true if stack is full
		return (top == maxSize-1);
	}      
	public void makeEmpty() {     // empty stack
		top=-1;
	}
}    