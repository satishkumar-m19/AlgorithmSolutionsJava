package skeleton;

import java.util.PriorityQueue;

class MergeNArray {
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
		// TODO Auto-generated method stub
		int[] output;
		int n = 0, k = 0;
		for (int i = 0; i < input.length; i++) {
			n = n + input[i].length;
		}
		output = new int[n];
		for (int i = 0; i < input.length; i++) {
			// System.out.println(input[i][0]);
			valueArrayPair temp = new valueArrayPair(input[i][0], i, 1);
			minHeap.add(temp);
		}
		while (minHeap.peek() != null) {
			valueArrayPair temp = (valueArrayPair) minHeap.poll();
			output[k++] = temp.value;
			// System.out.println("putti ge kopa nan mele :( : "temp.value+"   "+
			// temp.arrayNumber+"   "+ temp.index);
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