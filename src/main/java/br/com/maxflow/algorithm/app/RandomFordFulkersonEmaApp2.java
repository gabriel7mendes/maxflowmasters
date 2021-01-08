package br.com.maxflow.algorithm.app;

import java.io.IOException;

import br.com.maxflow.algorithm.ema.RandomFordFulkersonEma;

public class RandomFordFulkersonEmaApp2 {

	public static void main(String[] args) throws IOException {
		int m = 1001;
		int flow =  Integer.parseInt(args[0]);
		
		RandomFordFulkersonEma randomFordFulkersonEma = new RandomFordFulkersonEma(m-1);
				
		int s = 0;
		int t = 3;
			
		randomFordFulkersonEma.createEdges(flow, m, s, t);
		
		System.out.println(randomFordFulkersonEma.maxFlow(s, t));
	}

}
