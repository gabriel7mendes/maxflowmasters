package br.com.maxflow.graph;

public class Edge {

	private int flow;
	private int capacity;
	private int from;
	private int to;
	private Edge reverse;

	public Edge() {
	}

	public Edge(int from, int to, int flow, int capacity) {
		this.from = from;
		this.to = to;
		this.flow = flow;
		this.capacity = capacity;
	}

	public void setReverse(Edge reverse) {
		this.reverse = reverse;
	}

	public Edge getReverse() {
		return reverse;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getFlow() {
		return flow;
	}

	public void pushFlow(int flow) {
		this.flow += flow;
		reverse.flow -= flow;
	}

}
