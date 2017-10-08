import java.util.StringTokenizer;


/**
*	446 - Kibbles "n" Bits "n" Bits "n" Bits
*
*
*	Submision:	9366808
*	Date:		2011-10-13 14:58:46
*	Runtime:	0.104
*	Ranking:	4802
*/
class Main446 
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
	 * - Sistemas de numeración
	 * 
	 * Leer 2 números en hexadecimal, pasarlos a binario y mostrar el resultado de la suma o resta en decimal
	 */
	public static void main(String[] args) 
	{
		(new Main446()).begin();
	}

	private void begin() 
	{
		int tc = Integer.parseInt( readLn() );
		for ( int i = 0; i < tc; i++ ) 
		{
			String input = readLn();
			StringTokenizer st = new StringTokenizer(input);
			String firstHex = st.nextToken();
			String firstBinary = toBinary(firstHex);
			int    firstInt = toInt( firstHex );
			String op = st.nextToken();
			String secondHex = st.nextToken();
			String secondBinary = toBinary(secondHex);
			int    secondInt = toInt( secondHex );
			int result = (op.equals("+"))?firstInt+secondInt:firstInt-secondInt;
			System.out.println(firstBinary + " " + op + " " + secondBinary + " = " + result );
		}
	}

	private int toInt(String hex) 
	{
		int result = 0;
		for ( int i = 0; i < hex.length(); i++ ) 
		{
			result = result * 16;
		    char c = hex.charAt(i);
			switch (c) 
			{
			    case '0' : result = result + 0; break;
			    case '1' : result = result + 1; break;
			    case '2' : result = result + 2; break;
			    case '3' : result = result + 3; break;
			    case '4' : result = result + 4; break;
			    case '5' : result = result + 5; break;
			    case '6' : result = result + 6; break;
			    case '7' : result = result + 7; break;
			    case '8' : result = result + 8; break;
			    case '9' : result = result + 9; break;
			    case 'A' : result = result + 10; break;
			    case 'B' : result = result + 11; break;
			    case 'C' : result = result + 12; break;
			    case 'D' : result = result + 13; break;
			    case 'E' : result = result + 14; break;
			    case 'F' : result = result + 15; break;
			}
		}
		return result ;
	}

	private String toBinary(String hex) 
	{
		String result = "";
		for ( int i = 0; i < hex.length(); i++ ) 
		{
			char c = hex.charAt(i);
			switch (c) 
			{
			    case '0' : result = result + "0000"; break;
			    case '1' : result = result + "0001"; break;
			    case '2' : result = result + "0010"; break;
			    case '3' : result = result + "0011"; break;
			    case '4' : result = result + "0100"; break;
			    case '5' : result = result + "0101"; break;
			    case '6' : result = result + "0110"; break;
			    case '7' : result = result + "0111"; break;
			    case '8' : result = result + "1000"; break;
			    case '9' : result = result + "1001"; break;
			    case 'A' : result = result + "1010"; break;
			    case 'B' : result = result + "1011"; break;
			    case 'C' : result = result + "1100"; break;
			    case 'D' : result = result + "1101"; break;
			    case 'E' : result = result + "1110"; break;
			    case 'F' : result = result + "1111"; break;
			}
		}
		while ( result.length() < 12 ) 
		{
			result = "0000" + result;
		}
		return "0" + result;
	}
}