package unitTests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import sudoku.DisplaySudoku;

class DisplaySudokyTest {

	@Test
	void IsA9x9Square() {
		DisplaySudoku displaySudoku = new DisplaySudoku();
		// On vérifie qu'on a bien un carré de 9x9
		int[][] square = displaySudoku.createSquare(1);
		Assert.assertEquals("Nombre de lignes", square.length, 9);

		if (square.length == 9) {
			for (int i = 0; i < square.length; i++) {
				Assert.assertEquals("Taille de la ligne " + i, 9, square[i].length);
			}
		}
	}

	@Test
	void IsARealSudoku() {
		DisplaySudoku displaySudoku = new DisplaySudoku();
		// On vérifie qu'il y a bien les 9 premiers chiffres par lignes et par colonnes
		final boolean[][] allGood = { { true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true } };
		
		boolean[][] rowCheck = { { false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false } };

		boolean[][] colunmCheck = { { false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false } };

		//On vérifie que chaque ligne contient les 9 chffres
		int[][] square = displaySudoku.createSquare(1);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int number = square[i][j];
				rowCheck[i][number - 1] = true;
			}
		}
		
		//On vérifie que chaque colonne contient les 9 chffres
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int number = square[j][i];
				colunmCheck[number - 1][i] = true;
			}
		}
		
		Assert.assertArrayEquals("Tout les lignes ont les 9 chiffres", allGood, rowCheck);
		Assert.assertArrayEquals("Tout les colonnes ont les 9 chiffres", allGood, colunmCheck);

	}

}
