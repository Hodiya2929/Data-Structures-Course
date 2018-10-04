package tree;

import lineardataStructures.LinkedListqueue;

/**
 * (From StackOverFlow)
 *When to use Pre-Order, In-order or Post-Order?
 The traversal strategy the programmer selects depends on the specific needs of the algorithm
 being designed. The goal is speed, so pick the strategy that brings you the nodes you require the
 fastest. 
 * If you know you need to explore the roots before inspecting any leaves, you pick 
 pre-order because you will encounter all the roots before all of the leaves.
 * If you know you need to explore all the leaves before any nodes, you select post-order
 because you don't waste any time inspecting roots in search for leaves.
 * If you know that the tree has an inherent sequence in the nodes, and you want to flatten 
 the tree back into its original sequence, than an in-order traversal should be used. The tree
 would be flattened in the same way it was created. A pre-order or post-order traversal might
 not unwind the tree back into the sequence which was used to create it.
 * 
 * Of course that there are many actions in addition to printing, that can be done
 * 
 * @author עימנואל
 *
 */
public class TreeStaticFunctions {

	/**
	 * In inorder each parent node is visited in between its children
	 * 'InOrder' traversal, in binary search trees this kind of traversal will print 
	 * the elements in increasing order. order of traversing is: left, root, right.
	 * @param currentNode - root of the tree. 
	 */
	public static<T> void inOrderTraversal(BNode<T> currentNode){ 

		if(currentNode!=null) { // if root null stop!

			inOrderTraversal(currentNode.getLeftChild());  //First go to the left 
			System.out.print(currentNode+", ");
			inOrderTraversal(currentNode.getRightChild());	
		}
	}

	/**
	 * In postOrder each parent node is visited after (post) its children.
	 * Order of traversing is: left, right, root.
	 * @param currentNode - root of the tree. 
	 */
	public static<T> void postOrderTraversal(BNode<T> currentNode){

		if(currentNode!=null) {

			postOrderTraversal(currentNode.getLeftChild());
			postOrderTraversal(currentNode.getRightChild());
			System.out.println(currentNode+", ");			
		}
	}

	/**
	 * In preorder each parent node is visited before (pre) its children.
	 * Order of traversing is: root, left,right.
	 * @param currentNode - root of the tree. 
	 */
	public static<T> void preOrderTraversal(BNode<T> currentNode){

		if(currentNode!=null) {

			System.out.println(currentNode+", ");
			preOrderTraversal(currentNode.getLeftChild());
			preOrderTraversal(currentNode.getRightChild());
		}
	}

	public static<T> void IterateOverLevels(BNode<T> currentNode) {

		LinkedListqueue<BNode<T>> queue=new LinkedListqueue<>();
		queue.Enqueue(currentNode);

		while(!queue.isEmpty()) {
			BNode<T> temp=queue.Dequeue();
			System.out.print(temp+", ");
			queue.Enqueue(temp.getLeftChild());
			queue.Enqueue(temp.getRightChild());

		}
	}

	public static<T> boolean isEmpty(BNode<T> root) {

		return (root==null);
	}

	/**
	 * 
	 * @param currentNode
	 * @return the height of the tree - the longest path from root to leaf
	 */
	public static<T> int height(BNode<T> currentNode) {
		
		if(currentNode==null)
			return -1;

		return Math.max(height(currentNode.getLeftChild()),height(currentNode.getRightChild()))+1;
	}
}
