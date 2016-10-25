import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
*	12802 - Gift From the Gods
*
*
*	Submision:	17633907
*	Date:		2016-07-07 21:13:43	
*	Runtime:	0.070
*	Ranking:	541
*/
public class Main12802 {

	/**
	 * - Números primos
	 * - Palíndromos
	 * 
	 *  Imprimir el doble del número ingresado hasta que el número ingresado sea
	 *  primo y palíndromo
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		int n;
		boolean print  = true;
		while ((line = br.readLine()) != null) {
			n = Integer.parseInt(line);
			if (print) {
				System.out.println(n * 2);
			}
			if (esprimo(n)) {
				if (palindromo(line)) {
					print = false;
				}
			}
			
		}
		
	}
	
	public static boolean esprimo(int num) {
		if (num == 1) {
			return false;
		}
		if (num == 2) {
			return true;
		}
		if (num % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean palindromo(String string) {
		char[] arreglo = string.toCharArray();
		int size = arreglo.length;
		int reverse = size - 1;
		for (int i = 0; i < size / 2; i++) {
			if (arreglo[i] != arreglo[reverse - i]) {
				return false;
			}
		}
		return true;
	}

}
