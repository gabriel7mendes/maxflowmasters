package br.com.maxflow.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.ema.RandomFordFulkersonEma;

public class RandomFordFulkersonEmaApp3 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String fileName = sc.next();
		int k = Integer.parseInt(sc.next());
		
		RandomFordFulkersonEma randomFordFulkersonEma = new RandomFordFulkersonEma(k-1);
				
		int s = 0;
		int t = 3;
			
		randomFordFulkersonEma.createEdges(k, k, s, t);
		
		System.out.println("maxflow: " + randomFordFulkersonEma.maxFlow(s, t));
		System.out.println("number of steps: " + randomFordFulkersonEma.steps());
		
		FileWriter fw = new FileWriter(fileName);
		fw.write(randomFordFulkersonEma.steps() + "\n");
		fw.close();
		
		sc.close();
	}

}
