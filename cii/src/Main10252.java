import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String a,b;
		String tokensa[], tokensb[];
		Vector<String>soluciona=new Vector<String>();
		Vector<String>solucionb=new Vector<String>();
		int i;
		while((a=reader.readLine())!=null)
		{		
			soluciona.removeAll(soluciona);
			solucionb.removeAll(solucionb);
			b=reader.readLine();
			tokensa=a.split("");
			tokensb=b.split("");
			for( i=1;i<tokensb.length; i++)
			{			
				solucionb.add(tokensb[i]);
			}	
			for( i=1;i<tokensa.length;i++)
			{
				if(solucionb.contains(tokensa[i]))
				{
					soluciona.add(tokensa[i]);
					solucionb.remove(tokensa[i]);
				}
			}
			Collections.sort(soluciona);
			for( i=0; i<soluciona.size(); i++)
			{
				System.out.print(soluciona.get(i));
			}
			System.out.println();			
		}
		// TODO Auto-generated method stub
	}
}
