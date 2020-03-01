package sudoku;

public class DisplaySudoku {

	final static int EASY = 1;
	private int[][] square;

	public DisplaySudoku() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int[][] createSquare(int difficulty) {
		if(difficulty == EASY) {
			square = new int[][] {
	            {1, 5, 9, 3, 4, 6, 7, 2, 8},
	            {4, 6, 7, 8, 2, 1, 9, 5, 3},
	            {8, 2, 3, 7, 5, 9, 1, 4, 6},
	            {9, 3, 6, 1, 7, 5, 2, 8, 4},
	            {7, 1, 5, 4, 8, 2, 6, 3, 9},
	            {2, 8, 4, 6, 9, 3, 5, 7, 1},
	            {5, 9, 8, 2, 6, 4, 3, 1, 7},
	            {3, 4, 2, 9, 1, 7, 8, 6, 5},
	            {6, 7, 1, 5, 3, 8, 4, 9, 2}
	        };
			return square;
				
		}
		return null;
	}
}
