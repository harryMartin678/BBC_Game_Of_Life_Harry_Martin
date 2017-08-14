package bbc.codingtests.gameoflife.gamestate;

public interface GameState {
    /**
     * Whether the cell at the given row and column is alive or not
     * Should return false if the coordinates are outside the grid
     * @param row
     * @param col
     * @return
     */
    public boolean isCellAliveAt(int row, int col);

    /**
     * @return Number of rows the game has
     */
    public int getRows();

    /**
     * @return Number of columns the game has
     */
    public int getCols();
}
