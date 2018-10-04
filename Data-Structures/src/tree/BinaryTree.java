package tree;

public class BinaryTree<T>implements Tree<T> {

	protected BNode<T> root;

	public BinaryTree() {
		root=null;
	}

	@Override
	public void insert(T data) {

		root=insert(data, root);

	}

	@Override
	public void remove(T dataToRemove) {

		root=remove(dataToRemove,root);

	}


	@Override
	public BNode<T> search(T data) {

		return search(data, root);
	}


	@Override
	public void traverse() {

		if(isEmpty())
			System.out.println("Tree is empty.");
		TreeStaticFunctions.inOrderTraversal(root);;
	}

	@Override
	public boolean isEmpty() {

		return TreeStaticFunctions.isEmpty(root);
	}

	@Override
	public int height() {

		return TreeStaticFunctions.height(root);
	}
	
	@Override
	public boolean contains(T data) {
		
		return contains(data, root);
	}
	



	private BNode<T> insert(T data, BNode<T> currentNode) {

		if(currentNode==null) //insert data to the root/set current node 
			return new BNode<T>(data);

		if(Math.random()>0.5)
			currentNode.setLeftChild(insert(data, currentNode.getLeftChild()));
		else {
			currentNode.setRightChild(insert(data,currentNode.getRightChild()));
		}

		return currentNode; 

		/* if left/right child is null then return new node that will be returned to the calling parent.
		 *else - return current node - we don't want to change the tree structure so that we return the current
		 *node.*/

	}


	private BNode<T> remove(T dataToRemove, BNode<T> currentNode) {

		if(currentNode==null)
			return null;

		if(dataToRemove==currentNode.getData()) {

			if(currentNode.getLeftChild()==null&&currentNode.getRightChild()==null)
				return null;
			else if(currentNode.getLeftChild()==null)
				return currentNode.getRightChild();
			else if(currentNode.getRightChild()==null)
				return currentNode.getLeftChild();
			else {

				if((Math.random())>0.5){

					BNode<T> leftLeaf=currentNode.getLeftChild();

					while(leftLeaf.getLeftChild()!=null)
						leftLeaf=leftLeaf.getLeftChild();

					currentNode.setData(leftLeaf.getData());
					currentNode.setLeftChild(remove(leftLeaf.getData(), currentNode.getLeftChild()));
				}
				else {

					BNode<T> rightLeaf=currentNode.getRightChild();
					while(rightLeaf.getRightChild()!=null)
						rightLeaf=rightLeaf.getRightChild();

					currentNode.setData(rightLeaf.getData());
					currentNode.setRightChild(remove(rightLeaf.getData(), currentNode.getRightChild()));
				}	
			}
		}

		currentNode.setLeftChild(remove(dataToRemove, currentNode.getLeftChild()));
		currentNode.setRightChild(remove(dataToRemove, currentNode.getRightChild()));

		return currentNode;
	}


	private BNode<T> search(T data, BNode<T> currentNode) {

		if(currentNode==null)
			return null;

		if(currentNode.getData()==data)
			return currentNode;

		BNode<T> leftCheck=search(data,currentNode.getLeftChild());
		BNode<T> rightCheck=search(data,currentNode.getRightChild());

		if(leftCheck!=null)
			return leftCheck;
		else if (rightCheck!=null)
			return rightCheck;
		else return null;

	}
	
	private boolean contains(T data, BNode<T> currentNode) {
		
	boolean ans=false;
	
		if(currentNode!=null)
		ans=(currentNode.getData()==data||contains(data,currentNode.getLeftChild())
				||data==currentNode.getRightChild());
		
		return ans;
		
	}

  	
 


}
