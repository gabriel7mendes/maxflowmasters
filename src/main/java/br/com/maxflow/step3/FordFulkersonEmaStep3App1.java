package br.com.maxflow.step3;

import java.io.IOException;

import br.com.maxflow.algorithm.ema.FordFulkersonEma;

public class FordFulkersonEmaStep3App1 {
	
	public static void main(String[] args) throws IOException {		
		int m = Integer.parseInt(args[0]);
		int cap = Integer.parseInt(args[1]);
		
		FordFulkersonEma fordFulkersonEma = new FordFulkersonEma(m-1);
				
		int s = 0;
		int t = 3;
			
		fordFulkersonEma.createEdges(cap, m, s, t);
		
		System.out.println("maxflow: " + fordFulkersonEma.maxFlow(s, t));
		System.out.println("number of steps: " + fordFulkersonEma.steps());
	}


}
