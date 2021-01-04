package br.com.maxflow.algorithm.app;

import java.io.IOException;

import br.com.maxflow.algorithm.RandomFordFulkerson;

public class RandomFordFulkersonApp {
	
	public static void main(String[] args) throws IOException {
		int m = 10;
		RandomFordFulkerson randomFordFulkerson = new RandomFordFulkerson(m-1);
		
		int s = 0;
		int t = 5;
		
		randomFordFulkerson.addEdge(s, 1, 16);
		randomFordFulkerson.addEdge(s, 2, 13);
		randomFordFulkerson.addEdge(1, 2, 10);
		randomFordFulkerson.addEdge(2, 1, 4);
		randomFordFulkerson.addEdge(1, 3, 12);
		randomFordFulkerson.addEdge(2, 4, 14);
		randomFordFulkerson.addEdge(3, 2, 9);
		randomFordFulkerson.addEdge(3, t, 20);
		randomFordFulkerson.addEdge(4, 3, 7);
		randomFordFulkerson.addEdge(4, t, 4);
		
		System.out.println(randomFordFulkerson.maxFlow(s, t));
	}

}
