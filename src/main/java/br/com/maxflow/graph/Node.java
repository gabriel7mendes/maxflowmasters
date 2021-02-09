package br.com.maxflow.graph;

import br.com.datastructures.linkedlist.LinkedList;

public class Node {
	
	private long steps;
	int key;
	private LinkedList<Edge> edges;
	private Edge parent;

	public Node(int key) {
		this.key = key;
		steps++;
		edges = new LinkedList<>();
		steps++;
	}
	
	public int getKey() {
		return key;
	}

	public void addEdge(Edge edge) {
		edges.insertBegin(edge);
		steps++;
	}

	public void setEdge(int i, Edge e) {
		edges.deleteAt(i);
		steps++;
		edges.insertPosition(i, e);
		steps++;
	}
	
	public int edgesSize() {
		steps++;
		return edges.size();
	}

	public Edge getEdge(int i) {
		steps++;
		return edges.get(i);
	}
	
	public LinkedList<Edge> getEdges() {
		steps++;
		return edges;
	}

	public Edge getParent() {
		steps++;
		return parent;
	}

	public void setParent(Edge parent) {
		this.parent = parent;
		steps++;
	}

	@Override
	public String toString() {
		steps++;
		return this.key + "";
	}
	
	public long steps() {
		return parent != null ? steps + parent.steps() + edges.steps() : steps;
	}
}
