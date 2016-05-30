/*
 *   Fabio Andr�s Sierra Jaraba
 *   Pi
 *   UVa:  412
 *    
 */
/**
*	412 - Pi
*
*
*	Submision:	9362608
*	Date:		2011-10-12 13:10:56
*	Runtime:	0.704
*	Ranking:	3498
*/
class Main412 
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

	public static void main(String[] args) 
	{
		try 
		{
			(new Main412()).begin();
		}
		catch (Throwable t)
		{
			while (true) 
			{
			}
		}
	}

	private void begin() 
	{
		int n = Integer.parseInt(readLn());
		while (n != 0) 
		{
			int numeros[] = new int[n];
			for (int i = 0; i < n; i++) 
			{
				numeros[i] = Integer.parseInt(readLn());
			}

			// Procura o numero de pares
			int pairCount = 0;
			for (int i = 1; i < n; i++) 
			{
				for (int j = 0; j < i; j++) 
				{
					if (gcd(numeros[i], numeros[j]) == 1) 
					{
						pairCount++;
					}
				}
			}
			int totalPairs = n * (n - 1) / 2;
			if (pairCount == 0) 
			{
				System.out.println("No estimate for this data set.");
			}
			else
			{
				double est = Math.sqrt(6.0 * totalPairs / pairCount);
				String out = round(est, 6);
				System.out.println(out);
			}
			n = Integer.parseInt(readLn());
		}
	}

	static String str(char ch, int n) 
	{
		String resultado = "";
		for (int i = 0; i < n; i++) 
		{
			resultado += ch;
		}
		return resultado;
	}

	static String round(double valor, int casas) 
	{
		long numero = Math.round(valor * Math.pow(10, casas));
		String retorno;
		if (numero < 0)
			retorno = "-";
		else
			retorno = "";
		retorno += (Math.abs(numero) / (long) Math.pow(10, casas));
		retorno += ".";
		String resto = "" + (Math.abs(numero) % (long) Math.pow(10, casas));
		resto = str('0', casas - resto.length()) + resto;
		retorno += resto;
		return retorno;
	}

	private int gcd(int i, int j) 
	{
		while (j != 0) 
		{
			int t = j;
			j = i % j;
			i = t;
		}
		return i;
	}
}