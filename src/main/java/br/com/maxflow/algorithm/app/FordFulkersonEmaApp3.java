package br.com.maxflow.algorithm.app;

import java.io.IOException;

import br.com.maxflow.algorithm.ema.FordFulkersonEma;

public class FordFulkersonEmaApp3 {
	
	public static void main(String[] args) throws IOException {
		int m = Integer.parseInt(args[0]);
		int flow = Integer.parseInt(args[1]);
		
		FordFulkersonEma fordFulkersonEma = new FordFulkersonEma(m-1);
				
		int s = 0;
		int t = 3;
			
		fordFulkersonEma.createEdges(flow, m, s, t);
		
		System.out.println(fordFulkersonEma.maxFlow(s, t));
	}

}
