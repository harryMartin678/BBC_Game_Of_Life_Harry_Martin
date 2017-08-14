package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.Grid;

import org.junit.Test;

import static org.junit.Assert.*;

public class LifeTest {

	//TODO make this test pass
	@Test
	public void Scenario0() {
		String emptyStateInput = "...\n...\n...";

		Life testLife = new GameOfLifeRules();
		GameState emptyState = new Grid(emptyStateInput);
		GameState nextState = testLife.evolve(emptyState);
		assertEquals("An empty grid should stay the same", emptyStateInput, nextState.toString());
	}

	//TODO implement further tests for the other cases in the instructions
	
	/*
	 * Scenario 1: One or zero neighbour causes a cell to die 
	 */
	@Test
	public void Scenario1(){
		
		String oneNeighInput = ".**\n...\n...";
		
		GameState emptyState = new Grid("...\n...\n...");
		GameState oneState = new Grid(oneNeighInput);
		Life testLife = new GameOfLifeRules();
		GameState nextStateOne = testLife.evolve(oneState);
		assertEquals("Should be empty",emptyState.toString(), nextStateOne.toString());
		
		String noNeighInput = "...\n.*.\n...";
		
		GameState noNeighState = new Grid(noNeighInput);
		GameState nextStateNo = testLife.evolve(noNeighState);
		
		assertEquals("Should be empty",emptyState.toString(), nextStateNo.toString());
	}
	
	/*
	 * Scenario 2: four neighbours cause a cell to die 
	 */
	@Test
	public void Scenario2(){
		
		String fourNeighInput = ".*.\n***\n.*.";
		Life testLife = new GameOfLifeRules();
		GameState nextState = testLife.evolve(new Grid(fourNeighInput));
		assertEquals("Incorrect Result",false, nextState.isCellAliveAt(1, 1));
	}
	
	/*
	 * Scenario 3: Two or three neighbours cause a cell to survive
	 */
	@Test
	public void Scenario3(){
		
		String threeNeighInput = "...\n***\n.*.";
		String twoNeighInput = "...\n***\n...";
		Life testLife = new GameOfLifeRules();
		GameState threeNeighState = testLife.evolve(new Grid(threeNeighInput));
		GameState twoNeighState = testLife.evolve(new Grid(twoNeighInput));
		assertEquals("Incorrect Result",true, threeNeighState.isCellAliveAt(1, 1));
		assertEquals("Incorrect Result",true, twoNeighState.isCellAliveAt(1, 1));
	}
	
	/*
	 * Scenario 4: Three neighbours cause a cell to come alive
	 */
	@Test
	public void Scenario4(){
		
		String threeNeighEmptyInput = "...\n*.*\n.*.";
		Life testLife = new GameOfLifeRules();
		GameState threeNeighState = testLife.evolve(new Grid(threeNeighEmptyInput));
		assertEquals("Incorrect Result",true, threeNeighState.isCellAliveAt(1, 1));
	}
	
	/*
	 * Scenario 5: Is a repeat of scenario 0
	 */
	@Test
	public void Scenario5(){
		
		Scenario0();
	}
	
	/*
	 * Scenario 6: Game of life rules produce .*.\n.*.\n.*. from ...\n***\n...
	 */
	@Test
	public void Scenario6(){
		
		String intialStateStr = "...\n***\n...";
		String target = ".*.\n.*.\n.*.";
		Life testLife = new GameOfLifeRules();
		GameState intialState = new Grid(intialStateStr);
		GameState nextState = testLife.evolve(intialState);
		assertEquals("Incorrect Result",target, nextState.toString());
		GameState backtoIntital = testLife.evolve(nextState);
		assertEquals("Incorrect Result",intialStateStr, backtoIntital.toString());
	}
	
}
