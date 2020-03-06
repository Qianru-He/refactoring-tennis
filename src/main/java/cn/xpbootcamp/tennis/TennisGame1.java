package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.ScoreTranslator.*;

public class TennisGame1 implements TennisGame {

	private final Player player1 = new Player();
	private final Player player2 = new Player();

	public TennisGame1(String player1Name, String player2Name) {
		this.player1.name = player1Name;
		this.player2.name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName.equals(player1.name))
			player1.point = player1.point + 1;
		else
			player2.point = player2.point + 1;
	}

	public String getScore() {
		if (player1.point == player2.point) {
			return getDrawScore(player1.point);
		}
		if (player1.point >= 4 || player2.point >= 4) {
			return getAdvantageAndWinScore(player1,player2);
		}
		return getOtherScore();
	}

	private String getOtherScore() {
		return translateOtherScore(player1.point) + "-" + translateOtherScore(player2.point);
	}
}