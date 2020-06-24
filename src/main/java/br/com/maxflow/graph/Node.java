package br.com.maxflow.graph;

import br.com.maxflow.linkedlist.LinkedList;

public class Node {

	int key;
	private LinkedList<Edge> edges;
	private Edge parent;

	public Node(int key) {
		this.key = key;
		edges = new LinkedList<>();
	}

	public void addEdge(Edge edge) {
		edges.insertBegin(edge);
	}

	public int edgesSize() {
		return edges.size();
	}

	public Edge getEdge(int i) {
		return edges.get(i);
	}

	public Edge getParent() {
		return parent;
	}

	public void setParent(Edge parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return this.key + "";
	}

}
