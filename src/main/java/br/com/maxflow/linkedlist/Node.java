package br.com.maxflow.linkedlist;

public class Node<T> {
	
	private T key;
	private Node<T> next;

	public Node(T key) {
		this.key = key;
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

	@Override
	public String toString() {
		return "" + key;
	}
}
