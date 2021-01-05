package br.com.maxflow.algorithm.ema;

import org.junit.Assert;
import org.junit.Test;

public class EdmondsKarpEmaTest {
	
	@Test
	public void test() {
		int m = 5;
		int flow = 1000;
		EdmondsKarpEma edmondsKarpEma = new EdmondsKarpEma(m-1);
				
		int s = 0;
		int t = 3;
			
		edmondsKarpEma.createEdges(flow, m, s, t);
		
		Assert.assertEquals(edmondsKarpEma.maxFlow(s, t), 2000);
	}


}
