package br.com.maxflow.step3;

import java.io.FileWriter;
import java.io.IOException;

import br.com.maxflow.algorithm.ema.RandomFordFulkersonEma;

public class RandomFordFulkersonEmaStep3App2 {
	
	public static void main(String[] args) throws IOException {	
		FileWriter fw = new FileWriter("RandomFordFulkersonEmaStep3App2.txt");
		
		for(int k = 1000;  k <= 20000;  k += 1000) {		
			RandomFordFulkersonEma randomFordFulkersonEma = new RandomFordFulkersonEma(k-1);
					
			int s = 0;
			int t = 3;
				
			randomFordFulkersonEma.createEdges(k, k, s, t);
			
			randomFordFulkersonEma.maxFlow(s, t);
			
			System.out.println(k + "," + randomFordFulkersonEma.steps());
			
			fw.write(k + "," + randomFordFulkersonEma.steps() + "\n");
		}
		
		fw.close();
	}


}
