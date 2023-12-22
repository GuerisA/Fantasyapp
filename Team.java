import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private Double oldRank;
    private Double newRank;
    private int size;
    private double overallScore;
    private double lastGameScore;
    private Player DE;
    private Player CB;
    private Player QB;
    private Player RB;
    private Player DT;
    private List<Player> playerList = new ArrayList<>();;

    public Team() {

    }

    public String getTeamName() {
        return teamName;
    }

    public Player getDefensiveEnd() {
        return DE;
    }

    public Player getCornerback() {
        return CB;
    }

    public Player getQuarterback() {
        return QB;
    }

    public Player getRunningBack() {
        return RB;
    }

    public Player getDefensiveTackle() {
        return DT;
    }

    public Double getTeamOldRank() {
        return oldRank;
    }

    public Double getOverallScore() {
        return overallScore;
    }

    public Double getLastGameScore() {
        return lastGameScore;
    }

    public void setTeamOldRank(Double oldRank) {
        this.oldRank = oldRank;
    }

    public Double getTeamNewRank() {
        return newRank;
    }

    public void setTeamNewRank(Double newRank) {
        this.newRank = newRank;
    }

    public void setDefensiveEnd(Player DE) {
        this.DE = DE;
    }

    public void setCornerback(Player CB) {
        this.CB = CB;
    }

    public void setQuarterback(Player QB) {
        this.QB = QB;
    }

    public void setRunningBack(Player RB) {
        this.RB = RB;
    }

    public void setDefensiveTackle(Player DT) {
        this.DT = DT;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;

    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;

    }
    public void setLastGameScore(double lastGameScore) {
        this.lastGameScore = lastGameScore;

    }

    public List<Player> getPlayers() {
        return playerList;
    }

    public double getTeamSize() {
        size = playerList.size();
        return size;

    }

    public void setPlayers(List<Player> players) {
        this.playerList = players;

    }


    @Override
    public String toString() {
        return "Teams{" +
                "teamName='" + teamName + '\'' +
                '}';
    }
}