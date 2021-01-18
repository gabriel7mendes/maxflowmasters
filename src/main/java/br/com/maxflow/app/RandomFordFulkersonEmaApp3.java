package br.com.maxflow.app;

import java.io.IOException;

import br.com.maxflow.algorithm.ema.RandomFordFulkersonEma;

public class RandomFordFulkersonEmaApp3 {
	
	public static void main(String[] args) throws IOException {
		int m = Integer.parseInt(args[0]);
		int flow = Integer.parseInt(args[1]);
		
		RandomFordFulkersonEma randomFordFulkersonEma = new RandomFordFulkersonEma(m-1);
				
		int s = 0;
		int t = 3;
			
		randomFordFulkersonEma.createEdges(flow, m, s, t);
		
		System.out.println("maxflow: " + randomFordFulkersonEma.maxFlow(s, t));
	}

}
