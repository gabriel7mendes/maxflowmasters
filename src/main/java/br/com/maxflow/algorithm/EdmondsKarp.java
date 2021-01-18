package br.com.maxflow.algorithm;

import br.com.datastructures.queue.Queue;
import br.com.maxflow.graph.Edge;
import br.com.maxflow.graph.Graph;
import br.com.maxflow.graph.Node;

public class EdmondsKarp {
	
	protected long steps;
	private Graph graph;

	public EdmondsKarp(int n) {
		graph = new Graph(n); 
		steps++;
	}
	 	
	public void addEdge(int from, int to, int cap) {
		graph.addEdge(from, to, cap);
		steps++;
	}
	
	protected boolean hasPath(int source, int sink) {
		Queue<Node> queue = new Queue<>();
		steps++;
	    
		queue.enqueue(graph.getNode(source));
		steps++;
	   
		while(!queue.isEmpty()) {			
			Node curr = queue.dequeue();
			steps++;
			
			for(int i=0; i < curr.edgesSize(); i++) {
				Edge edge = curr.getEdge(i);
				steps++;
				
				if(graph.getParent(edge.getTo()) == null
			    && edge.getTo() != source 
			    && edge.getCapacity() > edge.getFlow()) {
					graph.setParent(edge.getTo(), edge);
					queue.enqueue(graph.getNode(edge.getTo()));
					steps+=2;
				}
			}
		}
		
		steps += queue.steps();
		
		if(graph.getParent(sink) == null) {
			steps++;
			return false;
		}
		
		steps++;
		return true;
	}
	
	public int maxFlow(int source, int sink) {
		int maxFlow = 0;
		steps++;
		
		while(true)
		{
			graph.resetParent();
			steps++;
			
			if (!hasPath(source,sink)) 
                break;
			
        	int df = Integer.MAX_VALUE;
        	steps++;
        	
        	for(Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
        		df = Math.min(df, edge.getCapacity() - edge.getFlow());
        		steps++;
        	}
       		    
	       	for(Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
	       		edge.pushFlow(df);
	       		steps++;
	       	}
	    
        	maxFlow += df;
        	steps++;
		}
		
		steps++;
		return maxFlow;
	}
	
	public long steps() {
		return steps + graph.steps();
	}

}
