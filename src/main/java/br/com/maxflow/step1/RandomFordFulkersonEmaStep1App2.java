package br.com.maxflow.step1;

import java.io.FileWriter;
import java.io.IOException;

import br.com.maxflow.algorithm.ema.RandomFordFulkersonEma;

public class RandomFordFulkersonEmaStep1App2 {
	
	public static void main(String[] args) throws IOException {	
		FileWriter fw = new FileWriter("RandomFordFulkersonEmaStep1App2.txt");
		
		for(int m = 15000; m < 125000; m += 5000) {
			int cap = 1000;
			
			RandomFordFulkersonEma randomFordFulkersonEma = new RandomFordFulkersonEma(m-1);
					
			int s = 0;
			int t = 3;
				
			randomFordFulkersonEma.createEdges(cap, m, s, t);
			
			randomFordFulkersonEma.maxFlow(s, t);
			
			System.out.println(m + "," + randomFordFulkersonEma.steps());
			
			fw.write(m + "," + randomFordFulkersonEma.steps() + "\n");
		}
		
		fw.close();
	}

}
