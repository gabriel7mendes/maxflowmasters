package br.com.maxflow.queue;

public class Node<T> {
	
	private T key;
	private Node<T> next;
	private Node<T> prev;

	public Node(T item) {
		this.key = item;
	}
	
	public T getKey() {
		return key;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrev() {
		return prev;
	}
	
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "" + key;
	}

}
