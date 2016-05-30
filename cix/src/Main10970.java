import java.io.IOException;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{	
		Scanner input=new Scanner(System.in);
		int m,n;
		while(input.hasNext())
		{
			m=input.nextInt();
			n=input.nextInt();
			System.out.printf("%d\n",m*n-1);
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
