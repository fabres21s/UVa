import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	12992 - Huatuo's Medicine
*
*
*	Submision:	17624247
*	Date:		2016-07-05 19:13:40	
*	Runtime:	0.030
*	Ranking:	150
*/
public class Main12992 {

	/*
	 * - Muy fácil
	 * 
	 * No entiendo muy bien el porque resulta ser así
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		StringBuffer output = new StringBuffer();
		int n;
		for (int i = 1; i <= testCases; i++) {
			n = Integer.parseInt(br.readLine());
			output.append("Case #"+i+": "+(2*n - 1)+"\n");
		}
		System.out.print(output);
	}

}
