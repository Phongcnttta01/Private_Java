import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    public List<Account> accounts = new ArrayList<>();

    @Override
    public List<Account> getAllAccount() {
        return accounts;
    }

    @Override
    public void createNewAccount(Account account) {
        accounts.add(account);
        System.out.println("Tạo tài khoản thành công: " + account.getUsername());
    }

    @Override
    public Account getAccountByUsername(String username) {
        for (Account account : accounts) {
            if (username.equals(account.getUsername())) {
                return account;
            }
        }
    return null;
    }

    @Override
    public void deleteAccount(String username) {
        Account account = getAccountByUsername(username);
        if (account != null) {
            accounts.remove(account);
            System.out.println("Xóa tài khoản thành công: " + username);
        } else {
            System.out.println("Không tìm thấy tài khoản: " + username);
        }
    }

    @Override
    public void changeStatus(String username, Status status) {
        Account account = getAccountByUsername(username);
        if (account != null) {
            account.setStatus(status);
            System.out.println("Thay đổi trạng thái thành công cho tài khoản: " + username);
        } else {
            System.out.println("Không tìm thấy tài khoản: " + username);
        }
    }
}
