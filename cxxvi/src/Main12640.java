import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader lect = new BufferedReader(new InputStreamReader(
				System.in));

		String linea = lect.readLine();

		while (true) {
			try {
				String temp[] = linea.split(" ");
				int size = temp.length;
				int[] numeros = new int[size];
				int suma = 0, mayor = 0;

				for (int i = 0; i < size; i++) {
					numeros[i] = Integer.parseInt(temp[i]);
					suma += numeros[i];
					if (suma > mayor) {
						mayor = suma;
					}
					if (suma < 0) {
						suma = 0;
					}
				}
				System.out.println(mayor);

				linea = lect.readLine();
			} catch (Exception e) {
				System.exit(0);
			}

		}
	}
}
