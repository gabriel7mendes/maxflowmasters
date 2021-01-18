package br.com.maxflow.time;

import java.io.IOException;

import br.com.maxflow.algorithm.ema.FordFulkersonEma;

public class FordFulkersonTimeApp1 {
	
	public static void main(String[] args) throws IOException {	
		long begin = System.currentTimeMillis();
		
		int m = Integer.parseInt(args[0]);
		int cap = 1000;
		
		FordFulkersonEma fordFulkersonEma = new FordFulkersonEma(m-1);
				
		int s = 0;
		int t = 3;
			
		fordFulkersonEma.createEdges(cap, m, s, t);
		
		System.out.println("maxflow: " + fordFulkersonEma.maxFlow(s, t));
		
		long end = System.currentTimeMillis();
		
		System.out.println("time (ms): " + (end - begin));
	}

}
