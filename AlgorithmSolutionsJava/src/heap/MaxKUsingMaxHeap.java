package heap;

/*
 * Maximum k integers using max heap
 * 
 * Problem
 * Find k maximum integers from an array of infinite integers.
 * 
 * Brute force
 * We can sort the integers and return the top k elements. The complexity is O(n log n) because of sorting. 
 * As n is very large we would have to store all the elements in memory for sorting them.
 * 
 * Better solution
 * We can implement a max heap to hold exactly k elements. Every time a new number is added we can check with the 
 * top of the element which is the maximum of the current k elements. If new number is greater than the max heap top 
 * then that number is discarded otherwise it is added in the heap after removing the current top. In this way we 
 * always keep only k items in memory and the complexity is O(n log k) (assumption is that k is significantly lesser than n)
 * */

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class MaxKUsingMaxHeap {
	public static void main(String[] args) {
		int arraySize = 10;
		int[] input = new int[arraySize];
		Random random = new Random();
		for (int i = 0; i < arraySize; i++) {
			input[i] = random.nextInt(100);
			System.out.print(input[i] + "=>");
		}
		int k = 5;
		int[] result = getTopKElements(input, k);
		System.out.println();
		for (int i : result)
			System.out.print(i + "=>");
	}

	private static int[] getTopKElements(int[] input, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,
				Collections.reverseOrder());
		int[] output = new int[k];
		for (int i = 0; i < input.length; i++) {
			int currentNum = input[i];
			if (maxHeap.size() < k)
				maxHeap.add(currentNum);
			else {
				if (currentNum < (int) maxHeap.peek()) {
					maxHeap.poll();
					maxHeap.add(currentNum);
				}
			}
		}
		int index = 0;
		while (!maxHeap.isEmpty())
			output[index++] = (int) maxHeap.poll();
		return output;
	}
}
