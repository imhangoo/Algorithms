package com.imhangoo.algorithms;

public class BinarySearchTree {
	public static void main(String[] args) {
		
		// initialize a tree
		Node root = new Node(10);
		
		int values[] = {2,1,3,4,7,6,5,2};
		for (int i = 0; i < values.length; i++) {
			insert(root,new Node(values[i]));
		}
		
		inOrderTraverse(root);
		
	}

	
	public static void insert(Node root,Node node){
		if(node.value == root.value) return;
		
		if(node.value < root.value){
			if(root.left == null){
				root.left = node;
			}else{
				insert(root.left,node);
			}
			return;
		}
		
		if(node.value > root.value){
			if(root.right == null){
				root.right = node;
			}else{
				insert(root.right,node);
			}
			return;
		}
		
	}
	
	public Node search(Node root,Node node){
		if(root == null) return null;
		
		if(root.value == node.value){
			return root;
		}else if(root.value < node.value) {
			return search(root.left, node);
		}else{
			return search(root.right,node);
		}
		
	}
	
	public static void inOrderTraverse(Node root){
		if(root == null) return;
		inOrderTraverse(root.left);
		System.out.println(root.value);
		inOrderTraverse(root.right);
	}
	
}

class Node{
	Node left;
	Node right;
	int value;
	
	public Node(int value){
		this.value = value;
		left = null;
		right = null;
	}
}


