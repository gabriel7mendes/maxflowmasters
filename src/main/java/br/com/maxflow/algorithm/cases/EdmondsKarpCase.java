package br.com.maxflow.algorithm.cases;

import br.com.maxflow.algorithm.EdmondsKarp;

public class EdmondsKarpCase extends EdmondsKarp {
	
	public EdmondsKarpCase(int n) {
		super(n);
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
