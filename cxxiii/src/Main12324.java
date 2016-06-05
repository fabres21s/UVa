import java.util.Scanner;

/**
*	12324 - Philip J. Fry Problem
*
*
*	Submision:	9528053
*	Date:		2011-12-02 22:00:24
*	Runtime:	0.928
*	Ranking:	306
*/
public class Main12324 {

	/**
	 * - Simulación
	 */

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int trips;
		// String linea;
		while ((trips = input.nextInt()) != 0) {
			int totalViaje = 0;
			int[][] tripsInfo = new int[trips][2];
			for (int i = 0; i < trips; i++) {
				tripsInfo[i][0] = input.nextInt();
				tripsInfo[i][1] = input.nextInt();
			}
			boolean continuar = true;
			while (continuar) {
				// Seleecion del mayor
				int posMayor = 0;
				for (int i = 0; i < tripsInfo.length; i++) {
					if (tripsInfo[i][0] > tripsInfo[posMayor][0]) {
						posMayor = i;
					}
				}
				// Revisar cuantas pepas hay
				int numPepas = 0;
				for (int i = posMayor - 1; i >= 0; i--) {
					if (tripsInfo[i][1] > 0) {
						numPepas++;
						tripsInfo[i][1]--;
						break;
					}
				}
				// Utilizar pepas posibles
				if (numPepas > 0) {
					totalViaje += (tripsInfo[posMayor][0]) / 2;
					tripsInfo[posMayor][0] = 0;
				} else {
					totalViaje += tripsInfo[posMayor][0];
					tripsInfo[posMayor][0] = 0;
				}
				// Decidir si continua
				continuar = false;
				for (int i = 0; i < tripsInfo.length; i++) {
					if (tripsInfo[i][0] > 0) {
						continuar = true;
						break;
					}
				}
				// Imprimir tiempo total
			}
			System.out.println(totalViaje);
		}
	}
}
