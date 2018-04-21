import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
*	725 - Division
*
*
*	Submission:	20422510
*	Date:		2017-11-30 13:13:50
*	Runtime:	0.140
*	Ranking:	2610
*/
public class Main725 {

	/**
	 * - Pregenerados
	 * 
	 *  Hallar las divisiones que den como resultado n
	 *  con la condición que no se repita ningún número del 0 al 9 en el dividendo y divisor
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		StringBuffer output = new StringBuffer();
		Map<Integer, StringBuffer> solution = new HashMap<Integer, StringBuffer>();
		for (int i = 2; i <= 80; i++) {

			StringBuffer answer = new StringBuffer();
			answer.append("There are no solutions for " + i + ".\n");
			boolean isThereSolution = false;
			int min = 1000 * i;

			for (int j = min; j <= 99999; j += i) {
				int array[] = new int[10];

				int aux = j;

				while (aux != 0) {
					array[aux % 10]++;
					aux /= 10;
				}

				aux = j / i;

				while (aux != 0) {
					array[aux % 10]++;
					aux /= 10;
				}

				boolean isValid = true;
				if (array[0] == 1 || array[0] == 0) {
					for (int x = 1; x < 10; x++) {
						if (array[x] != 1) {
							isValid = false;
						}
					}
				} else {
					isValid = false;
				}

				if (isValid) {

					String div = j / i < 10000 ? "0" + (j / i) : String.valueOf(j / i);

					if (!isThereSolution) {
						isThereSolution = true;
						answer = new StringBuffer();

					}
					answer.append(j + " / " + div + " = " + i);
					answer.append("\n");

					// set.add(e)
				}

			}
			solution.put(i, answer);

		}


		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		
		
		boolean firstCase = true;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			
			if (!firstCase) {
				output.append("\n");
			}
			output.append(solution.get(n));
			firstCase = false;
		}
		
		System.out.print(output);
	}

}
