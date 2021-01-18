package br.com.maxflow.time;

import java.io.FileWriter;
import java.io.IOException;

import br.com.maxflow.algorithm.ema.FordFulkersonEma;

public class FordFulkersonTimeApp2 {
	
	public static void main(String[] args) throws IOException {	
		FileWriter fw = new FileWriter("FordFulkersonTimeApp2.txt");
		
		for(int m= 15000; m < 125000; m+= 5000) {
			long begin = System.currentTimeMillis();
			
			int cap = 1000;
			
			FordFulkersonEma fordFulkersonEma = new FordFulkersonEma(m-1);
					
			int s = 0;
			int t = 3;
				
			fordFulkersonEma.createEdges(cap, m, s, t);
			
			fordFulkersonEma.maxFlow(s, t);
			
			long end = System.currentTimeMillis();
			
			System.out.println(m + "," + (end - begin));
			
			fw.write(m + "," + (end - begin) + "\n");
		}
		
		fw.close();
	}

}
