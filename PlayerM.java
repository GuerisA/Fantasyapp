
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerM {
    private static String playerInfo = "PlayerInfo.xlsx";
    public static List<Double> playerScore = ExcelR.readDoubleFromExcel(playerInfo, "Overall Score");
    public static List<String> playerTeam = ExcelR.readStringFromExcel(playerInfo, "Team");
    public static List<String> playerPosition = ExcelR.readStringFromExcel(playerInfo, "Position");
    public static List<Double> playerRank = ExcelR.readDoubleFromExcel(playerInfo, "Rankings");
    public static List<String> players = ExcelR.readStringFromExcel(playerInfo, "Player");
    private static List<Double> playerLastGame = ExcelR.readDoubleFromExcel(playerInfo, "Last Game Score");

    public static Player playerM(String playerName) {

        Player player = new Player(playerName);
        for (int i = 0; i < players.size(); i++) {
            if (playerName.equals(players.get(i))) {

                player.setPlayerTeam(playerTeam.get(i));
                player.setPlayerOverallScore(playerScore.get(i));
                player.setPlayerOldRank(playerRank.get(i));

                player.setPlayerLastGameScore(playerLastGame.get(i));
                player.setPlayerPosition(playerPosition.get(i));

            }

        }

        return player;
    }

    public static void playerInfo(String searchTerm) {

        Map<String, Double> leaderBoards = new HashMap<>();
        for (int i = 0; i < players.size(); i++)
            if (searchTerm.equals("Overall Score")) {
                leaderBoards.put(players.get(i), playerScore.get(i));

            } else if (searchTerm.equals("Last Game Score")) {
                leaderBoards.put(players.get(i), playerLastGame.get(i));
            } else if (searchTerm.equals("Rankings")) {
                leaderBoards.put(players.get(i), playerRank.get(i));
            }

        System.out.println("Players " + searchTerm);
        leaderBoards.forEach((k, v) -> {
            System.out.println("PLayer: " + k + ", " + searchTerm + ": " + v + "");

        });
    }

    public static void showPlayers() {
        Sort.quickSort(players);
        System.out.println("players:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i));
        }

    }
    public static void searchPlayers(String searchTerm, String playerName) {
        BinarySearchTree searchTree = new BinarySearchTree(null);
        if (searchTerm.equals("Score") || searchTerm.equals("Rankings")) {

            for (int i = 0; i < players.size(); i++) {

                if (searchTerm.equals("Score")) {

                    BinarySearchTree.Node rootnode = new BinarySearchTree.Node(players.get(0), playerScore.get(0));
                    searchTree = new BinarySearchTree(rootnode);
                    BinarySearchTree.Node node = new BinarySearchTree.Node(players.get(i), playerScore.get(i));
                    System.out.println(rootnode.name + node.name);
                    if (!rootnode.name.equals(node.name)) {

                        searchTree.insert(rootnode, playerScore.get(i), players.get(i));
                    } else {
                        searchTree.insert(rootnode, playerScore.get(i), players.get(i));
                    }

                } else if (searchTerm.equals("Rankings")) {
                    BinarySearchTree.Node rootnode = new BinarySearchTree.Node(players.get(0), playerRank.get(0));
                    BinarySearchTree.Node node = new BinarySearchTree.Node(players.get(i), playerRank.get(i));
                    searchTree = new BinarySearchTree(rootnode);
                    if (rootnode != node) {
                        searchTree.insert(rootnode, playerRank.get(i), players.get(i));
                    } else {
                        searchTree.insert(rootnode, playerRank.get(i), players.get(i));
                    }
                   
                }

            }
            System.out.println(searchTree);
            BinarySearchTree.Node node = BinarySearchTree.searchNode(searchTree.root, playerName);
            System.out.println(playerName + " has a " + searchTerm + " of " + node.score);

        }

    }

}
