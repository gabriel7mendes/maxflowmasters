package br.com.maxflow.step3;

import java.io.FileWriter;
import java.io.IOException;

import br.com.maxflow.algorithm.ema.EdmondsKarpEma;

public class EdmondsKarpEmaStep3App2 {
	
	public static void main(String[] args) throws IOException {	
		FileWriter fw = new FileWriter("EdmondsKarpEmaStep3App2.txt");
		
		for(int k = 1000;  k <= 20000;  k += 1000) {		
			EdmondsKarpEma edmondsKarpEma = new EdmondsKarpEma(k-1);
					
			int s = 0;
			int t = 3;
				
			edmondsKarpEma.createEdges(k, k, s, t);
			
			edmondsKarpEma.maxFlow(s, t);
			
			System.out.println(k + "," + edmondsKarpEma.steps());
			
			fw.write(k + "," + edmondsKarpEma.steps() + "\n");
		}
		
		fw.close();
	}

}
