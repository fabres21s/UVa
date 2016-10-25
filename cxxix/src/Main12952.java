import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	12952 - Tri-du
*
*
*	Submision:	17623688
*	Date:		2016-07-05 16:57:22	
*	Runtime:	0.040
*	Ranking:	397
*/
public class Main12952 {

	/*
	 * - Muy fácil
	 * 
	 * Ver si en un juego de cartas, un jugador puede hacer trio o par
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line ;
		StringBuffer output = new StringBuffer();
		while ((line = br.readLine()) != null) {
			args = line.split(" ");
			if (args[0].equals(args[1])) {
				output.append(args[0]);
			} else {
				output.append(Math.max(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
			}
			output.append("\n");
		}
		System.out.print(output);
	}

}
