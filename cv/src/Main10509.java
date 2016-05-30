import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner (System.in);
		double n,dx,a;
		while((n=input.nextDouble())!=0)
		{
			a=(int) Math.cbrt(n);
			//a=r;
			//System.out.println("raiz "+r);
			if(a*a*a==n)
			{
				System.out.printf("%.4f\n",a);
				continue;
			}
			dx=(n-a*a*a)/(3*a*a);
			System.out.printf("%.4f\n",(a+dx));
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
