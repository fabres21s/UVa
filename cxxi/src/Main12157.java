import java.util.Scanner;

/**
*	12157 - Tariff Plan
*
*
*	Submision:	16202839
*	Date:		2015-10-03 12:03:42
*	Runtime:	0.092
*	Ranking:	2587
*/
public class Main12157 {

	/**
	 * - Simulación
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt() + 1;
		int calls, costMile, costJuice, duration;
		for (int i = 1; i < cases; i++) {
			calls = input.nextInt();
			costMile = costJuice = 0;
			while (calls-- > 0) {
				duration = input.nextInt();
				costMile += (duration / 30 + 1) * 10;
				costJuice += (duration / 60 + 1) * 15;
			}
			System.out.print("Case " + i + ": ");
			if (costMile < costJuice) {
				System.out.println("Mile " + costMile);
			} else if (costJuice < costMile) {
				System.out.println("Juice " + costJuice);
			} else {
				System.out.println("Mile Juice " + costJuice);
			}
		}
	}

}
