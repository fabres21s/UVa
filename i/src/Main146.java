import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


public class Main146 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String st=reader.readLine();
		while(!st.equals("#"))
		{
			LinkedList<Character>ll=new LinkedList<Character>();
			boolean found=false;
			char c[]=st.toCharArray();
			int i=0;
			for( i=c.length-1;i>=0&&!found;i--)
			{
				char ch=c[i];

				Iterator<Character>it=ll.iterator();
				while(it.hasNext()&&!found)
				{

					char x=it.next();
					if(x>ch)
					{
						found=true;

						c[i]=x;

						it.remove();

					}
				}

				ll.add(ch);
			}
			if(found)
			{
				i=i+2;
				Collections.sort(ll);
				Iterator<Character>it=ll.iterator();

				while(it.hasNext())
				{
					c[i++]=it.next();
				}
				String s="";
				for(int j=0;j<c.length;j++)
					s+=c[j];
				System.out.println(s);

			}
			else
				System.out.println("No Successor");
			st=reader.readLine();
		}


		
		// TODO Auto-generated method stub
	}
	
	
	

}
