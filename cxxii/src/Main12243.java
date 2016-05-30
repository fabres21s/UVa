import java.util.Scanner;

/*
 *   Fabio Andrés Sierra Jaraba
 *   Flowers Flourish From France
 *   
 *   UVa:  12243
 *    
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		String s;
		    while(input.hasNext())
		    {
		    	s=input.nextLine();
		    	if(s.equals("*"))
		    	{
		    		break;
		    	}
		        int i = 0, n = s.length()-1;
		        char ch = ops(s.charAt(0));
		        boolean flag = true;
		        while(s.charAt(i) != ' ' && i < n)
		        {
		        	i++;
		        }
		        while(i < n)
		        {
		            i++;
		            if(ch != ops(s.charAt(i))) 
		            {
		            	flag = false;
		            }
		            while(s.charAt(i) != ' ' && i < n) 
		            {
		            	i++;
		            }
		        }
		        if(flag)
		        {
		        	System.out.println("Y");
		        }
		        else
		        {
		        	System.out.println("N");
		        }
		    }
		
		// TODO Auto-generated method stub

	}
	
	static char ops(char ch)
	{
	    if(ch < 'a')
	    {
	    	return (char) (ch+32);
	    }
	    return ch;
	}

}
