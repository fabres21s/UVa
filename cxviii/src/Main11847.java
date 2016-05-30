import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner (System.in);
		int n;
		while((n=input.nextInt())!=0){
			System.out.println((int)(Math.log10(n)/Math.log10(2)));
		}

	}

}
