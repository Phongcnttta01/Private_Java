import java.util.Scanner;

public class AuthServiceImpl implements AuthService {
    public Account currentAccount;

    @Override
    public void login(Scanner scanner, AccountService accountService) {

        System.out.print("Nhập tên đăng nhập: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String matKhau = scanner.nextLine();
        this.currentAccount = accountService.getAccountByUsername(ten);
        if (currentAccount != null && currentAccount.getPassword().equals(matKhau) && currentAccount.getStatus() == Status.ACTIVE) {
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Sai thông tin đăng nhập hoặc tài khoản bị khóa.");
        }
    }

    @Override
    public void logout() {
        if (currentAccount != null) {
            System.out.println("Đăng xuất thành công!");
            currentAccount = null;
        } else {
            System.out.println("Chưa có tài khoản đăng nhập.");
        }
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        if (currentAccount != null && currentAccount.getUsername().equals(username) && currentAccount.getPassword().equals(oldPassword)) {
            currentAccount.setPassword(newPassword);
            System.out.println("Đổi mật khẩu thành công!");
        } else {
            System.out.println("Đổi mật khẩu thất bại. Kiểm tra lại thông tin.");
        }
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

}
