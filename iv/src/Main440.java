
/**
*	440 - Eeny Meeny Moo
*
*
*	Submision:	9366689
*	Date:		2011-10-13 14:25:41
*	Runtime:	1.104
*	Ranking:	2385
*/
class Main440
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
        return (buffer.toString().trim());    
    }
	
	public static void main(String[] args) 
	{
		(new Main440()).begin();
	}	
	
	private void begin() 
	{
		int n = Integer.parseInt(readLn());
		while ( n != 0 ) 
		{
		//for ( int n = 13; n < 100; n++ ) {
			int m = 0;
			boolean determinado = false;
			while ( !determinado ) 
			{
				m++;
				boolean offZones[] = new boolean[n];
				int hops = 0;
				//Desliga o primeiro
				offZones[0] = true;
				int offCount = 1;
				int i = 1;
				//Enquanto a zona 12 (13-1) estiver ligada
				while ( !offZones[1] ) 
				{
					if ( !offZones[i%n] ) 
					{
						hops++;
					}
					if ( hops == m ) 
					{
						offZones[i%n] = true;
						offCount++;
						hops = 0;
					}
					i++;
				}
				determinado = (offCount == n);
			}			
			System.out.println(m);
			//System.out.println("values["+n+"] = " + m);
			n = Integer.parseInt(readLn());
		}
	}
}