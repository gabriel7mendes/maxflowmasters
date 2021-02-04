package br.com.maxflow.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.ema.FordFulkersonEma;

public class FordFulkersonEmaApp3 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String fileName = sc.next();
		int k = Integer.parseInt(sc.next());
		
		FordFulkersonEma fordFulkersonEma = new FordFulkersonEma(k-1);
				
		int s = 0;
		int t = 3;
			
		fordFulkersonEma.createEdges(k, k, s, t);
		
		System.out.println("maxflow: " + fordFulkersonEma.maxFlow(s, t));
		System.out.println("number of steps: " + fordFulkersonEma.steps());
		
		FileWriter fw = new FileWriter(fileName);
		fw.write(fordFulkersonEma.steps() + "\n");
		fw.close();
		
		sc.close();
	}

}
