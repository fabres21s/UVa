import java.util.Scanner;

/**
*	1368 - DNA Consensus String
*
*
*	Submision:	16840307
*	Date:		2016-02-12 19:11:48
*	Runtime:	0.116
*	Ranking:	986
*/
public class Main1368 {

	
	/**
	 * - Arreglos
	 * En una columna, ver la letra que más se repetía, y contar las que eran diferentes a la 
	 * que más se repite y cambiarlas
	 */
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int testCases = input.nextInt();
		
		while(testCases -- > 0) {
			
			int m = input.nextInt();
			int n = input.nextInt();
			char [][] array = new char[m][n];
			for (int i=0; i<m;i++) {
				array[i] = input.next().toCharArray();
			}
			
			int A,T,G,C;
			int changes = 0;
			for (int i = 0; i<n; i++) {
				A = T = G = C=0;
				for (int j = 0; j < m; j++) {
					switch (array[j][i]) {
					case 65:
							A++;
						break;
						
					case 67:
						C++;
						break;
						
					case 71:
						G++;
						break;
						
					case 84:
						T++;
						break;

					default:
						break;
					}
				}
				
				char charMax = 0; 
				if (A >= C && A>=G && A>=T) {
					charMax = 'A';
					changes = changes + (m - A);
				} else 
				
				if (C >= A && C>=G && C>=T) {
					charMax = 'C';
					changes = changes + (m - C);
				} else
				
				if (G >= A && G>=C && G>=T) {
					charMax = 'G';
					changes = changes + (m - G);
				} else
				
				if (T >= A && T>=G && T>=C) {
					charMax = 'T';
					changes = changes + (m - T);
				}
				
				for (int j = 0; j < m; j++) {
					if (array[j] [i] != charMax){
						array[j][i] = charMax;
					}
				}
				
				
			}
			
			
		//	for (int i = 0; i<m; i++){
				System.out.println(new String(array[0]));
				System.out.println(changes);
			//}
			
			
		}
		input.close();
	}
}
