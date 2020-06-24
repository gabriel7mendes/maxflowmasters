package br.com.maxflow.algorithm.app;

import br.com.maxflow.algorithm.worstcase.FordFulkersonWorstCase;

public class FordFulkersonWorstCaseApp1 {
	
	public static void main(String[] args) {
		FordFulkersonWorstCase fordFulkersonWorstCase = new FordFulkersonWorstCase(4);
        
		fordFulkersonWorstCase.createEdges(1000, 5, 0, 3);
		
        System.out.println("Max Flow: " + fordFulkersonWorstCase.maxFlow(0, 3));
	}


}
