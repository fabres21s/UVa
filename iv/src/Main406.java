import java.util.StringTokenizer;


/**
*	406 - Prime Cuts
*
*
*	Submision:	9362586
*	Date:		2011-10-12 13:03:58
*	Runtime:	1.280
*	Ranking:	6288
*/
class Main406 
{
	// Rotina de Leitura
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
		(new Main406()).begin();
	}

	private void begin() 
	{
		int primes[] = { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
				47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
				113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
				181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241,
				251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313,
				317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389,
				397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461,
				463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547,
				557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617,
				619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
				701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773,
				787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859,
				863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947,
				953, 967, 971, 977, 983, 991, 997 };		
		
		String input = readLn();
		while ( input != null ) 
		{
			StringTokenizer st = new StringTokenizer( input );
			int n = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			//Primeiro verifica o tamanho da lista
			int qtd = 0;
			while ( qtd < primes.length && primes[qtd] <= n ) 
			{
				qtd++;
			}			
			int ini = (qtd / 2) - c;
			int fim;
			if ( qtd % 2 == 0 ) 
			{
				fim = ini + (c*2) - 1;
			}
			else 
			{
				ini = ini + 1;
				fim = ini + (c*2) - 2;
			}			
			if ( ini < 0 ) 
			{
				ini = 0;
			}
			if ( fim > qtd - 1 ) 
			{
				fim = qtd - 1;
			}			
			StringBuffer sb = new StringBuffer();
			sb.append(n);
			sb.append(" ");
			sb.append(c);
			sb.append(": ");
			for ( int i = ini; i <= fim; i++ ) 
			{
				sb.append(primes[i]);
				if ( i != fim ) 
				{
					sb.append( " " );
				}
			}			
			System.out.println(sb);
			System.out.println();			
			input = readLn();
		}
	}
}