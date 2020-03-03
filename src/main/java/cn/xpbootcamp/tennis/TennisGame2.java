package cn.xpbootcamp.tennis;

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
		String score = "";
		if (P1point == P2point) {
            return getDrawScore();
        }

		if (P1point < 4 && P2point < 4) {
			return getOtherScore(P1point) + "-" + getOtherScore(P2point);
		}

		score = getAdvantageAndWin();
		return score;
	}

    private String getDrawScore() {
        String score;
        score = translateScore(P1point);
        if (P1point < 3) {
            score += "-All";
        }
        return score;
    }

    private String getOtherScore(int score) {
        String des = translateScore(score);
        if (score == 3) {
            des = "Forty";
        }
        return des;
    }

    private String getAdvantageAndWin() {
        String score;
        int minusResult = P1point - P2point;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
	}

	private String translateScore(int sscore) {
		String score = "";
		if (sscore < 4) {
			if (sscore == 0)
				score = "Love";
			if (sscore == 1)
				score = "Fifteen";
			if (sscore == 2)
				score = "Thirty";
		}
		if (sscore >= 3)
			score = "Deuce";
		return score;
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