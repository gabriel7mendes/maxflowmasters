package br.com.maxflow.algorithm.worstcase;

import br.com.maxflow.algorithm.FordFulkerson;

public class FordFulkersonWorstCase extends FordFulkerson {
	
	public FordFulkersonWorstCase(int n) {
		super(n);
	}

	@Override
	protected void worstPath(int count, int source, int sink) {
		if(count % 2 == 0) {
			graph.setParent(sink, graph.getNode(2).getEdge(0));
			graph.setParent(2, graph.getNode(1).getEdge(1));
			
		} else {
			graph.setParent(1, graph.getNode(2).getEdge(1));
		}	
	}
	
	public void createEdges(int flow, int m, int source, int sink) {
	    addEdge(source, 1, flow);
    	addEdge(source, 2, flow);
	    addEdge(1, 2, 1);    
	    addEdge(2, sink, flow);

    	int v = 1; 	
    	int w = 4;
	    if(m > 5) { 
   	    	for(int i=0; i < (m-5); i++) {
	    		addEdge(v, w, flow);	 
	    		v = w;
	    		w++;
	        }    	
	    }
    	addEdge(v, sink, flow);	
	}

}
