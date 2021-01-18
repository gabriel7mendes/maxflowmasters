package br.com.maxflow.graph;

public class Edge {
	
	private long steps;
	private int flow;
	private int capacity;
	private int from;
	private int to;
	private Edge reverse;

	public Edge() {
	}

	public Edge(int from, int to, int flow, int capacity) {
		this.from = from;
		steps++;
		this.to = to;
		steps++;
		this.flow = flow;
		steps++;
		this.capacity = capacity;
		steps++;
	}

	public void setReverse(Edge reverse) {
		this.reverse = reverse;
		steps++;
	}

	public Edge getReverse() {
		steps++;
		return reverse;
	}

	public int getFrom() {
		steps++;
		return from;
	}

	public int getTo() {
		steps++;
		return to;
	}

	public int getCapacity() {
		steps++;
		return capacity;
	}

	public int getFlow() {
		steps++;
		return flow;
	}

	public void pushFlow(int flow) {
		steps++;
		this.flow += flow;
		steps++;
		reverse.flow -= flow;
	}
	
	public long steps() {
		return steps;
	}

}
