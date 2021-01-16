package br.com.maxflow.algorithm.time1;

import java.io.IOException;

import br.com.maxflow.algorithm.ema.RandomFordFulkersonEma;

public class RandomFordFulkersonTimeApp1 {
	
	public static void main(String[] args) throws IOException {	
		long begin = System.currentTimeMillis();
		
		int m = Integer.parseInt(args[0]);
		int cap = 1000;
		
		RandomFordFulkersonEma randomFordFulkersonEma = new RandomFordFulkersonEma(m-1);
				
		int s = 0;
		int t = 3;
			
		randomFordFulkersonEma.createEdges(cap, m, s, t);
		
		System.out.println("maxflow: " + randomFordFulkersonEma.maxFlow(s, t));
		
		long end = System.currentTimeMillis();
		
		System.out.println("time (ms): " + (end - begin));
	}

}
