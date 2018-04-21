import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	13012 - Identifyng tea
*
*
*	Submission:	17601369
*	Date:		2016-06-30 23:05:14	
*	Runtime:	0.040
*	Ranking:	583
*/
public class Main13012 {

	/**
	 * - Muy f�cil
	 * 
	 * No hay mucho que explicar
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String correct;
		int validos = 0;
		while ((correct = br.readLine()) != null) {
			args = br.readLine().split(" ");
			for (String value : args) {
				if (value.equals(correct)) {
					validos++;
				}
			}
			System.out.println(validos);
			validos  =0;
		}
	}

}
