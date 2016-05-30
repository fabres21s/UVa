import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int estaciones, milla;
		int arreglo[];
		StringBuffer output = new StringBuffer();
		while (input.hasNext()){
			estaciones = input.nextInt() ;
			if (estaciones == 0) {
				break;
			}
			arreglo = new int[estaciones*2];
			for (int i = 0; i< estaciones; i++){
				arreglo [i] = input.nextInt();
				arreglo[estaciones * 2 -1 -i] = 2844 - arreglo[i];
			}
			Arrays.sort(arreglo);
			boolean posible = true;
			for (int i = 0 ; i< estaciones*2 -1; i++){
				if (Math.abs(arreglo[i] -arreglo[i+1]) > 200){
					posible = false; 
					break;
				}
			}
			
			output.append(posible?"POSSIBLE\n":"IMPOSSIBLE\n");
			
		}
		System.out.print(output);
	}

}
