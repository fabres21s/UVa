import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 11541 - Decoding
 *
 *
 * Submission: 17452194 
 * Date: 2016-06-01 15:25:55 
 * Runtime: 0.060 
 * Ranking: 3234
 */
public class Main11541 {

	/**
	 * - Arreglos
	 * - Expresiones Regulares
	 * 
	 * Dada una cadena con la secuencia letra n�mero, imprimir la letra
	 * tantas veces seg�n el n�mero.
	 * Ej: A1B2C3 -> ABBCCC
	 * Se utilizan las expresiones regulares para separar los n�meros y las letras
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());

		String letras[], numeros[];
		String line;
		StringBuffer output = new StringBuffer();
		for (int i = 1; i <= testCases; i++) {
			output.append("Case "+i+": ");
			line =  br.readLine();
			letras = line.replaceAll("[^A-Z]", "").split("");
			numeros = line.replaceAll("[A-Z]", " ").split(" ");
			
			int index =1;
			for (String letra: letras) {
				for(int x = 0; x < Integer.parseInt(numeros[index]); x++) {
					output.append(letra);
				}
				index++;
			}
			output.append("\n");
			
		}
		System.out.print(output);

	}
}
