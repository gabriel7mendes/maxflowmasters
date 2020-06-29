package br.com.maxflow.algorithm.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.cases.EdmondsKarpCase;

public class EdmondsKarpCase1App {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
        
		int flow = Integer.parseInt(scanner.nextLine());
		int m = 500000;

		EdmondsKarpCase edmondsKarpCase = new EdmondsKarpCase(m-1);	
		edmondsKarpCase.createEdges(flow, m, 0, 3);	
		System.out.println("Max Flow: " + edmondsKarpCase.maxFlow(0, 3));

		scanner.close();
	}
	
}
