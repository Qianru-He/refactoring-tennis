package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

	private int m_score1 = 0;
	private int m_score2 = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName.equals("player1"))
			m_score1 += 1;
		else
			m_score2 += 1;
	}

	public String getScore() {
		if (m_score1 == m_score2) {
			return getDrawScore();
		}
		if (m_score1 >= 4 || m_score2 >= 4) {
			return getAdvantageAndWin();
		}
		return getOtherScore();
	}

	private String getDrawScore() {
		String score = translateScore(m_score1);
		if (m_score1 < 3) {
			score += "-All";
		}
		return score;
	}

	private String getAdvantageAndWin() {
		String score;
		int minusResult = m_score1 - m_score2;
		if (minusResult == 1) score = "Advantage player1";
		else if (minusResult == -1) score = "Advantage player2";
		else if (minusResult >= 2) score = "Win for player1";
		else score = "Win for player2";
		return score;
	}

	private String getOtherScore() {
		return translateOddScore(m_score1) + "-" + translateOddScore(m_score2);
	}

	private String translateOddScore(int score) {
		if (score == 3) {
			return "Forty";
		}
		return translateScore(score);
	}

	private String translateScore(int score) {
		String scoreDescribe;
		switch (score) {
			case 0:
				scoreDescribe = "Love";
				break;
			case 1:
				scoreDescribe = "Fifteen";
				break;
			case 2:
				scoreDescribe = "Thirty";
				break;
			default:
				scoreDescribe = "Deuce";
				break;

		}
		return scoreDescribe;
	}
}