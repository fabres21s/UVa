import java.util.Arrays;
import java.util.Scanner;

/**
*	11364 - Parking
*
*
*	Submision:	17448783
*	Date:		2016-06-01 01:09:50
*	Runtime:	0.080
*	Ranking:	5620
*/
public class Main11364 {

	/**
	 * - Arreglos
	 * - Simulación
	 * 
	 * Dado un arreglo, ordenarlo, sacar el promedio y encontrar el número que más se acerque a dicho promedio
	 * para posteriormente encontrar las diferencias absolutas con el primer y último elemento del arreglo
	 * y multiplicarlas por 2.
	 * 
	 * Los arreglos son distancias en un centro comercial, desde los parqueaderos, hacía las tiendas,
	 * el objetivo es minimizar la distancia de recorrido, saliendo del parqueadero, pasando por todas las tiendas
	 * y volver al parqueadero.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int testCases = input.nextInt();
		int stores;
		for (int i = 0; i < testCases; i++) {
			stores = input.nextInt();
			int sum = 0;
			int parking[] = new int[stores];
			for (int j = 0; j < stores; j++) {
				parking[j] = input.nextInt();
				sum += parking[j];
			}
			Arrays.sort(parking);
			int prom = sum / stores;
			int min = 100;
			for (int j = 0; j < stores; j++) {
				if (Math.abs(parking[j] - prom) < min) {
					min = parking[j];
				}
			}
			
			System.out.println(Math.abs(min - parking[0])*2 + Math.abs(min-parking[stores -1 ])*2);
		}
		input.close();
	}

}
