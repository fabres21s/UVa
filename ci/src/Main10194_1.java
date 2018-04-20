import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

//TODO Generar casos de prueba, da WA y todo parece estar igual
public class Main10194_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		PrintWriter cout = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
		String name;

		int nMatches, nTeams, scoreA, scoreB;
		while (true) {

			name = br.readLine();

			List<Team> teams = new ArrayList<Team>();
			Map<String, Team> mapTeams = new HashMap<String, Team>();
			nTeams = Integer.parseInt(br.readLine());
			while (nTeams-- > 0) {
				Team team = new Team();
				team.setName(br.readLine());
				mapTeams.put(team.getName(), team);
				teams.add(team);
			}

			nMatches = Integer.parseInt(br.readLine());
			while (nMatches-- > 0) {
				args = br.readLine().split("[@]");

				// home
				String nameA = args[0].split("[#]")[0];
				scoreA = Integer.parseInt(args[0].split("[#]")[1]);
				Team teamA = mapTeams.get(nameA);
				teamA.addGoalsScored(scoreA);

				// away
				String nameB = args[1].split("[#]")[1];
				scoreB = Integer.parseInt(args[1].split("[#]")[0]);
				Team teamB = mapTeams.get(nameB);
				teamB.addGoalsScored(scoreB);

				teamA.addGoalsAgainst(scoreB);
				teamB.addGoalsAgainst(scoreA);
				teamA.addMatches();
				teamB.addMatches();

				if (scoreA == scoreB) {
					teamA.addPoints(1);
					teamA.addTies();
					teamB.addPoints(1);
					teamB.addTies();
				} else if (scoreA > scoreB) {
					teamA.addPoints(3);
					teamA.addWins();
					teamB.addLosses();
				} else {
					teamB.addPoints(3);
					teamA.addLosses();
					teamB.addWins();
				}

			}
			Collections.sort(teams);

			cout.println(name);
			for (int i = 1; i <= teams.size(); i++) {
				Team team = teams.get(i - 1);
				cout.println((i) + ") " + team.getName() + " " + team.getPoints() + "p, " + team.getMatches() + "g ("
						+ team.getWins() + "-" + team.getTies() + "-" + team.getLosses() + "), "
						+ (team.getGoalsScored() - team.getGoalsAgainst()) + "gd (" + team.getGoalsScored() + "-"
						+ team.getGoalsAgainst() + ")");
			}
			if (--testCases > 0) {
				cout.println();
			} else {
				break;
			}

		}
		cout.flush();
	}

}

class Team implements Comparable<Team> {
	private String name;
	private int matches;
	private int points;
	private int wins;
	private int ties;
	private int losses;
	private int goalsScored;
	private int goalsAgainst;

	public Team() {
		this.losses = this.matches = this.points = this.wins = this.ties = this.goalsScored = this.goalsAgainst = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void addPoints(int points) {
		this.points += points;
	}

	public int getWins() {
		return wins;
	}

	public void addWins() {
		this.wins += 1;
	}

	public int getTies() {
		return ties;
	}

	public void addTies() {
		this.ties += 1;
	}

	public int getGoalsScored() {
		return goalsScored;
	}

	public void addGoalsScored(int goalsScored) {
		this.goalsScored += goalsScored;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public void addGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst += goalsAgainst;
	}

	public int getMatches() {
		return matches;
	}

	public void addMatches() {
		this.matches += 1;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public void setTies(int ties) {
		this.ties = ties;
	}

	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public int getLosses() {
		return losses;
	}

	public void addLosses() {
		this.losses++;
	}

	@Override
	public int compareTo(Team o) {
		if (this.points > o.points) {
			return -1;
		} else if (this.points == o.points) {
			if (this.wins > o.wins) {
				return -1;
			} else if (this.wins == o.wins) {
				if ((this.goalsScored - this.goalsAgainst) > (o.goalsScored - o.goalsAgainst)) {
					return -1;
				} else if ((this.goalsScored - this.goalsAgainst) == (o.goalsScored - o.goalsAgainst)) {
					if (this.goalsScored > o.goalsScored) {
						return -1;
					} else if (this.goalsScored == o.goalsScored) {
						if (this.matches < o.matches) {
							return -1;
						} else if (this.matches == o.matches) {
							String a = this.name.toUpperCase();
							String b = o.name.toUpperCase();
							if (a.compareTo(b) < 0) {
								return -1;
							}
						}
					}
				}
			}
		}
		return 1;
	}

}
