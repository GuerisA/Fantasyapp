public class Player {
    private String playerName;
    private Double oldRank;
    private Double newRank;
    private String team;
    private String position;
    private Double overallScore;
    private Double lastGameScore;

    public Player(String playerName) {
        this.playerName = playerName;

    }

    public String getPlayerName() {
        return playerName;
    }

    public Double getPlayerOldRank() {
        return oldRank;
    }
    public Double getPlayerNewRank() {
        return newRank;
    }

    public String getPlayerteam() {
        return team;
    }

    public String getPlayerPosition() {
        return position;
    }

    public Double getPlayerOverallScore() {
        return overallScore;
    }

    public Double getPlayerLastGameScore() {
        return lastGameScore;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerPosition(String position) {
        this.position = position;
    }

    public void setPlayerTeam(String team) {

        this.team = team;
    }

    public void setPlayerOverallScore(Double overallScore) {

        this.overallScore = overallScore;
    }

    public void setPlayerLastGameScore(Double lastGameScore) {

        this.lastGameScore = lastGameScore;
    }

    public void setPlayerOldRank(Double oldRank) {
        this.oldRank = oldRank;
    }

    public void setPlayerNewRank(Double newRank) {
        this.newRank = newRank;
    }
    public String toString() {
        return "Player Name: " + playerName + "\n" +
                "Rank: " + newRank + "\n" +
                "Team: " + team + "\n" +
                "Position: " + position + "\n" +
                "Overall Score: " + overallScore + "\n" +
                "Last Game Score: " + lastGameScore;
    }

}