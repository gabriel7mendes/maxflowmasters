package br.com.maxflow.stack;

public class Stack<T> {
	
	private int size;
	private Node<T> top;
	
	public boolean isEmpty() {
		if(top == null)
			return true;
		else
			return false;
	}
	
	public T top() {
		return top.getKey();
	}
	
	public int size() {
		return size;
	}
	
	public Node<T> push(T element) {
		Node<T> node = new Node<>(element);
		node.setNext(top);	
		top = node;
		size++;
		return node;
	}
	
	public T pop() {
		T element;
		
		if(isEmpty()) {
			return null;
		} 
		else {
			element = top();
		    top = top.getNext();
			size--;
			return element;
		}
	}
	

	public void display() {
		if(isEmpty()) {
			System.out.println("Empty Stack");
		} else {
			System.out.println("Top: " + top.getKey());
			System.out.println("Size: " + size);
			
			Node<T> node = top;
			while(node != null) {
				System.out.print(node.getKey() + " ");
				node = node.getNext();
			}
			
			System.out.println();
		}
	}

}
