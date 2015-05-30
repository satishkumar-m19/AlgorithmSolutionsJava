package stack;
import java.util.Stack;

public class SortStack {
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(3);
		stack.push(9);
		stack.push(2);
		stack.push(6);
		sort(stack);
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
	public static void sort(Stack stack){
		if(stack.isEmpty())
			return;
		Integer top = (Integer) stack.pop();
		sort(stack);
		insertSorted(top,stack);
		return;
	}
	public static void insertSorted(Integer top, Stack stack){
		if(stack.isEmpty() || (Integer) stack.peek() > top){
			stack.push(top);
			return;
		}
		Integer smaller = (Integer) stack.pop();
		insertSorted(top, stack);
		stack.push(smaller);
	}
}
