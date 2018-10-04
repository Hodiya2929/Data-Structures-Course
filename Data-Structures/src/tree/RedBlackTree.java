package tree;


public class RedBlackTree<T extends Comparable<T>> {

	private static final boolean RED=false;
	private static final boolean BLACK=true;

	RBNode<T> root;

	public RedBlackTree() {
		root=null;
	}


	public void insert(T data) {
		root=insertRedBlack(data,root);

	}


	private RBNode<T> insertRedBlack(T data, RBNode<T> root) {

		if(root==null)
			root=new RBNode<T>(data,BLACK);


		else {

			RBNode<T> temp=root;
			RBNode<T> parent=temp;

			while(temp!=null) {

				if(data.compareTo(temp.data)<0) {
					parent=temp;
					temp=temp.left;
				}

				else {
					parent=temp;
					temp=temp.right;
				}
			}
			temp=new RBNode<T> (data,RED);

			if(data.compareTo(parent.data)<0) 
				parent.setLeft(temp);

			else parent.setRight(temp);

			temp.setParent(parent);

			if(temp.getParent().getColour()==RED)
				fixAfterInsersion(temp);

		}

		return root;

	}

	private RBNode<T> getUncle (RBNode<T> currentNode){

		RBNode<T> parent=currentNode.getParent();
		RBNode<T> grandpa=parent.getParent();

		RBNode<T> uncle=null;

		if(grandpa.getLeft()==parent)
			uncle=grandpa.getRight();
		else uncle=grandpa.getLeft();


		return uncle;
	}


	private void fixAfterInsersion(RBNode<T> currentNode) {

		RBNode<T> uncle=getUncle(currentNode);

		RBNode<T> parent=currentNode.getParent();
		RBNode<T> grandpa=parent.getParent();

		if(isRed(uncle)) {

			uncle.setColour(!uncle.getColour());
			parent.setColour(!parent.getColour());
			grandpa.setColour(!grandpa.getColour());

			if(grandpa==root||grandpa.getParent().getColour()==BLACK) {
				root.setColour(BLACK);
				return;
			}
			else fixAfterInsersion(grandpa);

		}

		else
			makeRotations(currentNode);

	}



	private void makeRotations(RBNode<T> currentNode){

		RBNode<T> after=null;
		
		RBNode<T>parent=currentNode.getParent();
		RBNode<T> grandpa=parent.getParent();
		
		if(grandpa.getLeft()==parent&&parent.getLeft()==currentNode) {
			rotationColourChanging(grandpa, parent);
			after=rotateRight(grandpa);
		}
		else if(grandpa.getLeft()==parent&&parent.getRight()==currentNode) {
		parent=	rotateLeft(parent);
		rotationColourChanging(grandpa, parent);
		after=rotateRight(grandpa);
		
		}
		else if(grandpa.getRight()==parent&&parent.getRight()==currentNode) {
			rotationColourChanging(grandpa, parent);
			after=rotateRight(grandpa);
		}
		else {
			parent=	rotateRight(parent);
			rotationColourChanging(grandpa, parent);
			after=rotateLeft(grandpa);
		}

		if(after.getParent()==null) {
			root.setData(after.getData());
			root.setLeft(after.getLeft());
			root.setRight(after.getRight());
			root.setColour(BLACK);
		}
		else if(after.getColour()==BLACK||after.getParent().getColour()==BLACK)
			return;
		else fixAfterInsersion(after);
	}


	private boolean isRed(RBNode<T> currentNode) {


		if(currentNode==null)
			return false;
		else return currentNode.getColour()==RED;
	}

	private void rotationColourChanging(RBNode<T> node1,RBNode<T> node2) {
		node1.setColour(!node1.getColour());
		node2.setColour(!node2.getColour());
	}


	private RBNode<T> rotateLeft(RBNode<T> currentNode) {

		RBNode<T> parentOfGrandpa=currentNode.getParent();

		RBNode<T> rightChild=currentNode.getRight();
		
		currentNode.setRight(rightChild.getLeft());
		rightChild.setLeft(currentNode);
		currentNode.setParent(rightChild);
		rightChild.setParent(parentOfGrandpa);

		if(parentOfGrandpa!=null)
		{
			if(parentOfGrandpa.getLeft()==currentNode)
				parentOfGrandpa.setLeft(rightChild);
			else parentOfGrandpa.setRight(rightChild);		
		}
		return rightChild;
	}


	private RBNode<T> rotateRight(RBNode<T> currentNode) {

		RBNode<T> parentOfGrandpa=currentNode.getParent();
		
		RBNode<T> leftChild=currentNode.getLeft();

		currentNode.setLeft(leftChild.getRight());
		leftChild.setRight(currentNode);
		currentNode.setParent(leftChild);
		leftChild.setParent(parentOfGrandpa);

		if(parentOfGrandpa!=null)
		{

			if(parentOfGrandpa.getLeft()==currentNode)
				parentOfGrandpa.setLeft(leftChild);
			else parentOfGrandpa.setRight(leftChild);		
		}

		return leftChild;
	}
	public static void main(String[] args) {

		RedBlackTree<Integer> tree=new RedBlackTree<>();

for(int i=0;i<100;i++) {
	
	
	tree.insert(new Integer(   (int) (Math.random()*100+1)) );
}


	
	}


}