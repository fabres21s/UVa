import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
*	1586 - Molar mass
*
*
*	Submision:	17579729
*	Date:		2016-06-26 22:22:47
*	Runtime:	0.070
*	Ranking:	2126
*/
public class Main1586 {

	/*
	 * - Map
	 * - Expresiones Regulares
	 * 
	 * Dada una fórmula química, encontrar la masa molar de ella
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());

		String letras[], numeros[];
		String line;
		
		
		Map<Character, Long> values = new HashMap<Character, Long>();
		values.put('C', 12010L);
		values.put('H', 1008L);
		values.put('O', 16000L);
		values.put('N', 14010L);
		for (int i = 1; i <= testCases; i++) {
			StringBuffer output = new StringBuffer();
			//la diferencia entre AC y WA era el .trim(), por qué, ni idea
			line =  br.readLine().trim();
			letras = line.replaceAll("[^A-Z]", "").split("");
			numeros = line.replaceAll("[A-Z]", " ").split(" ");
			
			int index =1;
			for (String letra: letras) {
				try {
					for(int x = 0; x < Integer.parseInt(numeros[index]); x++) {
						output.append(letra);
					}
				} catch (Exception exc ){
					output.append(letra);
				}
				index++;
			}
			
			char array []= output.toString().toCharArray();
			long sum  = 0;
			for (char c : array) {
				sum += values.get(c);
			}
			System.out.printf("%.3f\n", ((double)sum)/1000);
			
		}

	}
}
