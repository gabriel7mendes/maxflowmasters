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
				if (graph.getParent(edge.getTo()) == null && edge.getTo() != source
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
		Node sourceNode = graph.getNode(source);
		steps++;

		Node curr = sourceNode;
		steps++;

		Node node = null;
		steps++;

		int maxIter = 0;
		steps++;

		while (curr != null) {
			Random r = new Random();
			steps++;

			int n = curr.edgesSize();
			steps++;

			int j = r.nextInt(n);
			steps++;

			Edge edge = curr.getEdge(j);
			steps++;

			if (graph.getParent(edge.getTo()) == null && edge.getTo() != source
					&& edge.getCapacity() > edge.getFlow()) {
				int to = edge.getTo();
				steps++;

				graph.setParent(to, edge);
				steps++;

				Node nodeTo = graph.getNode(to);
				steps++;

				curr = nodeTo;
				steps++;

				maxIter = 0;
				steps++;
			} else {
				if (curr.getKey() != sink) {
					maxIter++;
					steps++;

					if (node == null) {
						node = curr;
						steps++;
					}

				} else {
					curr = null;
					steps++;
				}
			}

			if (maxIter > 100) {
				if (node != null && !sourceNode.equals(node)) {
					Edge parent = node.getParent();
					steps++;

					int from = parent.getFrom();
					steps++;

					Node nodeFrom = graph.getNode(from);
					steps++;

					curr = nodeFrom;
					steps++;

					node = nodeFrom;
					steps++;

					int to = parent.getTo();
					steps++;

					graph.setParent(to, null);
					steps++;
				} else {
					graph.resetParent();
					steps++;

					curr = sourceNode;
					steps++;
				}

				maxIter = 0;
				steps++;
			}
		}

		/*
		 * for (Edge edge = graph.getParent(sink); edge != null; edge =
		 * graph.getParent(edge.getFrom())) { System.out.println(edge); }
		 */
		
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

			if (!hasPath(source, sink))
				break;

			graph.resetParent();
			steps++;

			if (!randomPath(source, sink))
				break;

			int df = Integer.MAX_VALUE;
			steps++;

			for (Edge edge = graph.getParent(sink); edge != null; edge = graph.getParent(edge.getFrom())) {
				df = Math.min(df, edge.getCapacity() - edge.getFlow());
				steps++;
			}

			/*
			 * System.out.println("df: " + df); System.out.println();
			 * System.out.println("******************************************");
			 * System.out.println();
			 */

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
