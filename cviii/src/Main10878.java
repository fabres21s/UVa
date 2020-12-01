import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
*	10878 - Decode the tape
*
*	Submission:	25793814
*	Date:		2020-12-01 20:35:42
*	Runtime:	0.050
*	Ranking:	5179 / 5770
*/
public class Main10878 {

	/**
	 * - Arreglos
	 * 
	 * Asociar unos caracteres a un valor
	 */
	static int values[] = { 0, 0, 64, 32, 16, 8, 0, 4, 2, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		StringBuilder output = new StringBuilder();

		while (!(line = br.readLine()).equals("___________")) {
			output.append(findCharacter(line.toCharArray()));

		}
		System.out.print(output);
	}

	private static char findCharacter(char mander []) {
		int sum = 0;
		for (int i = 2; i < 10; i++) {
			if (mander[i] == 'o') {
				sum += values[i];
			}
		}

		return (char) sum;
	}

}
