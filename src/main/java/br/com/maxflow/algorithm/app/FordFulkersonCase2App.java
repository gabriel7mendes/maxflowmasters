package br.com.maxflow.algorithm.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.cases.FordFulkersonCase;

public class FordFulkersonCase2App {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		int flow = 1000;
		int m = Integer.parseInt(scanner.nextLine());

		FordFulkersonCase fordFulkersonCase = new FordFulkersonCase(m-1);	
		fordFulkersonCase.createEdges(flow, m, 0, 3);		
		System.out.println("Max Flow: " + fordFulkersonCase.maxFlow(0, 3));

		scanner.close();
	}

}
