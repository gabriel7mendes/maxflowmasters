package br.com.maxflow.algorithm.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.ema.FordFulkersonEma;

public class FordFulkersonEmaApp1 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int flow = 1000;
		
		FordFulkersonEma fordFulkersonEma = new FordFulkersonEma(m-1);
				
		int s = 0;
		int t = 3;
			
		fordFulkersonEma.createEdges(flow, m, s, t);
		
		System.out.println(fordFulkersonEma.maxFlow(s, t));
		
		sc.close();
	}

}
