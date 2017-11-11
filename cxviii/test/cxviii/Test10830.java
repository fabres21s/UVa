package cxviii;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

import org.junit.Test;

public class Test10830 {

	
	@Test
	public void read() throws FileNotFoundException {
		File file = new File("input.txt");
		Scanner input = new Scanner(file);
		String replace, replacement;
		while (input.hasNext()) {
			replace = input.next();
			replacement = input.next();
			
			if (replace.equals(replacement) && replacement.equals("0")) {
				break;
			}
			
			byBigInteger(replace, replacement);
		}
	}

	private void byBigInteger(String replace, String replacement) {
		
		long t = System.currentTimeMillis();
		
		String number = replacement.replaceAll(replace, "");
		BigInteger value = new BigInteger( number.length() == 0 ? "0" : number);
		System.out.println(System.currentTimeMillis() - t);
	}
}
