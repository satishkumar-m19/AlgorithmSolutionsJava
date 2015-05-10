package skeleton;

public class ReverseString {
	public static void main(String[] args) {
		String givenString = new String("hello world satish ankur");
		char[] givenStringCharArray = givenString.toCharArray();
		System.out.println("Given Array : " + new String(givenStringCharArray));
		givenStringCharArray = reverseString(givenStringCharArray, 0,
				givenStringCharArray.length - 1);
		System.out.println("Given Array : " + new String(givenStringCharArray));

		int startIndex = 0;
		for (int j = 0; j < givenStringCharArray.length; j++) {

			if (givenStringCharArray[j] == ' ') {
				givenStringCharArray = reverseString(givenStringCharArray,
						startIndex, j - 1);
				startIndex = j + 1;
			}
		}
		reverseString(givenStringCharArray, startIndex,
				givenStringCharArray.length - 1);
		System.out.println("Reversed Array : "
				+ new String(givenStringCharArray));

		System.out.println("remove duplicate chars from strings : "
				+ removeDuplicates(givenString));
		System.out
				.println("remove duplicate chars and maintain order from strings : "
						+ removeDuplicatesMaintainOrder(givenString));
		splitString();
	}

	// method to reverse the string
	public static char[] reverseString(char[] temp, int start, int end) {
		int mid = (start + end) / 2;
		for (int i = start; i <= mid; i++) {
			char tempSwapChar = temp[i];
			temp[i] = temp[end + start - i];
			temp[end + start - i] = tempSwapChar;
		}
		return temp;
	}

	public static String removeDuplicates(String str) {
		int charsCount[] = new int[256];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			charsCount[ch]++;
		}
		StringBuilder sb = new StringBuilder(charsCount.length);
		for (int i = 0; i < charsCount.length; i++) {
			if (charsCount[i] > 0) {
				sb.append((char) i);
			}
		}
		return sb.toString();
	}

	/* Maintains the order of the string as well */
	public static String removeDuplicatesMaintainOrder(String str) {
		boolean seen[] = new boolean[256];
		StringBuilder sb = new StringBuilder(seen.length);
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// System.out.println((int)ch);
			if (!seen[ch]) {
				seen[ch] = true;
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	public static void splitString(){
		String stringToSplit = "hi #there how are you #how are you doing #whatsup with you";
		String[] arrayOfString = stringToSplit.split("[#]");
		for (String str : arrayOfString){
			System.out.println(str);	
		}
		
	}
}
