import java.util.Scanner;


/**
*	408 - Uniform Generator
*
*
*	Submision:	10279738
*	Date:		2012-07-02 02:00:44
*	Runtime:	0.364
*	Ranking:	3136
*/
public class Main408 {

	/**
	 * - GCD
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);	
		int step,mod;
		while(input.hasNext())
		{			
			step=input.nextInt();
			mod=input.nextInt();
			System.out.printf("%10d%10d    ",step,mod);
			if(gcd(step,mod)==1)
			{				
				System.out.println("Good Choice");
				
			}
			else
				System.out.println("Bad Choice");
			System.out.println();
		}
		input.close();
	}

	private static int gcd(int a, int b) 
	{
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}
}
