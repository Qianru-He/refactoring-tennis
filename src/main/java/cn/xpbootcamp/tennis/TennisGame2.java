package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.ScoreTranslator.*;

public class TennisGame2 implements TennisGame {
	private final Player player1 = new Player();
	private final Player player2 = new Player();

	public TennisGame2(String player1Name, String player2Name) {
		this.player1.name = player1Name;
		this.player2.name = player2Name;
	}

	public String getScore() {
		if (player1.point == player2.point) {
			return getDrawScore(player1.point);
		}

		if (player1.point < 4 && player2.point < 4) {
			return translateOtherScore(player1.point) + "-" + translateOtherScore(player2.point);
		}

		return getAdvantageAndWinScore(player1,player2);
	}

	private void P1Score() {
		player1.point++;
	}

	private void P2Score() {
		player2.point++;
	}

	public void wonPoint(String player) {
		if (player.equals(player1.name))
			P1Score();
		else
			P2Score();
	}
}