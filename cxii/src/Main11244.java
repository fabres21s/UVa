import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	11244 - Counting Stars
*
*
*	Submision:	17447344
*	Date:		2016-05-31 16:50:05
*	Runtime:	0.120
*	Ranking:	2118
*/
public class Main11244 {

	/**
	 * - Arreglos
	 * 
	 * Dado un arreglo que representa el cielo, siendo los '*' estrellas y los '.' espacios en blanco
	 * encontrar cuantas estrellas hay, teniendo en cuenta que si dos o más '*' se encuentran juntos,
	 * no son estrellas.
	 */
	//TODO Llevarlo al otro Workspace
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int rows, columns, i, stars, j;
		boolean star;
		while ( !(line = br.readLine() ).equals("0 0")) {
			args = line.split(" ");
			rows = Integer.parseInt(args[0]);
			columns = Integer.parseInt(args[1]);
			char sky[][] = new char[rows+2][columns+2];
			for ( i = 1; i <=rows; i ++) {
				for (j =1; j<=columns; j++) {
					sky[i][j] = (char)br.read();
				}
				br.readLine();
			}
			
			stars = 0;
			for (i = 1; i<=rows; i++) {
				for (j = 1; j <= columns; j++) {
					if (sky[i][j] == '*') {
						//sup
						star = true;
						if (sky[i-1][j-1] == '*' || sky[i-1][j] == '*' || sky[i-1][j+1] == '*') {
							star = false;
						}
						//lados
						else if (sky[i][j-1] == '*'  || sky[i][j+1] == '*') {
							star = false;
						}
						
						//inf
						else if (sky[i+1][j-1] == '*' || sky[i+1][j] == '*' || sky[i+1][j+1] == '*') {
							star = false;
						}
						if (star) {
							stars++;
						}
					}
				}
			}
			System.out.println(stars);
		}

	}

}
