import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
*	10929 - You can say 11
*
*
*	Submision:	17456904
*	Date:		2016-06-02 15:05:26
*	Runtime:	0.140
*	Ranking:	6666
*/
public class Main10929 {

	/**
	 * - Proceso matemático
	 * 
	 * Determinar si un número es multiplo de 11
	 * El proceso consiste en sumar todos los números en las posiciones pares
	 * y en las posiciones impares, por separado, y si la resta entre ellos 
	 * es multiplo de 11, el número original también lo es.
	 * Ej 142857
	 * Suma de posiciones impares = 1 + 2 + 5 = 8
	 * Suma de posiciones pares   = 4 + 8 + 7 = 19
	 * 19 - 8 = 11, por lo que 142857 es multiplo de 11
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String number ;
		while (!(number = br.readLine()).equals("0") ) {
			char [] array = number.toCharArray();
			int sumPosPar = 0, sumPosImpar = 0, index = 0;
			for (char c : array) {
				switch (index%2) {
					case 0:
						sumPosPar += c -48;
						break;
						
					case 1:
						sumPosImpar += c - 48;
						break;
				}
				index++;
			}
			if ((sumPosPar - sumPosImpar)%11 == 0) {
				System.out.println(number + " is a multiple of 11." );	
			} else {
				System.out.println(number + " is not a multiple of 11." );
			}
			
		}
	}

}
