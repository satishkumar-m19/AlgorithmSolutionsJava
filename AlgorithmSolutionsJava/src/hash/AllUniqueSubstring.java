package hash;

/*
 * Problem
 * Given a string find out the longest substring which has all unique letters,
 *  i.e. no letter is repeated.
 *  Solution
 *  We start by putting two pointers named startIndex and endIndex at the beginning
 *   of the string. As we move forward the end index new found letters are added in 
 *   a set. If the letter is already found in the set, we start moving the start pointer
 *   and keep on removing the corresponding letters. When we found that the letter which 
 *   caused the repetition is removed from the set, then we know that all the letters are 
 *   unique in this substring. Every time we find such substrings we compare its length 
 *   with a kept maximum. In this way we find the longest substring which does not have 
 *   any repetition.
 * */
import java.util.HashSet;

public class AllUniqueSubstring {
	public static void main(String[] args) {
		String input = "abacbdadbc";
		printAllUniqueSubstring(input);
	}

	public static void printAllUniqueSubstring(String input) {
		HashSet<Character> set = new HashSet<Character>();
		int startIndex = 0;
		int endIndex = 0;
		int maxLength = 0;
		int startMax = 0;
		int endMax = 0;
		while (endIndex < input.length()) {
			char addChar = input.charAt(endIndex);
			if (!set.contains(addChar)) {
				set.add(addChar);
				int currentLength = endIndex - startIndex + 1;
				if (currentLength > maxLength) {
					maxLength = currentLength;
					startMax = startIndex;
					endMax = endIndex;
				}
				endIndex++;
			} else {
				char removeChar = input.charAt(startIndex);
				set.remove(removeChar);
				startIndex++;
				if (removeChar == addChar) {
					int currentLength = endIndex - startIndex + 1;
					if (currentLength > maxLength) {
						maxLength = currentLength;
						startMax = startIndex;
						endMax = endIndex;
					}
					endIndex++;
				}
			}
		}
		System.out.println(startMax + "," + endMax);
		System.out.println(input.substring(startMax, endMax));
	}
}
