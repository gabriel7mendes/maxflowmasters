package br.com.maxflow.algorithm.ema;

import br.com.maxflow.algorithm.RandomFordFulkerson;
import br.com.maxflow.graph.Edge;

public class RandomFordFulkersonEma extends RandomFordFulkerson {

	public RandomFordFulkersonEma(int n) {
		super(n);
	}
	
	public void createEdges(int flow, int m, int source, int sink) {		
		addEdge(1, sink, flow);
		addEdge(source, 2, flow);
	    addEdge(1, 2, 1);    
	    addEdge(2, sink, flow);
    	
	    int v = 1; 	
    	int w = 4;
    	
	    if(m > 5) { 	    	
   	    	for(int i=0; i < (m-5); i++) {
	    		addEdge(w, v, flow);	 
	    		v = w;
	    		w++;
	        }    	    	   	
	    }
	    	    
		addEdge(source, v, flow);
	}
	
	@Override
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
