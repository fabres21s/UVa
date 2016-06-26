import java.io.IOException;

/**
*	10033 - Interpreter
*
*
*	Submision:	9306587
*	Date:		2011-09-27 19:36:33
*	Runtime:	0.104
*	Ranking:	3411
*/
class Main10033 implements Runnable {
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
	 * TODO Asignar Categoradkfjgl/skdaj la'wjtkqwlueh elq;wrh AEW:5u lwk/rjhlwjkexck.jacrjo	�a!!!
	 */
	public static void main(String args[]) {
		Main10033 myWork = new Main10033();
		myWork.run();
	}

	public void run() {
		new myStuff().run();
	}
}

class myStuff implements Runnable {
	private static final int MAX_LENGTH = 1024;

	private static final int HALT = -1;

	private int[] registers = new int[10];
	private int[] ram = new int[1000];

	public void run() {
		int testCaseCount;
		String line = Main10033.ReadLn(MAX_LENGTH);
		line = line.trim();
		testCaseCount = Integer.valueOf(line);
		Main10033.ReadLn(MAX_LENGTH); // throw a blank line
		for (int i = 0; i < testCaseCount; i++) {
			if (i != 0) {
				System.out.println();
			}
			process();
		}
		while (Main10033.ReadLn(MAX_LENGTH) != null)
			; // Flush the remaining lines
	}

	public void process() {
		load();
		execute();
	}

	public void load() {
		// Initialize registers and RAM
		for (int i = 0; i < registers.length; i++) {
			registers[i] = 0;
		}
		for (int i = 0; i < ram.length; i++) {
			ram[i] = 0;
		}
		int address = 0;
		String line;
		while ((line = Main10033.ReadLn(MAX_LENGTH)) != null) {
			line = line.trim();
			if (line.isEmpty()) {
				break;
			}
			ram[address] = Integer.valueOf(line);
			address++;
		}
	}

	public void execute() {
		int executionCount = 0;
		int programCounter = 0;
		while (programCounter < ram.length) {
			executionCount++;
			programCounter = interpret(programCounter);
			if (programCounter == HALT) {
				break;
			}
		}
		System.out.println(executionCount);
	}

	public int interpret(int programCounter) {
		int instruction = ram[programCounter];
		programCounter++;
		if (instruction == 100) {
			return HALT;
		}

		int command = instruction / 100;
		int parameters = instruction % 100;
		switch (command) {
		case 2: {
			int registerIndex = parameters / 10;
			int value = parameters % 10;
			registers[registerIndex] = value;
			break;
		}

		case 3: {
			int registerIndex = parameters / 10;
			int value = parameters % 10;
			registers[registerIndex] = (registers[registerIndex] + value) % 1000;
			break;
		}

		case 4: {
			int registerIndex = parameters / 10;
			int value = parameters % 10;
			registers[registerIndex] = (registers[registerIndex] * value) % 1000;
			break;
		}

		case 5: {
			int register1Index = parameters / 10;
			int register2Index = parameters % 10;
			registers[register1Index] = registers[register2Index];
			break;
		}

		case 6: {
			int register1Index = parameters / 10;
			int register2Index = parameters % 10;
			registers[register1Index] = (registers[register1Index] + registers[register2Index]) % 1000;
			break;
		}

		case 7: {
			int register1Index = parameters / 10;
			int register2Index = parameters % 10;
			registers[register1Index] = (registers[register1Index] * registers[register2Index]) % 1000;
			break;
		}

		case 8: {
			int register1Index = parameters / 10;
			int register2Index = parameters % 10;
			registers[register1Index] = ram[registers[register2Index]];
			break;
		}

		case 9: {
			int register1Index = parameters / 10;
			int register2Index = parameters % 10;
			ram[registers[register2Index]] = registers[register1Index];
			break;
		}

		case 0: {
			int register1Index = parameters / 10;
			int register2Index = parameters % 10;
			if (registers[register2Index] != 0) {
				programCounter = registers[register1Index];
			}
			break;
		}
		}
		return programCounter;
	}
}