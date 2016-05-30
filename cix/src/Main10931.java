import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String s,cs;
		int b,t;
		BigInteger a;
		b=10;
		t=2;
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext())
		{			

			s=sc.next();
			if(s.equals("0"))
			{
				break;
			}
				a=new BigInteger(s,b);
				cs=a.toString(t);
				System.out.println("The parity of "+cs+" is "+contarunos(cs)+" (mod 2).");
		}	
		sc.close();
		// TODO Auto-generated method stub
	}
	
	static int contarunos(String linea)
	{
		char [] p=linea.toCharArray();
		int c=0;
		for(int i=0;i<p.length;i++)
		{
			if(p[i]=='1')
			{
				c++;
			}
		}
		return c;
	}
}
