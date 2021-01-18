package br.com.maxflow.algorithm.ema;

import br.com.maxflow.algorithm.FordFulkerson;
import br.com.maxflow.graph.Edge;

public class FordFulkersonEma extends FordFulkerson {
	
	Edge[] parentsPath1 = new Edge[graph.nodesSize()];
	Edge[] parentsPath2 = new Edge[2];

	public FordFulkersonEma(int n) {
		super(n);
		steps++;
	}
	
	private void prepareWorstPath(int source, int sink) {
		parentsPath1[sink] = graph.getEdge(2, sink);
		steps++;
		parentsPath1[2] = graph.getEdge(1, 2);
		steps++;
		
		int m = graph.nodesSize() + 1;
		steps++;

		if (m > 5) {
			parentsPath1[1] = graph.getEdge(4, 1);
			steps++;

			for (int i = 4; i < (m-2); i++) {
				parentsPath1[i] = graph.getEdge(i+1, i);
				steps++;
			}
			
			parentsPath1[m-2] = graph.getEdge(source, m-2);
			steps++;
		} else {
			parentsPath1[1] = graph.getEdge(source, 1);
			steps++;
		}
		
		parentsPath2[0] = graph.getEdge(1, sink);
		steps++;
		parentsPath2[1] = graph.getEdge(2, 1);
		steps++;
	}

	protected void forceWorstPath(int aum, int source, int sink) {
		if (aum % 2 == 0) {
			graph.setParent(sink, parentsPath1[sink]);
			steps++;
			graph.setParent(2, parentsPath1[2]);	
			steps++;
			graph.setParent(1, parentsPath1[1]);
			steps++;
			
			int m = graph.nodesSize() + 1;
			steps++;
			
			if (m > 5) {
				for (int i = 4; i <= (m-2); i++) {
					graph.setParent(i, parentsPath1[i]);
					steps++;
				}
			}
		} else {
			graph.setParent(sink, parentsPath2[0]);
			steps++;
			graph.setParent(1, parentsPath2[1]);
			steps++;
		}
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
	
	@Override
	public int maxFlow(int source, int sink) {
		int maxFlow = 0;
		steps++;
		int augmentations = 0;
		steps++;
		
		prepareWorstPath(source, sink);
		steps++;

		while (true) {
			graph.resetParent();
			steps++;
		
			if (!hasPath(source, sink)) break;
			
			forceWorstPath(augmentations, source, sink);
			steps++;

			int df = Integer.MAX_VALUE;
			steps++;

            for(Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
            	df = Math.min(df, edge.getCapacity() - edge.getFlow());
            	steps++;
            }
            	
			
			for (Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
				edge.pushFlow(df);
				steps++;
			}
				
			maxFlow += df;
			steps++;
			augmentations++;
			steps++;
		}

		steps++;
		return maxFlow;
	}

}
