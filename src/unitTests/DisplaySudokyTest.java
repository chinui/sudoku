package unitTests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import sudoku.DisplaySudoku;

class DisplaySudokyTest {

	@Test
	void IsA9x9Square() {
		DisplaySudoku displaySudoku = new DisplaySudoku();
		// On vérifie qu'on a bien un carré de 9x9
		int[][] square = displaySudoku.createGrid(1);
		Assert.assertEquals("Nombre de lignes", square.length, 9);

		if (square.length == 9) {
			for (int i = 0; i < square.length; i++) {
				Assert.assertEquals("Taille de la ligne " + i, 9, square[i].length);
			}
		}
	}

	@Test
	void IsARealSudoku() {
		// On vérifie après mélange, qu'il y a toujours les 9 premiers chiffres par
		// lignes et par colonnes.
		DisplaySudoku displaySudoku = new DisplaySudoku();

		// Grille de résultat attendu
		final boolean[][] allGood = { { true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true },
				{ true, true, true, true, true, true, true, true, true } };

		// Grille de départ pour les lignes
		boolean[][] rowCheck = { { false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false } };

		// Grille de départ pour les colonnes
		boolean[][] colunmCheck = { { false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false },
				{ false, false, false, false, false, false, false, false, false } };

		// On vérifie que chaque ligne contient les 9 chiffres
		// A chaque fois qu'un chiffre apparait sur une ligne, il fait passer son false
		// à true.
		// Exemple si grid[3][1] = 5, alors rowCheck[3][5] = true;
		int[][] grid = displaySudoku.createGrid(1);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int number = grid[i][j];
				rowCheck[i][number - 1] = true;
			}
		}

		// On vérifie que chaque colonne contient les 9 chiffres
		// A chaque fois qu'un chiffre apparait sur une colonnes, il fait passer son
		// false à true.
		// Exemple si grid[3][1] = 5, alors columnCheck[5][1] = true;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int number = grid[j][i];
				colunmCheck[number - 1][i] = true;
			}
		}

		Assert.assertArrayEquals("Tout les lignes ont les 9 chiffres", allGood, rowCheck);
		Assert.assertArrayEquals("Tout les colonnes ont les 9 chiffres", allGood, colunmCheck);

	}

}
