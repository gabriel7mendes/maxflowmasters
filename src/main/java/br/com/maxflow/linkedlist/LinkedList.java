package br.com.maxflow.linkedlist;

public class LinkedList<T> {
	
	private int size;
	private Node<T> head;
	
	public Node<T> head() {
		return head;
	}
	
	public void insertBegin(T data) {
		Node<T> node = new Node<>(data);
		node.setNext(head);
		head = node;
		size++;
	}
	
	public void insertPosition(int position, T data) {
		if(head == null)
			return;
		
		if(position == 0) {
			insertBegin(data);
			return;
		}
		
		Node<T> node = head;
		
		for(int i = 0; node != null && i < (position-1); i++)
			node = node.getNext();
		
		if(node == null)
			return;
		
		Node<T> next = node.getNext();
		
		Node<T> newNode = new Node<>(data);	
		newNode.setNext(next);
		
		node.setNext(newNode);
		
		size++;
	}
	
	public void insertEnd(T data) {
		Node<T> node = new Node<>(data);
		
		if(head == null) {
			head = new Node<>(data);
			return;
		}
		
		node.setNext(null);
		
		Node<T> last = head;
		while(last.getNext() != null)
			  last = last.getNext();
		
		last.setNext(node);
		
		size++;
		
		return;
	}
	
	public T get(int position) {
		if(head == null)
			return null;
		
		Node<T> node = head;
		
		if(position == 0) {
			return node.getKey();
		}
		
		node = node.getNext();
		for(int i = 0; node.getNext() != null && i < (position-1); i++)
			node = node.getNext();
		
		return node.getKey();
	}
 	
	public void deleteNode(int position) {
		if(head == null)
			return;
		
		Node<T> node = head;
		
		if(position == 0) {
			head = node.getNext();
			size--;
			return;
		}
		
		for(int i = 0; node != null && i < (position-1); i++)
			node = node.getNext();
		
		if(node == null || node.getNext() == null)
			return;
		
		Node<T> next = node.getNext().getNext();
		
		node.setNext(next);
		
		size--;
	}
	
	public void printList() {
		Node<T> node = head;	
	
		System.out.print("[" + node.getKey());
		node = node.getNext();
		
		while(node != null) {
			System.out.print("," + node.getKey());
			node = node.getNext();
		}
		
		System.out.println("]");
	}
	
	public int size() {
		return size;
	}
	
}
