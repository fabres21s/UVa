import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int i,j,n,sum;
		while((n=input.nextInt())!=0)
		{
			sum=0;
			for(i=1;i<n;i++)
				for(j=i+1;j<=n;j++)
					sum+=gcd(i,j);
			System.out.println(sum);
		}
		input.close();
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
