import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int casos=input.nextInt();
		double a,b,x,prom;
		while(casos-->0){
			a=input.nextInt();
			b=input.nextInt();
			x=input.nextInt();
			prom=(a+b)/3;
			System.out.println(Math.round((x*(a-prom))/prom));
		}
		// TODO Auto-generated method stub

	}

}
