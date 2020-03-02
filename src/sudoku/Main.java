package sudoku;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisplaySudoku displaySudoku = new DisplaySudoku();
		int[][] grid = displaySudoku.createGrid(1);
		System.out.println( Arrays.deepToString(grid));
	}

}
