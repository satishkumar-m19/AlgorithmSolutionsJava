package stack;

import java.util.Stack;
import java.util.Random;

public class StackMinimumOrderOne {
	public static Stack<Integer> stackVar = new Stack<Integer>();
	public static Stack<Integer> minStackVar = new Stack<Integer>();

	public static void main(String[] args) {
		Random random = new Random();
		// test condition
		push(random.nextInt(100));
		push(random.nextInt(100));
		push(random.nextInt(100));
		push(random.nextInt(100));
		push(random.nextInt(100));
		System.out.println(getMinimum());
		push(random.nextInt(100));
		push(random.nextInt(100));
		push(random.nextInt(100));
		push(random.nextInt(100));
		push(random.nextInt(100));
		push(random.nextInt(100));
		pop();
		pop();
		pop();
		pop();
		pop();
		pop();
		pop();
		System.out.println(getMinimum());
	}

	public static Integer push(Integer item) {
		System.out.print(item + "==> ");
		if (stackVar.empty()) {
			stackVar.push(item);
			minStackVar.push(item);
			return item;
		}
		Integer currentMin = minStackVar.peek();
		if (currentMin < item)
			minStackVar.push(currentMin);
		else
			minStackVar.push(item);
		stackVar.push(item);
		return item;
	}

	public static Integer pop() {
		if (stackVar.size() == 0)
			return null;
		minStackVar.pop();
		return stackVar.pop();
	}

	public static Integer getMinimum() {
		if (stackVar.size() == 0)
			return null;
		return minStackVar.peek();
	}

	public static int size() {
		return stackVar.size();
	}
}
