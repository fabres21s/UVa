import java.util.Scanner;

/* Fabio Andr�s Sierra
 * Fermat vs. Pitagoras
 * UVa: 106
 */
public class Main106 
{
	static int n,total;
	static int [] ss=new int [1000002];

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		while(input.hasNext())
		{
			n=input.nextInt();
			calcular();
		}
		// TODO Auto-generated method stub

	}

	private static void calcular() 
	{
		int m,r,s,x,y,k,z,up,tri=0,total=0;
		m=(int) Math.sqrt(n);
		if(m*m<n)
		{
			m++;
		}
		for(r=1;r<=m;r++)
		{
			up=Math.min((n-r*r), (r-1));
			for(s=1;s<=up;s++)
			{
				x=r*r-s*s;
				y=2*r*s;
				z=r*r+s*s;
				if((x*x+y*y)==z*z && z<=n)
				{
					if(gcd(x,y)==1)
					{
						tri++;
						for(k=1;k*z<=n;k++)
						{
							ss[k*x]=1;
							ss[k*y]=1;
							ss[k*z]=1;
						}
					}
				}
			}
		}
		for(k=1;k<=n;k++)
		{
			if(ss[k]==0)
			{
				total++;
			}
			ss[k]=0;
		}
		System.out.printf("%d %d\n",tri,total);
		// TODO Auto-generated method stub		
	}
	
	private static int gcd(int a, int b) 
	{
		if(b>0)
		{
			return gcd(b,a%b);
		}
		return a;
	}
}
