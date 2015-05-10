package skeleton;

import java.util.Random;

public class SingleLinkedList {
	static LNode head = null;

	// method to add a element
	public void addElementAtStart(int element) {
		LNode temp = new LNode(element);
		temp.setNextLNode(head);
		head = temp;
	}

	// method to delete a element
	public boolean deleteElement(int element) {
		LNode curr = new LNode();
		LNode prev = new LNode();
		curr = head;
		prev = curr;
		if (curr.getLNodeElement() == element) {
			head = head.getNextLNode();
			curr = null;
			return true;
		}
		while (curr != null) {
			if (curr.getLNodeElement() == element) {
				// do the delete operation
				prev.setNextLNode(curr.getNextLNode());
				curr = null;
				return true;
			} else {
				prev = curr;
				curr = curr.getNextLNode();
			}
		}
		return false;
	}

	// method to reverse the linked list
	public void reverseLinkedList() {
		LNode temp = new LNode();
		LNode next = new LNode();
		temp = null;
		next = null;
		while (head!=null){
			next = head.getNextLNode();
			head.setNextLNode(temp);
			temp = head;
			head = next;
		}
		head = temp;
	}
	
	public LNode reverseLinkedListRecurrsion(LNode temp){
		if (temp == null || temp.getNextLNode() == null){
			return temp;
		}
		LNode remainingReverse=  reverseLinkedListRecurrsion(temp.getNextLNode());
		temp.getNextLNode().setNextLNode(temp) ;
		temp.setNextLNode(null);
		return remainingReverse;
	}

	// method to search an element
	public void searchAnElement(int element) {
		int counter = 1;
		LNode temp = new LNode();
		temp = head;
		while (temp != null) {
			if (temp.getLNodeElement() == element) {
				System.out.println("Element found at position : " + counter);
				break;
			}
			else{
				temp = temp.getNextLNode();
				counter++;
			}
		}

	}

	// method to display the linked list
	public void displayLinkedList() {
		LNode curr = new LNode();
		curr = head;
		while (curr != null) {
			System.out.print(curr.getLNodeElement()+"->");
			curr = curr.getNextLNode();
		}
	}
/*
 * reverse pair
 * while curr!= null and curr.next !=null
 * temp =  curr.next;
 * temp2 = temp.next;
 * temp.next = curr;
 * curr.next = temp2
 * if curr
 * 	curr = curr.next;
 * */
	public static void main(String[] args) {
		Random random = new Random();
		LNode secondReversal = null;
		int randomNumber;
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.addElementAtStart(5);
		linkedList.addElementAtStart(10);
		for (int i = 0; i < 5; i++) {
			randomNumber = random.nextInt(100);
			System.out.println("random number generated : " + randomNumber);
			linkedList.addElementAtStart(randomNumber);
		}
		linkedList.addElementAtStart(25);
		linkedList.addElementAtStart(75);
		linkedList.addElementAtStart(100);
		linkedList.displayLinkedList();
		int[] deleteElementValue = {25,100};
		System.out.println();
		for (int i = 0; i <deleteElementValue.length; i++){
			if (linkedList.deleteElement(deleteElementValue[i])) {
				System.out.println("Succesfully Deleted : " + deleteElementValue[i]);
			}
		}
		linkedList.displayLinkedList();
		linkedList.searchAnElement(10);
		linkedList.reverseLinkedList();
		System.out.println("displaying after the reversal");
		linkedList.displayLinkedList();
		secondReversal = linkedList.reverseLinkedListRecurrsion(head);
		System.out.println("2nd reversal recurrsion");
		while (secondReversal!=null){
			System.out.print(secondReversal.getLNodeElement() + "->");
			secondReversal = secondReversal.getNextLNode();
		}
	}
}
