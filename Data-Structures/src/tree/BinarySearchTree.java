package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T>  {

	public BinarySearchTree() {
		super();
	}
	
	
	@Override
	public void insert(T data) {

		root=insertByComparing(data,this.root);
	}

	@Override
	public void remove(T dataToRemove) {

		root=removeByComparing(dataToRemove,root);
	}

	private BNode<T> removeByComparing(T dataToRemove, BNode<T> currentNode) {

		if(currentNode==null)
			return null;

		if(dataToRemove==currentNode.getData()) {

			if(currentNode.getRightChild()==null&&currentNode.getLeftChild()==null)
				return null;
			else if(currentNode.getLeftChild()==null)
				return currentNode.getRightChild();
			else if(currentNode.getRightChild()==null)
				return currentNode.getLeftChild();
			/*
			 * // In case that current node has 2 children, we need to swap or the biggest 
			 *    leaf in the left sub-tree or the smallest leaf in the right sub-tree.
			 *    Because of that in the next classes I'm going to implement red black and avl tree
			 *    and they are kind of bstrees we can add two methods find max and min
			 *     element in a tree
			 */
			else {

				BNode<T> maxInLeftTree=this.findMaxElem(currentNode.getLeftChild());

				currentNode.setData(maxInLeftTree.getData());

				currentNode.setLeftChild(removeByComparing(maxInLeftTree.getData(), currentNode.getLeftChild()));

			}

		}

		if(dataToRemove.compareTo(currentNode.getData())<0)
			currentNode.setLeftChild(removeByComparing(dataToRemove, currentNode.getLeftChild()));

		else currentNode.setRightChild(removeByComparing(dataToRemove, currentNode.getRightChild()));

		return currentNode;
	}

	@Override
	public BNode<T> search(T data) {

		return BSsearch(data,root);

	}


	@Override
	public boolean contains(T data) {

		return BScontains(data,root);

	}

	public BNode<T> findMaxElem(BNode<T> currentNode){

		BNode<T> maximum=currentNode;
		while(maximum.getRightChild()!=null)
			maximum=maximum.getRightChild();

		return maximum;

	}

	public BNode<T> findMinElem(BNode<T> currentNode){

		BNode<T> minimum=currentNode;
		while(minimum.getLeftChild()!=null)
			minimum=minimum.getLeftChild();

		return minimum;

	}

	private BNode<T> insertByComparing(T data, BNode<T> currentNode) {

		if(currentNode==null)
			return new BNode<T>(data);

		if(data.compareTo(currentNode.getData())<0) // data is smaller that current root
			currentNode.setLeftChild(insertByComparing(data, currentNode.getLeftChild())); //try to insert data to left side
		else 
			currentNode.setRightChild(insertByComparing(data, currentNode.getRightChild()));

		return currentNode; // return the reference to parent because we want to preserve the tree structure
	}

	private boolean BScontains(T data, BNode<T> currentNode) {

		boolean ans=false;

		if(currentNode!=null) {

			if(data.compareTo(currentNode.getData())<0)
				ans=(BScontains(data, currentNode.getLeftChild()));
			else if (data.compareTo(currentNode.getData())>0)
				ans=(BScontains(data, currentNode.getRightChild()));
			else ans=true;
		}

		return ans;
	}

	private BNode<T> BSsearch(T data, BNode<T> currentNode) {

		BNode<T> ans=null;

		if(currentNode!=null) {
			if(data.compareTo(currentNode.getData())==0)
				ans=currentNode;
			else if(data.compareTo(currentNode.getData())<0)
				ans=BSsearch(data, currentNode.getLeftChild());
			else ans=BSsearch(data, currentNode.getRightChild());
		}

		return ans;
	}


}
