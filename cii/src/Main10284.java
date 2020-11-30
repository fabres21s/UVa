import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
*	10284 - Chessboard in FEN
*
*
*	Submission:	20352060
*	Date:		2017-11-16 02:10:14
*	Runtime:	0.240
*	Ranking:	1510 / 1709
*/
public class Main10284 {

	public static boolean chessBoardFree[][] = new boolean[12][12];
	public static char chessBoard[][] = new char[12][12];

	/**
	 * - Ajedrez
	 * 
	 *  Dada una configuración inicial sobre un trablero de ajedrez en notación FEN
	 *  encontrar cuantas casillas están desocupadas y sin estar atacadas
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();

		String line;
		while ((line = br.readLine()) != null) {

			for (int i = 0; i < 12; i++) {
				Arrays.fill(chessBoard[i], '*');
				Arrays.fill(chessBoardFree[i], true);
			}

			args = line.split("[/]");

			int row = 2;
			for (String FEN : args) {
				int nextPosition = 2;
				char array[] = FEN.toCharArray();
				for (char s : array) {
					if (Character.isAlphabetic(s)) {
						chessBoard[row][nextPosition] = s;
						nextPosition++;
					} else {
						nextPosition += s - 48;
					}
				}
				row++;
			}

			for (int i = 2; i < 10; i++) {
				for (int j = 2; j < 10; j++) {
					if (Character.isAlphabetic(chessBoard[i][j])) {
						chessBoardFree[i][j] = false;

						switch (chessBoard[i][j]) {
						// Torre - Rook
						case 82:
							rook(i, j);
							break;

						case 114:
							rook(i, j);
							break;

						// Caballo - Knight
						case 78:
							knight(i, j);
							break;

						case 110:
							knight(i, j);
							break;

						// Alfil - Bishop
						case 66:
							bishop(i, j);
							break;

						case 98:
							bishop(i, j);
							break;

						// Dama - Queen
						case 81:
							bishop(i, j);
							rook(i, j);
							break;

						case 113:
							bishop(i, j);
							rook(i, j);
							break;

						// Rey - King
						case 75:
							king(i, j);
							break;

						case 107:
							king(i, j);
							break;

						case 80:
							pawn(i, j, true);
							break;

						case 112:
							pawn(i, j, false);
							break;
						}

					}
				}
			}

			int free = 0;
			for (int i = 2; i < 10; i++) {
				for (int j = 2; j < 10; j++) {
					if (chessBoardFree[i][j]) {
						free++;
					}
				}
			}

			output.append(free);
			output.append("\n");
		}
		System.out.print(output);

	}

	public static void king(int x, int y) {
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				chessBoardFree[i][j] = false;
			}
		}
	}

	public static void pawn(int x, int y, boolean isWhite) {
		if (isWhite) {
			chessBoardFree[x - 1][y + 1] = false;
			chessBoardFree[x - 1][y - 1] = false;
		} else {
			chessBoardFree[x + 1][y - 1] = false;
			chessBoardFree[x + 1][y + 1] = false;
		}
	}

	public static void knight(int x, int y) {
		chessBoardFree[x - 1][y - 2] = false;
		chessBoardFree[x + 1][y - 2] = false;
		chessBoardFree[x + 2][y - 1] = false;
		chessBoardFree[x + 2][y + 1] = false;
		chessBoardFree[x + 1][y + 2] = false;
		chessBoardFree[x - 1][y + 2] = false;
		chessBoardFree[x - 2][y + 1] = false;
		chessBoardFree[x - 2][y - 1] = false;

	}

	public static void rook(int x, int y) {
		// a la izquierda
		for (int j = y - 1; j >= 2; j--) {
			if (chessBoard[x][j] != '*') {
				break;
			}
			chessBoardFree[x][j] = false;
		}

		// a la derecha
		for (int j = y + 1; j <= 9; j++) {
			if (chessBoard[x][j] != '*') {
				break;
			}
			chessBoardFree[x][j] = false;
		}

		// hacía arriba
		for (int i = x - 1; i >= 2; i--) {
			if (chessBoard[i][y] != '*') {
				break;
			}
			chessBoardFree[i][y] = false;
		}

		// hacía abajo
		for (int i = x + 1; i <= 9; i++) {
			if (chessBoard[i][y] != '*') {
				break;
			}
			chessBoardFree[i][y] = false;
		}
	}

	public static void bishop(int x, int y) {
		// arriba a la izquierda
		int i = x - 1, j = y - 1;

		while (i > 1 && j > 1 && (chessBoard[i][j] == '*')) {
			chessBoardFree[i][j] = false;
			i--;
			j--;
		}

		// arriba a la derecha
		i = x + 1;
		j = y - 1;
		while (i < 10 && j > 1 && (chessBoard[i][j] == '*')) {
			chessBoardFree[i][j] = false;
			i++;
			j--;
		}

		// abajo a la izquierda
		i = x - 1;
		j = y + 1;
		while (i > 1 && j < 10 && (chessBoard[i][j] == '*')) {
			chessBoardFree[i][j] = false;
			i--;
			j++;
		}

		// abajo a la izquierda
		i = x + 1;
		j = y + 1;
		while (i < 10 && j < 10 && (chessBoard[i][j] == '*')) {
			chessBoardFree[i][j] = false;
			i++;
			j++;
		}

	}

}
