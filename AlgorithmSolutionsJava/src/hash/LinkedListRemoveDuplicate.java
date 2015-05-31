package hash;

/*
 * Problem
 * You have an infinite linked list which is not sorted and contains duplicate elements. 
 * You have to convert it to a linked list which does not contain duplicate elements.
 * Solution
 * While traversing through the input linked list we will maintain a hashset. 
 * If a number from input linked list is present in the hashset we will ignore it. 
 * otherwise we will insert it into hashset and inset into output linked list. 
 * The below program creates a similar representation of java LinkedHashSet. 
 * We can use that as well. Assuming a good hash distribution the space complexity is O(n) 
 * and time complexity is O(n).
 * */
import java.util.HashSet;

public class LinkedListRemoveDuplicate {
	public static void main(String[] args) {
		Node input = new Node(3);
		input.next = new Node(5);
		input.next.next = new Node(4);
		input.next.next.next = new Node(2);
		input.next.next.next.next = new Node(3);
		input.next.next.next.next.next = new Node(2);
		input.next.next.next.next.next.next = new Node(6);
		input.next.next.next.next.next.next.next = new Node(3);
		input.next.next.next.next.next.next.next.next = new Node(4);
		Node tempHead = input;
		System.out.println("Original Linked List");
		while (tempHead != null) {
			System.out.print(tempHead.value + "=>");
			tempHead = tempHead.next;
		}
		Node output = removeDuplicate(input);
		System.out.println();
		System.out.println("Linked List after removing the duplicates");
		while (output.next != null) {
			System.out.print(output.value + "=>");
			output = output.next;
		}
	}

	public static Node removeDuplicate(Node tempHead) {
		Node output = new Node();
		Node tempOutput = output;
		HashSet hashSet = new HashSet();
		while (tempHead != null) {
			if (!hashSet.contains(tempHead.value)) {
				hashSet.add(tempHead.value);
				tempOutput.value = tempHead.value;
				tempOutput.next = new Node();
				tempOutput = tempOutput.next;
			}
			tempHead = tempHead.next;
		}
		return output;
	}
}

class Node {
	int value;
	Node next;

	public Node(int value) {
		this.value = value;
	}

	public Node() {
	}
}