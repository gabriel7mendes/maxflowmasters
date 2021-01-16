package br.com.maxflow.algorithm.ema;

import br.com.maxflow.algorithm.FordFulkerson;
import br.com.maxflow.graph.Edge;

public class FordFulkersonEma extends FordFulkerson {
	
	Edge[] parentsPath1 = new Edge[graph.nodesSize()];
	Edge[] parentsPath2 = new Edge[2];

	public FordFulkersonEma(int n) {
		super(n);
	}
	
	private void prepareWorstPath(int source, int sink) {
		parentsPath1[sink] = graph.getEdge(2, sink);
		parentsPath1[2] = graph.getEdge(1, 2);
		
		int m = graph.nodesSize() + 1;

		if (m > 5) {
			parentsPath1[1] = graph.getEdge(4, 1);
			
			for (int i = 4; i < (m-2); i++) {
				parentsPath1[i] = graph.getEdge(i+1, i);
			}
			
			parentsPath1[m-2] = graph.getEdge(source, m-2);
		} else {
			parentsPath1[1] = graph.getEdge(source, 1);
		}
		
		parentsPath2[0] = graph.getEdge(1, sink);
		parentsPath2[1] = graph.getEdge(2, 1);
	}

	protected void forceWorstPath(int count, int source, int sink) {
		if (count % 2 == 0) {
			graph.setParent(sink, parentsPath1[sink]);
			graph.setParent(2, parentsPath1[2]);				
			graph.setParent(1, parentsPath1[1]);
			
			int m = graph.nodesSize() + 1;
			
			if (m > 5) {
				for (int i = 4; i <= (m-2); i++) {
					graph.setParent(i, parentsPath1[i]);
				}
			}
		} else {
			graph.setParent(sink, parentsPath2[0]);
			graph.setParent(1, parentsPath2[1]);
		}
	}

	public void createEdges(int cap, int m, int source, int sink) {
		addEdge(1, sink, cap);
		addEdge(source, 2, cap);
		addEdge(1, 2, 1);
		addEdge(2, sink, cap);
		
		if (m > 5) {
			addEdge(4, 1, cap);
			
			for (int i = 4; i < (m-2); i++) {
				addEdge(i+1, i, cap);
			}
			
			addEdge(source, m-2, cap);
		} else {
			addEdge(source, 1, cap);
		}
	}
	
	@Override
	public int maxFlow(int source, int sink) {
		int maxFlow = 0;
		int count = 0;
		
		prepareWorstPath(source, sink);

		while (true) {
			graph.resetParent();
		
			if (!hasPath(source, sink)) break;
			
			forceWorstPath(count, source, sink);

			int df = Integer.MAX_VALUE;

            for(Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) 
            	df = Math.min(df, edge.getCapacity() - edge.getFlow());
			
			for (Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom()))
				edge.pushFlow(df);

			maxFlow += df;
			count++;
		}

		return maxFlow;
	}

}
