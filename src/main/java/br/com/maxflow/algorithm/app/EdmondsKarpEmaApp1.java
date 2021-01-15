package br.com.maxflow.algorithm.app;

import java.io.IOException;

import br.com.maxflow.algorithm.ema.EdmondsKarpEma;

public class EdmondsKarpEmaApp1 {

	public static void main(String[] args) throws IOException {
		int m = Integer.parseInt(args[0]);
		int flow = 1000;
		
		EdmondsKarpEma edmondsKarpEma = new EdmondsKarpEma(m-1);
				
		int s = 0;
		int t = 3;
			
		edmondsKarpEma.createEdges(flow, m, s, t);
		
		System.out.println("maxflow: " + edmondsKarpEma.maxFlow(s, t));
	}
	
}
