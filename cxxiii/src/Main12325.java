import java.util.Scanner;

//TODO WA - Zombie's Treasure Chest 
public class Main12325 
{
	/**
	 * Wrong Answer - Hay unos casos de prueba (udebug) que no correspoonden
	 * toca volver a leer el problema 
	 
	 */
	public static void main(String[] args) 
	{		
		System.out.println(Long.MAX_VALUE);
		Scanner input=new Scanner(System.in);
		long t,n,s1,v1,s2,v2,k;
		t=input.nextInt();
		for(k=1;k<=t;k++)
		{
			n=input.nextLong();
			s1=input.nextLong();
			v1=input.nextLong();
			s2=input.nextLong();
			v2=input.nextLong();
			System.out.println("Case #"+k+": "+Math.max(evaluar(s1,v1,s2,v2,n), evaluar(s2,v2,s1,v1,n)));
		}	
		input.close();
	}
	
	static long evaluar(long a, long b, long c, long d, long n)
	{
		long m1=n/a;
		n=n%a;
		long m2=n/c;	
//		System.out.println(m1+" "+m2);
		System.out.println((b*m1+d*m2));
		return b*m1+d*m2;
	}	
}
/*
#include "stdio.h"
#include "conio.h"
int evaluar(int a,int b, int c, int d, int n);

void main()
{
int t,n,s1,v1,s2,v2,k;


scanf("%d",&t);
		for(k=1;k<=t;k++)
		{
		scanf("%d",&n);
		      //	n=input.nextInt();
		      scanf("%d",&s1);
			//s1=input.nextInt();
			scanf("%d",&v1);
		      //	v1=input.nextInt();
		      scanf("%d",&s2);
		      //	s2=input.nextInt();
		      scanf("%d",&v2);
		       //	v2=input.nextInt();
			int a=evaluar(s1,v1,s2,v2,n);
			int b=evaluar(s2,v2,s1,v1,n);
			if(a>b)
			{
			  printf("Case #%d: %d\n",k,a);
			}
			else
			{
			  printf("Case #%d: %d\n",k,b);
			}
//printf("Case #"+k+": "+Math.max(evaluar(s1,v1,s2,v2,n), evaluar(s2,v2,s1,v1,n)));
		}
		getch();
}

int evaluar(int a, int b, int c, int d, int n)
	{
		int m1=n/a;
		n=n%a;
		int m2=n/c;
	       //	System.out.println((a*m1+c*m2)+"  "+(b*m1+d*m2));
		return b*m1+d*m2;
	}

*/