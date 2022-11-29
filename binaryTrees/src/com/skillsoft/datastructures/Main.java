package com.skillsoft.datastructures;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Main {
	//------------------------------------------------------------------------------
	public static void main(String[] args) {
//			a
//	       /  \
//	      b    c
//	      	  /  \
//	      	 d    e
//	      	/ \    \
//	       f  h     g
	       
		Node<Character> a = new Node<>('A');
		Node<Character> b = new Node<>('B');
		Node<Character> c = new Node<>('C');
		Node<Character> d = new Node<>('D');
		Node<Character> e = new Node<>('E');
		Node<Character> f = new Node<>('F');
		Node<Character> g = new Node<>('G');
		Node<Character> h = new Node<>('H');
				
		a.setLeftChild(b);
		a.setRightChild(c);
		c.setLeftChild(d);
		c.setRightChild(e);
		d.setLeftChild(f);
		d.setRightChild(h);
		e.setRightChild(g);
		
//		System.out.println("\n");
//		breadthFirst(a);
//		System.out.println("\n");
//		breadthFirstSimple(a);
//		System.out.println("\n");
//		dfsInOrder(a);
//		System.out.println("\n");
//		dfsInOrderRecursion(a);
//		System.out.println("\n");
//		dfsPreOrder(a);
//		System.out.println("\n");
//		dfsPreOrderRecursion(a);
//		System.out.println("\n");
//		dfsPostOrder(a);
//		System.out.println("\n");
//		dfsPostOrderRecursion(a);
		
//		System.out.println("Tree has " +countNodes(a)+ "nodes");
//		System.out.println("Trees depth is "+maxDepth(a));
		
//			1
//	       /  \
//	      2    3
//	      	  /  \
//	      	 7    6
//	      	/    / \
//	       8    5   4
		
		Node<Integer> one = new Node<>(1);
		Node<Integer> two = new Node<>(2);
		Node<Integer> three = new Node<>(3);
		Node<Integer> four = new Node<>(4);
		Node<Integer> five = new Node<>(5);
		Node<Integer> six = new Node<>(6);
		Node<Integer> seven = new Node<>(7);
		Node<Integer> eight = new Node<>(8);
		
		one.setLeftChild(two);
		one.setRightChild(three);
		three.setLeftChild(seven);
		three.setRightChild(six);
		seven.setLeftChild(eight);
		six.setLeftChild(five);
		six.setRightChild(four);
		
		System.out.println();
//		System.out.println("hasPathSum 3: "+hasPathSum(one,19));
//		System.out.println("Original");
//		breadthFirst(one);
//		mirror(one);
//		System.out.println("\nMirror");
//		breadthFirst(one);
//		System.out.println("Is tree full: "+isFull(one));
//		System.out.println("Is tree full: "+isFull(six));
//		System.out.println("Is Perfect Tree: "+isPerfect(three));
//		System.out.println("Is Perfect Tree: "+isPerfect(six));
//		System.out.println("Is Complete Tree: "+isComplete(one, 0, countNodes(one)));
//		System.out.println("Is Complete Tree: "+isComplete(six, 0, countNodes(six)));
//		System.out.println("Is Balanced: "+isBalanced(a, new HashMap<Node<Character>, Integer>()));
//		System.out.println("Is Balanced: "+isBalanced(c, new HashMap<Node<Character>, Integer>()));
		
		insert(eight,3);
		insert(eight,10);
		insert(eight, 1);
		insert(eight, 14);
		insert(eight,6);
		insert(eight,4);
		insert(eight,7);
		insert(eight,13);
//		System.out.println();
//		breadthFirst(eight);
//		
//		System.out.println("\n\nIn-Order");
//		dfsInOrder(eight);
//		System.out.println("\n\n");
//		System.out.println(lookup(eight,4));
//		System.out.println("\n\n");
//		System.out.println(lookup(eight,15));
//		System.out.println("\n");
//		System.out.println("\nMinimum Value: "+minimumValue(eight));
//		System.out.println("\n");
//		System.out.println("\nMax Value: "+maxValue(eight));
		
//		printRange(eight, 7, 14);

}
	//------------------------------------------------------------------------------
	public static boolean isBinarySearchTree(Node<Integer> root) {
		if(root == null) {
			return true;
		}
		if(root.getLeftChild() != null) {
			if(root.getLeftChild().getData() > root.getData()) {
				return false;
			}
		}
		if(root.getRightChild() != null) {
			if(root.getRightChild().getData() <= root.getData()) {
				return false;
			}
		}
		return isBinarySearchTree(root.getLeftChild()) && 
			   isBinarySearchTree(root.getRightChild());
	}
	//------------------------------------------------------------------------------
	public static void printRange(Node<Integer> root, int low, int high) {
		if(root == null) {
			return;
		}
		if(low <= root.getData()) {
			printRange(root.getLeftChild(), low, high);
		}
		if(low <= root.getData() && root.getData() <= high) {
			System.out.println(root.getData());
		}
		if(high > root.getData()) {
			printRange(root.getRightChild(), low, high);
		}
		
	}
	//------------------------------------------------------------------------------
	public static Integer maxValue(Node<Integer> root) {
		int maxValue =Integer.MIN_VALUE;
		
		while(root != null) {
			maxValue = root.getData();
			System.out.println("Currently at node: "+maxValue+" going into the right subtree");
			root = root.getRightChild();
		}
		return maxValue;
	}
	//------------------------------------------------------------------------------
	public static Integer minimumValue(Node<Integer> root) {
		int minValue =Integer.MAX_VALUE;
		
		while(root != null) {
			minValue = root.getData();
			System.out.println("Currently at node: "+minValue+" going into the left subtree");
			root = root.getLeftChild();
		}
		return minValue;
	}
	//------------------------------------------------------------------------------
	public static Node<Integer> lookup(Node<Integer> root, int data){
		if(root == null) {
			return null;
		}
		if(root.getData() == data) {
			return root;
		}
		if(data <= root.getData()) {
			System.out.println(data + " <= " + root.getData() + " looking in the left subtree");
			return lookup(root.getLeftChild(), data);
		} else {
			System.out.println(data + " > " + root.getData() + " looking in the right subtree");
			return lookup(root.getRightChild(), data);
		}
	}
	//------------------------------------------------------------------------------
	public static Node<Integer> insert(Node<Integer> root, int data){
		if(root == null) {
			return new Node<Integer>(data);
		}
		if(data <= root.getData()) {
			root.setLeftChild(insert(root.getLeftChild(), data));
		}
		else {
			root.setRightChild(insert(root.getRightChild(), data));
		}
		return root;
	}
	//------------------------------------------------------------------------------
	public static <T> boolean isBalanced(Node<T> root, HashMap<Node<T>, Integer> nodeHeightMap) {
		if(root == null) {
			return true;
		}
		
		boolean isLeftBalanced = isBalanced(root.getLeftChild(), nodeHeightMap);
		boolean isRightBalanced = isBalanced(root.getRightChild(), nodeHeightMap);
		
		int leftHeight = nodeHeightMap.getOrDefault(root.getLeftChild(), 0);
		int rightHeight = nodeHeightMap.getOrDefault(root.getRightChild(), 0);
		
		nodeHeightMap.put(root,  Math.max(leftHeight,  rightHeight)+1);
		
		if(Math.abs(leftHeight - rightHeight) <= 1) {
			return isLeftBalanced && isRightBalanced;
		}
		
		return false;
	}
	//------------------------------------------------------------------------------
	public static <T> boolean isComplete(Node<T> root, int currNodeIndex, int totalNodes) {
		if(root == null) {
			return true;
		}
		
		if(currNodeIndex >= totalNodes) {//leaf
			return false;
		}
		
		int leftChildIndex = 2 * currNodeIndex +1;
		int rightChildIndex = 2 * currNodeIndex +2;
		
		return isComplete(root.getLeftChild(), leftChildIndex, totalNodes) &&
				isComplete(root.getRightChild(), rightChildIndex, totalNodes); 
	}
	//------------------------------------------------------------------------------
	//Different version below
//	public static <T> int countNodes(Node<T> root) {
//		if(root == null) {
//			return 0;
//		}
//		
//		return 1 + countNodes(root.getLeftChild()) + countNodes(root.getRightChild());
//	}
	//------------------------------------------------------------------------------
	public static <T> boolean isPerfect(Node<T> root){
		int leftDepth = leftDepth(root);
		return isPerfectRecursive(root, leftDepth, 0);
	}
	//------------------------------------------------------------------------------
	public static <T> boolean isPerfectRecursive(Node<T> root, int leftDepth, int currentLevel) {
		if(root == null) {
			return true;
		}
		
		if(root.getLeftChild() == null && root.getRightChild() == null) {//leaf
			return currentLevel == leftDepth;
		}
		
		if(root.getLeftChild() == null || root.getRightChild() == null) {//leaf
			return false;
		}
		
		return isPerfectRecursive(root.getLeftChild(), leftDepth, currentLevel+1) &&
			   isPerfectRecursive(root.getRightChild(), leftDepth, currentLevel+1); 
	}
	//------------------------------------------------------------------------------
	public static <T> int leftDepth(Node <T> root) {
		int leftDepth = 0;
		Node<T> node = root;
		
		while(node != null) {
			leftDepth++;
			node = node.getLeftChild();
		}
		
		return leftDepth - 1;
	}
	//------------------------------------------------------------------------------
	public static <T> boolean isFull(Node<T> root) {
		if(root == null) {
			return true;
		}
		
		if(root.getLeftChild() == null && root.getRightChild() == null) {//leaf
			return true;
		}
		
		if(root.getLeftChild() != null && root.getRightChild() != null) {//leaf
			return isFull(root.getLeftChild()) && isFull(root.getRightChild());
		}
		
		return false;
	}
	//------------------------------------------------------------------------------
	public static <T> void mirror(Node<T> root) {
		if(root == null) {
			return;
		}
		
		Node<T> temp = root.getLeftChild();
		
		root.setLeftChild(root.getRightChild());
		root.setRightChild(temp);
		
		mirror(root.getLeftChild());
		mirror(root.getRightChild());
	}

	//------------------------------------------------------------------------------
	public static boolean hasPathSum(Node<Integer> root, int currentSum) {
		if(root == null) {//case where node has one leaf
			return false;
		}
		
		if(root.getLeftChild() == null && root.getRightChild() == null) {//leaf
			return currentSum == root.getData();
		}
		
		boolean leftHasPathSum = hasPathSum(root.getLeftChild(), currentSum - root.getData());
		boolean rightHasPathSum = hasPathSum(root.getRightChild(), currentSum - root.getData());
		
		boolean hasPathSum = leftHasPathSum || rightHasPathSum;
		
		System.out.println(root +
				" leftHasPathSum: "+leftHasPathSum+
				" rightHasPathSum: "+ rightHasPathSum+
				" hasPathSum: "+hasPathSum);
		
		return hasPathSum;
	}
	//------------------------------------------------------------------------------
	public static <T> int maxDepth(Node<T> root) {
		if(root == null) {//case where node has one leaf
			return 0;
		}
		
		if(root.getLeftChild() == null && root.getRightChild() == null) {//leaf
			System.out.println(root + " maxDepth: "+0);
			return 0;
		}
		
		int leftMaxDepth = maxDepth(root.getLeftChild());
		int rightMaxDepth = maxDepth(root.getRightChild());
		
		int maxDepth = 1 + Math.max(leftMaxDepth, rightMaxDepth);
		
		System.out.println(root +
				" left maxDept: "+leftMaxDepth+
				" right maxDepth: "+ rightMaxDepth+
				" current maxDepth: "+maxDepth);
		
		return maxDepth;
	}
	//------------------------------------------------------------------------------
	public static <T> int countNodes(Node<T> root) {
		if(root == null) {
			return 0;
		}
		
		int leftNodes = countNodes(root.getLeftChild());
		int rightNodes = countNodes(root.getRightChild());
		
		return 1 + leftNodes + rightNodes;
	}
	//------------------------------------------------------------------------------
	public static <T> void dfsPostOrderRecursion(Node<T> root) {
		if(root == null) {
			return;
		}
		
		dfsPostOrderRecursion(root.getLeftChild());
		dfsPostOrderRecursion(root.getRightChild());
		System.out.print(root.getData() + "->");
	}
	//------------------------------------------------------------------------------
	public static <T> void dfsPostOrder(Node<T> root) {
		if(root == null) {
			return;
		}
		
		Set<Node<T>> visitedNodes = new HashSet<>();
		Stack<Node<T>> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node<T> top = stack.pop();
			
			if(top.getLeftChild() == null && top.getRightChild() == null) {//leaf node
				System.out.print(top +"->");
			}
			else if(visitedNodes.contains(top)) {//left subtree already processed
				System.out.print(top +"->");
			}
			else {//adds lft & rgt nodes in stack to process in right order
				visitedNodes.add(top);
				stack.push(top);//The location of this is what changes
				
				if(top.getRightChild() != null) {
					stack.push(top.getRightChild());
				}
				
				if(top.getLeftChild() != null) {
					stack.push(top.getLeftChild());
				}
				
			}
		}
	}
	//------------------------------------------------------------------------------
	public static <T> void dfsPreOrderRecursion(Node<T> root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.getData() + "->");
		dfsPreOrderRecursion(root.getLeftChild());
		dfsPreOrderRecursion(root.getRightChild());
	}
	//------------------------------------------------------------------------------
	public static <T> void dfsPreOrder(Node<T> root) {
		if(root == null) {
			return;
		}
		
		Set<Node<T>> visitedNodes = new HashSet<>();
		Stack<Node<T>> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node<T> top = stack.pop();
			
			if(top.getLeftChild() == null && top.getRightChild() == null) {//leaf node
				System.out.print(top +"->");
			}
			else if(visitedNodes.contains(top)) {//left subtree already processed
				System.out.print(top +"->");
			}
			else {//adds lft & rgt nodes in stack to process in right order
				visitedNodes.add(top);
				
				if(top.getRightChild() != null) {
					stack.push(top.getRightChild());
				}
				
				if(top.getLeftChild() != null) {
					stack.push(top.getLeftChild());
				}
				
				stack.push(top);//The location of this is what changes
			}
		}
	}
	//------------------------------------------------------------------------------
	public static <T> void dfsInOrderRecursion(Node<T> root) {
		if(root == null) {
			return;
		}
		
		dfsInOrderRecursion(root.getLeftChild());
		System.out.print(root.getData() + "->");
		dfsInOrderRecursion(root.getRightChild());
	}
	//------------------------------------------------------------------------------
	//Process left subtree -> node -> right subtree
	public static <T> void dfsInOrder(Node<T> root) {
		if(root == null) {
			return;
		}
		
		Set<Node<T>> visitedNodes = new HashSet<>();
		Stack<Node<T>> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node<T> top = stack.pop();
			
			if(top.getLeftChild() == null && top.getRightChild() == null) {//leaf node
				System.out.print(top +"->");
			}
			else if(visitedNodes.contains(top)) {//left subtree already processed
				System.out.print(top +"->");
			}
			else {//adds lft & rgt nodes in stack to process in right order
				visitedNodes.add(top);
				
				if(top.getRightChild() != null) {
					stack.push(top.getRightChild());
				}
				
				stack.push(top);
				
				if(top.getLeftChild() != null) {
					stack.push(top.getLeftChild());
				}
			}
		}
	}
	//------------------------------------------------------------------------------
	public static <T> void breadthFirstSimple(Node<T> root){
		if(root == null) return;
		
		Queue<Node<T>> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node<T> node = queue.remove();
			System.out.print(node + "-->");
			
			if(node.getLeftChild() != null) {
				queue.add(node.getLeftChild());
			}
			
			if(node.getRightChild() != null) {
				queue.add(node.getRightChild());
			}
		}
	}
	//------------------------------------------------------------------------------
	public static <T> void breadthFirst(Node<T> root){
		if(root == null) return;
		
		Queue<Pair<Node<T>, Integer>> queue = new LinkedList<>();
		
		int level = 0;
		queue.add(new Pair<>(root, level));
		
		while(!queue.isEmpty()) {
			Pair<Node<T>, Integer> pair = queue.remove();
			System.out.print(pair + "-->");
			
			level = pair.getValue() + 1;
			
			Node<T> leftChild = pair.getKey().getLeftChild();
			if(leftChild != null) {
				queue.add(new Pair<>(leftChild, level));
			}
			Node<T> rightChild = pair.getKey().getRightChild();
			if(rightChild != null) {
				queue.add(new Pair<>(rightChild, level));
			}
		}
	}

}
