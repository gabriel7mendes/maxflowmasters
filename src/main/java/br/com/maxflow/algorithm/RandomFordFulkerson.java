package br.com.maxflow.algorithm;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import br.com.datastructures.linkedlist.LinkedList;
import br.com.datastructures.stack.Stack;
import br.com.maxflow.graph.Edge;
import br.com.maxflow.graph.Graph;
import br.com.maxflow.graph.Node;

public class RandomFordFulkerson {

	protected long steps;
	protected Graph graph;
	private int sizeMaxPath;

	public RandomFordFulkerson(int n) {
		graph = new Graph(n);
		steps++;
	}

	public void addEdge(int from, int to, int cap) {
		graph.addEdge(from, to, cap);
		steps++;
	}

	private void randomAdjacencyList(Node v) {
		Random r = new Random();
		steps++;
		int n = v.edgesSize();
		steps++;

		if (v.getKey() == 1) {
			v.getEdges().printList();
		}

		for (int i = n - 1; i > 0; i--) {
			int j = r.nextInt(i + 1);
			steps++;

			Edge ei = v.getEdge(i);
			steps++;
			Edge ej = v.getEdge(j);
			steps++;
			v.setEdge(i, ej);
			steps++;
			v.setEdge(j, ei);
			steps++;

			if (v.getKey() == 1) {
				// System.out.println(j);
				// System.out.println(ei);
				// System.out.println(ej);
				v.getEdges().printList();
			}

		}
	}

	protected boolean hasPath(int source, int sink) {
		Stack<Node> stack = new Stack<>();
		steps++;

		stack.push(graph.getNode(source));
		steps++;

		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			steps++;

			//randomAdjacencyList(curr);
			//steps++;

			//System.out.print(curr + " ");

			for (int i = 0; i < curr.edgesSize(); i++) {
				Edge edge = curr.getEdge(i);
				steps++;
				if (graph.getParent(edge.getTo()) == null 
						&& edge.getTo() != source
						&& edge.getCapacity() > edge.getFlow()) {
					//System.out.println("isReverse " + edge.isReverse());
					graph.setParent(edge.getTo(), edge);
					stack.push(graph.getNode(edge.getTo()));
					steps += 2;
				}
			}
		}
		
		sizeMaxPath = 0;
		//System.out.println("caminho bom");
		for (Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
			//System.out.println(edge);
			sizeMaxPath++;
		}

		steps += stack.steps();

		if (graph.getParent(sink) == null) {
			steps++;
			return false;
		}

