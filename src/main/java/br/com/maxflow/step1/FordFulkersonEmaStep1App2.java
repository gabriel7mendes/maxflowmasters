package br.com.maxflow.step1;

import java.io.FileWriter;
import java.io.IOException;

import br.com.maxflow.algorithm.ema.FordFulkersonEma;

public class FordFulkersonEmaStep1App2 {
	
	public static void main(String[] args) throws IOException {	
		FileWriter fw = new FileWriter("FordFulkersonEmaStep1App2.txt");
		
		for(int m= 15000; m < 125000; m += 5000) {
			int cap = 1000;
			
			FordFulkersonEma fordFulkersonEma = new FordFulkersonEma(m-1);
					
			int s = 0;
			int t = 3;
				
			fordFulkersonEma.createEdges(cap, m, s, t);
			
			fordFulkersonEma.maxFlow(s, t);
			
			System.out.println(m + "," + fordFulkersonEma.steps());
			
			fw.write(m + "," + fordFulkersonEma.steps() + "\n");
		}
		
		fw.close();
	}

}
