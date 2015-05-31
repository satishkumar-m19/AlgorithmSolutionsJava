package heap;

/*
 * Merge N sorted arrays
 * 
 * Problem
 * Given n sorted arrays. Merge them into a single sorted array.
 * 
 * Solution
 * While merging two sorted sequences we always look at the front element and pick the lowest of them.
 * Then the next element from the picked array takes place of the previous element and the process 
 * continues till one of them is empty. In case of N arrays if we do the same process, the time 
 * complexity of checking the front elements is O(n). If there are N arrays all having elements 
 * of the order of N. Then there are O(N^2) elements and for every element we will have to 
 * find the minimum in O(n) time. So the overall complexity will be O(N^3). We can decrease the 
 * complexity to O(N^2 log N) by adding the arrays to a heap. Each node of the heap will be an array 
 * whose priority will be decided by the front element. So if we pick the root of the heap we will 
 * find the smallest of the front elements of all the arrays. After adding it to the resultant array we 
 * will remove it and again insert the array into the heap, This process will take O(log N). So the overall 
 * complexity will become O(N^2 log N)
 * */
import java.util.PriorityQueue;

public class MergeNSortedArrays {
	static PriorityQueue minHeap = new PriorityQueue();

	public static void main(String args[]) {
		int[][] input = new int[4][];
		input[0] = new int[] { 1, 2, 5, 74, 344 };
		input[1] = new int[] { 1, 8, 12, 33, 90, 95 };
		input[2] = new int[] { 9, 12, 17, 20, 91 };
		input[3] = new int[] { 1, 3 };
		int[] output = nWayMerge(input);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + ",");
		}
	}

	private static int[] nWayMerge(int[][] input) {
		int[] output;
		int n = 0, k = 0;
		for (int i = 0; i < input.length; i++) {
			n = n + input[i].length;
		}
		output = new int[n];
		for (int i = 0; i < input.length; i++) {
			valueArrayPair temp = new valueArrayPair(input[i][0], i, 1);
			minHeap.add(temp);
		}
		while (minHeap.peek() != null) {
			valueArrayPair temp = (valueArrayPair) minHeap.poll();
			output[k++] = temp.value;
			if (temp.index < input[temp.arrayNumber].length) {
				valueArrayPair temp1 = new valueArrayPair(
						input[temp.arrayNumber][temp.index], temp.arrayNumber,
						++temp.index);
				minHeap.add(temp1);
			}
		}
		return output;
	}
}

class valueArrayPair implements Comparable<valueArrayPair> {
	public int value;
	public int arrayNumber;
	public int index;

	valueArrayPair(int value, int arrayNumber, int index) {
		this.value = value;
		this.arrayNumber = arrayNumber;
		this.index = index;
	}

	public int compareTo(valueArrayPair o) {
		// this is for MinHeap
		if (this.value < o.value)
			return -1;
		return 1;
	}
}
