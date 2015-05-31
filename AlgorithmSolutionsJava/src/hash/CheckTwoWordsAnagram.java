package hash;

/*
 * Find if two words are anagram or not
 * Problem
 * Given two words, find whether they are anagram or not. An anagram of a word is 
 * another word which can be obtained by rearranging the letters of the first word. 
 * Without any addition or deletion of letters.
 * 
 * Solution
 * We will use the property of anagrams that the count of different letters in anagrams are equal. 
 * So we will take one word and keep its letter's count in a hash map. Now for second word we will 
 * keep on decreasing the count form the map. When the count is zero, we will remove the key from 
 * the map. In this way if two words are anagram then nothing should be left in the map at the end 
 * of this operation. So we return true if the map has no keys left. If during removal we find that 
 * that some letter is not found for removal then also it is not an anagram. 
 * */
import java.util.HashMap;

public class CheckTwoWordsAnagram {
	public static void main(String[] args) {
		String a = "listen";
		String b = "enlist";
		checkIfAnagram(a, b);
	}

	public static void checkIfAnagram(String a, String b) {
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (char ch : a.toCharArray()) {
			if (charMap.containsKey(ch))
				charMap.put(ch, (charMap.get(ch) + 1));
			else
				charMap.put(ch, 1);
		}
		for (int i = 0; i < b.length(); i++) {
			char ch = b.charAt(i);
			if (charMap.containsKey(ch)) {
				if (charMap.get(ch) == 1)
					charMap.remove(ch);
				else
					charMap.put(ch, (charMap.get(ch) - 1));
			} else {
				System.out.println("The given string is not a Anagram");
				return;
			}
		}
		if (charMap.isEmpty()) {
			System.out.println("The given string is a Anagram");
		}
	}
}
