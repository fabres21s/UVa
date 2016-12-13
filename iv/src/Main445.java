
/**
*	445 - Marvelous Mazes
*
*
*	Submision:	9366746
*	Date:		2011-10-13 14:42:49
*	Runtime:	0.112
*	Ranking:	9152
*/
class Main445 
{

    static String readLn() 
    {
    	String newLine = System.getProperty("line.separator");
    	StringBuffer buffer = new StringBuffer();
    	int car = -1;
    	try    	
    	{
    		car = System.in.read();
    		while ((car > 0) && (car != newLine.charAt(0)))    			
    		{
    			buffer.append((char) car);
    			car = System.in.read();    			
    		}
    		if (car == newLine.charAt(0))
    			System.in.skip(newLine.length() - 1);
    	}
    	catch (java.io.IOException e)    	
    	{
    		return (null);
    	}
    	if ((car < 0) && (buffer.length() == 0))
    		return (null);
    	return (buffer.toString().trim());
    }

	/**
	 * TODO Asignar Categoría!!!
	 */
    public static void main(String[] args) 
    {
    	String input = readLn();
    	while ( input != null ) 
    	{
    		if ( input.length() == 0 ) 
    		{
    			System.out.println();
    		}
    		else
    		{
    			int pos = 0;
    			StringBuffer out = new StringBuffer();
    			while ( pos < input.length() ) 
    			{
    				int qtd = 0;
    				char chr = input.charAt(pos++);
    				if ( chr == '!') 
    				{
    					out.append("\n");
    				}
    				else
    				{
    					while ( Character.isDigit(chr) ) 
    					{                                                  
    						qtd = qtd + Integer.parseInt("" + chr); 
    						chr = input.charAt(pos++);
    					}
    					if ( chr == 'b') 
    					{
    						chr = ' ';
    					}
    					for ( int i = 0; i < qtd; i++ ) 
    					{
    						out.append( chr );
    					}
    				}
    			}
    			System.out.println(out);
    		}
    		input = readLn();
    	}
    }
}