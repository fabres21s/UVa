import java.util.Scanner;

/**
*	10469 - To Carry or not to Carry
*
*
*	Submision:	9900800
*	Date:		2012-03-23 17:06:47
*	Runtime:	0.200
*	Ranking:	9605
*/
public class Main10469 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/*String v1,v2;
		char b1[],b2[];
		BigInteger a;
		int dif,tam1,tam2,i;*/
		Scanner input=new Scanner(System.in);
		while(input.hasNext())
		{
			System.out.println(input.nextLong()^input.nextLong());
			/*v1=input.next();
			v2=input.next();
			a=new BigInteger(v1,10);
			v1=a.toString(2);
			a=new BigInteger(v2,10);
			v2=a.toString(2);
			tam1=v1.length();
			tam2=v2.length();
			if(tam1!=tam2)
			{
				dif=Math.abs(tam1-tam2);
				System.out.print("sdfsd "+dif);
				if(tam1<tam2)				
					for(i=0;i<dif;i++)
						v1="0"+v1;				
				else
					for(i=0;i<dif;i++)
						v2+="0"+v2;					
			}
			b1=v1.toCharArray();
			b2=v2.toCharArray();
			v1="";
			for(i=0;i<b1.length;i++)
			{
				if(b1[i]=='0' && b2[i]=='0')
					v1+="0";
				else if(b1[i]=='0' && b2[i]=='1')
					v1+="1";
				else if(b1[i]=='1' && b2[i]=='0')
					v1+="1";
				else
					v1+="0";
			}
			//v1=b1.toString();
			a=new BigInteger(v1,2);
			System.out.println(a.toString(10));*/
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
