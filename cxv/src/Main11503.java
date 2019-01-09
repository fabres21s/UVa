import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main11503 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuffer output = new StringBuffer();
		int friendship;
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			friendship = Integer.parseInt(br.readLine());
			 DisjoinSets ds = new DisjoinSets();
			for (int i = 0; i < friendship; i++) {
				args = br.readLine().split(" ");
				ds.makeSet(args[0]);
				ds.makeSet(args[1]);
				ds.union(ds.map.get(args[0]), ds.map.get(args[1]));
				output.append(String.format("%d\n", ds.nMap.get(ds.find(ds.map.get(args[0])))));
			}
			

		}
		System.out.print(output);
		

	}


static class DisjoinSets {

    List<Integer> parent, rank;
    HashMap<String, Integer> map;
    HashMap<Integer, Integer> nMap;
    int total;

    public DisjoinSets() {
        map = new HashMap<String, Integer>();
        nMap = new HashMap<Integer, Integer>();
        parent = new ArrayList<Integer>();
        rank = new ArrayList<Integer>();
        total = 0;
    }

    void makeSet(String s) {
        if (!map.containsKey(s)) {
            map.put(s, total);
            parent.add(total);
            rank.add(0);
            nMap.put(total, 1);
            total++;
        }
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            int totalFriend = nMap.get(px) + nMap.get(py);
            nMap.put(px, totalFriend);
            nMap.put(py, totalFriend);
        }
        if (rank.get(px) > rank.get(py)) {
            parent.set(py, px);
        } else {
            parent.set(px, py);
        }
        if (rank.get(px) == rank.get(py)) {
            rank.set(py, rank.get(py) + 1);
        }
    }

    int find(int x) {
        if (x != parent.get(x)) {
            parent.set(x, find(parent.get(x)));
        }
        return parent.get(x);
    }
}
}