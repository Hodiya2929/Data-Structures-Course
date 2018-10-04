package tree;

public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T> {


	public AvlTree() {
		super();
	}


	@Override
	public void insert(T dataToInsert) {
	
		root=insertAndBalance(dataToInsert,root);
		
	}

	private BNode<T> insertAndBalance(T dataToInsert,BNode<T> currentNode) {
		
		if(currentNode==null)
			return new BNode<T>(dataToInsert);
		
		if(dataToInsert.compareTo(currentNode.getData())<0)
			currentNode.setLeftChild(insertAndBalance(dataToInsert, currentNode.getLeftChild()));
		
		else currentNode.setRightChild(insertAndBalance(dataToInsert,currentNode.getRightChild()));
	
		
		
		int balanceValue=isBalanced(currentNode);
			
		if(balanceValue>1) {
			if(dataToInsert.compareTo(currentNode.getData())>=0)
				currentNode.setLeftChild(rotateLeft(currentNode.getLeftChild()));
				
				currentNode=rotateRight(currentNode);
		}
		
		else if(balanceValue<-1) {
			
			if(dataToInsert.compareTo(currentNode.getData())<0)
				currentNode.setRightChild(rotateRight(currentNode.getRightChild()));
			
				currentNode=rotateLeft(currentNode);
		}
		
		currentNode.setHeight(TreeStaticFunctions.height(currentNode));
		
		
		return currentNode;
	}

	@Override
	public void remove(T dataToRemove) {
	
		root=removeAndBalance(dataToRemove,root);
	
	}
	
	private BNode<T> removeAndBalance(T dataToRemove, BNode<T> currentNode) {
		
		
		if(currentNode==null)
			return null;

		if(dataToRemove.compareTo(currentNode.getData())==0) {

			if(currentNode.getRightChild()==null&&currentNode.getLeftChild()==null)
				return null;
			else if(currentNode.getLeftChild()==null)
				return currentNode.getRightChild();
			else if(currentNode.getRightChild()==null)
				return currentNode.getLeftChild();
		
			else {

				BNode<T> maxInLeftTree=this.findMaxElem(currentNode.getLeftChild());

				currentNode.setData(maxInLeftTree.getData());

				currentNode.setLeftChild(removeAndBalance(maxInLeftTree.getData(), currentNode.getLeftChild()));

			}

		}

		if(dataToRemove.compareTo(currentNode.getData())<0)
			currentNode.setLeftChild(removeAndBalance(dataToRemove, currentNode.getLeftChild()));

		else currentNode.setRightChild(removeAndBalance(dataToRemove, currentNode.getRightChild()));

		currentNode.setHeight(TreeStaticFunctions.height(currentNode));
		
		int balanceValue=isBalanced(currentNode);
		
		if(balanceValue>1) {
			if(currentNode.getLeftChild().getRightChild()!=null)
				currentNode.setLeftChild(rotateLeft(currentNode.getLeftChild()));
		currentNode=rotateRight(currentNode);
		}
		
		else if(balanceValue<-1) {
			if(currentNode.getRightChild().getLeftChild()!=null)
				currentNode.setRightChild(rotateRight(currentNode.getRightChild()));
		currentNode=rotateLeft(currentNode);
			
		}
		
	return currentNode;
	}


	private int isBalanced(BNode<T> currentNode) {
		int leftChildHeight=TreeStaticFunctions.height(currentNode.getLeftChild());
		int rightChildHeight=TreeStaticFunctions.height(currentNode.getRightChild());


		return leftChildHeight-rightChildHeight;
	}
	
	private BNode<T> rotateRight(BNode<T> currentNode){
		
		BNode<T> newRoot=currentNode.getLeftChild();
		BNode<T> rightChildOfLeftChild=newRoot.getRightChild();
		
		newRoot.setRightChild(currentNode);
		currentNode.setLeftChild(rightChildOfLeftChild);

		return newRoot;
	}
	
	private BNode<T> rotateLeft(BNode<T> currentNode){
		
		BNode<T> newRoot=currentNode.getRightChild();
		BNode<T> leftChildOfRightChild=newRoot.getLeftChild();
		
		currentNode.setRightChild(leftChildOfRightChild);
		newRoot.setLeftChild(currentNode);
		
		return newRoot;
	
	}
	
	public static void main(String[] args) {
		
		AvlTree<Integer> tree=new AvlTree<>();
	
		for (int i=0;i<10000;i++) {
			
			tree.insert(new Integer(i));
		
		}
		for (int i=3000;i<4000;i++) {
			
			tree.remove(i);
		
		}
	
		tree.traverse();


	System.out.println();
	
	
		
	}
	
}
