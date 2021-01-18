package br.com.maxflow.step2;

import java.io.FileWriter;
import java.io.IOException;

import br.com.maxflow.algorithm.ema.RandomFordFulkersonEma;

public class RandomFordFulkersonEmaStep2App2 {
	
	public static void main(String[] args) throws IOException {	
		FileWriter fw = new FileWriter("RandomFordFulkersonEmaStep2App2.txt");
		
		for(int cap= 15000; cap < 125000; cap += 5000) {
			int m = 1000;
			
			RandomFordFulkersonEma randomFordFulkersonEma = new RandomFordFulkersonEma(m-1);
					
			int s = 0;
			int t = 3;
				
			randomFordFulkersonEma.createEdges(cap, m, s, t);
			
			randomFordFulkersonEma.maxFlow(s, t);
			
			System.out.println(cap + "," + randomFordFulkersonEma.steps());
			
			fw.write(cap + "," + randomFordFulkersonEma.steps() + "\n");
		}
		
		fw.close();
	}


}
