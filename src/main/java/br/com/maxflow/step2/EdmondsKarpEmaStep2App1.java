package br.com.maxflow.step2;

import java.io.IOException;

import br.com.maxflow.algorithm.ema.EdmondsKarpEma;

public class EdmondsKarpEmaStep2App1 {
	
	public static void main(String[] args) throws IOException {		
		int m = 1000;
		int cap = Integer.parseInt(args[0]);
		
		EdmondsKarpEma edmondsKarpEma = new EdmondsKarpEma(m-1);
				
		int s = 0;
		int t = 3;
			
		edmondsKarpEma.createEdges(cap, m, s, t);
		
		System.out.println("maxflow: " + edmondsKarpEma.maxFlow(s, t));
		System.out.println("number of steps: " + edmondsKarpEma.steps());
	}


}
