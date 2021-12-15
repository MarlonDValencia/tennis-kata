
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
        if (playerName.equals(player1Name))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score;
        if (m_score1 == m_score2) score = equalScore();
        else if (m_score1 >=4 || m_score2 >=4) score = scoreGreaterThanFour();
        else score = differentScore(m_score1).concat("-").concat(differentScore(m_score2));
        return score;
    }

    private String differentScore(int playerScore){
        String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
        return scores[playerScore];
    }

    private String scoreGreaterThanFour(){
        int minusResult = m_score1 - m_score2;
        if (minusResult==1 || minusResult==-1) return advantageScore(minusResult);
        return winScore(minusResult);
    }

    private String advantageScore(int minusResult){
        return minusResult==1 ? "Advantage player1" : "Advantage player2";
    }

    private String winScore(int score){
        return score >=2 ? "Win for player1" : "Win for player2";
    }

    private String equalScore(){
        String[] scores = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
        return m_score1>3 ? scores[3] : scores[m_score1];
    }
}

