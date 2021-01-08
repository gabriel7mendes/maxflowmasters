package br.com.maxflow.algorithm.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.ema.RandomFordFulkersonEma;

public class RandomFordFulkersonEmaApp1 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int flow = 1000;
		
		RandomFordFulkersonEma randomFordFulkersonEma = new RandomFordFulkersonEma(m-1);
				
		int s = 0;
		int t = 3;
			
		randomFordFulkersonEma.createEdges(flow, m, s, t);
		
		System.out.println(randomFordFulkersonEma.maxFlow(s, t));
		
		sc.close();
	}

}
