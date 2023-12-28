
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import java.util.Comparator;

public class Simulator {

    private static String teamInfo = "TeamsInfo.xlsx";
    private static String playerInfo = "PlayerInfo.xlsx";
    private static double multiplier = 1.0;

    public static void matchSimulator() {
        Random rand = new Random();

        int rand1 = rand.nextInt(TeamM.teams.size()) ;
        int rand2 = rand.nextInt(TeamM.teams.size()) ;
        if (rand1 == rand2 || (rand1 >= TeamM.teams.size() || rand2 >= TeamM.teams.size())) {
            matchSimulator();

        } else {
            Team teamOne = TeamM.teamM(TeamM.teams.get(rand1));
            Team teamTwo = TeamM.teamM(TeamM.teams.get(rand2));

            System.out.println(teamOne.getTeamName() + " Will play " + teamTwo.getTeamName());
            matchScoreSimulator(teamOne, teamTwo);

        }

    }

    public static double playerScoreSimulator(Player player) {
        Random rand = new Random();    
        double lastGameScore = player.getPlayerLastGameScore();
        double playerRank = player.getPlayerOldRank();
        double playerScore = (int) (rand.nextInt(15) * (multiplier *= 0.9) + playerRank);
        double overallScoreSTR = lastGameScore + playerScore;
        ExcelW.writeDoubleToExcel(playerInfo, overallScoreSTR, "Overall Score", player.getPlayerName());
        ExcelW.writeDoubleToExcel(playerInfo, playerScore, "Last Game Score", player.getPlayerName());

        return playerScore;
    }

    public static void matchScoreSimulator(Team teamOne, Team teamTwo) {
        Random rand = new Random();


        double team1Score = rand.nextInt(100);
        double team2Score = rand.nextInt(100);
        

        for (int i = 0; i < teamOne.getTeamSize(); i++) {

            double nn = playerScoreSimulator(teamOne.getPlayers().get(i));
            double tt = playerScoreSimulator(teamTwo.getPlayers().get(i));

            team1Score =  team1Score + nn;
            team2Score =  team2Score + tt;
         
        }


        if (team1Score > team2Score) {

            System.out.println(
                    teamOne.getTeamName() + " Beat " + teamTwo.getTeamName() + "-" + team1Score + " - " + team2Score);
        } else if (team1Score < team2Score) {

            System.out.println(
                    teamTwo.getTeamName() + " Beat " + teamOne.getTeamName() + "-" + team2Score + "-" + team1Score);
        } else {

            System.out.println(teamTwo.getTeamName() + " Tied " + teamOne.getTeamName());
        }

        for (int i = 0; i < 4; i++) {

        }
        double overallScore = team1Score + teamOne.getOverallScore();
        double overallScore2 = team2Score + teamTwo.getOverallScore();
        ExcelW.writeDoubleToExcel(teamInfo, overallScore, "Overall Score", teamOne.getTeamName());
        ExcelW.writeDoubleToExcel(teamInfo, overallScore2, "Overall Score", teamTwo.getTeamName());
        ExcelW.writeDoubleToExcel(teamInfo, team1Score, "Last Game Score", teamOne.getTeamName());
        ExcelW.writeDoubleToExcel(teamInfo, team2Score, "Last Game Score", teamTwo.getTeamName());
    }

    public static void playerStandings(Player player) {
        List<Player> playersList = new ArrayList<>();


        for (int i = 0; i < PlayerM.players.size(); i++) {

            if (PlayerM.playerPosition.get(i).equals(player.getPlayerPosition())) {
                
                playersList.add(PlayerM.playerM(PlayerM.players.get(i)));


            }



        }
        playersList.sort(Comparator.comparingDouble(Player::getPlayerOverallScore).reversed());

        int rank = 1;
        for ( int i = 0; i < playersList.size(); i++) {

            playersList.get(i).setPlayerOldRank(player.getPlayerNewRank()); 
            playersList.get(i).setPlayerNewRank((double) rank); 

            rank++;
            ExcelW.writeDoubleToExcel(playerInfo, playersList.get(i).getPlayerNewRank(), "Rankings", playersList.get(i).getPlayerName());
        }

    }

    public static void leagueSimulator(List<Team> teams) {

        for (int i = 0; i < 5; i++) {
            teams.add(TeamM.teamM(TeamM.teams.get(i)));

            playerStandings(teams.get(i).getPlayers().get(i));

        }
        
        Sort.insertionSort(teams);

        int rank = 5;
        for (Team team : teams) {
            team.setTeamOldRank(team.getTeamNewRank()); 
            team.setTeamNewRank((double) rank); 
            rank--;
            ExcelW.writeDoubleToExcel(teamInfo, team.getTeamNewRank(), "Rankings", team.getTeamName());
        }

    }
}