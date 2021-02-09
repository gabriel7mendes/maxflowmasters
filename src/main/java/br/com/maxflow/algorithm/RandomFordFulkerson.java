package br.com.maxflow.algorithm;

import java.util.Random;

import br.com.datastructures.stack.Stack;
import br.com.maxflow.graph.Edge;
import br.com.maxflow.graph.Graph;
import br.com.maxflow.graph.Node;

public class RandomFordFulkerson {

	protected long steps;
	protected Graph graph;

	public RandomFordFulkerson(int n) {
		graph = new Graph(n);
		steps++;
	}

	public void addEdge(int from, int to, int cap) {
		graph.addEdge(from, to, cap);
		steps++;
	}

	protected boolean hasPath(int source, int sink) {
		Stack<Node> stack = new Stack<>();
		steps++;

		stack.push(graph.getNode(source));
		steps++;

		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			steps++;

			for (int i = 0; i < curr.edgesSize(); i++) {
				Edge edge = curr.getEdge(i);
				steps++;
				if (graph.getParent(edge.getTo()) == null 
						&& edge.getTo() != source
						&& edge.getCapacity() > edge.getFlow()) {
					graph.setParent(edge.getTo(), edge);
					stack.push(graph.getNode(edge.getTo()));
					steps += 2;
				}
			}
		}
		
		steps += stack.steps();
			
		if (graph.getParent(sink) == null) {
			steps++;
			return false;
		}

		steps++;
		return true;
	}
	
	public boolean randomPath(int source, int sink) {
		Stack<Node> stack = new Stack<>();
		steps++;

		stack.push(graph.getNode(source));
		steps++;
		
        int maxIter = 0;
        steps++;
        
		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			steps++;

			Random r = new Random();
			steps++;
			
			int n = curr.edgesSize();
			steps++;
			
			int j = r.nextInt(n);
			steps++;
			
			Edge edge = curr.getEdge(j);
			steps++;
			
			if (graph.getParent(edge.getTo()) == null 
					&& edge.getTo() != source
					&& edge.getCapacity() > edge.getFlow()) {
				graph.setParent(edge.getTo(), edge);
				stack.push(graph.getNode(edge.getTo()));
				maxIter = 0;
				steps += 3;
			} else if(curr.getKey() != sink){
				stack.push(curr);
				maxIter++;
				steps += 2;
			}
			
			if(maxIter > 100) {
				while(!stack.isEmpty()) {
					stack.pop();
					steps ++;
				}
				graph.resetParent();
				stack.push(graph.getNode(source));
				maxIter = 0;
				steps += 3;
			}
		}

		steps += stack.steps();
		
//		for (Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
//			System.out.println(edge); 
//		}
		
		if (graph.getParent(sink) == null) {
			steps++;
			return false;
		}

		steps++;
		return true;
	}
	
	public int maxFlow(int source, int sink) {
		int maxFlow = 0;
		steps++;

		while (true) {
			graph.resetParent();
			steps++;

			if(!hasPath(source, sink))
				break;
			
			graph.resetParent();
			steps++;
			
			if(!randomPath(source, sink))
				break;

			int df = Integer.MAX_VALUE;
			steps++;

			for (Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
				df = Math.min(df, edge.getCapacity() - edge.getFlow());
				steps++;
			}
			
			//System.out.println("df: " + df);
			//System.out.println("***********************");

			for (Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
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
