import java.awt.im.InputContext;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sumInicial, r, sumReal;
		StringBuffer buffer = new StringBuffer();
		while (input.hasNext()) {
			sumInicial = input.nextInt();
			if (sumInicial == 0) {
				break;
			}
			
			r = (int)((-1 + Math.sqrt(1 + 8*sumInicial))/2 + 1);//de la fórmula de la sumatoria de los números
			
			sumReal = r*(r+1)/2;
			buffer.append((sumReal - sumInicial)+" "+r+"\n");
		}
		System.out.print(buffer);
		input.close();
	}

}
