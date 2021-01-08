package br.com.maxflow.algorithm.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.ema.FordFulkersonEma;

public class FordFulkersonEmaApp2 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int m = 1000;
		int flow = sc.nextInt();
		
		FordFulkersonEma fordFulkersonEma = new FordFulkersonEma(m-1);
				
		int s = 0;
		int t = 3;
			
		fordFulkersonEma.createEdges(flow, m, s, t);
		
		System.out.println(fordFulkersonEma.maxFlow(s, t));
		
		sc.close();
	}

}
