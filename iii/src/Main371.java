import java.util.Scanner;

/**
*	371 - Ackermann Functions
*
*
*	Submision:	9332330
*	Date:		2011-10-04 00:42:06
*	Runtime:	0.332
*	Ranking:	3618
*/
public class Main371 
{
	static int mayor=0;

	/**
	 * - Proceso matemático
	 */
	public static void main(String[] args) 
	{
		int a, b,p;
		Scanner input=new Scanner (System.in);
		while (input.hasNext())
		{
			mayor=0;
			a = input.nextInt();
			b = input.nextInt();	
			if(a==0 && b==0)
			{
				break;
			}
			p=numCicloMax(Math.min(a, b), Math.max(a, b));
			System.out.println("Between "+Math.min(a, b) +" and " + Math.max(a, b)  + ", " +mayor+" generates the longest sequence of "+ p+" values.");
		} 
		input.close();
	}
	
	static int numCicloMax(int a, int b) 
	{
		int cicloMax = -1; 
		for (int i = a; i <= b; i++) 
		{
			//System.out.println("iteraciones "+i);
			int con = numIteraciones(i);			
			if (con > cicloMax) 
			{ 
				cicloMax = con;
				mayor=i;
				
			}
		}
		return cicloMax-1; 		
	} 
	
	static int numIteraciones(int n) 
	{
		int cont = 1;	
		if(n==0)
		{
			return 1;
		}
		if(n==1)
		{
			return 4;
		}
		while (n>1)
		{
			if (n % 2 == 1) 
			{
				n = (3 * n) + 1;
			}
			else
			{
				n = n / 2;
			}
			
			cont++;

		}
		return cont;
	}
}
