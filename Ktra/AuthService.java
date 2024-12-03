import java.util.Scanner;

public interface AuthService {


    void login(Scanner scanner, AccountService accountService);

    public void logout();
    public void changePassword(String username, String oldPassword, String newPassword);

}
