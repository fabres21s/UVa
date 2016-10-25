import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	13113 - Presidential Election
*
*
*	Submision:	17605733
*	Date:		2016-07-01 22:54:45	
*	Runtime:	0.470
*	Ranking:	16
*/
public class Main13113 {

	/**
	 * - Arreglos
	 * - Simulación
	 * 
	 * Encontrar el ganador o los que pasan a segunda ronda en una elección presidencial
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		int candidatos, regiones;
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < testCases; i++) {
			
			if (i > 0) {
				output.append("\n");
			}
			args = br.readLine().split(" ");
			candidatos = Integer.parseInt(args[0]);
			regiones = Integer.parseInt(args[1]);
			
			double [] resultados = new double[candidatos];
			double totalVotos = 0, votos;
			for (int j = 0; j < regiones; j++) {
				args = br.readLine().split(" ");
				votos = Double.parseDouble(args[candidatos]);
				totalVotos += votos;
				
				for (int x = 0; x < candidatos; x++) {
					resultados[x] += votos * Double.parseDouble(args[x]) / 100;
				}
			}
			
			double mayor1 = Math.max(resultados[0], resultados[1]), mayor2 = Math.min(resultados[1], resultados[0]);
			int posMayor1, posMayor2;
			posMayor1 = (resultados[0] > resultados[1]) ? 0 : 1;
			posMayor2 = (resultados[1] > resultados[0]) ? 0 : 1;
			
			if (resultados[0] == resultados[1]) {
				posMayor1 = 0;
				posMayor2 = 1;
			}
			
			for (int j = 2; j < candidatos; j++) {
				if (resultados[j] > mayor1) {
					
					posMayor2 = posMayor1;
					mayor2 = mayor1;
					
					posMayor1 = j;
					mayor1 = resultados[j];
				} else if (resultados[j] == mayor1) {
					if (resultados[j] > mayor2) {
						posMayor2 = j;
						mayor2 = resultados[j];
					}
				} else if (resultados[j] > mayor2) {
					posMayor2 = j;
					mayor2 = resultados[j];
				}
			}
			
			output.append((posMayor1 + 1) + " "+((int)mayor1)+"\n");
			
			if (mayor1 <= totalVotos / 2) {
				output.append((posMayor2 + 1) +" "+ ((int)mayor2) + "\n");
			}
		}
		System.out.print(output);
	}

}
