package skeleton;

import java.util.Random;

public class KthLargestElement {

	public static void main(String[] args) {
		int[] numbers = new int[10];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new Random().nextInt(100);
		}
		kthLargestElement(numbers,0,numbers.length-1,5);
		
		int[] duplicateArray = new int[]{1,1,2,2,3,4,5,6,7,8,9,10,10,9,7,6,5,4,3};
//		int[] duplicateArray = new int[]{2,5,12,13,15,2,5,12,13};
	
		System.out.println("Single Occurence Numbeer : " + findSingleOccurenceDuplicateArray(duplicateArray));
	}

	public static void kthLargestElement(int[] numbers, int start, int end, int k) {
		int kthLargestNumber;
		for (int i: numbers){
			System.out.print(i + ">");
		}
		kthLargestNumber = pivotElementIndex(numbers, start, end, k);
		System.out.println();
		System.out.println("5th Largest value is : " + kthLargestNumber);
		System.out.println();
		for (int i: numbers){
			System.out.print(i + ">");
		}
	}

	public static int pivotElementIndex(int[] numbers, int start, int end, int k) {
		int pivot = start;
		int low = start;
		int high = end;
		while (low <= high) {
			while (numbers[low] <= numbers[pivot])
				++low;
			while (numbers[high] >= numbers[pivot])
				--high;
			if (low<high){
				int temp = numbers[high];
				numbers[high] = numbers[low];
				numbers[low] = temp;
			}
			
		}
		
		int temp = numbers[high];
		numbers[high] = numbers[pivot];
		numbers[pivot] = temp;
		
		if (k == high + 1) {
			return numbers[high];
		} else if (k > high + 1) {
			return pivotElementIndex(numbers, high + 1, end, k);
		} else {
			return pivotElementIndex(numbers, start, high, k);
		}
	}
	
	public static int findSingleOccurenceDuplicateArray(int[] duplicateArray){
		int finalValue = 0;
		System.out.println("T");
		for(int i : duplicateArray){
			System.out.println(i);
			finalValue = finalValue ^ i;
		}
		return finalValue;
		/*
		 * for(int i=0;i< duplicateArray.length;i++){
			finalValue = finalValue ^ duplicateArray[i];
		}
		 * */
	}
}
