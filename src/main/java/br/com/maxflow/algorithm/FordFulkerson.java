package br.com.maxflow.algorithm;

import br.com.datastructures.stack.Stack;
import br.com.maxflow.graph.Edge;
import br.com.maxflow.graph.Graph;
import br.com.maxflow.graph.Node;

public class FordFulkerson {
	
	protected long steps;
    protected Graph graph;
	
	public FordFulkerson(int n) {
		graph = new Graph(n); 
		steps++;
	}
	 	
	public void addEdge(int from, int to, int cap) {
		graph.addEdge(from, to, cap);
		steps++;
	}
	
	protected boolean hasPath(int source, int sink) {
	    Stack<Node> stack = new Stack<>();
	    steps++;
	    
		stack.push(graph.getNode(source));
		steps++;
		
		while(!stack.isEmpty()) {		
			Node curr = stack.pop();
			steps++;
					
			for(int i=0; i < curr.edgesSize(); i++) {
				Edge edge = curr.getEdge(i);
				steps++;
				
				if(graph.getParent(edge.getTo()) == null
				   && edge.getTo() != source 
				   && edge.getCapacity() > edge.getFlow()) {
					graph.setParent(edge.getTo(), edge);
					stack.push(graph.getNode(edge.getTo()));
					steps+=2;
				}
			}	
			
		}
		
		if(graph.getParent(sink) == null) {
			steps++;
			return false;
		}
		
		steps++;
		return true;
	}
	
	public int maxFlow(int source, int sink) {
		int maxFlow = 0;
		steps++;
		
		while(true)
		{
			graph.resetParent();
			steps++;
			
			if (!hasPath(source,sink)) 
                break;
				
        	int df = Integer.MAX_VALUE;
        	steps++;
        	
        	for(Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
        		df = Math.min(df, edge.getCapacity() - edge.getFlow());
        		steps++;
        	}
       		    
	       	for(Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
	       		edge.pushFlow(df);	
	       		steps++;
	       	}
	       		        
        	maxFlow += df;
        	steps++;
		}
		
		steps++;
		return maxFlow;
	}
	
	public long steps() {
		return steps + graph.steps();
	}
	
}
