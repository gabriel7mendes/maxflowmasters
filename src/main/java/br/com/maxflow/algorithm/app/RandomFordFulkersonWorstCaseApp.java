package br.com.maxflow.algorithm.app;

import java.io.IOException;

import br.com.maxflow.algorithm.worstcases.RandomFordFulkersonWorstCase;

public class RandomFordFulkersonWorstCaseApp {
	
	public static void main(String[] args) throws IOException {
		int m = 5;
		RandomFordFulkersonWorstCase randomFordFulkersonWorstCase = new RandomFordFulkersonWorstCase(m-1);
				
		int s = 0;
		int t = 3;
			
		randomFordFulkersonWorstCase.createEdges(m, s, t);
		
		System.out.println(randomFordFulkersonWorstCase.maxFlow(s, t));
	}

}
