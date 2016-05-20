import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
*	101 - The Blocks Problem
*
*
*	Submision:	9281686
*	Date:		2011-09-20 16:46:08
*	Runtime:	0.304
*	Ranking:	11723
*/
public class Main101 {
	static Stack<Integer>[] blocks;
	static int[] pos;

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Main101 p = new Main101();
		p.go();
		p.print();
		// TODO Auto-generated method stub
	}

	private void print() {
		for (int i = 0; i < blocks.length; i++) {
			System.out.println(blockToString(i));
		}
	}

	private String blockToString(int i) {
		String ans = "";
		while (!blocks[i].isEmpty()) {
			ans = " " + blocks[i].pop() + ans;
		}
		ans = i + ":" + ans;
		return ans;
	}

	@SuppressWarnings("unchecked")
	public void go() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		blocks = new Stack[N];
		pos = new int[N];
		for (int i = 0; i < N; i++) {
			blocks[i] = new Stack<Integer>();
			blocks[i].push(i);
			pos[i] = i;
		}
		String l = "";
		while (!(l = in.readLine()).equals("quit")) {
			StringTokenizer tokens = new StringTokenizer(l);
			String action = tokens.nextToken();
			int a = Integer.parseInt(tokens.nextToken());
			String type = tokens.nextToken();
			int b = Integer.parseInt(tokens.nextToken());
			if (a == b || pos[a] == pos[b]) {
				continue;
			}
			if (action.equals("move")) {
				if (type.equals("onto")) {
					moveOnto(a, b);
				} else if (type.equals("over")) {
					moveOver(a, b);
				}

			} else if (action.equals("pile")) {
				if (type.equals("onto")) {
					pileOnto(a, b);
				} else if (type.equals("over")) {
					pileOver(a, b);
				}
			}
		}
	}

	public static void moveOnto(int a, int b) {
		clearAbove(b);
		moveOver(a, b);
	}

	public static void moveOver(int a, int b) {
		clearAbove(a);
		blocks[pos[b]].push(blocks[pos[a]].pop());
		pos[a] = pos[b];
	}

	public static void pileOnto(int a, int b) {
		clearAbove(b);
		pileOver(a, b);
	}

	public static void pileOver(int a, int b) {
		Stack<Integer> aPile = new Stack<Integer>();
		while (blocks[pos[a]].peek() != a) {
			aPile.push(blocks[pos[a]].pop());
		}
		aPile.push(blocks[pos[a]].pop());
		while (!aPile.isEmpty()) {
			int top = aPile.pop();
			blocks[pos[b]].push(top);
			pos[top] = pos[b];
		}
	}

	public static void clearAbove(int x) {
		while (blocks[pos[x]].peek() != x) {
			returnHome(blocks[pos[x]].pop());
		}
	}

	private static void returnHome(Integer x) {
		while (!blocks[x].isEmpty()) {
			returnHome(blocks[x].pop());
		}
		blocks[x].push(x);
		pos[x] = x;
	}
}
