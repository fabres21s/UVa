import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	13059 - Tennis Championship
*
*
*	Submision:	17535486
*	Date:		2016-06-17 19:27:52
*	Runtime:	0.820
*	Ranking:	147
*/
public class Main13059 {

	/*
	 * - Muy fácil
	 * - Simulación
	 * 
	 * En un torneo de tenis, con n jugadores y con eliminación directa, determinar cu�ntos partidos
	 * son necesarios para determinar un campeón
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
		String line;
		while (( line = br.readLine()) != null) {
			System.out.println(Long.valueOf(line) - 1);
		}
//		while (true ){
//			int players = input.nextInt();
//			int matches = 0;
//			while (players != 1){
//				matches += players /2;
//				players = players/2 + players%2;
//			}
//			System.out.println(matches);
//		}
	}

}
