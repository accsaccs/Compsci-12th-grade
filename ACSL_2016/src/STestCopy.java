
public class STestCopy {
	
	
	static int UNASSIGNED = 0;
	/* Takes a partially filled-in grid and attempts to assign values to
	  all unassigned locations in such a way to meet the requirements
	  for Sudoku solution (non-duplication across rows, columns, and boxes) */
	public static boolean SolveSudoku(int[][] grid)
	{
	    int row = 0;
	    int col = 0;
	 
	    // If there is no unassigned location, we are done
	    if (!FindUnassignedLocation(grid, row, col))
	       return true; // success!
	 
	    // consider digits 1 to 4
	    for (int num = 1; num <= 4; num++)
	    {
	        // if looks promising
	        if (isSafe(grid, row, col, num))
	        {
	            // make tentative assignment
	            grid[row][col] = num;
	 
	            // return, if success, yay!
	            if (SolveSudoku(grid))
	                return true;
	 
	            // failure, unmake & try again
	            grid[row][col] = UNASSIGNED;
	        }
	    }
	    return false; // this triggers backtracking
	}
	 
	/* Searches the grid to find an entry that is still unassigned. If
	   found, the reference parameters row, col will be set the location
	   that is unassigned, and true is returned. If no unassigned entries
	   remain, false is returned. */
	public static boolean FindUnassignedLocation(int[][] grid, int row, int col)
	{
	    for (row = 0; row < 4; row++)
	        for (col = 0; col < 4; col++)
	            if (grid[row][col] == UNASSIGNED) return true;
	    return false;
	}
	 
	/* Returns a boolean which indicates whether any assigned entry
	   in the specified row matches the given number. */
	public static boolean UsedInRow(int[][] grid, int row, int num)
	{
	    for (int col = 0; col < 4; col++)
	        if (grid[row][col] == num)
	            return true;
	    return false;
	}
	 
	/* Returns a boolean which indicates whether any assigned entry
	   in the specified column matches the given number. */
	public static boolean UsedInCol(int[][] grid, int col, int num)
	{
	    for (int row = 0; row < 4; row++)
	        if (grid[row][col] == num)
	            return true;
	    return false;
	}
	 
	/* Returns a boolean which indicates whether any assigned entry
	   within the specified 3x3 box matches the given number. */
//	public static boolean UsedInBox(int[][] grid, int boxStartRow, int boxStartCol, int num)
//	{
//	    for (int row = 0; row < 2; row++)
//	        for (int col = 0; col < 2; col++)
//	            if (grid[row+boxStartRow][col+boxStartCol] == num)
//	                return true;
//	    return false;
//	}
	 
	/* Returns a boolean which indicates whether it will be legal to assign
	   num to the given row,col location. */
	public static boolean isSafe(int[][] grid, int row, int col, int num)
	{
	    /* Check if 'num' is not already placed in current row,
	       current column and current 3x3 box */
	    return !UsedInRow(grid, row, num) &&
	           !UsedInCol(grid, col, num); // &&
	           //!UsedInBox(grid, row - row%2 , col - col%2, num);
	}
	 
	 /* A utility function to print grid  */
	//prints the board
	public static void printGrid(int[][] grid)
	{
	    for (int row = 0; row < 4; row++)
	    {
	       for (int col = 0; col < 4; col++)
	       {
	    	   System.out.print(grid[row][col] + " ");
	       }
	       System.out.println();
	    }
	}
	 
	/* Driver Program to test above functions */
	public static void main(String[] args) 
	{
	    // 0 means unassigned cells
	    int[][] grid = new int[][] {
	    				  {1, 4, 0, 0},
	                      {0, 0, 3, 4},
	                      {3, 0, 4, 0},
	                      {4, 0, 0, 0}};
	    if (SolveSudoku(grid) == true)
	          printGrid(grid);
	    else
	         System.out.println(("No solution exists"));
	 
	}
}
