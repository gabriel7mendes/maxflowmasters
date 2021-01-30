package br.com.maxflow.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.ema.FordFulkersonEma;

public class FordFulkersonEmaApp1 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String fileName = args[0];
		int m = sc.nextInt();
		int cap = 1000;
		
		FordFulkersonEma fordFulkersonEma = new FordFulkersonEma(m-1);
				
		int s = 0;
		int t = 3;
			
		fordFulkersonEma.createEdges(cap, m, s, t);
		
		System.out.println("maxflow: " + fordFulkersonEma.maxFlow(s, t));
		System.out.println("number of steps: " + fordFulkersonEma.steps());
		
		FileWriter fw = new FileWriter(fileName);
		fw.write(fordFulkersonEma.steps() + "\n");
		fw.close();
		
		sc.close();
	}

}
