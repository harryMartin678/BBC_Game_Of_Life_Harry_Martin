package bbc.codingtests.gameoflife.gamestate;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameStateTest {

	/*
	 * Tests whether indexing works
	 */
    @Test
    public void testParsing() {
        String input = ".*.\n*.*\n...";
        GameState testState = new Grid(input);
        assertTrue("Row 0, col 1 should be alive",testState.isCellAliveAt(0,1));
        assertFalse("Row 2, col 2 should not be alive",testState.isCellAliveAt(2,2));
    }

    /*
     * Tests whether given an input the grid has enough rows and columns
     */
    @Test
    public void testRowColCounts() {
        String input = "...\n***\n..*";
        GameState testState = new Grid(input);
        assertEquals("The game should have 3 columns", 3, testState.getCols());
        assertEquals("The game should have 3 rows", 3, testState.getRows());
    }
}
