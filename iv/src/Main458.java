import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
*	458 - The Decoder
*
*
*	Submision:	9367461
*	Date:		2011-10-13 18:06:50
*	Runtime:	0.364
*	Ranking:	20435
*/
public class Main458 {
	
	/*
 	* 458 - The Decoder
 	* - Cadena de caracteres
 	* - Reemplazar un caracter por su ASCII - 7
 	*
 	* */
public static void main(String[] args) throws IOException 
	{
		DataInputStream in = new DataInputStream(System.in);
		DataOutputStream output = new DataOutputStream(System.out) ;
		int C;
		while ((C =in.read()) !=-1)
		{
			output.write((Character.isSpace((char)C) ? C : (C-7)));
		}
			//output.write((Character.isSpace((char)C) ? C : (C-7)));
		// TODO Auto-generated method stub

	}

}
