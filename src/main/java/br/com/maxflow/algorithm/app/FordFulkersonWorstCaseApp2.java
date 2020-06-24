package br.com.maxflow.algorithm.app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.maxflow.algorithm.worstcase.FordFulkersonWorstCase;

public class FordFulkersonWorstCaseApp2 {
	
	private static long totalTime;
	private static FileWriter arq;
	private static PrintWriter gravarArq;
	
	public static void writeFile() throws IOException  {
		arq = new FileWriter("fordfulkerson.txt");
		gravarArq = new PrintWriter(arq);
        	
		int m = 1000;
		for (int flow = 3000; flow <= 100000; flow+=3000) {
			long startTime = System.currentTimeMillis();
			
			FordFulkersonWorstCase fordFulkersonWorstCase = new FordFulkersonWorstCase(m-1);
	        
			fordFulkersonWorstCase.createEdges(flow, m, 0, 3);
			
	        System.out.println("Max Flow: " + fordFulkersonWorstCase.maxFlow(0, 3));
				
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
