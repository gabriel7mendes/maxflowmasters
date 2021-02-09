package br.com.maxflow.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.ema.RandomFordFulkersonEma;

public class RandomFordFulkersonEmaApp1 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		//String fileName = sc.next();
		//int m = Integer.parseInt(sc.next());
		int m = 5;
		int cap = 1000;
		
		RandomFordFulkersonEma randomFordFulkersonEma = new RandomFordFulkersonEma(m-1);
				
		int s = 0;
		int t = 3;
		randomFordFulkersonEma.createEdges(cap, m, s, t);
		//randomFordFulkersonEma.randomPath(s, t);
		/*
		int s = 0;
		int t = 5;
		
		randomFordFulkersonEma.addEdge(s, 1, 16);
		randomFordFulkersonEma.addEdge(s, 2, 13);
		randomFordFulkersonEma.addEdge(1, 2, 10);
		randomFordFulkersonEma.addEdge(2, 1, 4);
		randomFordFulkersonEma.addEdge(1, 3, 12);
		randomFordFulkersonEma.addEdge(2, 4, 14);
		randomFordFulkersonEma.addEdge(3, 2, 9);
		randomFordFulkersonEma.addEdge(3, t, 20);
		randomFordFulkersonEma.addEdge(4, 3, 7);
		randomFordFulkersonEma.addEdge(4, t, 4);
		*/
		
		//randomFordFulkersonEma.printAllPaths();
		System.out.println("maxflow: " + randomFordFulkersonEma.maxFlow(s, t));
		//System.out.println("number of steps: " + randomFordFulkersonEma.steps());
		
		//FileWriter fw = new FileWriter(fileName);
		//fw.write(randomFordFulkersonEma.steps() + "\n");
		//fw.close();
		
		sc.close();
	}

}
