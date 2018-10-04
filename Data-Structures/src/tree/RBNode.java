package tree;

public class RBNode<T extends Comparable<T>> {

	T data;
	
	RBNode<T> left;
	RBNode<T> right;
	RBNode<T> parent;
	
	
	public RBNode() {
		data=null;
		
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public RBNode<T> getLeft() {
		return left;
	}


	public RBNode<T> getParent() {
		return parent;
	}


	public void setParent(RBNode<T> parent) {
		this.parent = parent;
	}


	public boolean getColour() {
		return colour;
	}


	public void setColour(boolean colour) {
		this.colour = colour;
	}


	public void setLeft(RBNode<T> left) {
		this.left = left;
	}


	public RBNode<T> getRight() {
		return right;
	}


	public void setRight(RBNode<T> right) {
		this.right = right;
	}


	boolean colour;

	public RBNode(T data) {	
		
		this.data = data;
		left=null;
		right=null;
		parent=null;
	}


	public RBNode(T data, boolean colour) {
		this.data=data;
		this.colour=colour;
	}
}
