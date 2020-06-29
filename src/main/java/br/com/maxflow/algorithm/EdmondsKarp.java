package br.com.maxflow.algorithm;

import br.com.datastructures.queue.Queue;
import br.com.maxflow.graph.Edge;
import br.com.maxflow.graph.Node;

public class EdmondsKarp extends FordFulkerson {

	public EdmondsKarp(int n) {
		super(n);
	}

	@Override
	protected boolean hasPath(int source, int sink) {
		Queue<Node> queue = new Queue<>();
	    
		queue.enqueue(graph.getNode(source));
	   
		while(!queue.isEmpty()) {			
			Node curr = queue.dequeue();
			
			for(int i=0; i < curr.edgesSize(); i++) {
				Edge edge = curr.getEdge(i);
				
				if(graph.getParent(edge.getTo()) == null
			    && edge.getTo() != source 
			    && edge.getCapacity() > edge.getFlow()) {
					graph.setParent(edge.getTo(), edge);
					queue.enqueue(graph.getNode(edge.getTo()));
				}
			}
		}
		
		if(graph.getParent(sink) == null) {
			return false;
		}
		
		return true;
	}
}
