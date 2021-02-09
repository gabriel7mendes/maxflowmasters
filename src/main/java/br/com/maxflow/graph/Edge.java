package br.com.maxflow.graph;

public class Edge {
	
	private long steps;
	private int flow;
	private int capacity;
	private int from;
	private int to;
	private boolean isReverse;
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
	
	public Edge(int from, int to, int flow, int capacity, boolean isReverse) {
		this.from = from;
		steps++;
		this.to = to;
		steps++;
		this.flow = flow;
		steps++;
		this.capacity = capacity;
		steps++;
		this.isReverse = isReverse;
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
		this.flow += flow;
		steps++;
		reverse.flow -= flow;
		steps++;
	}
	
	public boolean isReverse() {
		steps++;
		return isReverse;
	}
	
	public long steps() {
		return steps;
	}

	@Override
	public String toString() {
		return "Edge [capacity=" + capacity + ", flow=" + flow + ", from=" + from + ", to=" + to + "]";
	}
	
}
