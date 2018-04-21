import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10170 - The Hotel with Infinite Rooms
*
*	Submission:	20399798
*	Date:	    2017-11-25 23:53:01
*	Runtime:	0.150
*	Ranking:	2140
*/
public class Main10170 {

	/**
	 * - No entiendo
	 * 
	 *  Realmente no lo entendí muy bien
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		
		String line;
		long s,d;
		double k;
		while ((line = br.readLine()) != null) {
			args = line.split(" ");
			
			s = Long.parseLong(args[0]);
			d = Long.parseLong(args[1]);
			
			k = Math.sqrt(2.0*d+s*(s-1.0)+0.25)-0.5;
			output.append((int)Math.ceil(k));
			output.append("\n");
		}

		System.out.print(output);
	}

}
