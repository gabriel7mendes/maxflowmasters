package br.com.maxflow.step2;

import java.io.FileWriter;
import java.io.IOException;

import br.com.maxflow.algorithm.ema.EdmondsKarpEma;

public class EdmondsKarpEmaStep2App2 {
	
	public static void main(String[] args) throws IOException {	
		FileWriter fw = new FileWriter("EdmondsKarpEmaStep2App2.txt");
		
		for(int cap = 15000; cap <= 125000; cap += 5000) {
			int m = 1000;
			
			EdmondsKarpEma edmondsKarpEma = new EdmondsKarpEma(m-1);
					
			int s = 0;
			int t = 3;
				
			edmondsKarpEma.createEdges(cap, m, s, t);
			
			edmondsKarpEma.maxFlow(s, t);
			
			System.out.println(cap + "," + edmondsKarpEma.steps());
			
			fw.write(cap + "," + edmondsKarpEma.steps() + "\n");
		}
		
		fw.close();
	}
}
