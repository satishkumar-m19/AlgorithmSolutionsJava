package skeleton;

import java.util.Stack;
import java.util.Queue;
import java.util.*;
import java.util.LinkedList;
import java.math.*;

public class BinarySearchTree{
	public static BinaryTreeNode bst;
	public static BinaryTreeNode bstTwo;
	public static int[] treePath = new int[25];
	public static int pathLength = 0;
	
	public static void main(String[] args){
		/*
		 * 				1
		 * 		2				3
		 * 4		5		6		7
		 * */
		BinaryTreeNode bst = new BinaryTreeNode(5);
		bst.left = new BinaryTreeNode(2);
		bst.right = new BinaryTreeNode(7);
		bst.left.left = new BinaryTreeNode(1);
		bst.left.right = new BinaryTreeNode(4);
		bst.right.left = new BinaryTreeNode(6);
		bst.right.right = new BinaryTreeNode(10);
		BinaryTreeNode bstTwo = new BinaryTreeNode(5);
		bstTwo.left = new BinaryTreeNode(2);
		bstTwo.right = new BinaryTreeNode(7);
		System.out.print("pre Order : ");
		bst.preOrder();
		System.out.println("");
		System.out.print("post Order : ");
		bst.postOrder();
		System.out.println("");
		System.out.print("In Order : ");
		bst.inOrder();
		System.out.println("");
		System.out.print("In Order Iterative: ");
		bst.inOrderIterative();
		System.out.println("");
		System.out.print("BFS Traversal : ");
		bst.BFS();
		System.out.println("");
		System.out.print("DFS Traversal : ");
		bst.DFS();
		System.out.println("");
		System.out.println("Insertion : ");
		bst.insertNodeBST(bst,8);
		bst.insertNodeBST(bst,11);
		System.out.print("In Order : ");
		bst.inOrder();
		System.out.println("");
		bst.minimumValueIterBST(bst);
		bst.minimumValueRecurBST(bst);
		System.out.println("Maximum Depth of the tree : " + bst.maxDepthBST(bst));
		System.out.println("This is a Binary Search Tree : " + bst.isBst(bst));
		System.out.println("This is a Binary Search Tree recurrsive simplified method : " + bst.verifyBst(bstTwo,Integer.MIN_VALUE,Integer.MAX_VALUE));
		System.out.println("Different Paths of the Tree : ");
		bst.printPathRecurBST(bst,treePath,pathLength);
		System.out.println("Check wether both the tree are equal : " + bst.checkSameBST(bst, bst));
		System.out.println("Check wether both the tree are equal : " + bst.checkSameBST(bst, bstTwo));
		System.out.println("Height of the Binary Tree : " + bst.heightBinaryTree(bst));
		System.out.println("Diameter of the Binary Tree : " + bst.diameterOfBinaryTree(bst));
//		bst.deleteNodeBST(bst,8);
		System.out.print("In Order : ");
		bst.inOrder();
		System.out.println("");
		int minDiff = bst.minDiff(bst,20);
		System.out.println("minimum difference value : " + (minDiff + 20));
	}
}

