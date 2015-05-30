package stack;
import java.util.LinkedList;

/*
 * Given an array form another array where each element of previous 
 * array is replaced with its next minimum number in the array
 * */

public class ArrayNextElement {
	public static int[] inputArray = {3,4,5,2,7,5,7,3,8,2,5,7,9,1,3};
	public static int[] outputArray1 = new int[inputArray.length];
	public static int[] outputArray2 = new int[inputArray.length];
	public static LinkedList<Integer> stackVar = new LinkedList<Integer>();

	public static void main(String[] args) {
		
		//call for the brute force method.
		bruteForceApproach(inputArray,outputArray1);
		for (int i = 0; i < outputArray1.length; i++){
			System.out.print(outputArray1[i]+ " => ");
		}
		//call for the method using the stack operation O(n)
		System.out.println();
		usingStackApproach(inputArray,outputArray2);
		for (int i = 0; i < outputArray2.length; i++){
			System.out.print(outputArray2[i]+ " => ");
		}


	}
	public static void bruteForceApproach(int[] inputArray, int[] ouputArray1){
		for(int i = 0; i <inputArray.length;i++){
			for(int j = i;j<inputArray.length;j++){
				if(inputArray[j]<inputArray[i]){
					outputArray1[i] = inputArray[j];
					break;
				}
				
			}
		}
	}
	public static void usingStackApproach(int[] inputArray, int[] ouputArray2){
		for(int i = inputArray.length-1; i>=0;--i){
			int currentNumber = inputArray[i];
			if(stackVar.peek() == null){
				outputArray2[i] = 0;
				stackVar.push(currentNumber);
				continue;
			}
			while(stackVar.size()!=0 && stackVar.peek() >= currentNumber ){
				stackVar.pop();
			}
			outputArray2[i] = stackVar.peek() == null ? 0 : stackVar.peek();
			stackVar.push(currentNumber);
		}	
	}
}
