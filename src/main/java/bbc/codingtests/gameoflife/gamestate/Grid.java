package bbc.codingtests.gameoflife.gamestate;

public class Grid implements GameState {

	private String[] rows;
	private String gridStr;
	
	/*
	 * @Param input string which represents the grid
	 */
	public Grid(String input){
		
		this.gridStr = input;
		//divide the grids into it's rows so it can be accessed like an array
		this.rows = input.split("\n");
		
	}
	

	/*
	 * (non-Javadoc)
	 * @see bbc.codingtests.gameoflife.gamestate.GameState#isCellAliveAt(int, int)
	 */
	public boolean isCellAliveAt(int row, int col) {
		// TODO Auto-generated method stub
		//System.out.println("Indices: " + row + " " + col + " Size: " + rows.length + " " + rows[0].length());
		return rows[row].charAt(col) == '*';
	}

	/*
	 * (non-Javadoc)
	 * @see bbc.codingtests.gameoflife.gamestate.GameState#getRows()
	 */
	public int getRows() {
		// TODO Auto-generated method stub
		return rows.length;
	}

	/*
	 * (non-Javadoc)
	 * @see bbc.codingtests.gameoflife.gamestate.GameState#getCols()
	 */
	public int getCols() {
		// TODO Auto-generated method stub
		return rows[0].length();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return gridStr;
	}
	
	

}
