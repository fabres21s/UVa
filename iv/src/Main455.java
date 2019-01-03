import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
*	455 - Periodic Strings
*
*	Submission:	22531783
*	Date:		2018-12-31 15:56:44
*	Runtime:	0.050
*	Ranking:	5749
*/
public class Main455 {

	/**
	 * - Cadena de caracteres
	 * 
	 * Encontrar el mínimo número de carácteres que se repiten en una palabra
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		int length;
		String line;
		StringBuffer output = new StringBuffer();
		boolean firstCase = true;
		while (testCases > 0) {
			
			line = br.readLine();
			
			if (!line.isEmpty()) {
				testCases--;
				length = line.length();
				int size = length;
				for (int i = 1; i <= length/2; i++) {
					Set<String> set = new HashSet<String>();
					for (int j = 0; j <length; j+=i ) {
						set.add(line.substring(j, Math.min(j+i, length)));
					}
					if (set.size() == 1) {
						for (String s: set) {
							size = s.length();
						}
						break;
					}
					
				}

				if (!firstCase) {
					output.append("\n");
				}
				output.append(size);
				output.append("\n");
				firstCase  =false;
				
			}
		}
		System.out.print(output);
		
	}

}
