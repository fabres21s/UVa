import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
*	10258 - Contest Scorboard
*
*	Submission:	22580755
*	Date:		2019-01-08 18:34:00
*	Runtime:	0.040
*	Ranking:	4712
*/
public class Main10258 {

	/**
	 * - Simulación
	 * - Sort
	 * 
	 *  Rankear equipos de acuerdo a la cantidad de ejercicios resueltos
	 *  y a los envíos realizados
	 */
	public static void main(String[] arg) throws NumberFormatException, IOException {

		Map<Integer, Team> map = new HashMap<Integer, Team>();
		List<Team> teams = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int testCases = Integer.parseInt(br.readLine());
		String line = br.readLine();
		int numberTeam;
		for (int i = 1; i <= testCases; i++) {
			
		
			while ((line=br.readLine())!=null && !line.isEmpty()) {
				StringTokenizer st=new StringTokenizer(line);
				numberTeam = Integer.parseInt(st.nextToken());
				int excersize = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				String answer = st.nextToken();

				Team team = map.get(numberTeam);

				if (team == null) {
					team = new Team(numberTeam);
					teams.add(team);
					map.put(numberTeam, team);
				}

				if (answer.equals("I")) {
					if (!team.getSolvedProblems().contains(excersize)) {
						team.getIncorrectSubmissions().add(Integer.valueOf(excersize));
					}
				} else if (answer.equals("C")) {
					if (team.getSolvedProblems().add(Integer.valueOf(excersize))) {
						team.setTime(team.getTime() + Integer.valueOf(time));
					}
				}
			}

			for (Team team : teams) {
				team.calculatePenalty();
			}

			Collections.sort(teams, new Comparator<Team>() {

				@Override
				public int compare(Team o1, Team o2) {
					int compare = o2.getSolvedProblems().size() - o1.getSolvedProblems().size();
					if (compare == 0) {

						compare = o1.getTime() - o2.getTime();

						if (compare == 0) {
							return o1.getNumber() - o2.getNumber();
						}

						return compare;

					}

					return compare;
				}
			});

			for (Team team : teams) {
				output.append(String.format("%s\n", team));
			}
			if (i != testCases) {
				output.append("\n");
			}
			teams.clear();
			map.clear();
		}

		System.out.print(output);

	}

}

class Team {
	private int number;
	private Set<Integer> solvedProblems;
	private List<Integer> incorrectSubmissions;
	private int time;

	public Team(int number) {
		this.number = number;
		this.solvedProblems = new HashSet<Integer>();
		this.time = 0;
		this.incorrectSubmissions = new ArrayList<>();
	}

	public void calculatePenalty() {
		for (Integer i : incorrectSubmissions) {
			if (solvedProblems.contains(i)) {
				this.time += 20;
			}
		}
	}

	@Override
	public String toString() {
		return this.number + " " + this.solvedProblems.size() + " " + this.time;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Set<Integer> getSolvedProblems() {
		return solvedProblems;
	}

	public void setSolvedProblems(Set<Integer> solvedProblems) {
		this.solvedProblems = solvedProblems;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public List<Integer> getIncorrectSubmissions() {
		return incorrectSubmissions;
	}

	public void setIncorrectSubmissions(List<Integer> incorrectSubmissions) {
		this.incorrectSubmissions = incorrectSubmissions;
	}
}
