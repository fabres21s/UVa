import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		long n,m,k,i,d;
		Scanner input=new Scanner(System.in);
		while((n=input.nextLong())!=0)
		{
			k=d=0;
			for(i=0;i<n;i++)
			{
				m=input.nextLong();
				k+=Math.abs(d);
				d+=m;
			}
			System.out.println(k);			
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
