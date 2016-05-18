import java.util.Scanner;

/*
 *   Fabio Andr�s Sierra Jaraba
 *   Power Of Cryptography  
 *   UVa:  113
 *    
 */

public class Main113 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		double n,p;
		long k;
		while(input.hasNext())
		{
			n=input.nextDouble();
			p=input.nextDouble();
			//k=(long)(Math.log10(p)/Math.log10(n));
			k=(long)Math.round(Math.pow(p, 1/n));
			System.out.println(k);
		}
		// TODO Auto-generated method stub

	}

}
