package br.com.maxflow.algorithm.app;

import java.io.IOException;

import br.com.maxflow.algorithm.EdmondsKarp;

public class EdmondsKarpApp {

	public static void main(String[] args) throws IOException {
		int m = 10;
		EdmondsKarp edmondsKarp = new EdmondsKarp(m-1);
		
		int s = 0;
		int t = 5;
		
		edmondsKarp.addEdge(s, 1, 16);
		edmondsKarp.addEdge(s, 2, 13);
		edmondsKarp.addEdge(1, 2, 10);
		edmondsKarp.addEdge(2, 1, 4);
		edmondsKarp.addEdge(1, 3, 12);
		edmondsKarp.addEdge(2, 4, 14);
		edmondsKarp.addEdge(3, 2, 9);
		edmondsKarp.addEdge(3, t, 20);
		edmondsKarp.addEdge(4, 3, 7);
		edmondsKarp.addEdge(4, t, 4);
		
		System.out.println(edmondsKarp.maxFlow(s, t));
	}
	
}
