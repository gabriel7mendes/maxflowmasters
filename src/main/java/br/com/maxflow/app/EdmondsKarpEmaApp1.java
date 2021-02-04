package br.com.maxflow.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.ema.EdmondsKarpEma;

public class EdmondsKarpEmaApp1 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String fileName = sc.next();
		int m = Integer.parseInt(sc.next());
		int cap = 1000;
		
		EdmondsKarpEma edmondsKarpEma = new EdmondsKarpEma(m-1);
				
		int s = 0;
		int t = 3;
			
		edmondsKarpEma.createEdges(cap, m, s, t);
		
		System.out.println("maxflow: " + edmondsKarpEma.maxFlow(s, t));
		System.out.println("number of steps: " + edmondsKarpEma.steps());
		
		FileWriter fw = new FileWriter(fileName);
		fw.write(edmondsKarpEma.steps() + "\n");
		fw.close();
	
		sc.close();
	}
	
}
