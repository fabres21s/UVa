import java.util.Scanner;

/**
 * 414 - Machined Surfaces
 * Arreglos - Simulación
 * Determinar cuantos espacios en blanco hay, y cuantos pueden ser eliminados
 * teniendo en cuenta que solo se pueden eliminar la menor cantidad de espacios blancos en todas las filas
 * @author fabio
 *
 */
/**
*	414 - Machined Surfaces
*
*
*	Submision:	16967881
*	Date:		2016-03-07 17:17:31
*	Runtime:	0.065
*	Ranking:	6933
*/
public class Main414 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rows ;
		while ( (rows = Integer.valueOf(input.nextLine())) != 0) {
			char array [][] = new char[rows][25];
			for (int i =0;  i < rows; i++) {
				array[i] = input.nextLine().toCharArray();
			}
			
			int min = 25;
			int totalBlanks = 0;
			int blanks = 0;
			for (int i = 0; i <rows; i++) {
				blanks = 0;
				for (int j = 0; j<25; j++) {
					if (array[i][j] == ' ') {
						blanks++;
					}
				}
				totalBlanks += blanks;
				min = Math.min(min, blanks);
			}
			
			System.out.println(totalBlanks - (min*rows));
		}
		input.close();
	}

}