import java.util.StringTokenizer;

/**
*	438 - The Circumference of the Circle
*
*
*	Submision:	9362647
*	Date:		2011-10-12 13:21:00
*	Runtime:	0.152
*	Ranking:	6192
*/
class Main438 
{
	//	Rotina de Leitura
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
		(new Main438()).begin();
	}

	private void begin() 
	{
		double PI = 3.141592653589793;
		String input = readLn();
		while ( input != null ) 
		{
			StringTokenizer st = new StringTokenizer(input);
			double x1 = new Double(st.nextToken()).doubleValue();
			double y1 = new Double(st.nextToken()).doubleValue();
			double x2 = new Double(st.nextToken()).doubleValue();
			double y2 = new Double(st.nextToken()).doubleValue();
			double x3 = new Double(st.nextToken()).doubleValue();
			double y3 = new Double(st.nextToken()).doubleValue();
			//Calcula as medidas dos lados
			double a = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
			double b = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
			double c = Math.sqrt((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1));
			//Aplica a formula de heron
			double p = (a+b+c)/2;
			double r = (a*b*c)/(4*Math.sqrt(p*(p-a)*(p-b)*(p-c)));
			double circunferencia = 2*PI*r;
			//Formata e imprime
			System.out.println(format(circunferencia));
			input = readLn();
		}
	}

	private String format(double circunferencia) 
	{
		circunferencia = Math.round(circunferencia*100) / 100.0;
		String result = String.valueOf(circunferencia);
		while ( result.indexOf('.') > result.length() - 3) 
		{
			result = result + '0';
		}
		return result;
	}	
}