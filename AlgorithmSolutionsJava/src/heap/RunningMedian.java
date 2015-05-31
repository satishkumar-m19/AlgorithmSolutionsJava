package heap;

/*
 * Running Median
 * 
 * Problem
 * 
 * Find the running median after entering every number from a sequence of infinite integers.
 * 
 * Brute force
 * 
 * If we keep each number in a sorted sequence then cost of single entry is O(n) and finding median is O(n). 
 * A slight modification can be done by keeping the middle pointer and adjusting it based on the insertion 
 * on its left side and right side. In that case finding median after insertion is O(1). But the overall 
 * cost for finding median still remains O(n) as insertion in sorted sequence is necessary after each number 
 * is entered.
 * 
 * Better solution
 * 
 * We can keep two heaps which divides the entered number in two almost equal halves. 
 * Half of the number would be greater than the median and the rest would be lesser. 
 * The upper half will be maintained in a min heap and the lower half will be maintained in a max heap. 
 * In this arrangement we can find out in O(1) time whether a new number would go to the upper half or lower half. 
 * All we need to do is to compare the new number with the head of two heaps. After deciding we can insert in a 
 * heap in O(log n) time. After this insertion if the heaps are unbalanced, we can just move from one heap to another. 
 * which is again of O(log n) complexity. And now we can find the median in O(1) time. If two heaps contain same 
 * number of elements then median is the average of the head of two heaps. If one is greater, then median is the 
 * head of the larger heap.
 * 
 * Further discussion
 * Whenever the answer of some problem requires knowing greater among something or lesser among something but it 
 * does not matter whether the rest of the elements are ordered or not, heap might give the optimal solution.
 * 
 * */

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class RunningMedian {
	// contains the upper part of the numbers
	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	// contains the lower part of the numbers
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10,
			Collections.reverseOrder());
	static {
		minHeap.add(Integer.MAX_VALUE);
		maxHeap.add(Integer.MIN_VALUE);
	}

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("num \t median");
		for (int i = 0; i < 10; i++) {
			int num = random.nextInt(100);
			System.out.print(num + " \t ");
			System.out.println(getCurrentMedian(num));
		}
	}

	private static double getCurrentMedian(int num) {
		// insert into the heap
		if (num > minHeap.peek())
			minHeap.add(num);
		else
			maxHeap.add(num);

		// check for the heap size to alter
		if (minHeap.size() - maxHeap.size() == 2)
			maxHeap.add(minHeap.poll());
		else if (maxHeap.size() - minHeap.size() == 2)
			minHeap.add(maxHeap.poll());

		// retrieve based on the heap size
		if (minHeap.size() == maxHeap.size())
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		else if (minHeap.size() > maxHeap.size())
			return minHeap.peek();
		else
			return maxHeap.peek();
	}
}
