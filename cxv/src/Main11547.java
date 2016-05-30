import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int n;
		int k=input.nextInt();
		while(k>0)
		{
			k--;
			n=input.nextInt();
			n*=63;
			n+=7492;
			n*=5;
			n-=498;
			n/=10;
			
			System.out.println(Math.abs(n%10));
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
