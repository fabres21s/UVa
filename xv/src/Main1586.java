import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

//TODO - Respuesta incorrecta, creo que es por el redonde de cifras ta vez
public class Main1586 {


	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());

		String letras[], numeros[];
		String line;
		
		
		Map<Character, Double> values = new HashMap<Character, Double>();
		values.put('C', 12.01);
		values.put('H', 1.008);
		values.put('O', 16.0);
		values.put('N', 14.01);
		DecimalFormat decimalFormat = new DecimalFormat("#.000");
		for (int i = 1; i <= testCases; i++) {
			StringBuffer output = new StringBuffer();
			line =  br.readLine();
			letras = line.replaceAll("[^A-Z]", "").split("");
			numeros = line.replaceAll("[A-Z]", " ").split(" ");
			
			int index =1;
			for (String letra: letras) {
				try {
					for(int x = 0; x < Integer.parseInt(numeros[index]); x++) {
						output.append(letra);
					}
				} catch (Exception exc ){
					output.append(letra);
				}
				index++;
			}
			
			char array []= output.toString().toCharArray();
			double sum  = 0;
			for (char c : array) {
				sum += values.get(c);
			}
			System.out.println(decimalFormat.format(sum).replaceAll(",", "."));
			
		}

	}
}
