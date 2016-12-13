import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
*	12210 - A Match Making Problem
*
*
*	Submision:	17002501
*	Date:		2016-03-12 12:59:57
*	Runtime:	0.106
*	Ranking:	974
*/
public class Main12210 {

	/**
	 * - Muy fácil
	 * - Validaciones
	 * 
	 * Encontrar los
	 * emparejamientos entre hombres y mujeres
	 * y ver si hombres quedan sin pareja, de ser así imprimer la edad del menor
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = 0;
		int men, women, age;
		while (true) {
			cases++;
			args = br.readLine().split(" ");

			men = Integer.parseInt(args[0]);
			women = Integer.parseInt(args[1]);

			if (men == women && women == 0) {
				break;
			}
			// int ageMen [] = new int [men];
			// int ageWomen [] = new int[women];
			int menor = 60;
			for (int i = 0; i < men; i++) {
				age = Integer.parseInt(br.readLine());
				menor = Math.min(age, menor);

			}

			for (int i = 0; i < women; i++) {
				age = Integer.parseInt(br.readLine());
				// menor = Math.min(age, menor);

			}

			if (women < men) {
				System.out.printf("Case %d: %d %d\n", (cases), (men - women),
						menor);
			} else {
				System.out.printf("Case %d: 0\n", cases);
			}

		}
	}

}
