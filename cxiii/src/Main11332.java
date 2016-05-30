import java.util.Scanner;

public class Main 
{
	static int sum;

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int n;
		while((n=input.nextInt())!=0)
		{
			descomponer(n);
			System.out.println(sum);
		}
		input.close();
		// TODO Auto-generated method stub
	}
	
	static void descomponer(int n)
	{
		sum=0;
		while(n>0)
		{
			sum+=n%10;
			n=n/10;
			//mul*=10;
			//System.out.println(n+"   "+sum);
		}
		if(sum>9)
		{
			descomponer(sum);
		}
	}

}
