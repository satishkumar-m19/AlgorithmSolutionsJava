package hash;
/*
 * Longest subarray with equal number of ones and zeros
 * Problem
 * You are given an array of 1's and 0's only. Find the longest subarray 
 * which contains equal number of 1's and 0's.
 * 
 * Solution
 * We will keep a running sum of "no of ones minus no of zeros" for each index of the array. 
 * For any two indices, if the running sum is equal, that means there are equal number of ones 
 * and zeros between these two indices. We will store the running sum in an array such that it 
 * acts like a hash map where key is the running sum and value is the leftmost index of that 
 * running sum to appear. The running sum can vary from -n to +n. So we need an array of length 
 * 2*n+1. So for any index we can check whether this sum has occurred before and if yes what is 
 * the left most index for it. We can do this in O(1) time by maintaining the array. So at any 
 * index we can find the longest equal subarray till that point. We will compare it with a maximum 
 * value and update the maximum accordingly. So the overall complexity for the process is O(n)
 * 
 * */

import java.util.HashMap;
public class MaxSubarrayEqualOnesZeros {
	public static void main(String[] args){
		int[] input = {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0,1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0};
		printMaxSubarray(input);
		printMaxSubarrayUsingHashmap(input);
	}

	private static void printMaxSubarrayUsingHashmap(int[] input) {
		int[] diffMap = new int[input.length * 2 +1];
		diffMap[input.length] = -1;
		int sum = 0;
		int maxLength = 0;
		int maxStart = -1;
		int maxEnd = -1;
		for (int i = 0; i < input.length; i++){
			if (input[i]==0)
				sum-=1;
			else
				sum+=1;
			int prevIndex = diffMap[input.length + sum];
			if (prevIndex == 0)
				diffMap[input.length + sum]=i;
			else{
				if(i - prevIndex>maxLength){
					maxLength = i - prevIndex;
					maxStart = prevIndex + 1;
					maxEnd = i;	
				}
			}
		}
		System.out.println("indices (" + maxStart + "," + maxEnd + ")");
		System.out.println("length=" + maxLength);
	}

	private static void printMaxSubarray(int[] input) {
		HashMap<Integer, MaxMinIndex> diffMap = new HashMap<Integer,MaxMinIndex>();
		int sum = 0;
		for(int i = 0; i < input.length; i++){
			int num = input[i];
			if (num == 0)
				sum -= 1;
			else
				sum +=1;
			if(diffMap.containsKey(sum)){
				MaxMinIndex temp = diffMap.get(sum);
				temp.maxIndex = i;
				diffMap.put(sum, temp);
			}
			else{
				MaxMinIndex temp = new MaxMinIndex();
				temp.minIndex = i;
				temp.maxIndex = i;
				diffMap.put(sum, temp);
			}
		}
		int lowIndex = 0,highIndex = 0, maximum = 0;
		for(MaxMinIndex h : diffMap.values()){
			int localMax = h.maxIndex - h.minIndex;
			if(localMax>maximum){
				maximum = localMax;
				lowIndex = h.minIndex + 1;
				highIndex = h.maxIndex;
			}
		}
		System.out.println("indices (" + lowIndex + "," + highIndex + ")");
		System.out.println("length=" + maximum);;
		
	}

}
class MaxMinIndex{
	int maxIndex = 0;
	int minIndex = 999;
}
