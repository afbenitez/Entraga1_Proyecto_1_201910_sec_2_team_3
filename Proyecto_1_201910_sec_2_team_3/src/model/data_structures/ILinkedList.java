package model.data_structures;

public interface ILinkedList<T> extends Iterable<T> {
	
Node<T> darNodo(int pos);

	
	void add(T elem);
	
	
	void addAtEnd(T elem);
	
	
	void addAtK(T elem, int pos);
	
	
	T getElement(int pos);
	
	
	T getCurrentElement();
	
	
	Integer getSize();
	
	
	boolean delete(T elem);
	
	
	T deleteAtK(int pos);
	
	
	Node<T> next();
	
	
	Node<T> previous();

}
