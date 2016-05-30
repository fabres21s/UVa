import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		Scanner input=new Scanner(System.in);
		//long filas[]=new long[200];
		//BigInteger p;
		double p;
		int k=input.nextInt();
		while(k>0)
		{
			k--;
			p=input.nextDouble();
			System.out.printf("%.0f\n",Math.floor((Math.sqrt(1+8*p)-1)/2));
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
