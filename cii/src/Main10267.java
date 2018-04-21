import java.io.IOException;
import java.util.Stack;


/**
*	10267 - Graphical Editor
*
*
*	Submission:	9305894
*	Date:		2011-09-27 16:49:42
*	Runtime:	2.248
*	Ranking:	2898
*/
public class Main10267 implements Runnable {
	static String ReadLn(int maxLength) {
		byte line[] = new byte[maxLength];
		int length = 0;
		int input = -1;
		try {
			while (length < maxLength) {
				input = System.in.read();
				if ((input < 0) || (input == '\n'))
					break;
				line[length++] += input;
			}

			if ((input < 0) && (length == 0))
				return null;
			return new String(line, 0, length);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * - Simulaci�n
	 */
	public static void main(String args[]) {
		Main10267 myWork = new Main10267();
		myWork.run();
	}

	public void run() {
		new myStuff().run();
	}
}

class myStuff implements Runnable {
	private static final int MAX_LENGTH = 1024;

	private static final char COLOR_WHITE = 'O';

	private char[][] image;

	public void run() {
		String line;
		while ((line = Main10267.ReadLn(MAX_LENGTH)) != null) {
			line = line.trim();
			if (line.isEmpty()) {
				continue;
			}
			char command = line.charAt(0);
			if (command == 'X') {
				while (Main10267.ReadLn(MAX_LENGTH) != null)
					; // Flush the remaining lines
				break;
			}
			String[] parameters = line.split("\\s+");
			process(command, parameters);
		}
	}

	public void process(char command, String[] parameters) {
		switch (command) {
		case 'I':
			int columnSize = Integer.valueOf(parameters[1]);
			int rowSize = Integer.valueOf(parameters[2]);
			image = new char[rowSize][columnSize];
		case 'C':
			for (int row = 0; row < image.length; row++) {
				for (int column = 0; column < image[0].length; column++) {
					image[row][column] = COLOR_WHITE;
				}
			}
			break;

		case 'L': {
			int column = Integer.valueOf(parameters[1]) - 1;
			int row = Integer.valueOf(parameters[2]) - 1;
			char color = parameters[3].charAt(0);
			image[row][column] = color;
			break;
		}

		case 'V': {
			int column = Integer.valueOf(parameters[1]) - 1;
			int rowStart = Integer.valueOf(parameters[2]) - 1;
			int rowEnd = Integer.valueOf(parameters[3]) - 1;
			char color = parameters[4].charAt(0);
			if (rowStart > rowEnd) {
				int temp = rowStart;
				rowStart = rowEnd;
				rowEnd = temp;
			}
			for (int row = rowStart; row <= rowEnd; row++) {
				image[row][column] = color;
			}
			break;
		}

		case 'H': {
			int columnStart = Integer.valueOf(parameters[1]) - 1;
			int columnEnd = Integer.valueOf(parameters[2]) - 1;
			int row = Integer.valueOf(parameters[3]) - 1;
			char color = parameters[4].charAt(0);
			if (columnStart > columnEnd) {
				int temp = columnStart;
				columnStart = columnEnd;
				columnEnd = temp;
			}
			for (int column = columnStart; column <= columnEnd; column++) {
				image[row][column] = color;
			}
			break;
		}

		case 'K': {
			int columnStart = Integer.valueOf(parameters[1]) - 1;
			int rowStart = Integer.valueOf(parameters[2]) - 1;
			int columnEnd = Integer.valueOf(parameters[3]) - 1;
			int rowEnd = Integer.valueOf(parameters[4]) - 1;
			char color = parameters[5].charAt(0);
			for (int row = rowStart; row <= rowEnd; row++) {
				for (int column = columnStart; column <= columnEnd; column++) {
					image[row][column] = color;
				}
			}
			break;
		}

		case 'F': {
			int column = Integer.valueOf(parameters[1]) - 1;
			int row = Integer.valueOf(parameters[2]) - 1;
			char color = parameters[3].charAt(0);
			if (image[row][column] != color) {
				spread(row, column, color);
			}
			break;
		}

		case 'S':
			String filename = parameters[1];
			System.out.println(filename);
			for (int row = 0; row < image.length; row++) {
				for (int column = 0; column < image[0].length; column++) {
					char colorOfPixel = image[row][column];
					System.out.print(colorOfPixel);
				}
				System.out.println();
			}
			break;
		}
	}

	class Pixel {
		int row;
		int column;

		public Pixel(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}

	private void spread(int row, int column, char color) {
		char prevColor = image[row][column];

		Pixel pixel = new Pixel(row, column);
		Stack<Pixel> pixels = new Stack<Pixel>();
		pixels.push(pixel);
		while (!pixels.isEmpty()) {
			Pixel poppedPixel = pixels.pop();
			spread(poppedPixel, prevColor, color, pixels);
		}
	}

	private void spread(Pixel pixel, char prevColor, char newColor,
			Stack<Pixel> pixels) {
		int row = pixel.row;
		int column = pixel.column;
		image[row][column] = newColor;

		if (row > 0 && image[row - 1][column] == prevColor) {
			image[row - 1][column] = newColor;
			pixels.push(new Pixel(row - 1, column));
		}
		if (row < image.length - 1 && image[row + 1][column] == prevColor) {
			image[row + 1][column] = newColor;
			pixels.push(new Pixel(row + 1, column));
		}
		if (column > 0 && image[row][column - 1] == prevColor) {
			image[row][column - 1] = newColor;
			pixels.push(new Pixel(row, column - 1));
		}
		if (column < image[0].length - 1 && image[row][column + 1] == prevColor) {
			image[row][column + 1] = newColor;
			pixels.push(new Pixel(row, column + 1));

		}
	}
}