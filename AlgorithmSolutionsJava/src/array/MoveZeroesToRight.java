package array;

/*
 * Move zeros to the right with minimum swap
 * Problem
 * You are given an integer array which contains some zeros. Move the zeros to the right side 
 * of the array with minimum number of swaps. The order of the original array can be destroyed.
 * 
 * Solution
 * We can do this in at most n/2 swaps. We move one index from left to right side and another 
 * from right to left side. If we get a non zero number at right index and zero in the left 
 * index then we swap the numbers. If in the right side we get a zero we just move the pointer 
 * to the left side and if we get a non zero in the left index then we move it to the right side. 
 * We continue this process till the two pointers meet.
 * 
 * */
public class MoveZeroesToRight {
	public static void main(String[] args) {
		int[] input = { 0, 5, 0, 2, 3, 0, 3, 5, 0 };
		moveZeroToRight(input);
		for (int num : input)
			System.out.print(num + " =>");
	}

	private static void moveZeroToRight(int[] input) {
		int lowIndex = 0, highIndex = input.length - 1;
		while (lowIndex < highIndex) {
			if (input[lowIndex] == 0 && input[highIndex] != 0) {
				int temp = input[lowIndex];
				input[lowIndex] = input[highIndex];
				input[highIndex] = temp;
			}
			while (input[lowIndex] != 0)
				lowIndex++;
			while (input[highIndex] == 0)
				highIndex--;
		}
	}
}
