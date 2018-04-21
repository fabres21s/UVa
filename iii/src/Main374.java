import java.util.Scanner;


/**
*	374 - Big Mod
*
*
*	Submission:	9573613
*	Date:		2011-12-19 01:56:54
*	Runtime:	0.116
*	Ranking:	10561
*/
public class Main374 {

	/**
	 * - Modular
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int b,p,m,i,r,cary,x,d;
		while(input.hasNext())
		{
			int a[]=new int [46344];
			b=input.nextInt();
			p=input.nextInt();
			m=input.nextInt();
			if(b==0)
			{
				System.out.println(0);
				continue;
			}
			if(p==0)
			{
				System.out.println(1%m);
				continue;
			}
			if(b%m==0)
			{
				System.out.println(0);
				continue;
			}
			cary=1;
			i=0;
			while(true)
			{
				d=b%m;
				x=d*cary;
				cary=x%m;
				if(a[cary]>0)
				{
					break;
				}
				a[cary]=1;
				i++;
			}
			r=p%i;
			cary=1;
			d=b%m;
			for(i=1;i<=r;i++)
			{
				x=d*cary;
				cary=x%m;
			}
			System.out.println(cary);
		}
		input.close();
	}
}
