import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Main Menu:" + "\n"
                + "1.Team Menu" + "\n"
                + "2.Player Menu" + "\n"
                + "3.User Menu" + "\n"
                + "4.Simulate Game" + "\n"
                + "5.Logout" + "\n"
                + "Enter a number");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                teamMenu();
                break;
            case 2:
                playerMenu();
                break;
            case 3:
                userMenu();
                break;
            case 4:
                Simulator.matchSimulator();
                mainMenu();
                break;
            case 5:
                System.out.println("Goodbye");
                List<Team> teams = new ArrayList<>();

                Simulator.leagueSimulator(teams);
                break;
            default:
                System.out.println("Enter a number only, try again.");
                mainMenu();
        }

        sc.close();
    }

    public static void teamMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Team Menu:" + "\n"
                + "1.Teams" + "\n"
                + "2.Team Leaderboards" + "\n"
                + "3.Team Score" + "\n"
                + "4.View Team Owners" + "\n"
                + "5.Search For A Team" + "\n"
                + "6.Return" + "\n"
                + "Enter a number");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                TeamM.showTeams();
                break;
            case 2:
                TeamM.teamInfo("Rankings");
                break;
            case 3:
                TeamM.teamInfo("Overall Score");
                break;
            case 4:
                TeamM.teamInfo("Owner");
                break;
            case 5:
                System.out.println("Search Teams By Rankings Or Score?");
                String answer = sc.next();
                System.out.println();
                System.out.println("Which Team?");
                String team = sc.next();
                TeamM.searchTeams(answer, team);
                break;
            case 6:
                mainMenu();
                break;
            default:
                System.out.println("Enter a number only, try again.");
                teamMenu();
        }
        teamMenu();
        sc.close();
    }

    public static void playerMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player Menu:" + "\n"
                + "1.Players" + "\n"
                + "2.Player LeaderBoards" + "\n"
                + "3.Player Rank By Position" + "\n"
                + "4.Players Last Game Score" + "\n"
                + "5.Search For A Player" + "\n"
                + "6.Return" + "\n"
                + "Enter a number");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                PlayerM.showPlayers();
                break;
            case 2:
                PlayerM.playerInfo("Overall Score");
                break;
            case 3:
                PlayerM.playerInfo("Rankings");
                break;
            case 4:
                PlayerM.playerInfo("Last Game Score");
                break;
            case 5:
                System.out.println("Search Players By Rankings Or Score?");
                String answer = sc.next();
                System.out.println();
                System.out.println("Which Player?");
                String player = sc.next();
                PlayerM.searchPlayers(answer, player);
                break;
            case 6:
                mainMenu();
                break;
            default:
                System.out.println("Enter a number only, try again.");
                playerMenu();
        }
        playerMenu();
        sc.close();
    }

    public static void userMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("User Menu:" + "\n"
                + "1.View Users" + "\n"
                + "2.Return" + "\n"
                + "Enter a number");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                UserV.userInfo();

                break;
            case 2:
                mainMenu();
                break;
            default:
                System.out.println("Enter a number only, try again.");
                userMenu();
        }
        userMenu();
        sc.close();
    }

}
