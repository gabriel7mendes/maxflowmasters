package br.com.maxflow.step1;

import java.io.IOException;

import br.com.maxflow.algorithm.ema.EdmondsKarpEma;

public class EdmondsKarpEmaStep1App1 {
	
	public static void main(String[] args) throws IOException {		
		int m = Integer.parseInt(args[0]);
		int cap = 1000;
		
		EdmondsKarpEma edmondsKarpEma = new EdmondsKarpEma(m-1);
				
		int s = 0;
		int t = 3;
			
		edmondsKarpEma.createEdges(cap, m, s, t);
		
		System.out.println("maxflow: " + edmondsKarpEma.maxFlow(s, t));
		System.out.println("number of steps: " + edmondsKarpEma.steps());
	}

}
