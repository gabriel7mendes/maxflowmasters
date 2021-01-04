package br.com.maxflow.algorithm;

import java.util.Random;

import br.com.datastructures.stack.Stack;
import br.com.maxflow.graph.Edge;
import br.com.maxflow.graph.Graph;
import br.com.maxflow.graph.Node;

public class RandomFordFulkerson {
	
	protected Graph graph;
	
	public RandomFordFulkerson(int n) {
		graph = new Graph(n);  
	}
	 	
	public void addEdge(int from, int to, int cap) {
		graph.addEdge(from, to, cap);
	}
	
	protected void randomAdjacencyList(Node v) {
       Random r = new Random();
       int n = v.edgesSize();
       
       for(int i=n-1; i > 0; i--) {
    	   int j = r.nextInt(i+1);
    	   
    	   Edge temp = v.getEdge(i);   	  
    	   v.setEdge(i, v.getEdge(j));
    	   v.setEdge(j, temp);
       }
	
	}
	
	protected boolean hasPath(int source, int sink) {
	    Stack<Node> stack = new Stack<>();
	    
		stack.push(graph.getNode(source));
	    
		while(!stack.isEmpty()) {		
			Node curr = stack.pop();
			
			randomAdjacencyList(curr);
			
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
	
	public int maxFlow(int source, int sink) {
		int maxFlow = 0;
		
		while(true)
		{
			graph.resetParent();
			
			if (!hasPath(source,sink)) 
	            break;
				
	    	int df = Integer.MAX_VALUE;
	    	
	    	for(Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom()))
	   		    df = Math.min(df, edge.getCapacity() - edge.getFlow());
	   	
	       	for(Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom()))
	       		edge.pushFlow(df);	 
	     
	    	maxFlow += df;
		}
		
		return maxFlow;
	}
	
}
