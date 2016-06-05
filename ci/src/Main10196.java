import java.io.IOException;
import java.util.Scanner;

/**
*	10196 - Check The Check
*
*
*	Submision:	9262727
*	Date:		2011-09-15 14:14:31
*	Runtime:	0.764
*	Ranking:	3717
*/
public class Main10196 {

	/**
	 * - Ajedrez
	 * 
	 * Dado un tablero de ajedrez, y la disposición de las piezas
	 * determinar si uno de los reyes se encuentra en jaque
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String[][] tablero = new String[12][12];
		llenar(tablero);
		String[] tokens;
		boolean negro, blanco;
		int casos = 0, cont = 1, i, j, aux, aux1;
		while (cont > 0) {
			negro = false;
			blanco = false;
			casos++;
			cont = 0;
			for (i = 0; i < 8; i++) {
				tokens = input.nextLine().split("");
				for (j = 0; j < 8; j++) {
					tablero[i + 2][j + 2] = tokens[j + 1];
				}
			}
			for (i = 2; i < 10; i++) {
				for (j = 2; j < 10; j++) {
					if (!tablero[i][j].equals(".")) {
						cont++;
						if (tablero[i][j].equals("P")) // pe�n blanco
						{
							if (tablero[i - 1][j - 1].equals("k")
									|| tablero[i - 1][j + 1].equals("k")) {
								negro = true;
								break;
							}
						}
						if (tablero[i][j].equals("p")) // pe�n negro
						{
							if (tablero[i + 1][j - 1].equals("K")
									|| tablero[i + 1][j + 1].equals("K")) {
								blanco = true;
								break;
							}
						} else if (tablero[i][j].equals("N")) // caballo blanco
						{
							if (tablero[i - 1][j - 2].equals("k")
									|| tablero[i - 2][j - 1].equals("k")
									|| tablero[i - 2][j + 1].equals("k")
									|| tablero[i - 1][j + 2].equals("k")
									|| tablero[i + 1][j - 2].equals("k")
									|| tablero[i + 2][j - 1].equals("k")
									|| tablero[i + 2][j + 1].equals("k")
									|| tablero[i + 1][j + 2].equals("k")) {
								negro = true;
								break;
							}
						} else if (tablero[i][j].equals("n")) // caballo negro
						{
							if (tablero[i - 1][j - 2].equals("K")
									|| tablero[i - 2][j - 1].equals("K")
									|| tablero[i - 2][j + 1].equals("K")
									|| tablero[i - 1][j + 2].equals("K")
									|| tablero[i + 1][j - 2].equals("K")
									|| tablero[i + 2][j - 1].equals("K")
									|| tablero[i + 2][j + 1].equals("K")
									|| tablero[i + 1][j + 2].equals("K")) {
								blanco = true;
								break;
							}
						} else if (tablero[i][j].equals("R")) // torre blanca
						{
							aux = i + 1;
							while (tablero[aux][j].equals(".") && aux < 10) // hac�a
																			// arriba
							{
								aux++;
							}
							if (tablero[aux][j].equals("k")) {
								negro = true;
								break;
							}
							aux = i - 1;
							while (tablero[aux][j].equals(".") && aux > 1) // hac�a
																			// abajo
							{
								aux--;
							}
							if (tablero[aux][j].equals("k")) {
								negro = true;
								break;
							}
							aux = j + 1;
							while (tablero[i][aux].equals(".") && aux < 10) // hac�a
																			// la
																			// derecha
							{
								aux++;
							}
							if (tablero[i][aux].equals("k")) {
								negro = true;
								break;
							}
							aux = j - 1;
							while (tablero[i][aux].equals(".") && aux > 1) // hac�a
																			// la
																			// izquierda
							{
								aux--;
							}
							if (tablero[i][aux].equals("k")) {
								negro = true;
								break;
							}
						} else if (tablero[i][j].equals("r")) // torre negra
						{
							aux = i + 1;
							while (tablero[aux][j].equals(".") && aux < 10)// arriba
							{
								aux++;
							}
							if (tablero[aux][j].equals("K")) {
								blanco = true;
								break;
							}
							aux = i - 1;
							while (tablero[aux][j].equals(".") && aux > 1)// abajo
							{
								aux--;
							}
							if (tablero[aux][j].equals("K")) {
								blanco = true;
								break;
							}
							aux = j + 1;
							while (tablero[i][aux].equals(".") && aux < 10)// derecha
							{
								aux++;
							}
							if (tablero[i][aux].equals("K")) {
								blanco = true;
								break;
							}
							aux = j - 1;
							while (tablero[i][aux].equals(".") && aux > 1)// izquierda
							{
								aux--;
							}
							if (tablero[i][aux].equals("K")) {
								blanco = true;
								break;
							}
						} else if (tablero[i][j].equals("B")) // alfil blanco
						{
							aux = i + 1;
							aux1 = j + 1;
							while (tablero[aux][aux1].equals(".") && aux < 10
									&& aux1 < 10)// derecha abajo
							{
								aux++;
								aux1++;
							}
							if (tablero[aux][aux1].equals("k")) {
								negro = true;
								break;
							}
							aux = i + 1;
							aux1 = j - 1;
							while (tablero[aux][aux1].equals(".") && aux < 10
									&& aux1 > 1)// izquierda abajo
							{
								aux++;
								aux1--;
							}
							if (tablero[aux][aux1].equals("k")) {
								negro = true;
								break;
							}
							aux = i - 1;
							aux1 = j - 1;
							while (tablero[aux][aux1].equals(".") && aux > 1
									&& aux1 > 1)// izquierda arriba
							{
								aux--;
								aux1--;
							}
							if (tablero[aux][aux1].equals("k")) {
								negro = true;
								break;
							}
							aux = i - 1;
							aux1 = j + 1;
							while (tablero[aux][aux1].equals(".") && aux > 1
									&& aux1 < 10)// derecha arriba
							{
								aux--;
								aux1++;
							}
							if (tablero[aux][aux1].equals("k")) {
								negro = true;
								break;
							}
						} else if (tablero[i][j].equals("b")) // alfil negro
						{
							aux = i + 1;
							aux1 = j + 1;
							while (tablero[aux][aux1].equals(".") && aux < 10
									&& aux1 < 10)// derecha abajo
							{
								aux++;
								aux1++;

							}
							if (tablero[aux][aux1].equals("K")) {
								blanco = true;
								break;
							}
							aux = i + 1;
							aux1 = j - 1;
							while (tablero[aux][aux1].equals(".") && aux < 10
									&& aux1 > 1)// izquierda abajo
							{
								aux++;
								aux1--;
							}
							if (tablero[aux][aux1].equals("K")) {
								blanco = true;
								break;
							}
							aux = i - 1;
							aux1 = j - 1;
							while (tablero[aux][aux1].equals(".") && aux > 1
									&& aux1 > 1)// izquierda arriba
							{
								aux--;
								aux1--;
							}
							if (tablero[aux][aux1].equals("K")) {
								blanco = true;
								break;
							}
							aux = i - 1;
							aux1 = j + 1;
							while (tablero[aux][aux1].equals(".") && aux > 1
									&& aux1 < 10)// derecha arriba
							{
								aux--;
								aux1++;
							}
							if (tablero[aux][aux1].equals("K")) {
								blanco = true;
								break;
							}
						} else if (tablero[i][j].equals("Q")) // dama blanca
						{
							aux = i + 1;
							while (tablero[aux][j].equals(".") && aux < 10)// hac�a
																			// arriba
							{
								aux++;
							}
							if (tablero[aux][j].equals("k")) {
								negro = true;
								break;
							}
							aux = i - 1;
							while (tablero[aux][j].equals(".") && aux > 1) // hac�a
																			// abajo
							{
								aux--;
							}
							if (tablero[aux][j].equals("k")) {
								negro = true;
								break;
							}
							aux = j + 1;
							while (tablero[i][aux].equals(".") && aux < 10) // hac�a
																			// la
																			// derecha
							{
								aux++;
							}
							if (tablero[i][aux].equals("k")) {
								negro = true;
								break;
							}
							aux = j - 1;
							while (tablero[i][aux].equals(".") && aux > 1) // hac�a
																			// la
																			// izquierda
							{
								aux--;
							}
							if (tablero[i][aux].equals("k")) {
								negro = true;
								break;
							}// ///
							aux = i + 1;
							aux1 = j + 1;
							while (tablero[aux][aux1].equals(".") && aux < 10
									&& aux1 < 10)// derecha abajo
							{
								aux++;
								aux1++;

							}
							if (tablero[aux][aux1].equals("k")) {
								negro = true;
								break;
							}
							aux = i + 1;
							aux1 = j - 1;
							while (tablero[aux][aux1].equals(".") && aux < 10
									&& aux1 > 1)// izquierda abajo
							{
								aux++;
								aux1--;
							}
							if (tablero[aux][aux1].equals("k")) {
								negro = true;
								break;
							}
							aux = i - 1;
							aux1 = j - 1;
							while (tablero[aux][aux1].equals(".") && aux > 1
									&& aux1 > 1)// izquierda arriba
							{
								aux--;
								aux1--;
							}
							if (tablero[aux][aux1].equals("k")) {
								negro = true;
								break;
							}
							aux = i - 1;
							aux1 = j + 1;
							while (tablero[aux][aux1].equals(".") && aux > 1
									&& aux1 < 10)// derecha arriba
							{
								aux--;
								aux1++;
							}
							if (tablero[aux][aux1].equals("k")) {
								negro = true;
								break;
							}
						} else if (tablero[i][j].equals("q")) // dama negra
						{
							aux = i + 1;
							while (tablero[aux][j].equals(".") && aux < 10)// arriba
							{
								aux++;
							}
							if (tablero[aux][j].equals("K")) {
								blanco = true;
								break;
							}
							aux = i - 1;
							while (tablero[aux][j].equals(".") && aux > 1)// abajo
							{
								aux--;
							}
							if (tablero[aux][j].equals("K")) {
								blanco = true;
								break;
							}
							aux = j + 1;
							while (tablero[i][aux].equals(".") && aux < 10)// derecha
							{
								aux++;
							}
							if (tablero[i][aux].equals("K")) {
								blanco = true;
								break;
							}
							aux = j - 1;
							while (tablero[i][aux].equals(".") && aux > 1)// izquierda
							{
								aux--;
							}
							if (tablero[i][aux].equals("K")) {
								blanco = true;
								break;
							}
							aux = i + 1;
							aux1 = j + 1;
							while (tablero[aux][aux1].equals(".") && aux < 10
									&& aux1 < 10)// derecha abajo
							{
								aux++;
								aux1++;

							}
							if (tablero[aux][aux1].equals("K")) {
								blanco = true;
								break;
							}
							aux = i + 1;
							aux1 = j - 1;
							while (tablero[aux][aux1].equals(".") && aux < 10
									&& aux1 > 1)// izquierda abajo
							{
								aux++;
								aux1--;
							}
							if (tablero[aux][aux1].equals("K")) {
								blanco = true;
								break;
							}
							aux = i - 1;
							aux1 = j - 1;
							while (tablero[aux][aux1].equals(".") && aux > 1
									&& aux1 > 1)// izquierda arriba
							{
								aux--;
								aux1--;
							}
							if (tablero[aux][aux1].equals("K")) {
								blanco = true;
								break;
							}
							aux = i - 1;
							aux1 = j + 1;
							while (tablero[aux][aux1].equals(".") && aux > 1
									&& aux1 < 10)// derecha arriba
							{
								aux--;
								aux1++;
							}
							if (tablero[aux][aux1].equals("K")) {
								blanco = true;
								break;
							}
						}

					}
				}
				if (blanco || negro) {
					break;
				}
			}
			if (blanco) {
				System.out.println("Game #" + casos
						+ ": white king is in check.");
			} else if (negro) {
				System.out.println("Game #" + casos
						+ ": black king is in check.");
			} else {
				if (cont > 0) {
					System.out.println("Game #" + casos
							+ ": no king is in check.");
				}
			}
			input.nextLine();
		}
		input.close();
	}

	static String[][] llenar(String[][] tablero) {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				tablero[i][j] = "";
			}
		}
		return tablero;
	}
}
