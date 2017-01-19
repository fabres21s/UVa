import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	13130 - Cacho
*
*
*	Submision:	18495595
*	Date:		2016-12-13 17:29:21
*	Runtime:	0.040
*	Ranking:	140
*/
public class Main13130 {

	/**
	 * - Validaciones
	 * 
	 * Verificar que todos los números sean consecutivos
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCases; i++) {
			args = br.readLine().split(" ");
			String last = "";
			boolean scale = true;
			for (String s: args) {
				if (last.compareTo(s) != -1) {
					scale = false;
					break;
				}
				last = s;
			}
			
			System.out.println(scale ? "Y" : "N");
		}
	}

}
