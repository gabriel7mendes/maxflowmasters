package br.com.maxflow.stack;

public class Node<T> {
	
	private T key;
	private Node<T> next;

	public Node(T d) {
		key = d;
		next = null;
	}
	
	public T getKey() {
		return key;
	}
	
	public void setKey(T key) {
		this.key = key;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "" + key;
	}

}
