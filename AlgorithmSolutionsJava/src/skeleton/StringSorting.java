package skeleton;

import java.util.Arrays;

public class StringSorting {
	private int[] arrayOfIntegers = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	private int[] tempArray = new int[10];
	private char[] charArrayName;

	private void mergeSort(int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int middleIndex = ((startIndex + endIndex) / 2);
			mergeSort(startIndex, middleIndex);
			mergeSort(middleIndex + 1, endIndex);
			mergeArray(startIndex, middleIndex, endIndex);
		}
	}

	public void mergeArray(int startIndex, int middleIndex, int endIndex) {
		for (int i = startIndex; i <= endIndex; i++) {
			tempArray[i] = arrayOfIntegers[i];
		}

		int i = startIndex, j = middleIndex + 1;
		int k = startIndex;
		for (; i <= middleIndex && j <= endIndex; k++) {
			if (tempArray[i] < tempArray[j]) {
				arrayOfIntegers[k] = tempArray[i++];
			} else {
				arrayOfIntegers[k] = tempArray[j++];
			}

		}
		while (i <= middleIndex) {
			arrayOfIntegers[k] = tempArray[i];
			i++;
			k++;
		}

	}

	private String sortString(String name) {

		this.charArrayName = name.toCharArray();
		Arrays.sort(charArrayName);
		return new String(charArrayName);
	}

	public static void main(String[] args) {
		StringSorting currObj = new StringSorting();
		String name = new String();
		String sortedValue = "";
		name = "satish";
		sortedValue = currObj.sortString(name);
		System.out.println("string name after Sorting : " + sortedValue);
		currObj.mergeSort(0, currObj.arrayOfIntegers.length - 1);
		System.out.println("array Of Integers after sortig : "
				+ Arrays.toString(currObj.arrayOfIntegers));
	}
}
