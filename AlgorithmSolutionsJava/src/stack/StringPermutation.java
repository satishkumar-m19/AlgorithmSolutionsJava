package stack;

import java.util.Arrays;

public class StringPermutation {
	public static int temp;
	public static int[] originalArray = { 1, 2, 3, 4 };

	public static void stringPermutationRecurrsive(int[] originalArray,
			int lowIndex, int highIndex) {
		if (lowIndex == highIndex) {
			System.out.println("  " + Arrays.toString(originalArray));
		}
		for (int i = lowIndex; i < highIndex; i++) {
			// swap and then call again
			temp = originalArray[lowIndex];
			originalArray[lowIndex] = originalArray[i];
			originalArray[i] = temp;
			stringPermutationRecurrsive(originalArray, lowIndex + 1, highIndex);
			// swap again
			temp = originalArray[lowIndex];
			originalArray[lowIndex] = originalArray[i];
			originalArray[i] = temp;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(originalArray));
		stringPermutationRecurrsive(originalArray, 0, originalArray.length);

	}

}