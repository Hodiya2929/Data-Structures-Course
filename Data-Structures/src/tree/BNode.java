package tree;

class BNode<T> { // package friendly class

	protected T data;
	protected BNode<T> leftChild,rightChild;
	protected int height;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BNode(T data) {

		this.data=data;

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "Node: "+data;
	}

}
