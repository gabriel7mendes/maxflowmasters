package br.com.maxflow.algorithm.ema;

import br.com.maxflow.algorithm.FordFulkerson;
import br.com.maxflow.graph.Edge;

public class FordFulkersonEma extends FordFulkerson {
	
	public FordFulkersonEma(int n) {
		super(n);
	}
		
	protected void worstPath(int count, int source, int sink) {
		if(count % 2 == 0) {
			graph.setParent(sink, graph.getEdge(2, sink));
			graph.setParent(2, graph.getEdge(1, 2));
			
			int m = graph.nodesSize() + 1;
			
			int v = 1; 	
	    	int w = 4;
	    	
		    if(m > 5) {
              for(int i=0; i < (m-5); i++) {
	   	    		graph.setParent(v, graph.getEdge(w, v));
	   	    		v = w;
		    		w++;
	   	    	}
	   	    	
	   	    	graph.setParent(v, graph.getEdge(source, v));
		    }
			
		} else {
			graph.setParent(sink, graph.getEdge(1, sink));
			graph.setParent(1, graph.getEdge(2, 1));
		}	
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
		int count = 0;
		
		while(true)
		{
			graph.resetParent();
			
			if (!hasPath(source,sink)) 
	            break;
			
			worstPath(count, source, sink);
				
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
