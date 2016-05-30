import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	/*
	Determinar si una cadena es palindroma
	uso de expresiones regulares para reemplazar ,.?! por ""
	 * 
	 */
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line ="";
		while (!(line = br.readLine()).equals("DONE")){
			if (palindromo(line.trim().toLowerCase().replaceAll("[,|.|?|!|\\s]", ""))){
				System.out.println("You won't be eaten!");
			} else {
				System.out.println("Uh oh..");
			}
		}
	}

	private static boolean palindromo(String string) {
		char  []  arreglo = string.toCharArray();
		int size = arreglo.length;
		int reverse = size-1;
		for (int i = 0; i<size/2; i++){
			if (arreglo[i] != arreglo[reverse-i]){
				return false;
			}
		}
		return true;
	}

	

}



