package cn.xpbootcamp.tennis;


public class TennisGame3 implements TennisGame {

	private int p2Score;
	private int p1Score;
	private String p1Name;
	private String p2Name;
	private String[] possibleScores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

	public TennisGame3(String p1N, String p2N) {
		this.p1Name = p1N;
		this.p2Name = p2N;
	}

	public String getScore() {
		if (p1Score < 4 && p2Score < 4 && !(p1Score + p2Score == 6)) {
			return (p1Score == p2Score) ? translateScore(p1Score) + "-All" : translateScore(p1Score) + "-" + translateScore(p2Score);
		} else if (p1Score == p2Score) {
			return "Deuce";
		} else {
			String winer = p1Score > p2Score ? p1Name : p2Name;
			return isAdvantage() ? "Advantage " + winer : "Win for " + winer;
		}
	}

	private boolean isAdvantage() {
		return (p1Score - p2Score) * (p1Score - p2Score) == 1;
	}

	private String translateScore(int score) {
		return possibleScores[score];
	}

	public void wonPoint(String playerName) {
		if (playerName.equals("player1"))
			this.p1Score += 1;
		else
			this.p2Score += 1;

	}

}