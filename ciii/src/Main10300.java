import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int k=input.nextInt(), f,j;
		long sum,a,c;
		for(int i=0;i<k;i++)
		{
			f=input.nextInt();
			sum=0;
			for(j=0;j<f;j++)
			{
				a=input.nextLong();
				c=input.nextLong();
				sum+=a*c;
			}
			System.out.println(sum);
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
