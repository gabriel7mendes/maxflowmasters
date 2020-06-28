package br.com.maxflow.algorithm.app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.maxflow.algorithm.EdmondsKarp;

public class EdmondsKarpApp2 {
	
	private static long totalTime;
	private static FileWriter arq;
	private static PrintWriter gravarArq;
	
	public static void writeFile() throws IOException  {
		arq = new FileWriter("edmondskarp.txt");
		gravarArq = new PrintWriter(arq);
        	
		int m = 3000000;
		for (int flow = 3000; flow <= 100000; flow+=3000) {
			long startTime = System.currentTimeMillis();
			
			EdmondsKarp edmondsKarp = new EdmondsKarp(m-1);
			
			edmondsKarp.addEdge(0, 1, flow);
			edmondsKarp.addEdge(0, 2, flow);
			edmondsKarp.addEdge(1, 2, 1);
			edmondsKarp.addEdge(1, 3, flow);
			edmondsKarp.addEdge(2, 3, flow);
	        
	        System.out.println("Max Flow: " + edmondsKarp.maxFlow(0, 3));
				
			long endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			System.out.println("Time (in ms): " + totalTime);
			System.out.println("-------------------------");
			
			gravarArq.printf(flow + "," + totalTime + "\n");
		}
		
		arq.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		writeFile();
	}
	
}
