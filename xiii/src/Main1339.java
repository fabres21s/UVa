import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
*	1339 - Ancient Cipher
*
*	Submission:	25729027
*	Date:		2020-11-16 15:10:06
*	Runtime:	0.050
*	Ranking:	2395
*/
public class Main1339 {

	/**
	 *  - Arreglos
	 *  
	 *  Encontrar si un texto encriptado y uno en claro se corresponden
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		String line;
		
		while ((line = br.readLine()) != null) {
			char [] engraved = line.toCharArray();
			char [] original = br.readLine().toCharArray();
			
			int [] countEngraved = new int[30];
			int [] countOriginal = new int[30];
			
			for (int i =0; i < engraved.length; i++) {
				countEngraved[ engraved[i] - 65 ]++;
			}
			
			for (int i =0; i < original.length; i++) {
				countOriginal[ original[i] - 65 ]++;
			}
			
			Arrays.sort(countEngraved);
			Arrays.sort(countOriginal);
			
			output.append(Arrays.equals(countEngraved, countOriginal) ? "YES\n" : "NO\n");
		}
		System.out.print(output);
	}

}
