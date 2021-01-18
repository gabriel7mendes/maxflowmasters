package br.com.maxflow.step1;

import java.io.FileWriter;
import java.io.IOException;

import br.com.maxflow.algorithm.ema.EdmondsKarpEma;

public class EdmondsKarpEmaStep1App2 {
	
	public static void main(String[] args) throws IOException {	
		FileWriter fw = new FileWriter("EdmondsKarpEmaStep1App2.txt");
		
		for(int m = 15000; m <= 125000; m += 5000) {
			int cap = 1000;
			
			EdmondsKarpEma edmondsKarpEma = new EdmondsKarpEma(m-1);
					
			int s = 0;
			int t = 3;
				
			edmondsKarpEma.createEdges(cap, m, s, t);
			
			edmondsKarpEma.maxFlow(s, t);
			
			System.out.println(m + "," + edmondsKarpEma.steps());
			
			fw.write(m + "," + edmondsKarpEma.steps() + "\n");
		}
		
		fw.close();
	}

}
