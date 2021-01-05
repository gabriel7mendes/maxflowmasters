package br.com.maxflow.algorithm.ema;

import org.junit.Assert;
import org.junit.Test;

public class RandomFordFulkersonEmaTest {

	@Test
	public void test() {
		int m = 1001;
		int flow = 1000;
		RandomFordFulkersonEma randomFordFulkersonEma = new RandomFordFulkersonEma(m-1);

		int s = 0;
		int t = 3;

		randomFordFulkersonEma.createEdges(flow, m, s, t);

		Assert.assertEquals(randomFordFulkersonEma.maxFlow(s, t), 2000);
	}

}
