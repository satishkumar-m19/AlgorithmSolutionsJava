package hash;
/*
 * Problem
 * You are given an integer array. Find all the Pythagorean triplets in this array. 
 * Pythagorean triplets are 3 numbers a, b, c such that a^2+b^2=c^2.
 * Solution
 * First we store all the squares of the numbers in a hash set. Then in O(n^2) we 
 * try with all the combinations (a,b) and search a^2+b^2 in the hash set. If it 
 * exists then we have found a pythagorean triplet. The complexity is O(n^2) as 
 * compared to brute force of O(n^3).
 * */
import java.util.HashSet;

public class PythagoreanTriplet {
	public static void main(String[] args){
		int[] input = {2, 3, 4, 6, 7, 12, 13, 15, 5, 17, 14, 22};
		findPythagoreanTriplets(input);
	}
	public static void findPythagoreanTriplets(int[] input){
		HashSet squaresSet = new HashSet();
		for(int num: input)
			squaresSet.add((long)(num * num));
		for (int i = 0; i <input.length;i++){
			for(int j = i+1; j<input.length;j++){
				long squareNumber = (input[i]*input[i])+(input[j]*input[j]);
				if(squaresSet.contains(squareNumber)){
					System.out.println(input[i] +","+ input[j]+","+(int)Math.sqrt(squareNumber));
				}
			}
		}
	}
}
