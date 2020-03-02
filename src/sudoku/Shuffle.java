package sudoku;

/*  
 * Le but de cette classe est de d'intervertir les lignes et les colonnes d'un sudoku
 * pour ainsi en créer un nouveau, sans créer de doublon dans les lignes, les colonnes et les cases.
 */
public class Shuffle {

	/*
	 * On va utiliser toutes les autres méthodes codées ci-dessous pour mélanger
	 * notre grille de sudoku.
	 */
	public void shuffling(int[][] grid) {
		
		// On va mélanger au maximum 100 fois
		int shufflingNumber = (int) (Math.random() * 100);
		for (int i = 0; i < shufflingNumber; i++) {

			// On choisit une méthode de mélange au hasard parmi les 4
			int shufflingChoice = (int) (Math.random() * 3);
			if (shufflingChoice == 0) {
				// Les lignes vont de 0 à 8.
				int row1 = (int) (Math.random() * 8);
				int row2 = row1 + 1;
				if (!((row1 >= 0 && row1 <= 2 && row2 >= 0 && row2 <= 2)
						|| (row1 >= 3 && row1 <= 5 && row2 >= 3 && row2 <= 5)
						|| (row1 >= 6 && row1 <= 8 && row2 >= 6 && row2 <= 8))) {
					row2 = row1 - 1;

				}
				rowInterchange(grid, row1, row2);
			} else if (shufflingChoice == 1) {
				// Les colonnes vont de 0 à 8.
				int column1 = (int) (Math.random() * 8);
				int column2 = column1 + 1;
				if (!((column1 >= 0 && column1 <= 2 && column2 >= 0 && column2 <= 2)
						|| (column1 >= 3 && column1 <= 5 && column2 >= 3 && column2 <= 5)
						|| (column1 >= 6 && column1 <= 8 && column2 >= 6 && column2 <= 8))) {
					column2 = column1 - 1;

				}
				columnInterchange(grid, column1, column2);
			} else if (shufflingChoice == 2) {
				// Les neuf lignes sont regroupées par groupe de 3
				int bigRow1 = (int) (Math.random() * 2);
				int bigRow2 = bigRow1 + 1;
				if (bigRow2 > 2) {
					bigRow2 = bigRow1 - 1;
				}
				bigRowInterchange(grid, bigRow1, bigRow2);
			} else {
				// Les neuf colonnes sont regroupées par groupe de 3
				int bigColumn1 = (int) (Math.random() * 2);
				int bigColumn2 = bigColumn1 + 1;
				if (bigColumn2 > 2) {
					bigColumn2 = bigColumn1 - 1;
				}
				bigColumnInterchange(grid, bigColumn1, bigColumn2);
			}
		}

	}

	/*
	 * Dans un sudoku, il est possible d'intervertir les lignes d'un même trio : Les
	 * lignes 1, 2 et 3 peuvent être interverties, les lignes 4, 5, 6 aussi Mais les
	 * lignes 3 et 4 ne peuvent l'être.
	 */
	public void rowInterchange(int[][] grid, int row1, int row2) {

		if ((row1 >= 0 && row1 <= 2 && row2 >= 0 && row2 <= 2) || (row1 >= 3 && row1 <= 5 && row2 >= 3 && row2 <= 5)
				|| (row1 >= 6 && row1 <= 8 && row2 >= 6 && row2 <= 8)) {

			// On intervertit deux lignes.
			for (int j = 0; j < 9; j++) {
				int tempRow = grid[row1][j];
				grid[row1][j] = grid[row2][j];
				grid[row2][j] = tempRow;
			}
		} else {
			System.out.println("rowInterchange : les paramètres d'entrée ne sont pas bons.");
		}
	}

	// Même principe que la méthode au-dessus mais avec les colonnes.
	public void columnInterchange(int[][] grid, int column1, int column2) {

		if ((column1 >= 0 && column1 <= 2 && column2 >= 0 && column2 <= 2)
				|| (column1 >= 3 && column1 <= 5 && column2 >= 3 && column2 <= 5)
				|| (column1 >= 6 && column1 <= 8 && column2 >= 6 && column2 <= 8)) {

			// On intervertit deux colonnes
			for (int i = 0; i < 9; i++) {
				int tempColumn = grid[i][column1];
				grid[i][column1] = grid[i][column2];
				grid[i][column2] = tempColumn;
			}
		} else {
			System.out.println("colunmInterchange : les paramètres d'entrée ne sont pas bons.");
		}
	}

	/*
	 * Dans la même veine que précédemment, il est possible d'intervertir les lignes
	 * par groupe de 3 : On peut par exemple intervertir les lignes 1,2 et 3 avec
	 * respectivement les lignes 4, 5, 6.
	 */
	public void bigRowInterchange(int[][] grid, int bigRow1, int bigRow2) {

		if (bigRow1 >= 0 && bigRow1 <= 2 && bigRow2 >= 0 && bigRow2 <= 2) {
			// On intervertit les lignes 3 par 3.
			int row1a = bigRow1 * 3 + 0;
			int row1b = bigRow1 * 3 + 1;
			int row1c = bigRow1 * 3 + 2;

			int row2a = bigRow2 * 3 + 0;
			int row2b = bigRow2 * 3 + 1;
			int row2c = bigRow2 * 3 + 2;
			for (int j = 0; j < 9; j++) {

				int tempRow = grid[row1a][j];
				grid[row1a][j] = grid[row2a][j];
				grid[row2a][j] = tempRow;

				tempRow = grid[row1b][j];
				grid[row1b][j] = grid[row2b][j];
				grid[row2b][j] = tempRow;

				tempRow = grid[row1c][j];
				grid[row1c][j] = grid[row2c][j];
				grid[row2c][j] = tempRow;
			}
		} else {
			System.out.println("bigRowInterchange : les paramètres d'entrée ne sont pas bons.");
		}
	}

	// Même principe que la méthode au-dessus mais avec les colonnes.
	public void bigColumnInterchange(int[][] grid, int bigColumn1, int bigColumn2) {

		if (bigColumn1 >= 0 && bigColumn1 <= 2 && bigColumn2 >= 0 && bigColumn2 <= 2) {
			// On intervertit les colonnes 3 par 3.
			int column1a = bigColumn1 * 3 + 0;
			int column1b = bigColumn1 * 3 + 1;
			int column1c = bigColumn1 * 3 + 2;

			int column2a = bigColumn2 * 3 + 0;
			int column2b = bigColumn2 * 3 + 1;
			int column2c = bigColumn2 * 3 + 2;
			for (int i = 0; i < 9; i++) {

				int tempColumn = grid[i][column1a];
				grid[i][column1a] = grid[i][column2a];
				grid[i][column2a] = tempColumn;

				tempColumn = grid[i][column1b];
				grid[i][column1b] = grid[i][column2b];
				grid[i][column2b] = tempColumn;

				tempColumn = grid[i][column1c];
				grid[i][column1c] = grid[i][column2c];
				grid[i][column2c] = tempColumn;
			}
		} else {
			System.out.println("bigColumnInterchange : les paramètres d'entrée ne sont pas bons.");
		}
	}
}
