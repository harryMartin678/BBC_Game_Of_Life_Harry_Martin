package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.Grid;

public class GameOfLifeRules implements Life {

	private int[] lc = new int[]{1,0,-1,0,0,1,0,-1,1,1,1,-1,-1,1,-1,-1};
	
	/*
	 * (non-Javadoc)
	 * @see bbc.codingtests.gameoflife.Life#evolve(bbc.codingtests.gameoflife.gamestate.GameState)
	 * 
	 * Applies game of life rules to a game state
	 */
	public GameState evolve(GameState currentState) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		//go through every cell in the state
		for(int row = 0; row < currentState.getRows(); row++){
			for(int col = 0; col < currentState.getCols(); col++){

				int noOfNeighbours = 0;
				//check the number of live neighbours this cell has, once 4 neighbours have been counted then there
				//is no point counting more
				for(int l = 0; l < lc.length && noOfNeighbours < 4; l+=2){
					
					//if this neighbours is in bounds of the grid and is alive then it is an neighbour
					if(inBounds(row + lc[l],col + lc[l+1],currentState.getRows(),currentState.getCols())
							&& currentState.isCellAliveAt(row + lc[l], col + lc[l+1])){
						
						noOfNeighbours++;
					}
				}
				
				//apply the game of life rules to this cell based on the number of neighbours
				//it has 
				if(applyRules(currentState.isCellAliveAt(row, col),noOfNeighbours)){
					
					sb.append("*");
				
				}else{
					
					sb.append(".");
				}
			}
			sb.append("\n");
		}
		
		//return the state as a grid with the last \n removed
		return new Grid(sb.substring(0,sb.length()-1));
	}
	

	/*
	 * @Param isCurrentlyAlive whether the cell is currently alive or not
	 * @Param noOfNeighbours how many neighbours the cell has  
	 * @Return whether the cell is alive or not
	 */
	private boolean applyRules(boolean isCurrentlyAlive,int noOfNeighbours){
		
		if(noOfNeighbours < 2 || noOfNeighbours > 3){
			
			return false;
		
		}else if(noOfNeighbours == 2 && isCurrentlyAlive){
			
			return true;
		
		}else if(noOfNeighbours == 3){
			
			return true;
		}
		
		return false;
	}
	
	private boolean inBounds(int x, int y, int width, int height){
		
		return x >= 0 && x < width && y >= 0 && y < height;
	}
	


}
