package cn.xpbootcamp.tennis;

class ScoreTranslator {

	static String getDrawScore(int score) {
		String translatedScore;
		translatedScore = translateScore(score);
		if (score < 3) {
			translatedScore += "-All";
		}
		return translatedScore;
	}

	private static String translateScore(int score) {
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
	static String translateOtherScore(int score) {
		if (score == 3) {
			return "Forty";
		}
		return translateScore(score);
	}
	static String getAdvantageAndWinScore(Player player1, Player player2) {
		String score;
		int minusResult = player1.point - player2.point;
		if (minusResult == 1) score = "Advantage "+player1.name;
		else if (minusResult == -1) score = "Advantage "+player2.name;
		else if (minusResult >= 2) score = "Win for "+player1.name;
		else score = "Win for "+player2.name;
		return score;
	}
}
