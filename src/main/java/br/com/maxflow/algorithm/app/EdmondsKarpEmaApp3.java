package br.com.maxflow.algorithm.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.ema.EdmondsKarpEma;

public class EdmondsKarpEmaApp3 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int flow = sc.nextInt();
		
		EdmondsKarpEma edmondsKarpEma = new EdmondsKarpEma(m-1);
				
		int s = 0;
		int t = 3;
			
		edmondsKarpEma.createEdges(flow, m, s, t);
		
		System.out.println("maxflow: " + edmondsKarpEma.maxFlow(s, t));
		
		sc.close();
	}

}
