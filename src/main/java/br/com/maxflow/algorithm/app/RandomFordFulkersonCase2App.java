package br.com.maxflow.algorithm.app;

import java.io.IOException;
import java.util.Scanner;

import br.com.maxflow.algorithm.cases.RandomFordFulkersonCase;

public class RandomFordFulkersonCase2App {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		int flow = 1000;
		int m = Integer.parseInt(scanner.nextLine());

		RandomFordFulkersonCase randomFordFulkersonCase = new RandomFordFulkersonCase(m-1);		
		randomFordFulkersonCase.createEdges(flow, m, 0, 3);
		System.out.println("Max Flow: " + randomFordFulkersonCase.maxFlow(0, 3));
		
		scanner.close();
	}
	
}
