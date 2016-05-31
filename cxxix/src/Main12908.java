import java.util.Scanner;

/**
*	12908 - The book thief
*
*
*	Submision:	16200043
*	Date:		2015-10-02 20:26:00
*	Runtime:	0.662
*	Ranking:	237
*/
public class Main12908 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sumInicial, r, sumReal;
		StringBuffer buffer = new StringBuffer();
		while (input.hasNext()) {
			sumInicial = input.nextInt();
			if (sumInicial == 0) {
				break;
			}

			r = (int) ((-1 + Math.sqrt(1 + 8 * sumInicial)) / 2 + 1);// de la
																		// fórmula
																		// de la
																		// sumatoria
																		// de
																		// los
																		// números

			sumReal = r * (r + 1) / 2;
			buffer.append((sumReal - sumInicial) + " " + r + "\n");
		}
		System.out.print(buffer);
		input.close();
	}

}
