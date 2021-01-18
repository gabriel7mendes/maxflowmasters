package br.com.maxflow.algorithm.ema;

import br.com.maxflow.algorithm.RandomFordFulkerson;

public class RandomFordFulkersonEma extends RandomFordFulkerson {

	public RandomFordFulkersonEma(int n) {
		super(n);
		steps++;
	}
	
	public void createEdges(int cap, int m, int source, int sink) {		
		addEdge(1, sink, cap);
		steps++;
		addEdge(source, 2, cap);
		steps++;
		addEdge(1, 2, 1);
		steps++;
		addEdge(2, sink, cap);
		steps++;
		
		if (m > 5) {
			addEdge(4, 1, cap);
			steps++;
			
			for (int i = 4; i < (m-2); i++) {
				addEdge(i+1, i, cap);
				steps++;
			}
			
			addEdge(source, m-2, cap);
			steps++;
		} else {
			addEdge(source, 1, cap);
			steps++;
		}
	}

}
