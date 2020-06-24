package br.com.maxflow.algorithm;

import br.com.maxflow.graph.Edge;
import br.com.maxflow.graph.Node;
import br.com.maxflow.stack.Stack;

public class FordFulkerson extends MaxFlow {
	
	public FordFulkerson(int n) {
		super(n);
	}
	
	protected boolean hasPath(int source, int sink) {
	    Stack<Node> stack = new Stack<>();
	    
		stack.push(graph.getNode(source));
	    
		while(!stack.isEmpty()) {		
			Node curr = stack.pop();
		
			for(int i=0; i < curr.edgesSize(); i++) {
				Edge edge = curr.getEdge(i);
				
				if(graph.getParent(edge.getTo()) == null
			    && edge.getTo() != source 
			    && edge.getCapacity() > edge.getFlow()) {
					graph.setParent(edge.getTo(), edge);
					stack.push(graph.getNode(edge.getTo()));
				}
			}	
			
		}
		
		if(graph.getParent(sink) == null) {
			return false;
		}
		
		return true;
	}

	@Override
	protected void worstPath(int count, int source, int sink) {
		
	}
	
}
