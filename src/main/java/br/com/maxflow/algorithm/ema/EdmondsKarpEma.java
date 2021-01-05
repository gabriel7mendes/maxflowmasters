package br.com.maxflow.algorithm.ema;

import br.com.maxflow.algorithm.EdmondsKarp;

public class EdmondsKarpEma extends EdmondsKarp {
	
	public EdmondsKarpEma(int n) {
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

}