		steps++;
		return true;
	}
	
	public boolean randomPath2(int source, int sink) {
		Stack<Node> stack = new Stack<>();
		steps++;

		stack.push(graph.getNode(source));
		steps++;
int count = 0;
		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			steps++;
            //System.out.print(curr + " ");
			//randomAdjacencyList(curr);
			//steps++;

			// System.out.print("list of " + curr + ": ");
			Random r = new Random();
			int n = curr.edgesSize();
			
			int j = r.nextInt(n);
			Edge edge = curr.getEdge(j);
			steps++;
			if (graph.getParent(edge.getTo()) == null 
					&& edge.getTo() != source
					&& edge.getCapacity() > edge.getFlow()) {
				graph.setParent(edge.getTo(), edge);
				//System.out.println("****");
				//System.out.println(edge.isReverse());
				//System.out.println(edge);
				stack.push(graph.getNode(edge.getTo()));
				steps += 2;
				count = 0;
			} else if(curr.getKey() != sink){
				stack.push(curr);
				count++;
			}
			
			if(count > 100) {
				while(!stack.isEmpty()) {
					stack.pop();
				}
				graph.resetParent();
				stack.push(graph.getNode(source));
				count = 0;
			}
			/*
			for (int i = 0; i < curr.edgesSize(); i++) {				
				int j = r.nextInt(n);
				Edge edge = curr.getEdge(j);
				steps++;
				if (graph.getParent(edge.getTo()) == null 
						&& edge.getTo() != source
						&& edge.getCapacity() > edge.getFlow()) {
					graph.setParent(edge.getTo(), edge);
					stack.push(graph.getNode(edge.getTo()));
					steps += 2;
				}
			}*/

			//System.out.println();
		}

		steps += stack.steps();
		
		for (Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
			 System.out.print(edge.getTo() + " ");
			if(graph.getParent(edge.getFrom()) == null)
			   System.out.print(edge.getFrom() + " ");
		}
		
		System.out.println();

		if (graph.getParent(sink) == null) {
			steps++;
			return false;
		}

		steps++;
		return true;
	}
	
	/*public void randomPath(int source, int sink) {
		Random r = new Random();
		Node v = graph.getNode(source);
		Node w = graph.getNode(sink);
		
		Stack<Node> stack = new Stack<>();
		
		stack.push(graph.getNode(source));
		
		//boolean isVisited[] = new boolean[graph.nodesSize()];
		
		//isVisited[source] = true;
		
		int i = 0;
		int fudeu = 0;
		
		graph.resetParent();
		
		String msg = "";
		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			
			int n = curr.edgesSize();
			
			/*if(i >= n) {
				msg = "";
				i = 0;
				v = graph.getNode(source);
				graph.resetParent();
				//Arrays.fill(isVisited,false);
			}
			
			int j = r.nextInt(n);
			Edge edge = v.getEdge(j);
			Node x = graph.getNode(edge.getTo());
			if(graph.getParent(edge.getTo()) == null && edge.getTo() != source && edge.getCapacity() > edge.getFlow()) {
				graph.setParent(edge.getTo(), edge);
				msg += v + " ";
				//isVisited[x.getKey()] = true;
				v = x;	
				i = 0;
			} else {
			    i++;
			}
			
			fudeu++;
		}
		
		System.out.println(msg + v);
	}*/
	
	/*
	
	public void randomPath(int source, int sink) {
		Random r = new Random();
		Node v = graph.getNode(source);
		Node w = graph.getNode(sink);
		
		//boolean isVisited[] = new boolean[graph.nodesSize()];
		
		//isVisited[source] = true;
		
		int i = 0;
		int fudeu = 0;
		
		graph.resetParent();
		
		String msg = "";
		while(v != w) {		
			int n = v.edgesSize();
			if(i >= n) {
				msg = "";
				i = 0;
				v = graph.getNode(source);
				graph.resetParent();
				//Arrays.fill(isVisited,false);
			}
			
			int j = r.nextInt(n);
			Edge edge = v.getEdge(j);
			Node x = graph.getNode(edge.getTo());
			if(graph.getParent(edge.getTo()) == null && edge.getTo() != source && edge.getCapacity() > edge.getFlow()) {
				graph.setParent(edge.getTo(), edge);
				msg += v + " ";
				//isVisited[x.getKey()] = true;
				v = x;	
				i = 0;
			} else {
			    i++;
			}
			
			fudeu++;
		}
		
		System.out.println(msg + v);
		
	}
*/
	public int maxFlow(int source, int sink) {
		int maxFlow = 0;
		steps++;

		while (true) {
			graph.resetParent();
			steps++;

			if(!hasPath(source, sink))
				break;
			
			graph.resetParent();
			
			if(!randomPath2(source, sink))
				break;

			int df = Integer.MAX_VALUE;
			steps++;

			// System.out.print("path: " );

			for (Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
				 //System.out.print(edge.getTo() + " ");
				df = Math.min(df, edge.getCapacity() - edge.getFlow());
				System.out.println("df " + df);
				steps++;
				// System.out.println("min " + df);
				//if(graph.getParent(edge.getFrom()) == null)
				 //System.out.print(edge.getFrom() + " ");
			}

			//System.out.println();

			for (Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
				//System.out.println("edge.pushFlow(df)");
				//System.out.println(edge);
				edge.pushFlow(df);
				//System.out.println(edge);
				steps++;
			}
			
			maxFlow += df;
			System.out.println("maxFlow " + maxFlow);
			steps++;
		}

		steps++;
		return maxFlow;
	}

	public long steps() {
		return steps + graph.steps();
	}

}
