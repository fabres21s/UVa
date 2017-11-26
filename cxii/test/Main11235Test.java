import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class Main11235Test {

	
	@Test
	public void compararTiempos() throws FileNotFoundException {
		File file = new File("output.txt");
		
		StringBuffer output = new StringBuffer();
		long array[][] = new long [4650][3];
		Scanner input = new Scanner(file);
		int index = 0;
		while (input.hasNext()) {
			input.nextLong();
			array[index] [0] = input.nextLong();
			index++;
		}
		
		
		file = new File("output2.txt");
		
		input = new Scanner(file);
		 index = 0;
		 long diff = 0, diffAcum=0;
		while (input.hasNext()) {
			input.nextLong();
			array[index] [1] = input.nextLong();
			
			
			diff = array[index][0] - array[index][1];
			
			diffAcum += diff;
			output.append(array[index][0] + "\t-\t"+array[index][1]+"\t=\t"+diff +"\t:::\t"+diffAcum);
			index++;
			output.append("\n");
			
			if (diffAcum > 1000000000) {
				System.out.println("1 segundo de diferencia");
				diffAcum = diffAcum - 1000000000;
			}
		}
		System.out.println(output);
	}
}
