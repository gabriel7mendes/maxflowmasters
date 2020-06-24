package br.com.maxflow.algorithm.app;

import br.com.maxflow.algorithm.EdmondsKarp;

public class EdmondsKarpApp1 {

	public static void main(String[] args) {
		EdmondsKarp edmondsKarp = new EdmondsKarp(7); 
		
		edmondsKarp.addEdge(0, 1, 3);
		edmondsKarp.addEdge(0, 3, 3);
		edmondsKarp.addEdge(1, 2, 4);
		edmondsKarp.addEdge(2, 0, 3);
		edmondsKarp.addEdge(2, 3, 1);
		edmondsKarp.addEdge(2, 4, 2);
		edmondsKarp.addEdge(3, 4, 2);
		edmondsKarp.addEdge(3, 5, 6);
		edmondsKarp.addEdge(4, 6, 1);
		edmondsKarp.addEdge(5, 6, 9);
		
        System.out.println("Max Flow: " + edmondsKarp.maxFlow(0, 6));
	}

}
