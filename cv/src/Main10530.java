import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	/**
	 * 10530 - Guessing Game
	 * Arreglo - Validaciones
	 * El juego de adivinar un número del 1 al 10 y verificar
	 * si la persona cambia el número, hace trampa, o está siendo honesto 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		String line;
		while ( (n = Integer.valueOf(br.readLine())) != 0 ) {
			
			boolean array []=  new boolean [12];
			int inicio, fin;
			while (!( line = br.readLine() ).equals("right on")) {
				if (line.equals("too high")) {
					inicio = n;
					fin =10;
				} else {
					inicio = 0;
					fin = n;
				}
				
				for (int i = inicio; i<=fin; i++) {
					array[i] =true;
				}
				
				n = Integer.valueOf(br.readLine());
			}
			
			if (array[n]) {
				System.out.println("Stan is dishonest");
			} else {
				System.out.println("Stan may be honest");
			}
			
		}
		
	}

}
