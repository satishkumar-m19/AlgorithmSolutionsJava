package array;
/*
 * Least difference in array
 * 
 * Problem
 * Find the least difference between any two elements of an integer array.
 * 
 * Solution
 * First we can sort the elements of the array. Then we can iterate over the array and 
 * find difference between consecutive elements. The least of them would be the least 
 * differences between any two elements of the array. The complexity will be O(nlogn) 
 * because of the sorting step.
 * 
 * */

import java.util.Arrays;
import java.util.Random;

public class LeastDifferenceInArray {
	public static void main(String[] args){
		int[] input = {};
		Arrays.sort(input);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < input.length-1;i++){
			int diff = Math.abs(input[i]-input[i+1]);
			if(diff<minDiff)
				minDiff = diff;
		}
		System.out.println("Minimum Difference : " + minDiff);
	}
}
