package unitTests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import sudoku.Shuffle;

class ShuffleTest {

	@Test
	void isShufflingTest() {
		Shuffle shuffle = new Shuffle();
		int[][] originalGrid = { { 1, 5, 9, 3, 4, 6, 7, 2, 8 }, { 4, 6, 7, 8, 2, 1, 9, 5, 3 },
				{ 8, 2, 3, 7, 5, 9, 1, 4, 6 }, { 9, 3, 6, 1, 7, 5, 2, 8, 4 }, { 7, 1, 5, 4, 8, 2, 6, 3, 9 },
				{ 2, 8, 4, 6, 9, 3, 5, 7, 1 }, { 5, 9, 8, 2, 6, 4, 3, 1, 7 }, { 3, 4, 2, 9, 1, 7, 8, 6, 5 },
				{ 6, 7, 1, 5, 3, 8, 4, 9, 2 } };

		int[][] grid = { { 1, 5, 9, 3, 4, 6, 7, 2, 8 }, { 4, 6, 7, 8, 2, 1, 9, 5, 3 },
				{ 8, 2, 3, 7, 5, 9, 1, 4, 6 }, { 9, 3, 6, 1, 7, 5, 2, 8, 4 }, { 7, 1, 5, 4, 8, 2, 6, 3, 9 },
				{ 2, 8, 4, 6, 9, 3, 5, 7, 1 }, { 5, 9, 8, 2, 6, 4, 3, 1, 7 }, { 3, 4, 2, 9, 1, 7, 8, 6, 5 },
				{ 6, 7, 1, 5, 3, 8, 4, 9, 2 } };
		
		shuffle.shuffling(originalGrid);

		// On vérifie après mélange, qu'il y a toujours les 9 premiers chiffres par lignes et par colonnes
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

		// On vérifie que chaque ligne contient les 9 chiffres
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int number = grid[i][j];
				rowCheck[i][number - 1] = true;
			}
		}

		// On vérifie que chaque colonne contient les 9 chiffres
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int number = grid[j][i];
				colunmCheck[number - 1][i] = true;
			}
		}

		Assert.assertArrayEquals("Tout les lignes ont les 9 chiffres", allGood, rowCheck);
		Assert.assertArrayEquals("Tout les colonnes ont les 9 chiffres", allGood, colunmCheck);
		
		Assert.assertNotEquals("Les deux grilles doivent être différentes, car l'une a été mélangée.", originalGrid, grid);
	}

	@Test
	void areRowsInterchangedTest() {
		// On teste que l'inversion de lignes marche bien.
		Shuffle shuffle = new Shuffle();
		int[][] originalGrid = { { 1, 5, 9, 3, 4, 6, 7, 2, 8 }, { 4, 6, 7, 8, 2, 1, 9, 5, 3 },
				{ 8, 2, 3, 7, 5, 9, 1, 4, 6 }, { 9, 3, 6, 1, 7, 5, 2, 8, 4 }, { 7, 1, 5, 4, 8, 2, 6, 3, 9 },
				{ 2, 8, 4, 6, 9, 3, 5, 7, 1 }, { 5, 9, 8, 2, 6, 4, 3, 1, 7 }, { 3, 4, 2, 9, 1, 7, 8, 6, 5 },
				{ 6, 7, 1, 5, 3, 8, 4, 9, 2 } };

		int[] originalRow0 = new int[9];
		int[] originalRow1 = new int[9];

		int row0 = 0;
		int row1 = 1;

		for (int j = 0; j < 9; j++) {
			originalRow0[j] = originalGrid[row0][j];
			originalRow1[j] = originalGrid[row1][j];
		}
		shuffle.rowInterchange(originalGrid, row0, row1);

		int[] interchangeRow0 = new int[9];
		int[] interchangeRow1 = new int[9];
		for (int j = 0; j < 9; j++) {
			interchangeRow0[j] = originalGrid[row0][j];
			interchangeRow1[j] = originalGrid[row1][j];
		}

		assertArrayEquals("Interversion de la première ligne", originalRow0, interchangeRow1);
		assertArrayEquals("Interversion de la deuxième ligne", originalRow1, interchangeRow0);
	}

	@Test
	void areNotRowsInterchangedTest() {
		// On teste que l'inversion de lignes ne marchent pas
		// quand on demande de changer de mauvaises lignes
		Shuffle shuffle = new Shuffle();
		int[][] originalGrid = { { 1, 5, 9, 3, 4, 6, 7, 2, 8 }, { 4, 6, 7, 8, 2, 1, 9, 5, 3 },
				{ 8, 2, 3, 7, 5, 9, 1, 4, 6 }, { 9, 3, 6, 1, 7, 5, 2, 8, 4 }, { 7, 1, 5, 4, 8, 2, 6, 3, 9 },
				{ 2, 8, 4, 6, 9, 3, 5, 7, 1 }, { 5, 9, 8, 2, 6, 4, 3, 1, 7 }, { 3, 4, 2, 9, 1, 7, 8, 6, 5 },
				{ 6, 7, 1, 5, 3, 8, 4, 9, 2 } };

		int[][] newGrid = originalGrid;
		int row2 = 2;
		int row3 = 3;
		shuffle.rowInterchange(newGrid, row2, row3);

		assertArrayEquals("La grille n'a pas bougé", originalGrid, newGrid);
	}

	@Test
	void areColumnsInterchangedTest() {
		// On teste que l'inversion de colonnes marche bien.
		Shuffle shuffle = new Shuffle();
		int[][] originalGrid = { { 1, 5, 9, 3, 4, 6, 7, 2, 8 }, { 4, 6, 7, 8, 2, 1, 9, 5, 3 },
				{ 8, 2, 3, 7, 5, 9, 1, 4, 6 }, { 9, 3, 6, 1, 7, 5, 2, 8, 4 }, { 7, 1, 5, 4, 8, 2, 6, 3, 9 },
				{ 2, 8, 4, 6, 9, 3, 5, 7, 1 }, { 5, 9, 8, 2, 6, 4, 3, 1, 7 }, { 3, 4, 2, 9, 1, 7, 8, 6, 5 },
				{ 6, 7, 1, 5, 3, 8, 4, 9, 2 } };

		int[] originalColumn7 = new int[9];
		int[] originalColumn8 = new int[9];

		int column7 = 7;
		int column8 = 8;

		for (int i = 0; i < 9; i++) {
			originalColumn7[i] = originalGrid[i][column7];
			originalColumn8[i] = originalGrid[i][column8];
		}
		shuffle.columnInterchange(originalGrid, column7, column8);

		int[] interchangeColumn7 = new int[9];
		int[] interchangeColumn8 = new int[9];
		for (int i = 0; i < 9; i++) {
			interchangeColumn7[i] = originalGrid[i][column7];
			interchangeColumn8[i] = originalGrid[i][column8];
		}

		assertArrayEquals("Interversion de la huitième colonne", originalColumn7, interchangeColumn8);
		assertArrayEquals("Interversion de la neufième colonne", originalColumn8, interchangeColumn7);
	}

	@Test
	void areNotColumnsInterchangedTest() {
		// On teste que l'inversion de colonnes ne marchent pas
		// quand on demande de changer de mauvaises colonnes
		Shuffle shuffle = new Shuffle();
		int[][] originalGrid = { { 1, 5, 9, 3, 4, 6, 7, 2, 8 }, { 4, 6, 7, 8, 2, 1, 9, 5, 3 },
				{ 8, 2, 3, 7, 5, 9, 1, 4, 6 }, { 9, 3, 6, 1, 7, 5, 2, 8, 4 }, { 7, 1, 5, 4, 8, 2, 6, 3, 9 },
				{ 2, 8, 4, 6, 9, 3, 5, 7, 1 }, { 5, 9, 8, 2, 6, 4, 3, 1, 7 }, { 3, 4, 2, 9, 1, 7, 8, 6, 5 },
				{ 6, 7, 1, 5, 3, 8, 4, 9, 2 } };

		int[][] newGrid = originalGrid;
		int column2 = 2;
		int column6 = 6;
		shuffle.columnInterchange(newGrid, column2, column6);

		assertArrayEquals("La grille ne doit pas changer", originalGrid, newGrid);
	}

	@Test
	void areBigRowsInterchangedTest() {
		// On teste que l'inversion de lignes marche bien.
		Shuffle shuffle = new Shuffle();
		int[][] originalGrid = { { 1, 5, 9, 3, 4, 6, 7, 2, 8 }, { 4, 6, 7, 8, 2, 1, 9, 5, 3 },
				{ 8, 2, 3, 7, 5, 9, 1, 4, 6 }, { 9, 3, 6, 1, 7, 5, 2, 8, 4 }, { 7, 1, 5, 4, 8, 2, 6, 3, 9 },
				{ 2, 8, 4, 6, 9, 3, 5, 7, 1 }, { 5, 9, 8, 2, 6, 4, 3, 1, 7 }, { 3, 4, 2, 9, 1, 7, 8, 6, 5 },
				{ 6, 7, 1, 5, 3, 8, 4, 9, 2 } };

		int[] originalRow0 = new int[9];
		int[] originalRow1 = new int[9];
		int[] originalRow2 = new int[9];

		int[] originalRow6 = new int[9];
		int[] originalRow7 = new int[9];
		int[] originalRow8 = new int[9];

		int bigRow0 = 0;
		int bigRow2 = 2;

		for (int j = 0; j < 9; j++) {
			// Ligne 1, 2 et 3
			originalRow0[j] = originalGrid[bigRow0 * 3 + 0][j];
			originalRow1[j] = originalGrid[bigRow0 * 3 + 1][j];
			originalRow2[j] = originalGrid[bigRow0 * 3 + 2][j];

			// Ligne 7, 8 et 9
			originalRow6[j] = originalGrid[bigRow2 * 3 + 0][j];
			originalRow7[j] = originalGrid[bigRow2 * 3 + 1][j];
			originalRow8[j] = originalGrid[bigRow2 * 3 + 2][j];
		}

		shuffle.bigRowInterchange(originalGrid, bigRow0, bigRow2);

		int[] interchangeRow0 = new int[9];
		int[] interchangeRow1 = new int[9];
		int[] interchangeRow2 = new int[9];

		int[] interchangeRow6 = new int[9];
		int[] interchangeRow7 = new int[9];
		int[] interchangeRow8 = new int[9];
		for (int j = 0; j < 9; j++) {
			// Ligne 1, 2 et 3
			interchangeRow0[j] = originalGrid[bigRow0 * 3 + 0][j];
			interchangeRow1[j] = originalGrid[bigRow0 * 3 + 1][j];
			interchangeRow2[j] = originalGrid[bigRow0 * 3 + 2][j];

			// Ligne 7, 8 et 9
			interchangeRow6[j] = originalGrid[bigRow2 * 3 + 0][j];
			interchangeRow7[j] = originalGrid[bigRow2 * 3 + 1][j];
			interchangeRow8[j] = originalGrid[bigRow2 * 3 + 2][j];
		}

		assertArrayEquals("Interversion de la première ligne", originalRow0, interchangeRow6);
		assertArrayEquals("Interversion de la deuxième ligne", originalRow1, interchangeRow7);
		assertArrayEquals("Interversion de la troisième ligne", originalRow2, interchangeRow8);

		assertArrayEquals("Interversion de la sixième ligne", originalRow6, interchangeRow0);
		assertArrayEquals("Interversion de la septième ligne", originalRow7, interchangeRow1);
		assertArrayEquals("Interversion de la huitième ligne", originalRow8, interchangeRow2);
	}

	@Test
	void areNotBigRowsInterchangedTest() {
		// On teste que l'inversion de lignes ne marchent pas
		// quand on demande de changer de mauvaises lignes
		Shuffle shuffle = new Shuffle();
		int[][] originalGrid = { { 1, 5, 9, 3, 4, 6, 7, 2, 8 }, { 4, 6, 7, 8, 2, 1, 9, 5, 3 },
				{ 8, 2, 3, 7, 5, 9, 1, 4, 6 }, { 9, 3, 6, 1, 7, 5, 2, 8, 4 }, { 7, 1, 5, 4, 8, 2, 6, 3, 9 },
				{ 2, 8, 4, 6, 9, 3, 5, 7, 1 }, { 5, 9, 8, 2, 6, 4, 3, 1, 7 }, { 3, 4, 2, 9, 1, 7, 8, 6, 5 },
				{ 6, 7, 1, 5, 3, 8, 4, 9, 2 } };

		int[][] newGrid = originalGrid;
		int bigRow2 = 2;
		int bigRow6 = 6;
		shuffle.bigRowInterchange(newGrid, bigRow2, bigRow6);

		assertArrayEquals("La grille ne doit pas changer", originalGrid, newGrid);
	}

	@Test
	void areBigColumnsInterchangedTest() {
		// On teste que l'inversion de colonnes marche bien.
		Shuffle shuffle = new Shuffle();
		int[][] originalGrid = { { 1, 5, 9, 3, 4, 6, 7, 2, 8 }, { 4, 6, 7, 8, 2, 1, 9, 5, 3 },
				{ 8, 2, 3, 7, 5, 9, 1, 4, 6 }, { 9, 3, 6, 1, 7, 5, 2, 8, 4 }, { 7, 1, 5, 4, 8, 2, 6, 3, 9 },
				{ 2, 8, 4, 6, 9, 3, 5, 7, 1 }, { 5, 9, 8, 2, 6, 4, 3, 1, 7 }, { 3, 4, 2, 9, 1, 7, 8, 6, 5 },
				{ 6, 7, 1, 5, 3, 8, 4, 9, 2 } };

		int[] originalColumn0 = new int[9];
		int[] originalColumn1 = new int[9];
		int[] originalColumn2 = new int[9];

		int[] originalColumn6 = new int[9];
		int[] originalColumn7 = new int[9];
		int[] originalColumn8 = new int[9];

		int bigColumn0 = 0;
		int bigColumn2 = 2;

		for (int i = 0; i < 9; i++) {
			// Colonne 1, 2 et 3
			originalColumn0[i] = originalGrid[i][bigColumn0 * 3 + 0];
			originalColumn1[i] = originalGrid[i][bigColumn0 * 3 + 1];
			originalColumn2[i] = originalGrid[i][bigColumn0 * 3 + 2];

			// Colonne 7, 8 et 9
			originalColumn6[i] = originalGrid[i][bigColumn2 * 3 + 0];
			originalColumn7[i] = originalGrid[i][bigColumn2 * 3 + 1];
			originalColumn8[i] = originalGrid[i][bigColumn2 * 3 + 2];
		}

		shuffle.bigColumnInterchange(originalGrid, bigColumn0, bigColumn2);

		int[] interchangeColumn0 = new int[9];
		int[] interchangeColumn1 = new int[9];
		int[] interchangeColumn2 = new int[9];

		int[] interchangeColumn6 = new int[9];
		int[] interchangeColumn7 = new int[9];
		int[] interchangeColumn8 = new int[9];
		for (int i = 0; i < 9; i++) {
			// Colonne 1, 2 et 3
			interchangeColumn0[i] = originalGrid[i][bigColumn0 * 3 + 0];
			interchangeColumn1[i] = originalGrid[i][bigColumn0 * 3 + 1];
			interchangeColumn2[i] = originalGrid[i][bigColumn0 * 3 + 2];

			// Colonne 7, 8 et 9
			interchangeColumn6[i] = originalGrid[i][bigColumn2 * 3 + 0];
			interchangeColumn7[i] = originalGrid[i][bigColumn2 * 3 + 1];
			interchangeColumn8[i] = originalGrid[i][bigColumn2 * 3 + 2];
		}

		assertArrayEquals("Interversion de la première colonne", originalColumn0, interchangeColumn6);
		assertArrayEquals("Interversion de la deuxième colonne", originalColumn1, interchangeColumn7);
		assertArrayEquals("Interversion de la troisième colonne", originalColumn2, interchangeColumn8);

		assertArrayEquals("Interversion de la sixième colonne", originalColumn6, interchangeColumn0);
		assertArrayEquals("Interversion de la septième colonne", originalColumn7, interchangeColumn1);
		assertArrayEquals("Interversion de la huitième colonne", originalColumn8, interchangeColumn2);
	}

	@Test
	void areNotBigColumnsInterchangedTest() {
		// On teste que l'inversion de colonnes ne marchent pas
		// quand on demande de changer de mauvaises colonnes
		Shuffle shuffle = new Shuffle();
		int[][] originalGrid = { { 1, 5, 9, 3, 4, 6, 7, 2, 8 }, { 4, 6, 7, 8, 2, 1, 9, 5, 3 },
				{ 8, 2, 3, 7, 5, 9, 1, 4, 6 }, { 9, 3, 6, 1, 7, 5, 2, 8, 4 }, { 7, 1, 5, 4, 8, 2, 6, 3, 9 },
				{ 2, 8, 4, 6, 9, 3, 5, 7, 1 }, { 5, 9, 8, 2, 6, 4, 3, 1, 7 }, { 3, 4, 2, 9, 1, 7, 8, 6, 5 },
				{ 6, 7, 1, 5, 3, 8, 4, 9, 2 } };

		int[][] newGrid = originalGrid;
		int bigColumn2 = 2;
		int bigColumn6 = 6;
		shuffle.bigColumnInterchange(newGrid, bigColumn2, bigColumn6);

		assertArrayEquals("La grille ne doit pas changer", originalGrid, newGrid);
	}

}
