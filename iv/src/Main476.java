import java.util.Scanner;
import java.util.Vector;

/**
*	476 - Points in Figures: Rectangles
*
*
*	Submission:	9967359
*	Date:		2012-04-07 20:25:34
*	Runtime:	1.112
*	Ranking:	6700
*/
public class Main476 {

	/**
	 * TODO Asignar Categor�a!!!
	 */
	public static void main(String[] args) 
	{
		double x,y,p1,p2,p3,p4;
		Vector <Object>v = new Vector<Object>();
		boolean contains;
		Scanner input=new Scanner(System.in);
		while(!(input.next()).equals("*"))
		{
			p1 = new Double(input.next()).doubleValue();
			p2 = new Double(input.next()).doubleValue();
			p3 = new Double(input.next()).doubleValue();
			p4 = new Double(input.next()).doubleValue();
			Rectangle2 rec = new Rectangle2( p1, p2, p3, p4 );
			v.addElement(rec);
		}
		int con=0;
		x=new Double(input.next()).doubleValue();
		y=new Double(input.next()).doubleValue();
		while(x!=9999.9 && y!=9999.9)
		{
			contains=false;
			con++;
			for ( int i = 0; i < v.size(); i++ ) 
			{
				Figure2 f = (Figure2)v.elementAt(i);
				if ( f.contains(x,y) ) 
				{
					System.out.println("Point "+con+" is contained in figure "+(i+1));
					contains = true;
				}
			}
			if ( !contains ) 
			{
				System.out.println("Point "+con+" is not contained in any figure");				
			}
			x=new Double(input.next()).doubleValue();
			y=new Double(input.next()).doubleValue();
		}
		input.close();
	}
}

interface Figure2 
{
	public boolean contains(double x, double y);
}

class Rectangle2 implements Figure2 
{
	private double ulx;
	private double uly;
	private double lrx;
	private double lry;

	public Rectangle2(double ulx, double uly, double lrx, double lry) 
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
