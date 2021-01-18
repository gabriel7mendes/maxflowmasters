package br.com.maxflow.step3;

import java.io.FileWriter;
import java.io.IOException;

import br.com.maxflow.algorithm.ema.FordFulkersonEma;

public class FordFulkersonEmaStep3App2 {
	
	public static void main(String[] args) throws IOException {	
		FileWriter fw = new FileWriter("FordFulkersonEmaStep3App2.txt");
		
		for(int k = 1000;  k <= 20000;  k += 1000) {		
			FordFulkersonEma fordFulkersonEma = new FordFulkersonEma(k-1);
					
			int s = 0;
			int t = 3;
				
			fordFulkersonEma.createEdges(k, k, s, t);
			
			fordFulkersonEma.maxFlow(s, t);
			
			System.out.println(k + "," + fordFulkersonEma.steps());
			
			fw.write(k + "," + fordFulkersonEma.steps() + "\n");
		}
		
		fw.close();
	}

}
