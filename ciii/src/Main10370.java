import java.util.Scanner;

/**
*	10370 - Above Average
*
*
*	Submision:	9663042
*	Date:		2012-01-20 15:25:10
*	Runtime:	1.616
*	Ranking:	14770
*/
public class Main10370 {

	/**
	 * - Estadística
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt(), i, datos;
		double media, mayores;
		while (casos > 0) {
			casos--;
			media = 0;
			datos = input.nextInt();
			i = datos;
			double arreglo[] = new double[datos];
			while (i > 0) {
				i--;
				arreglo[i] = input.nextDouble();
				media += arreglo[i];
			}
			media /= datos;
			mayores = 0;
			for (i = 0; i < datos; i++) {
				if (arreglo[i] > media) {
					mayores++;
				}
			}
			System.out.printf("%.3f%%\n", mayores * 100 / datos);
		}
		input.close();
	}
}
