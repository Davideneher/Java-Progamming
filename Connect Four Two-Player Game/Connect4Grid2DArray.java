import java.util.Arrays;
public class Connect4Grid2DArray implements Connect4Grid{
	
	public int[][] grid = new int[7][6]; 
	public static final int ROW = 0;
	public static final int COL = 0;
	
	public void emptyGrid() {
		for (int row = 0; row < grid[ROW].length; row++) { 
            for (int col = 0; col < grid[COL].length; col++) {
                grid[row][col] = 0; 
                } 
            }
	}
	
	
	public String toString() {
		String output = " ________________ \n";
		for(int row = 0; row < grid[ROW].length; row++) {
			for(int col = 0; col < grid[COL].length; col++) {
				if(grid[row][col] == 0) {
					output += " 0 ";
				}
				else if (grid[row][col] == 1) {
					output += " X ";
				}
				else {
					output += " Y ";
				}
			}
			output += "\n";
		}
		output += " ________________ \n";
		return output;
	}
	
	
	public boolean isValidColumn(int column) {
		if (column<=7) {
			return true;
		}
		else return false;
	}
	
	
	public boolean isColumnFull(int column) {
		
		for (int row=0; row<7; row++) {
			if (grid[row][column] == 0) {
				return false;
			}
			else {
				return true;
			}
		}
		return true;
	}
	
	
	public void dropPiece(ConnectPlayer player, int column) {
		boolean placed = false;
		column -= 1;
		for(int row = grid[ROW].length - 1; (row >= 0) && (placed == false); row--) {
			if(grid[row][column] == 0) {
				grid[row][column] = player.getPlayerID();
				placed = true;
			}
		}
	}
	
	
	public boolean didLastPieceConnect4() {
		
		//horizontal
		for (int row = 0; row < grid.length; row++){
			for (int col = 0; col < grid[row].length - 3; col++){
			
				if (grid[row][col] != 0 && grid[row][col] == grid[row][col+1] &&
			grid[row][col] == grid[row][col+2] && grid[row][col] == grid[row][col
			+3]){
			return true;
				}
			}
		}
		
		// Check for win vertically
		for (int col = 0; col < grid[0].length; col++){
			for (int row = 0; row < grid.length - 3; row++){
				
				if (grid[row][col] != 0 && grid[row][col] == grid[row+1][col] &&
				grid[row][col] == grid[row+2][col] && grid[row][col] == grid[row+3][col]){
				return true;
				}
			}
		}
		
		// Check for win diagonally, from top left
		for (int row = 0; row < grid.length - 3; row++){
			for (int col = 0; col < grid[row].length - 3; col++){
					
				if (grid[row][col] != 0 && grid[row][col] == grid[row+1][col
				+1] && grid[row][col] == grid[row+2][col+2] && grid[row][col] ==
				grid[row+3][col+3]){
				return true;
				}
			}
		}
		
		// Check for win diagonally, from top right
		for (int row = 0; row < grid.length - 3; row++){
			for (int col = 3; col < grid[row].length; col++){
					
				if (grid[row][col] != 0 && grid[row][col] == grid[row+1]
				[col-1] && grid[row][col] == grid[row+2][col-2] && grid[row]
				[col] == grid[row+3][col-3]){
				return true;
				}
			}
		}
		return false;
	}
	
	
	public boolean isGridFull() {
		boolean isFull = true;
		for(int row = 0; (row < grid[ROW].length) && (isFull == true); row++) {
			for(int col = 0; (col < grid[COL].length) && (isFull == true); col++) {
				if(grid[row][col] == 1 || grid[row][col] == 2) {
					isFull = true;
				}
				else {
					isFull = false;
				}
			}
		}
		return isFull;
	}
}