class BinaryTreeNode{
	int element;
	BinaryTreeNode left;
	BinaryTreeNode right;
	Stack<BinaryTreeNode> tempStack = new Stack<BinaryTreeNode>();
	Queue<BinaryTreeNode> tempQueue = new LinkedList<BinaryTreeNode>();
	public BinaryTreeNode(){}
	public BinaryTreeNode(int temp){
		this.element = temp;
//		this.left = null;
//		this.right = null;
	}
	public void preOrder(){
		if (this!=null) {
			System.out.print(this.element + ">");
			if (left != null) {left.preOrder();}
			if (right != null ) {right.preOrder();}
		}	
	}
	public void postOrder(){
		if (this!=null){
			if (this.left != null) this.left.postOrder();
			if (this.right != null) this.right.postOrder();
			System.out.print(this.element + ">");
		}
	}
	public void inOrder(){
		if (this!=null){
			if (this.left != null) this.left.inOrder();
			System.out.print(this.element + ">");
			if (this.right != null) this.right.inOrder();
			
		}
	}
	public void inOrderIterative(){
		BinaryTreeNode temp = this;
		while(true){
			while(temp!=null){
				tempStack.push(temp);
				temp = temp.left;
				
			}
			if (tempStack.isEmpty()){
				break;
			}
			temp = tempStack.pop();
			System.out.print(temp.element + ">");
			temp= temp.right;
		}
		
	}
	public void BFS(){
		BinaryTreeNode temp = this;
		if (temp!=null){
			tempQueue.add(temp);
		}
		while (!tempQueue.isEmpty()){
			temp = tempQueue.remove();
			System.out.print(temp.element + ">");
			if (temp.left != null) tempQueue.add(temp.left);
			if (temp.right != null) tempQueue.add(temp.right);
			
		}
	}
	public void DFS(){
		BinaryTreeNode temp = this;
		if (temp!=null){
			tempStack.push(temp);
		}
		while(!tempStack.isEmpty()){
			temp = tempStack.pop();
			System.out.print(temp.element + ">");
			if (temp.right != null) tempStack.push(temp.right);
			if (temp.left != null) tempStack.push(temp.left);
		}
	}
	public boolean insertNodeBST(BinaryTreeNode bst, int key){
		
		if (bst == null){
			BinaryTreeNode temp = new BinaryTreeNode(5);
			bst = temp;
			System.out.println("Node inserted at the root, since the root was null");
			return true;
		}
		if(bst.element > key ){
			System.out.println(bst.element + "  insdie if ");
			if (bst.left == null){
				bst.left = new BinaryTreeNode(key);
				return true;
			}else
			insertNodeBST(bst.left,key);
		}
		else {
			System.out.println(bst.element + "  insdie else ");
			if (bst.right == null){
				bst.right = new BinaryTreeNode(key);
				return true;
			}else
			insertNodeBST(bst.right,key);
		}
		return false;
		
	}
	public static BinaryTreeNode minimumValueIterBST(BinaryTreeNode bst){
		BinaryTreeNode temp = bst;
		if(temp!=null){
			while(temp.left !=null){
				temp = temp.left;
			}
			System.out.println("Minimum Element in the tree :"+temp.element);
			return temp;
		}
		return temp;
		
	}
	public void minimumValueRecurBST(BinaryTreeNode bst){
		BinaryTreeNode temp = bst;
		if(temp!=null){
			if(temp.left !=null){
				minimumValueRecurBST(temp.left);
			}
			else
			System.out.println("Minimum Element in the tree :"+temp.element);
		}
		
	}
	public int maxDepthBST(BinaryTreeNode bst){
		BinaryTreeNode temp = bst;
		if (temp==null){
			return 0;
		}
		else{
			return 1+(Math.max(maxDepthBST(temp.left),maxDepthBST(temp.right))) ;
		}
	}
	public boolean isBst(BinaryTreeNode bst){
		BinaryTreeNode temp = bst;
		//total four case, 1. left and right children, 2. left exist right no, 3.right exist but no left child, 4. no children
		if (temp != null){
			if(temp.left!=null && temp.right!=null){
				if (!(temp.element > temp.left.element && temp.element < temp.right.element)){
					System.out.println("the tree has problem with the node : " + temp.element);
					return false;
				}else return(isBst(temp.left) && isBst(temp.right));
			}
			else if (temp.left!=null && temp.right == null){
				if (!(temp.element > temp.left.element)){
					System.out.println("the tree has problem with the node : " + temp.element);
					return false;
				}else return(isBst(temp.left));
			}else if(temp.right!=null && temp.left == null){
				if (!(temp.element < temp.right.element)){
					System.out.println("the tree has problem with the node : " + temp.element);
					return false;
				}else return(isBst(temp.right));
			}else return true;
		}
		return true;
	}
	public boolean verifyBst(BinaryTreeNode bst, int minValue, int maxValue){
		if (bst == null){
			return true;
		}
		if(bst.element > minValue && bst.element < maxValue){
			boolean leftBst = verifyBst(bst.left,minValue,bst.element);
			boolean rightBst = verifyBst(bst.right,bst.element,maxValue);
			return leftBst && rightBst;
			/*
			 * in the above code if the left Bst fails still the right part will be checked which is not necessary, this can be optimized further
			 * return verifyBst(bst.left,minValue,bst.element) && verifyBst(bst.right,bst.element,maxValue);
			 * */
		}
		return false;
	}
	public void printPathRecurBST(BinaryTreeNode bst,int[] treePath, int pathLength){
		BinaryTreeNode temp = bst;
		if (temp == null){
			return;
		}
		treePath[pathLength++] = temp.element;
		if(temp.left == null && temp.right == null){
			printPathBST(treePath,pathLength);
		}else{
			printPathRecurBST(temp.left,treePath,pathLength);
			printPathRecurBST(temp.right,treePath,pathLength);
		}
	}
	public static void printPathBST(int[] treePath, int pathLength){
		for (int i = 0; i<pathLength;i++){
			System.out.print(" >"+treePath[i]);
		}
		System.out.println("");
	}
	public boolean checkSameBST(BinaryTreeNode bst1,BinaryTreeNode bst2){
		if (bst1 == null && bst2 == null){
			return true;
		}
		else if (bst1 != null && bst2 !=null){
			return ( (bst1.element == bst2.element) && checkSameBST(bst1.left, bst2.left)&& checkSameBST(bst1.right,bst2.right));
		}
		else
		return false;
	}
	public static void constructBSTUsingInorderPreOrder(){
		//to be implemented
	}
	public static int heightBinaryTree(BinaryTreeNode bst1){
		//does the diameter always passes through root : Nope, not necessarily
		//farthest distance between any two leaf nodes, it is somewhat related to the height of root, left sub tree, right sub tree and so on.
		if (bst1 == null){
			return 0;
		}
		else
		return (1+ Math.max(heightBinaryTree(bst1.left), heightBinaryTree(bst1.right)));		
	}
	public static int diameterOfBinaryTree(BinaryTreeNode bst2){
		if (bst2 == null){
			return 0;
		}else{
			int leftHeight = heightBinaryTree(bst2.left);
			int rightHeight = heightBinaryTree(bst2.right);
			int leftDiameter = diameterOfBinaryTree(bst2.left);
			int rightDiameter = diameterOfBinaryTree(bst2.right);
			return(Math.max((leftHeight + rightHeight+1),Math.max(leftDiameter, rightDiameter)));
		}
	}		
	/*some problem with the instance and initialization, Delete is not happening*/
	public static void deleteNodeBST(BinaryTreeNode bst,int key){
//		BinaryTreeNode temp = bst;
		if (bst==null){ return;}
		if (bst.element<key) deleteNodeBST(bst.right,key);
		else if(bst.element>key) deleteNodeBST(bst.left,key);
		else if(bst.element == key){//key is equal to temp element, handle three cases
			if(bst.left == null && bst.right == null){
				System.out.println("1Succesfully deleted the node : "+ bst.element);
				bst = null;return;
			}else if(bst.left == null){
				System.out.println("2Succesfully deleted the node : "+ bst.element);
				bst = bst.right;return;
			}else if (bst.right == null){
				System.out.println("3Succesfully deleted the node : "+ bst.element);
				bst = bst.left;return;
			}else{
				BinaryTreeNode successorNode = minimumValueIterBST(bst);
				System.out.println("4Succesfully deleted the node : "+ bst.element);
				bst.element = successorNode.element;
				deleteNodeBST(bst.right,successorNode.element);
				return;
			}
		}
		else System.out.println("No node found with value : " + key);
		bst.inOrder();
	}
	public static int smallDiff(int a,int b){
		if (Math.abs(a)>Math.abs(b)){
			return b;
		}
		return a;
	}
	//key method to define the minimum difference number
	public static int minDiff(BinaryTreeNode bst, int v){
		if (bst == null) return Integer.MAX_VALUE;
		if(bst.element < v) return smallDiff(bst.element-v,minDiff(bst.right,v));
		else return smallDiff(bst.element-v,minDiff(bst.left,v));
	}
}

//Here is an O(n) solution with minimal changes to the accepted answer:
//public static int[] getDiameter(BinaryTreeNode root) {
//    int[] result = new int[]{0,0};    //1st element: diameter, 2nd: height    
//    if (root == null)  return result;
//    int[] leftResult = getDiameter(root.getLeft());
//    int[] rightResult = getDiameter(root.getRight());
//    int height = Math.max(leftResult[1], rightResult[1]) + 1;
//    int rootDiameter = leftResult[1] + rightResult[1] + 1;
//    int leftDiameter = leftResult[0];
//    int rightDiameter = rightResult[0];
//    result[0] = Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
//    result[1] = height;
//
//    return result;
//}