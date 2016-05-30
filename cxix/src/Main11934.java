import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int i,con;
		long a,b,c,d,l;
		while(true)
		{
			a=input.nextLong();
			b=input.nextLong();
			c=input.nextLong();
			d=input.nextLong();
			l=input.nextLong();
			if(a==0 && b==0 && c==0 && d==0 && l==0)
			{
				break;
			}
			con=0;
			for(i=0;i<=l;i++)
			{
				if((a*i*i+b*i+c)%d==0)
				{
					con++;
				}
			}
			System.out.println(con);
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
