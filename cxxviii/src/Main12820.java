import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


/**
*	12820 - Cool Word
*
*
*	Submision:	17634024
*	Date:		2016-07-07 17:02	
*	Runtime:	0.090
*	Ranking:	332
*/
public class Main12820 {

	/**
	 * - Validaciones
	 * 
	 *  Validar si una palabra es cool,lo es cuando tiene más de 2 letras
	 *  y cada letra aparece un número diferente de veces.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int testCases = 0;
		int words;
		StringBuffer output = new StringBuffer();
		while ((line = br.readLine()) != null) {
			testCases++;
			words = Integer.parseInt(line);
			int coolWords = 0;
			for (int i = 0; i < words; i++) {
				line = br.readLine();
				if (isCoolWord(line)) {
					coolWords++;
				}
				
			}
			//System.out.println("Case "+testCases+": "+coolWords);
			output.append("Case "+testCases+": "+coolWords+"\n");
			
		}
		System.out.print(output);
	}

	private static boolean isCoolWord(String word) {
		if (word.length() < 3) {
			return false;
		}
		char [] array = word.toCharArray();
		int [] values = new int[30];
		for (char c:array) {
			values[c - 97]++;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for (int value: values) {
			if (value > 0) {
				if (!set.add(value)) {
					return false;
				}
			}
		}
		if (set.size() == 1) {
			return false;
		}
 			
		return true;
	}

}

/*
locclocooclccoloc
mcfkvcgjnpjtztwmoxry
godcygroslpflk
iilqskcrtzsplwbpa
cyvzsgwgzyrjtbtptxxlyaww
oooooooo
qomeupdddilhnhdzxc
bbttttbtbbttrbtbbttt
fzlcqjguqzy
hmuknevryrwxec
nnndjnnjjjjnjnnnnnjnjjjjd
*/
