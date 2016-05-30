import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int a,b,c,casos=input.nextInt();
		while(casos-->0){
			a=input.nextInt();
			b=input.nextInt();
			c=input.nextInt();
			if((a+b<=c || (a+c)<=b) || (b+c)<=a)
				System.out.println("Wrong!!");
			else
				System.out.println("OK");
		}
	}

}
