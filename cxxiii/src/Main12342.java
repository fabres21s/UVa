import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt() +1;
		double pay, k;
		for (int i = 1; i < cases; i++) {
			pay = 0;
			k = input.nextInt() - 180000;
			
			if (k > 0){
				if ( k <= 300000) {
					pay = pay + k/10;
				} else {
					pay = pay +30000;
				}
				k = k - 300000;
				if (k > 0) {
					if (k < 400000){
						pay = pay + k*15/100;
					} else {
						pay = pay + 60000;
					}
					k = k - 400000;
					if (k > 0) {
						if (k < 300000){
							pay = pay + k/5;
						} else {
							pay = pay + 60000;
						}
						k = k-300000;
						if (k > 0){
							pay = pay+k/4;
						}
					}
				}
			}
			
			if (pay >0 && pay < 2000) {
				pay = 2000;
			}
			k = (int)pay;
			if (k != pay){
				k++;
			}
			System.out.println("Case "+i+": "+(int)k);
		}
		input.close();
	}

}
