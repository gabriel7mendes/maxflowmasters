package br.com.maxflow.step2;

import java.io.FileWriter;
import java.io.IOException;

import br.com.maxflow.algorithm.ema.FordFulkersonEma;

public class FordFulkersonEmaStep2App2 {
	
	public static void main(String[] args) throws IOException {	
		FileWriter fw = new FileWriter("FordFulkersonEmaStep2App2.txt");
		
		for(int cap= 15000; cap < 125000; cap += 5000) {
			int m = 1000;
			
			FordFulkersonEma fordFulkersonEma = new FordFulkersonEma(m-1);
					
			int s = 0;
			int t = 3;
				
			fordFulkersonEma.createEdges(cap, m, s, t);
			
			fordFulkersonEma.maxFlow(s, t);
			
			System.out.println(cap + "," + fordFulkersonEma.steps());
			
			fw.write(cap + "," + fordFulkersonEma.steps() + "\n");
		}
		
		fw.close();
	}

}
