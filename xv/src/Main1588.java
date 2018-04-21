import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	1588 - Kickdown
*
*
*	Submission:	20453392
*	Date:		2017-12-06 23:15:09	
*	Runtime:	0.040
*	Ranking:	887
*/
public class Main1588 {

	/**
	 * - Validaciones
	 * 
	 *  Encontrar el tamaño mínimo en el que 2 arreglos que tienen valores de 1 o 2 
	 *  hacen match con la condición de que no estén dos 2 juntos, pudiéndose
	 *  correr hacía la izquierda 
	 *  
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;

		StringBuffer output = new StringBuffer();
		while ((line = br.readLine()) != null) {

			char array1[] = line.trim().toCharArray();

			char array2[] = br.readLine().trim().toCharArray();

			output.append(Math.min(evaluate(array1, array2), evaluate(array2, array1)));
			output.append("\n");

		}

		System.out.print(output);

	}

	static int evaluate(char[] arrayUp, char[] arrayDown) {
		int indexDown = 0;

		while (indexDown <= arrayDown.length) {

			int auxIndex = indexDown;

			boolean sirve = true;
			for (char c : arrayUp) {
				char value = auxIndex < arrayDown.length ? arrayDown[auxIndex] : '0';

				if ((c + value) > 99) {
					sirve = false;
					break;
				}
				auxIndex++;
			}

			if (sirve) {
				return (Math.max(arrayUp.length + indexDown, arrayDown.length));

			}

			indexDown++;
		}
		return 1001;

	}

}
