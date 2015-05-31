package queue;

/*
 * Queue using stack
 * 
 * Problem
 * Implement a queue using stack.
 * 
 * Solution
 * We can implement a queue using two stacks. while enqueueing we will put into stack one. 
 * while dequeuing we will pop from stack two. when stack two is empty we will pop the stack 
 * one and put all items into stack two.
 * */
import java.util.Stack;
import java.util.Random;

public class QueueUsingStack {
	public static Stack<Integer> stackPop = new Stack<Integer>();
	public static Stack<Integer> stackPush = new Stack<Integer>();

	public static void main(String[] args) {
		insertElement();
		System.out.println();
		System.out.print("dequeue " + deQueue() + " =>");
		System.out.print(deQueue() + " =>");
		System.out.println();
		insertElement();
		System.out.println();
		System.out.print("dequeue " + deQueue() + " =>");
		System.out.print(deQueue() + " =>");
	}

	private static void enQueue(int num) {
		stackPush.push(num);
	}

	private static Integer deQueue() {
		if (stackPop.isEmpty()) {
			while (!stackPush.isEmpty())
				stackPop.push(stackPush.pop());
			return stackPop.pop();
		} else
			return stackPop.pop();
	}

	private static void insertElement() {
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			int num = random.nextInt(100);
			enQueue(num);
			System.out.print(num + " => ");
		}
	}
}
