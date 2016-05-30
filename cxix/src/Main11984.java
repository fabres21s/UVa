import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		double c;
		int casos=input.nextInt();
		for(int i=1;i<=casos;i++)
		{			
			c=input.nextDouble();
			c=9*c/5+32;
			//System.out.println("   "+c);
			c+=input.nextDouble();
			c=5*(c-32)/9;
			System.out.printf("Case %d: %.2f\n",i,c);
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
