import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	static PrintWriter pw;
	static int maxCount = 0;
	
	public static void main(String[] args) throws IOException {

		File file =new File("output_10192.txt");
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter  bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);
		
		//hallarMaximaSecuencia("WbJ9ohkcz5B65ddvH8LS4nsfTI kYyj Xj7e".toCharArray(), 0, "4jcp3xWcTSpd8Fv0IJrteBfnMyi1qOlahol2YU7bOJ9oOwBXWuLjYVTc5218j3VcOU52roU5uBAYjoKEFgrWDBS1Wjlnb0SGtQ".toCharArray(), 0, 0);
		//hallarMaximaSecuencia("acdb".toCharArray(), 0, "abcd".toCharArray(), 0, 0);
	//	hallarMaximaSecuencia("abcd".toCharArray(), 0, "acdb".toCharArray(), 0, 0);
		hallarMaximaSecuencia("mX RvtR1lmZpn2VfDBtfRowvn1ToBXiLBpzTjP3nsKzIefS3vyzJamXTx".toCharArray(), 0, "JPM9NTEAA4GG870DYXK9SedurFbw33uExzkKItLU26Bbjs2CAT2KEXzZYzgwre6WdVF1EsmAjIeUtqKfF5SPSYA".toCharArray(), 0, 0);
		
		System.out.println(maxCount);
		bw.close();
	}
	
	public static void hallarMaximaSecuencia(char [] a, int startA, char [] b, int startB, int count) throws IOException {
		
		for (int i = startA; i < a.length; i++) {
			for (int j = startB; j < b.length; j++) {
				if (a[i] == b[j]) {
					
					pw.println(a[i] + " ::: "+b[j] +" >>>> "+i+" ::: "+j + " >>> count = "+count);
					hallarMaximaSecuencia(a, i + 1, b, j + 1, count +1);
					break;
				}
			}
			
			
		}
		pw.println("-------------------");
		maxCount = Math.max(count, maxCount);
	}
	
	

}
