import java.util.Scanner;

public class App {

    public static void main(String args[]) {

        enterCredentials();

    }

    public static void enterCredentials() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String enteredUsername = sc.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = sc.nextLine();

        String outPut = UserV.userV(enteredUsername, enteredPassword);

        if (outPut == "Granted") {
            System.out.println("Welcome " + enteredUsername);
            Menu.mainMenu();
        } else {
            System.out.println("Username or Password incorrect");
            enterCredentials();
        }

        sc.close();
    }

}
