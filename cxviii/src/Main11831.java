import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	11831 - Sticker Collector Robot
*
*
*	Submission:	17131945
*	Date:		2016-04-02 04:13:35
*	Runtime:	0.113
*	Ranking:	1402
*/
public class Main11831 {

	/**
	 * - Simulaci�n
	 * - Arreglos
	 * 
	 * Dado un grid y un robot en una posici�n y con una orientaci�n inicial
	 * determinar cuantos stickers (*) recoge, teniendo en cuenta unas
	 * instrucciones y condiciones
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int rows, columns, instructions;
		while (true) {
			args = br.readLine().split(" ");
			rows = Integer.parseInt(args[0]);
			columns = Integer.parseInt(args[1]);
			instructions = Integer.parseInt(args[2]);

			if (rows == 0 && columns == 0) {
				break;
			}

			int[][] array = new int[rows + 2][columns + 2];
			int posI = 0, posJ = 0;

			int orientacion = 0;
			for (int i = 1; i <= rows; i++) {
				for (int j = 1; j <= columns; j++) {
					array[i][j] = br.read();
					if (array[i][j] == 78) {
						orientacion = 78;
						// N
						posI = i;
						posJ = j;
					}

					else if (array[i][j] == 79) {
						orientacion = 79;
						// o
						posI = i;
						posJ = j;
					}

					else if (array[i][j] == 76) {
						orientacion = 76;
						// L
						posI = i;
						posJ = j;
					}

					else if (array[i][j] == 83) {
						orientacion = 83;
						// S
						posI = i;
						posJ = j;
					}

				}
				br.readLine();
			}

			int collects = 0;
			for (int i = 0; i < instructions; i++) {
				int action = br.read();

				switch (action) {

				// turn to the right
				case 68:
					switch (orientacion) {
					case 78:// norte
						orientacion = 76;
						break;

					case 79:// occ
						orientacion = 78;
						break;

					case 76:// oriente
						orientacion = 83;
						break;

					case 83:// sur
						orientacion = 79;
						break;
					}
					break;

				// turn to the left
				case 69:

					switch (orientacion) {
					case 78:// norte
						orientacion = 79;
						break;

					case 79:// occ
						orientacion = 83;
						break;

					case 76:// oriente
						orientacion = 78;
						break;

					case 83:// sur
						orientacion = 76;
						break;
					}
					break;

				// forward
				case 70:

					switch (orientacion) {
					case 78:// norte
						if (posI > 1) {
							switch (array[posI - 1][posJ]) {
							case 46:// punto
								array[posI][posJ] = 46;// abandona la posicion,
														// deja un punto
								posI--;
								break;

							case 42:// asterisco
								collects++;
								array[posI][posJ] = 46;// abandona la posicion,
														// deja un punto
								posI--;
								break;

							default:
								break;
							}
						}
						break;

					case 79:// occ

						if (posJ > 1) {
							switch (array[posI][posJ - 1]) {
							case 46:// punto
								array[posI][posJ] = 46;// abandona la posicion,
														// deja un punto
								posJ--;
								break;

							case 42:// asterisco
								collects++;
								array[posI][posJ] = 46;// abandona la posicion,
														// deja un punto
								posJ--;
								break;

							default:
								break;
							}
						}

						break;

					case 76:// oriente

						if (posJ < columns) {
							switch (array[posI][posJ + 1]) {
							case 46:// punto
								array[posI][posJ] = 46;// abandona la posicion,
														// deja un punto
								posJ++;
								break;

							case 42:// asterisco
								collects++;
								array[posI][posJ] = 46;// abandona la posicion,
														// deja un punto
								posJ++;
								break;

							default:
								break;
							}
						}

						break;

					case 83:// sur

						if (posI < rows) {
							switch (array[posI + 1][posJ]) {
							case 46:// punto
								array[posI][posJ] = 46;// abandona la posicion,
														// deja un punto
								posI++;
								break;

							case 42:// asterisco
								collects++;
								array[posI][posJ] = 46;// abandona la posicion,
														// deja un punto
								posI++;
								break;

							default:
								break;
							}
						}
						break;
					}
					break;

				}
			}

			System.out.println(collects);
			br.readLine();
		}
	}

}
/*
 * ....*..... .......*.. .....*.... ..*.#..... ...#N.*..* ...*...... ..........
 * .......... .......... ..........
 */