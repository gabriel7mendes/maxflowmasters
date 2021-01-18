package br.com.maxflow.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.ema.RandomFordFulkersonEma;

public class RandomFordFulkersonEmaApp2 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int m = 1000;
		int cap = sc.nextInt();
		
		RandomFordFulkersonEma randomFordFulkersonEma = new RandomFordFulkersonEma(m-1);
				
		int s = 0;
		int t = 3;
			
		randomFordFulkersonEma.createEdges(cap, m, s, t);
		
		System.out.println("maxflow: " + randomFordFulkersonEma.maxFlow(s, t));
		
		sc.close();
	}

}
