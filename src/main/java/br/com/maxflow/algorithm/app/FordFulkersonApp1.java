package br.com.maxflow.algorithm.app;

import br.com.maxflow.algorithm.FordFulkerson;

public class FordFulkersonApp1 {
	
	public static void main(String[] args) {
        FordFulkerson fordFulkerson = new FordFulkerson(5);
        
		fordFulkerson.addEdge(0, 1, 1000);
		fordFulkerson.addEdge(0, 2, 1000);
		fordFulkerson.addEdge(1, 2, 1);
		fordFulkerson.addEdge(1, 3, 1000);
		fordFulkerson.addEdge(2, 3, 1000);
        
        System.out.println("Max Flow: " + fordFulkerson.maxFlow(0, 3));
	}

}
