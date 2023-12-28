import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserV {

    private static String userLogin = "UserLogin.xlsx";
    private static List<String> passwordList = ExcelR.readStringFromExcel(userLogin, "Password");
    private static List<String> usersList = ExcelR.readStringFromExcel(userLogin, "Login");
    private static Map<String, String> passwordMatch;

    public static String userV(String userName, String passWord) {
        String accessW = "Granted";
        String accessD = "Dennied";

        if (verifyUser(userName, passWord)) {
            return accessW;
        } else {
            return accessD;
        }

    }

    public static boolean verifyUser(String username, String password) {
        passwordMatch = new HashMap<>();
        for (int i = 0; i < usersList.size(); i++) {
            passwordMatch.put(usersList.get(i), passwordList.get(i));
        }
        return usersList.contains(username) && passwordMatch.get(username).equals(password);
    }

    public static void userInfo() {
        Sort.quickSort(usersList);
        System.out.println("Users:");
        for (int i = 0; i < usersList.size(); i++) {
            System.out.println(usersList.get(i));
        }
    }

}
