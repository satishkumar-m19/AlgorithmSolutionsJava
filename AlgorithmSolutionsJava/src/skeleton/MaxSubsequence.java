package skeleton;

import java.math.*;

public class MaxSubsequence {

	static private int seqStart = 0;
	static private int seqEnd = -1;

	public static int maxSubSum3(int[] a) {
		int maxSum = 0;
		int thisSum = 0;

		for (int i = 0, j = 0; j < a.length; j++) {
			thisSum += a[j];
			 System.out.println(thisSum);
			 System.out.println(maxSum);
			if (thisSum > maxSum) {
				 System.out.println("inside if ");
				maxSum = thisSum;
				seqStart = i;
				seqEnd = j;
			} else if (thisSum < 0) {
				 System.out.println("inside else");
				i = j + 1;
				thisSum = 0;
			}
		}

		return maxSum;
	}



	/**
	 * Simple test program.
	 */
	public static void main(String[] args) {
		int a[] = { 4, -3, 5, -2, -1, 2, 6, -2 };
		int maxSum;

		// maxSum = maxSubSum1( a );
		// System.out.println( "Max sum is " + maxSum + "; it goes"
		// + " from " + seqStart + " to " + seqEnd );
		// maxSum = maxSubSum2( a );
		// System.out.println( "Max sum is " + maxSum + "; it goes"
		// + " from " + seqStart + " to " + seqEnd );
		maxSum = maxSubSum3(a);
		System.out.println("Max sum is " + maxSum + "; it goes" + " from "
				+ seqStart + " to " + seqEnd);
//		maxSum = maxSubSum4(a);
//		System.out.println("Max sum is " + maxSum);
	}
//	public static int maxSubSum4(int[] a) {
//	int[] s = new int[a.length];
//	int curr_sum = 0;
//	int max_value = 0;
//	for (int i = 0; i < a.length; i++) {
//		s[i] = Math.max((s[i] + a[i]), a[i]);
//	}
//	for (int i = 0; i < s.length; i++) {
//		if (s[i] > max_value) {
//			max_value = s[i];
//		}
//
//	}
//	return max_value;
//}

}
