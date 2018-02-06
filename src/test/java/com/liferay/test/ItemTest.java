package com.liferay.test;

import junit.framework.TestCase;

/**
 * @author Jan Brychta
 */
public class ItemTest  extends TestCase {
    /***
     * 0.01 - 0.04  ---> 0.05
     * 0.06 - 0.10 ----> 0.10
     * 0.11 - 0.15 ----> 0.15
     * 0.16 - 0.20 ----> 0.20
     */
    public void testRoundCountingResult(){
        Goods g = new Goods("test", 10d, false, false, 3);
        assertEquals(g.roundCountingResult(0.01), 0.05);
        assertEquals(g.roundCountingResult(0.02), 0.05);
        assertEquals(g.roundCountingResult(0.03), 0.05);
        assertEquals(g.roundCountingResult(0.04), 0.05);
        assertEquals(g.roundCountingResult(0.05), 0.05);
        assertEquals(g.roundCountingResult(0.06), 0.10);
        assertEquals(g.roundCountingResult(0.07), 0.10);
        assertEquals(g.roundCountingResult(0.08), 0.10);
        assertEquals(g.roundCountingResult(0.09), 0.10);
        assertEquals(g.roundCountingResult(0.10), 0.10);
        assertEquals(g.roundCountingResult(0.11), 0.15, 2);
        assertEquals(g.roundCountingResult(0.12), 0.15, 2);
        assertEquals(g.roundCountingResult(0.13), 0.15, 2);
        assertEquals(g.roundCountingResult(0.14), 0.15, 2);
        assertEquals(g.roundCountingResult(0.15), 0.15, 2);
    }
}
