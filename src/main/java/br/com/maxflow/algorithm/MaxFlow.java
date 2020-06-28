package br.com.maxflow.algorithm;

import br.com.datastructures.graph.Edge;
import br.com.datastructures.graph.Graph;

public abstract class MaxFlow {
	
	protected Graph graph;
	
	public MaxFlow(int n) {
		graph = new Graph(n);  
	}
	 	
	public void addEdge(int from, int to, int cap) {
		graph.addEdge(from, to, cap);
	}

	protected abstract boolean hasPath(int source, int sink);
	
	protected abstract void worstPath(int count, int source, int sink);
	
	public int maxFlow(int source, int sink) {
		int maxFlow = 0;
		int count = 0;
		
		while(true)
		{
			graph.resetParent();
			
			if (!hasPath(source,sink)) 
                break;
			
			worstPath(count,source,sink);
			
        	int df = Integer.MAX_VALUE;
        	
        	for(Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom()))
       		    df = Math.min(df, edge.getCapacity() - edge.getFlow());
       	
	       	for(Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom()))
	       		edge.pushFlow(df);	 
         
        	maxFlow += df;
        	count++;
		}
		
		return maxFlow;
	}

}
