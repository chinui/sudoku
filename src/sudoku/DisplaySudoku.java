package sudoku;

public class DisplaySudoku {

	final static int EASY = 1;

	public DisplaySudoku() {
		super();
		// TODO Auto-generated constructor stub
	}

	//La difficulté sera implémenté plus tard.
	//Pour l'instant, on n'utilise que le sudoku "EASY".
	public int[][] createGrid(int difficulty) {
		Shuffle shuffle = new Shuffle();
		int[][] grid;
		if (difficulty == EASY) {
			grid = new int[][] { { 1, 5, 9, 3, 4, 6, 7, 2, 8 }, { 4, 6, 7, 8, 2, 1, 9, 5, 3 },
					{ 8, 2, 3, 7, 5, 9, 1, 4, 6 }, { 9, 3, 6, 1, 7, 5, 2, 8, 4 }, { 7, 1, 5, 4, 8, 2, 6, 3, 9 },
					{ 2, 8, 4, 6, 9, 3, 5, 7, 1 }, { 5, 9, 8, 2, 6, 4, 3, 1, 7 }, { 3, 4, 2, 9, 1, 7, 8, 6, 5 },
					{ 6, 7, 1, 5, 3, 8, 4, 9, 2 } };

		} else {
			// A noter que ce sudoku est issue d'un mélange du premier ci-dessus.
			grid = new int[][] { { 2, 1, 8, 3, 9, 5, 6, 4, 7 }, { 5, 9, 7, 6, 1, 4, 2, 8, 3 },
					{ 4, 6, 3, 8, 7, 2, 5, 1, 9 }, { 3, 8, 5, 2, 4, 9, 7, 6, 1 }, { 1, 7, 9, 5, 8, 6, 4, 3, 2 },
					{ 6, 4, 2, 7, 3, 1, 9, 5, 8 }, { 8, 2, 4, 9, 6, 3, 1, 7, 5 }, { 7, 5, 1, 4, 2, 8, 3, 9, 6 },
					{ 9, 3, 6, 1, 5, 7, 8, 2, 4 } };

		}
		
		shuffle.shuffling(grid);

		return grid;
	}
}
