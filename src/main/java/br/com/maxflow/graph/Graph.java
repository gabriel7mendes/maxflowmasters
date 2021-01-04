package br.com.maxflow.graph;

import br.com.datastructures.linkedlist.LinkedList;

public class Graph {
	
	private Node[] nodes;

	public Graph(int n) {
		nodes = new Node[n];

		for (int i = 0; i < n; i++)
			nodes[i] = new Node(i);
	}

	public void addEdge(int from, int to, int cap) {
		Edge a = new Edge(from, to, 0, cap);
		Edge b = new Edge(to, from, 0, 0);

		a.setReverse(b);
		b.setReverse(a);

		nodes[from].addEdge(a);
		nodes[to].addEdge(b);
	}

	public int nodesSize() {
		return nodes.length;
	}

	public Node getNode(int key) {
		return nodes[key];
	}

	public Edge getParent(int key) {
		if (nodes[key] != null)
			return nodes[key].getParent();
		else
			return null;
	}
	
	public Edge getEdge(int from, int to) {
		LinkedList<Edge> edges = nodes[from].getEdges();
		
		for(int i=0; i < edges.size(); i ++) {
			Edge edge = edges.get(i);
			int t = edge.getTo();
		    
			if(to == t)
			   return edge;
		}
		
		return null;
	}

	public void resetParent() {
		for (int i = 0; i < nodes.length; i++)
			nodes[i].setParent(null);
	}

	public void setParent(int key, Edge edge) {
		if (nodes[key] != null)
			nodes[key].setParent(edge);
	}
	
}
