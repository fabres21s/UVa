import java.util.StringTokenizer;
import java.util.Vector;

/**
*	477 - Points in Figures: Rectangles and Circles
*
*
*	Submision:	9381077
*	Date:		2011-10-17 15:26:11
*	Runtime:	1.680
*	Ranking:	5582
*/
public class Main477 
{
	/**
	 * TODO Asignar Categoría!!!
	 */
	public static void main(String[] args) 
	{
		(new Main477()).begin();

	}
	
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
	
	
	private void begin() 
	{
		String input = readLn();
		Vector <Object>v = new Vector<Object>();
		StringTokenizer st;
		while (!input.equals("*")) 
		{
			st = new StringTokenizer(input);
			String type = st.nextToken();
			if ( type.equals("r") ) 
			{
				double ulx = new Double(st.nextToken()).doubleValue();
				double uly = new Double(st.nextToken()).doubleValue();
				double lrx = new Double(st.nextToken()).doubleValue();
				double lry = new Double(st.nextToken()).doubleValue();
				Rectangle r = new Rectangle( ulx, uly, lrx, lry );
				v.addElement(r);
			}
			else
			{
				double cx = new Double(st.nextToken()).doubleValue();
				double cy = new Double(st.nextToken()).doubleValue();
				double r = new Double(st.nextToken()).doubleValue();
				Circle c = new Circle( cx, cy, r );
				v.addElement(c);
			}
			input = readLn();
		}
		input = readLn();
		int tc = 0;
		while (!input.equals("9999.9 9999.9")) 
		{
			st = new StringTokenizer(input);
			tc++;
			boolean contains = false;
			double x = new Double(st.nextToken()).doubleValue();
			double y = new Double(st.nextToken()).doubleValue();
			for ( int i = 0; i < v.size(); i++ ) {
				Figure f = (Figure)v.elementAt(i);
				if ( f.contains(x,y) ) 
				{
					System.out.println("Point "+tc+" is contained in figure "+(i+1));
					contains = true;
				}
			}
			if ( !contains ) 
			{
				System.out.println("Point "+tc+" is not contained in any figure");				
			}
			input = readLn();
		}
	}
}

interface Figure 
{
	public boolean contains(double x, double y);
}

class Rectangle implements Figure 
{
	private double ulx;
	private double uly;
	private double lrx;
	private double lry;

	public Rectangle(double ulx, double uly, double lrx, double lry) 
	{
		this.ulx = ulx;
		this.uly = uly;
		this.lrx = lrx;
		this.lry = lry;
	}

	public boolean contains(double x, double y) 
	{
		return ( x > ulx && x < lrx ) && ( y > lry && y < uly );
	}	
}

class Circle implements Figure 
{
	private double cx;
	private double cy;
	private double r;

	public Circle( double cx, double cy, double r) 
	{
		this.cx = cx;
		this.cy = cy;
		this.r = r;
	}

	public boolean contains(double x, double y) 
	{
		return Math.sqrt((x-cx)*(x-cx)+(y-cy)*(y-cy)) < r;
	}	
}
