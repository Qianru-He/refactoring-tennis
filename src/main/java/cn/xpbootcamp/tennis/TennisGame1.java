package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.ScoreTranslator.*;

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
			return getDrawScore(m_score1);
		}
		if (m_score1 >= 4 || m_score2 >= 4) {
			return getAdvantageAndWinScore(m_score1 - m_score2);
		}
		return getOtherScore();
	}

	private String getOtherScore() {
		return translateOtherScore(m_score1) + "-" + translateOtherScore(m_score2);
	}
}