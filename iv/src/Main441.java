import java.util.Scanner;

/**
*	441 - Lotto
*
*
*	Submision:	16909882
*	Date:		2016-02-26 15:27:51
*	Runtime:	0.149
*	Ranking:	5862
*/
public class Main441 {

	/**
	 * - Arreglos
	 * 
	 * Encontrara forma de imprimir n números diferentes, en grupos de 6
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		int casos = 0;
		while ( (n = input.nextInt()) != 0 ) {
			if (casos > 0) {
				System.out.println();
			}
			int arreglo[] = new int[n];
			int i,j,k,x,y,z;
			
			for ( i = 0; i < n; i++) {
				arreglo [i] = input.nextInt();
			}
			
			for (i = 0; i < (n-5); i ++) {
				for (j=i+1; j <(n-4); j++) {
					for (k=j+1; k <(n-3); k++) {
						for (x=k+1; x <(n-2); x++) {
							for (y=x+1; y <(n-1); y++) {
								for (z=y+1; z <(n); z++) {
									System.out.println(arreglo[i]+ " "+arreglo[j]+ " "+arreglo[k]+ " "+arreglo[x]+ " "+arreglo[y]+ " "+arreglo[z]);
								}
							}
						}
					}
				}
			}
			casos++;
		}
		input.close();
	}

}
