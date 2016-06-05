import java.util.Scanner;

/**
*	12700 - Banglawash
*
*
*	Submision:	16502578
*	Date:		2015-11-27 22:44:41
*	Runtime:	0.092
*	Ranking:	1329
*/
public class Main12700 {

	/**
	 * - Validaciones
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int total;
		int B, A, W, T;
		for (int i = 1; i <= n; i++) {
			total = input.nextInt();
			B = A = W = T = 0;
			char array[] = input.next().toCharArray();
			for (int j = 0; j < total; j++) {
				switch (array[j]) {
				case 65:
					A++;
					break;

				case 66:
					B++;
					break;

				case 87:
					W++;
					break;

				case 84:
					T++;
					break;
				}
			}
			String response = "";
			if (A == total) {
				response = "ABANDONED";
			} else if ((A + B) == total) {
				response = "BANGLAWASH";
			} else if ((W + A) == total) {
				response = "WHITEWASH";
			} else if (W > B) {
				response = "WWW " + W + " - " + B;
			} else if (B > W) {
				response = "BANGLADESH " + B + " - " + W;
			} else {
				response = "DRAW " + B + " " + T;
			}
			System.out.printf("Case %d: %s\n", i, response);
		}

		input.close();
	}

}