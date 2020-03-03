package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.ScoreTranslator.*;

public class TennisGame2 implements TennisGame {
	private int P1point = 0;
	private int P2point = 0;

	private String P1res = "";
	private String P2res = "";
	private String player1Name;
	private String player2Name;

	public TennisGame2(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public String getScore() {
		if (P1point == P2point) {
			return getDrawScore(P1point);
		}

		if (P1point < 4 && P2point < 4) {
			return translateOddScore(P1point) + "-" + translateOddScore(P2point);
		}

		return getAdvantageAndWin(P1point - P2point);
	}

	private void P1Score() {
		P1point++;
	}

	private void P2Score() {
		P2point++;
	}

	public void wonPoint(String player) {
		if (player.equals("player1"))
			P1Score();
		else
			P2Score();
	}
}