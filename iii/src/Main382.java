import java.util.Scanner;


/**
*	382 - Perfection
*
*
*	Submision:	9341381
*	Date:		2011-10-06 17:17:20
*	Runtime:	0.112
*	Ranking:	11541
*/
public class Main382 {

	/**
	 * - Números Perfectos
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner (System.in);
		int n=-1, cont;
		StringBuffer buf=new StringBuffer();
		buf.append("PERFECTION OUTPUT\n");
		while((n=input.nextInt())!=0)
		{
			cont=1;
			for(int i=2;i<Math.sqrt(n);i++)
			{
				if(n%i==0)
				{
					cont+=i+n/i;
				}
			}
			
			int mul=10000;
			//System.out.println(n);
			while(n%mul>=n)
			{
				//System.out.println("para "+n+"  mul  "+mul+"  "+n%mul);
				mul/=10;
				buf.append(" ");
				//mul/=10;
			}
			if(n==1)
			{
				buf.append(n+"  DEFICIENT\n");
			}
			else if(cont==n)
			{
				buf.append(n+"  PERFECT\n");
			}
			else if(cont>n)
			{
				buf.append(n+"  ABUNDANT\n");
			}
			else
			{
				buf.append(n+"  DEFICIENT\n");
			}
		}
		buf.append("END OF OUTPUT");
		System.out.println(buf);
		

	}

}
