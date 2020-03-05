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
	static String getAdvantageAndWinScore(int minusResult) {
		String score;
		if (minusResult == 1) score = "Advantage player1";
		else if (minusResult == -1) score = "Advantage player2";
		else if (minusResult >= 2) score = "Win for player1";
		else score = "Win for player2";
		return score;
	}
}
