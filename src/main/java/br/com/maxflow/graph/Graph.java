package br.com.maxflow.graph;

import br.com.datastructures.linkedlist.LinkedList;

public class Graph {
	
	private long steps;
	private Node[] nodes;

	public Graph(int n) {
		nodes = new Node[n];
		steps++;

		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i);
			steps++;
		}
	}

	public void addEdge(int from, int to, int cap) {
		Edge a = new Edge(from, to, 0, cap);
		steps++;
		Edge b = new Edge(to, from, 0, 0);
		steps++;

		a.setReverse(b);
		steps++;
		b.setReverse(a);
		steps++;

		nodes[from].addEdge(a);
		steps++;
		nodes[to].addEdge(b);
		steps++;
	}

	public int nodesSize() {
		steps++;
		return nodes.length;
	}
	
	public Node getNode(int key) {
		steps++;
		return nodes[key];
	}

	public Edge getParent(int key) {
		if (nodes[key] != null) {
			steps++;
			return nodes[key].getParent();
		}
		else {
			steps++;
			return null;
		}
	}
	
	public Edge getEdge(int from, int to) {
		LinkedList<Edge> edges = nodes[from].getEdges();
		steps++;
		
		for(int i=0; i < edges.size(); i ++) {
			Edge edge = edges.get(i);
			steps++;
			int t = edge.getTo();
			steps++;
		    
			if(to == t) {
				steps++;
				return edge;
			}				
		}
		
		steps++;
		return null;
	}

	public void resetParent() {
		for (int i = 0; i < nodes.length; i++) {
			nodes[i].setParent(null);
			steps++;
		}		
	}

	public void setParent(int key, Edge edge) {
		if (nodes[key] != null) {
			nodes[key].setParent(edge);
			steps++;
		}			
	}
	
	public long steps() {
		long totalSteps = steps;
		
		for (int i = 0; i < nodes.length; i++) {
			totalSteps += nodes[i].steps();
		}
		
		return totalSteps;
	}
	
}
