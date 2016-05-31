import java.util.Scanner;

/**
*	12959 - Strategy Game
*
*
*	Submision:	16500737
*	Date:		2015-11-27 14:39:17
*	Runtime:	0.485
*	Ranking:	227
*/
public class Main12959 {

	/*
	 * Simulación, j jugadores, r rondas ver que jugador obtiene más puntos en
	 * todas las rondas
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int j, r, i;
		int array[];
		while (input.hasNext()) {
			j = input.nextInt();

			array = new int[j];

			r = input.nextInt();

			for (i = 0; i < j * r; i++) {
				array[i % j] += input.nextInt();
			}

			int max = 0, posMax = 0;

			for (i = 0; i < j; i++) {
				if (array[i] >= max) {
					max = array[i];
					posMax = i;
				}
			}

			System.out.println(posMax + 1);

		}

		input.close();
	}

}