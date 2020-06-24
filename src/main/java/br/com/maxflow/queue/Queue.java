package br.com.maxflow.queue;


public class Queue<T> {
	
	private int size;
	private Node<T> front;
	private Node<T> rear;
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public T front() {
		return front.getKey();
	}
	
	public T rear() {
		return rear.getKey();
	}
	
	public int size() {
		return size;
	}
	
	public T enqueue(T element) {
		Node<T> node = new Node<>(element);
		node.setNext(rear);	
		
		if(rear != null)
			rear.setPrev(node);
		
		rear = node;
		
		if(front == null)
			front = node;
		
		size++;
		
		return node.getKey();
	}
	
	public T dequeue() {
		Node<T> element;
		
		if(isEmpty()) {
			return null;
		} 
		else {
			element = front;
			
			if(front == rear) {
				front = null;
				rear = null;
			} else {
				front = front.getPrev();
				front.setNext(null);
			}
	
			size--;
			
			return element.getKey();
		}
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Empty Queue");
		} else {
			System.out.println("Front: " + front.getKey());
			System.out.println("Rear: " + rear.getKey());
			System.out.println("Size: " + size);
			
			Node<T> node = rear;
			while(node != null) {
				System.out.print(node.getKey() + " ");
				node = node.getNext();
			}
			
			System.out.println();
		}
	}

}
