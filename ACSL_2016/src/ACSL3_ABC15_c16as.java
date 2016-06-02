import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ACSL3_ABC15_c16as {

	public static int[][] fill(int filled1, int filled2, int filled3, int filled4, int numgiven, String[] lettercords)
	{
		//		String[][] board = new String[][]{
		//				{"-","-","-","-","-","-"},
		//				{"-","-","-","-","-","-"},
		//				{"-","-","-","-","-","-"},
		//				{"-","-","-","-","-","-"},
		//				{"-","-","-","-","-","-"},
		//				{"-","-","-","-","-","-"}
		//			};

		int[][] board = new int[6][6];

		//creates board 
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				board[i][j] = (i+j)+1+(5*i);
			}
		}

		//		//prints board
		//	        for(int r=0; r<board.length; r++) {
		//	          for(int c=0; c<board[r].length; c++)
		//	              System.out.print(board[r][c] + " ");
		//	          System.out.println();
		//	        }

		//turns filled cells into 0s and stores their coords
		int rowcoord1 = 0;
		int colcoord1 = 0;
		int rowcoord2 = 0;
		int colcoord2 = 0;
		int rowcoord3 = 0;
		int colcoord3 = 0;
		int rowcoord4 = 0;
		int colcoord4 = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] == filled1)
				{
					board[i][j] = 0;
					rowcoord1 = i;
					colcoord1 = j;
				}
				else if(board[i][j] == filled2)
				{
					board[i][j] = 0;
					rowcoord2 = i;
					colcoord2 = j;
				}
				else if(board[i][j] == filled3)
				{
					board[i][j] = 0;
					rowcoord3 = i;
					colcoord3 = j;
				}
				else if(board[i][j] == filled4)
				{
					board[i][j] = 0;
					rowcoord4 = i;
					colcoord4 = j;
				}
			}
		}

		//	  //prints board with 0s
		//        for(int r=0; r<board.length; r++) {
		//          for(int c=0; c<board[r].length; c++)
		//              System.out.print(board[r][c] + " ");
		//          System.out.println();
		//        }




		int[] letterCoords = new int[2];

		for (int i = 0; i < numgiven*2; i++) 
		{
			if(i%2 == 1)
			{
				letterCoords = getCoords(Integer.parseInt(lettercords[i]));

				//    		   //debug prints letter coordinates 
				//    		   for (int k = 0; k < letterCoords.length; k++) {
				//    			   System.out.println(letterCoords[k]);
				//    		   }

				if(letterLocation(lettercords[i]) == 'L') 
				{
					for (int k = 0; k < 4; k++) 
					{
						if(board[letterCoords[0]][letterCoords[1]+1+k] != 0)
						{
							if(lettercords[i-1].equals("A")) board[letterCoords[0]][letterCoords[1]+1+k] = 37;
							else if(lettercords[i-1].equals("B")) board[letterCoords[0]][letterCoords[1]+1+k] = 38;
							else if(lettercords[i-1].equals("C")) board[letterCoords[0]][letterCoords[1]+1+k] = 39;
							break;
						}
					} 
				}//close "left" if 
				else if(letterLocation(lettercords[i]) == 'R')  
				{
					for (int k = 0; k < 4; k++) 
					{
						if(board[letterCoords[0]][letterCoords[1]-1-k] != 0)
						{
							if(lettercords[i-1].equals("A")) board[letterCoords[0]][letterCoords[1]-1-k] = 37;
							else if(lettercords[i-1].equals("B")) board[letterCoords[0]][letterCoords[1]-1-k] = 38;
							else if(lettercords[i-1].equals("C")) board[letterCoords[0]][letterCoords[1]-1-k] = 39;
							break;
						}
					}  	   
				}//close "right" if 
				else if(letterLocation(lettercords[i]) == 'A')
				{
					for (int k = 0; k < 4; k++) 
					{
						if(board[letterCoords[0]+1+k][letterCoords[1]] != 0)
						{
							if(lettercords[i-1].equals("A")) board[letterCoords[0]+1+k][letterCoords[1]] = 37;
							else if(lettercords[i-1].equals("B")) board[letterCoords[0]+1+k][letterCoords[1]] = 38;
							else if(lettercords[i-1].equals("C")) board[letterCoords[0]+1+k][letterCoords[1]] = 39;
							break;
						}
					}   
				}//close "above" if
				else if(letterLocation(lettercords[i]) == 'B') //check 
				{
					for (int k = 0; k < 4; k++) 
					{
						if(board[letterCoords[0]-1-k][letterCoords[1]] != 0)
						{
							if(lettercords[i-1].equals("A")) board[letterCoords[0]-1-k][letterCoords[1]] = 37;
							else if(lettercords[i-1].equals("B")) board[letterCoords[0]-1-k][letterCoords[1]] = 38;
							else if(lettercords[i-1].equals("C")) board[letterCoords[0]-1-k][letterCoords[1]] = 39;
							break;
						}
					}  
				}//close "below" if
			}//if that catches odd numbers 
		}//for loop that goes thru each given letter 

		//     //prints board
		//       for(int r=0; r<board.length; r++) {
		//         for(int c=0; c<board[r].length; c++)
		//             System.out.print(board[r][c] + " ");
		//         System.out.println();
		//       }

		return board;

	}//close fill function 

	public static int[][] completeBoard(int[][] prelimboard)
	{
//		//prints prelim board
//		for(int r=0; r<prelimboard.length; r++) {
//			for(int c=0; c<prelimboard[r].length; c++)
//				System.out.print(prelimboard[r][c] + " ");
//			System.out.println();
//		}
//		System.out.println("----------");

		//convert int array to string array (and it's smaller -- just the 4 by 4 playing board)
		String[][] gameBoard = new String[4][4];
		for(int i = 0; i < 4; i++){
			gameBoard[i] = new String[4];
			for(int j = 0; j < 4; j++){
				gameBoard[i][j] = Integer.toString(prelimboard[i+1][j+1]);
			}
		}

		//converts numbers to letters and dashes 
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length; j++) {
				if(gameBoard[i][j].equals("37")) gameBoard[i][j] = "1"; //A
				else if(gameBoard[i][j].equals("38")) gameBoard[i][j] = "2"; //B
				else if(gameBoard[i][j].equals("39")) gameBoard[i][j] = "3"; //C
				else if(gameBoard[i][j].equals("0")) gameBoard[i][j] = "4"; //filled spot
				else gameBoard[i][j] = "0";
			}
		}

		int[][] intGameBoard = new int[4][4];
		for (int i = 0; i < intGameBoard.length; i++) 
		{
			for (int j = 0; j < intGameBoard.length; j++) 
			{
				intGameBoard[i][j] = Integer.parseInt(gameBoard[i][j]);
			}
		}


		//	     //prints the board
		//	       for(int r=0; r<gameBoard.length; r++) {
		//	         for(int c=0; c<gameBoard[r].length; c++)
		//	             System.out.print(gameBoard[r][c] + " ");
		//	         System.out.println();
		//	       }

		return intGameBoard;


	}//close completeBoard function

	// dimension of input
	static int N = 4;

	/**
	 * Class to abstract the representation of a cell. Cell => (x, y)
	 */
	static class Cell {

		int row, col;

		public Cell(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Cell [row=" + row + ", col=" + col + "]";
		}
	};


	/**
	 * Utility function to check whether @param value is valid for @param cell
	 */
	static boolean isValid(Cell cell, int value, int[][] grid) {

		if (grid[cell.row][cell.col] != 0) {
			throw new RuntimeException(
					"Cannot call for cell which already has a value");
		}

		// if v present row, return false
		for (int c = 0; c < 4; c++) {
			if (grid[cell.row][c] == value)
				return false;
		}

		// if v present in col, return false
		for (int r = 0; r < 4; r++) {
			if (grid[r][cell.col] == value)
				return false;
		}

		// if value not present in row, col and bounding box, return true
		return true;
	}

	// simple function to get the next cell
	// read for yourself, very simple and straight forward
	static Cell getNextCell(Cell cur) {

		int row = cur.row;
		int col = cur.col;

		// next cell => col++
		col++;

		// if col > 8, then col = 0, row++
		// reached end of row, got to next row
		if (col > 3) {
			// goto next line
			col = 0;
			row++;
		}

		// reached end of matrix, return null
		if (row > 3)
			return null; // reached end

		Cell next = new Cell(row, col);
		return next;
	}

	// everything is put together here
	// very simple solution
	// must return true, if the soduku is solved, return false otherwise
	static boolean solve(Cell cur, int[][] grid) {

		// if the cell is null, we have reached the end
		if (cur == null)
			return true;

		// if grid[cur] already has a value, there is nothing to solve here,
		// continue on to next cell
		if (grid[cur.row][cur.col] != 0) {
			// return whatever is being returned by solve(next)
			// i.e the state of soduku's solution is not being determined by
			// this cell, but by other cells
			return solve(getNextCell(cur), grid);
		}

		// this is where each possible value is being assigned to the cell, and
		// checked if a solutions could be arrived at.

		// if grid[cur] doesn't have a value
		// try each possible value
		for (int i = 1; i <= 4; i++) {
			// check if valid, if valid, then update
			boolean valid = isValid(cur, i, grid);

			if (!valid) // i not valid for this cell, try other values
				continue;

			// assign here
			grid[cur.row][cur.col] = i;

			// continue with next cell
			boolean solved = solve(getNextCell(cur), grid);
			// if solved, return, else try other values
			if (solved)
				return true;
			else
				grid[cur.row][cur.col] = 0; // reset
			// continue with other possible values
		}

		// if you reach here, then no value from 1 - 9 for this cell can solve
		// return false
		return false;
	}

	// utility to print the grid
	static void printGrid(int grid[][]) {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++)
				System.out.print(grid[row][col]);
			System.out.println();
		}
	}


	public static char letterLocation(String lettercord)
	{
		int int_lettercord = Integer.parseInt(lettercord);
		char position = '\0'; //empty char
		if(int_lettercord % 6 == 1) // 7 thru 25
		{
			position = 'L'; //left side of board
		}
		else if(int_lettercord % 6 == 0) // 12 thru 30 
		{
			position = 'R'; //right side of board
		}
		else if(int_lettercord >= 2 && int_lettercord <= 5)
		{
			position = 'A'; //above board
		}
		else if(int_lettercord >= 32 && int_lettercord <= 35)
		{
			position = 'B'; //below board
		}

		return position; //spit out the char 

	}//close letterLocation function 

	public static int[] getCoords(int numberSpot)
	{
		int[][] board = new int[6][6];
		//creates board 
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				board[i][j] = (i+j)+1+(5*i);
			}
		}
		int theI = 0;
		int theJ = 0;
		int[] coords = new int[2];

		for ( int i = 0; i < 6; i++ ) {
			for ( int j = 0; j < 6; j++ ) {
				if (board[i][j] == numberSpot ) {
					theI = i;
					theJ = j;
				} 
			}
		}//close for
		coords[0] = theI;
		coords[1] = theJ;

		return coords;
	}//close getCoords function

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int filled1 = 0;
		int filled2 = 0;
		int filled3 = 0;
		int filled4 = 0;
		int numgiven = 0;
		String letter1 = "";
		String letter2 = "";
		String letter3 = "";
		String letter4 = "";
		int lettercord1 = 0;
		int lettercord2 = 0;
		int lettercord3 = 0;
		int lettercord4 = 0;

		for (int i = 0; i < 12; i++) {
			
			String[] input = scan.nextLine().split(", ");

			filled1 = Integer.parseInt(input[0]);
			filled2 = Integer.parseInt(input[1]);
			filled3 = Integer.parseInt(input[2]);
			filled4 = Integer.parseInt(input[3]);
			numgiven = Integer.parseInt(input[4]);

			String[] lettercords = Arrays.copyOfRange(input, 5, input.length); //makes array of the letters and their coords 


			//completeBoard(fill(filled1, filled2, filled3, filled4, numgiven, lettercords));

			int[][] grid = completeBoard(fill(filled1, filled2, filled3, filled4, numgiven, lettercords));
			boolean solved = solve(new Cell(0, 0), grid);
			//printGrid(grid); //call the function here that makes the grid 
			
			ArrayList<String> answer = new ArrayList<String>();

			//gets array from numbers to letters (getting ready to print it out)
			for (int j = 0; j < grid.length; j++) 
			{
				for (int k = 0; k < grid.length; k++) 
				{
					if(grid[j][k] == 1) answer.add("A");
					else if(grid[j][k] == 2) answer.add("B");
					else if(grid[j][k] == 3) answer.add("C");
				}
			}
			
			//prints final answer in correct format 
			for (int j = 0; j < answer.size(); j++) 
			{
				System.out.print(answer.get(j));
			}
			System.out.println();

		}//close for



	}//main








}//class 
