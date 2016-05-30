import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		long a,b;
		while(input.hasNext())
		{
			a=input.nextLong();
			b=input.nextLong();
			if(a==0 && b==0)
			{
				break;
			}
			if(gcd(a,b))
			{
				System.out.println("Stan wins");
			}
			else
			{
				System.out.println("Ollie wins");
			}
		}
		input.close();
		// TODO Auto-generated method stub
	}

	private static boolean gcd(long a, long b) 
	{
		if(b>a)
		{
			return gcd(b,a);
		}
		if(b==0)
		{
			return false;
		}
		if(a/b==1)
		{
			return !gcd(b,a%b);
		}
		// TODO Auto-generated method stub
		return true;
	}

}
