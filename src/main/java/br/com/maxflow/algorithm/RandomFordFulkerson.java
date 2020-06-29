package br.com.maxflow.algorithm;

import java.util.Random;

import br.com.maxflow.graph.Edge;
import br.com.maxflow.graph.Node;

public class RandomFordFulkerson extends FordFulkerson {

	public RandomFordFulkerson(int n) {
		super(n);
	}

	@Override
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
}
