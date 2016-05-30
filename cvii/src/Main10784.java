import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		long N, n;
		long C=1;
		Scanner in = new Scanner( System.in );
		while( true )
		{
			N = in.nextLong();
			if( N==0 )
				break;
			n = (long)(3 + Math.sqrt(
					9.0+8.0*(N-1) ) )/2;
			System.out.println("Case "+ C +": "+ (n+1) );
			C++;
		}
		in.close();
		// TODO Auto-generated method stub		
	}
}
