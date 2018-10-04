package tree;

public interface Tree<T> {

	void insert(T data);
	void remove(T dataToRemove);
	BNode<T> search(T data);
	void traverse();
	int height();
	boolean isEmpty();
	boolean contains(T data);
	
}
