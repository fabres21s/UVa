

/**
*	424 - Integer Inquiry
*
*
*	Submision:	9362627
*	Date:		2011-10-12 13:16:13
*	Runtime:	0.160
*	Ranking:	9897
*/
class Main424 
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
	            buffer.append((char)car);
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
	    return (buffer.toString()).trim();
	}
	
	public static void main(String args[]) // entry point from OS
	{
		Main424 myWork = new Main424(); // create a dinamic instance
		myWork.Begin();
	}	
	
	void Begin() 
	{
		String input = readLn();
		int soma[] = toIntArray(input);
		input = readLn();
		while ( !input.equals("0")) 
		{
			int[] n = toIntArray(input);
			soma = add( soma, n);
			input = readLn();
		}		
		StringBuffer sb = new StringBuffer();
		int i = soma.length - 1;
		if ( soma[i] != 0 ) 
		{
			sb.append(soma[i]);			
		}
		i--;
		for ( ; i >= 0; i-- ) 
		{
			sb.append(soma[i]);
		}
		System.out.println(sb.toString());
	}
	int ZEROOFFSET = (int)'0';
	private int[] toIntArray(String input) 
	{
		int tam = input.length();
		int result[] = new int[tam];
		for ( int i = tam-1; i >= 0; i-- ) 
		{
			result[i] = (int)input.charAt( tam - i - 1 ) - ZEROOFFSET;
		}
		return result;
	}

	private int[] add(int[] a, int[] b) 
	{
		int[] bigger;
		int[] smaller;
		if ( a.length > b.length ) 
		{
			bigger = a;
			smaller = b;
		}
		else
		{
			bigger = b;
			smaller = a;
		}
		//Verifica o tamanho e instancia o vetor
		int tamanho = bigger.length;
		if ( bigger[tamanho - 1] != 0 ) 
		{
			tamanho++;
		}
		int[] result = new int[tamanho];
		
		//comeca a soma... indo at o menor...
		int carry = 0;
		for ( int i = 0; i < smaller.length; i++ ) 
		{
			int soma = bigger[i] + smaller[i] + carry;
			carry = soma / 10;
			result[i] = soma % 10;
		}
		
		//Se o maior for mais longo...
		if ( bigger.length > smaller.length ) 
		{
			for ( int i = smaller.length; i < bigger.length; i++ ) 
			{
				int soma = bigger[i] + carry;
				carry = soma / 10;
				result[i] = soma % 10;
			}
		}
		
		//Se sobrou carry...
		if ( carry != 0 ) 
		{
			result[tamanho-1] = carry;
		}		
		return result;
	}	
}