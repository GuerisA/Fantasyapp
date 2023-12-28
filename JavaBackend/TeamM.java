import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TeamM {
    private static String teamInfo = "TeamsInfo.xlsx";
    public static List<String> teams = ExcelR.readStringFromExcel(teamInfo, "Team");
    private static List<String> teamOwner = ExcelR.readStringFromExcel(teamInfo, "Owner");
    private static List<Double> teamScore = ExcelR.readDoubleFromExcel(teamInfo, "Overall Score");
    private static List<Double> teamRank = ExcelR.readDoubleFromExcel(teamInfo, "Rankings");
    private static List<Double> lastGame = ExcelR.readDoubleFromExcel(teamInfo, "Last Game Score");

    public static Team teamM(String teamName) {
        Team team = new Team();
        for (int i = 0; i < teams.size(); i++) {
            if (teamName.equals(teams.get(i))) {

                team.setTeamName(teams.get(i));
                team.setTeamOldRank(teamRank.get(i));
                team.setOverallScore(teamScore.get(i));
                team.setLastGameScore(lastGame.get(i));
                for (int j = 0; j < PlayerM.players.size(); j++) {
                    if (PlayerM.playerTeam.get(j).equals(teams.get(i))) {
                        Player player = PlayerM.playerM(PlayerM.players.get(j));

                        if (team.getCornerback() == null && player.getPlayerPosition().equals("Cornerback (CB)")) {
                            team.setCornerback(player);

                            team.getPlayers().add(player);

                        } else if (team.getQuarterback() == null
                                && player.getPlayerPosition().equals("Quarterback (QB)")) {
                            team.setQuarterback(player);
                            team.getPlayers().add(player);

                        } else if (team.getDefensiveEnd() == null
                                && player.getPlayerPosition().equals("Defensive End (DE)")) {
                            team.setDefensiveEnd(player);
                            team.getPlayers().add(player);

                        } else if (team.getDefensiveTackle() == null
                                && player.getPlayerPosition().equals("Defensive Tackle (DT)")) {
                            team.setDefensiveTackle(player);
                            team.getPlayers().add(player);

                        } else if (team.getRunningBack() == null
                                && player.getPlayerPosition().equals("Running Back (RB)")) {
                            team.setRunningBack(player);
                            team.getPlayers().add(player);

                        }

                    }
                }
            }
        }

        return team;
    }

    public static void teamInfo(String searchTerm) {
        Map<String, String> teamOwners = new HashMap<>();
        Map<String, Double> leaderBoards = new HashMap<>();

        if (searchTerm.equals("Score") || searchTerm.equals("Rankings")) {

            for (int i = 0; i < teams.size(); i++) {

                if (searchTerm.equals("Score")) {



                } else if (searchTerm.equals("Rankings")) {

                    leaderBoards.put(teams.get(i), teamRank.get(i));


                }

            }
            System.out.println("Team " + searchTerm);

            leaderBoards.forEach((k, v) -> {
                System.out.println(k + ", " + v);

            });
        } else {
            for (int i = 0; i < teams.size(); i++) {

                if (searchTerm.equals("Owner")) {
                    teamOwners.put(teams.get(i), teamOwner.get(i));
                }

            }
            System.out.println("Team " + searchTerm);

            teamOwners.forEach((k, v) -> {
                System.out.println(k + ", " + v);

            });

        }
    }

    public static void showTeams() {
        Sort.quickSort(teams);
        System.out.println("Teams:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println(teams.get(i));
        }

    }

    public static void searchTeams(String searchTerm, String teamName) {
        BinarySearchTree leaderBoardsgg = new BinarySearchTree(null);
        if (searchTerm.equals("Score") || searchTerm.equals("Rankings")) {

            for (int i = 0; i < teams.size(); i++) {

                if (searchTerm.equals("Score")) {

                    BinarySearchTree.Node rootnode = new BinarySearchTree.Node(teams.get(0), teamScore.get(0));
                    leaderBoardsgg = new BinarySearchTree(rootnode);
                    BinarySearchTree.Node node = new BinarySearchTree.Node(teams.get(i), teamScore.get(i));
                    System.out.println(rootnode.name + node.name);
                    if (!rootnode.name.equals(node.name)) {

                        leaderBoardsgg.insert(rootnode, teamScore.get(i), teams.get(i));
                    } else {
                        leaderBoardsgg.insert(rootnode, teamScore.get(i), teams.get(i));
                    }

                } else if (searchTerm.equals("Rankings")) {
                    BinarySearchTree.Node rootnode = new BinarySearchTree.Node(teams.get(0), teamRank.get(0));
                    BinarySearchTree.Node node = new BinarySearchTree.Node(teams.get(i), teamRank.get(i));
                    leaderBoardsgg = new BinarySearchTree(rootnode);
                    if (rootnode != node) {
                        leaderBoardsgg.insert(rootnode, teamRank.get(i), teams.get(i));
                    } else {
                        leaderBoardsgg.insert(rootnode, teamRank.get(i), teams.get(i));
                    }

                }

            }
            BinarySearchTree.Node node = BinarySearchTree.searchNode(leaderBoardsgg.root, teamName);
            System.out.println("The " + teamName + " have a " + searchTerm + " of " + node.score);

        }

    }

}
