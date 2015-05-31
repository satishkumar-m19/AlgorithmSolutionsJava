package array;
/*
 * Next larger palindrome
 * Problem
 * Given an integer find the immediate larger integer that that which is a palindrome, 
 * example 1234212 -> 1234321, 345676 -> 346643.
 * Solution
 * Let the integers' digit be abcdef. As number of digits are even we will divide it in two parts, 
 * abc and def. Now we reverse first part and it becomes cba. if cba is greater than def then 
 * abccba is the answer. If it is smaller we increment the first part and it becomes 
 * (abc+1)=suppose xyz, so the answer would be xyzzyx.
 * Now let's check what happens when number of digits are odd. Let the integer be abcdefg. 
 * We divide it into 3 parts. abc, d, efg. if cba is greater than efg then the answer is abcdcba. 
 * If it is smaller then abcd is incremented by 1. Suppose (abcd+1)=wxyz. Then the answer is wxyzyxw.
 * */

public class NextLargerPalindrom {

}
