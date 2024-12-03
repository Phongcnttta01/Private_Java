import java.util.Scanner;

public class Main {
    public static AuthServiceImpl authService = new AuthServiceImpl();
    public static AccountServiceImpl accountService = new AccountServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Address ad1 = new Address("Quốc Lộ 18", "Bắc Ninh");
        Account ac1 = new Account("001", "Nguyễn Đăng Phong", 19, ad1, "20/09/2005", "phongcntt", "phong", Role.ADMIN, Status.ACTIVE);
        Account ac2 = new Account("002", "Nguyễn Thị Kim Anh", 19, ad1, "14/06/2005", "kimanh", "123456", Role.USER, Status.ACTIVE);
        accountService.createNewAccount(ac1);
        accountService.createNewAccount(ac2);
        boolean running = true;
        while (running) {
            System.out.println("\n----- Hệ Thống Quản Lý -----");
            if (authService.getCurrentAccount() == null) {
                System.out.println("1. Đăng nhập");
                System.out.println("2. Thoát");
                System.out.print("Chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        authService.login(scanner,accountService);
                        break;
                    case 2:
                        running = false;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }

            }
            else {
                Account currentaccount = authService.getCurrentAccount();
                Role currentRole =currentaccount.role;
                if(currentRole == Role.ADMIN){
                    System.out.println("======= HỆ THỐNG QUẢN LÝ TÀI KHOẢN =======");
                    System.out.println("Xin chào ADMIN: " + currentaccount.getUsername() );
                    System.out.println("1. Xem danh sách tài khoản");
                    System.out.println("2. Tạo tài khoản mới");
                    System.out.println("3. Tìm kiếm tài khoản");
                    System.out.println("4. Xóa tài khoản");
                    System.out.println("5. Thay đổi trạng thái tài khoản");
                    System.out.println("6. Xem thông tin cá nhân");
                    System.out.println("7. Đăng xuất");
                    System.out.println("--------------------------------");
                    System.out.print("Mời nhập lựa chọn : ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice){
                        case 1:
                            accountService.getAllAccount().forEach(System.out::println);
                            break;
                        case 2:
                            System.out.print("Nhập ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Nhập tên đầy đủ: ");
                            String fullName = scanner.nextLine();
                            System.out.print("Nhập tuổi: ");
                            int age = Integer.parseInt(scanner.nextLine());
                            System.out.print("Nhập địa chỉ (đường, thành phố): ");
                            String street = scanner.nextLine();
                            String city = scanner.nextLine();
                            System.out.print("Nhập ngày sinh: ");
                            String birthday = scanner.nextLine();
                            System.out.print("Nhập username: ");
                            String username = scanner.nextLine();
                            System.out.print("Nhập password: ");
                            String password = scanner.nextLine();
                            System.out.print("Nhập vai trò (ADMIN/USER): ");
                            Role role = Role.valueOf(scanner.nextLine().toUpperCase());
                            accountService.createNewAccount(new Account(id, fullName, age, new Address(street, city), birthday, username, password, role, Status.ACTIVE));
                            break;
                        case 3:
                            System.out.print("Nhập username: ");
                            String searchUsername = scanner.nextLine();
                            Account account = accountService.getAccountByUsername(searchUsername);
                            if (account != null) {
                                System.out.println(account);
                            } else {
                                System.out.println("Không tìm thấy tài khoản.");
                            }
                            break;
                        case 4:
                            System.out.print("Nhập username: ");
                            String deleteUsername = scanner.nextLine();
                            accountService.deleteAccount(deleteUsername);
                            break;
                        case 5:
                            System.out.print("Nhập username: ");
                            String changeUsername = scanner.nextLine();
                            System.out.print("Nhập trạng thái (ACTIVE/BAN): ");
                            Status status = Status.valueOf(scanner.nextLine().toUpperCase());
                            accountService.changeStatus(changeUsername, status);
                            break;
                        case 6:
                            System.out.println(currentaccount.toString());
                            break;
                        case 7:
                            authService.logout();
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                    }
                }
                else{
                    System.out.println("===== HỆ THỐNG NGƯỜI DÙNG =====");
                    System.out.println("Xin chào USER : " + currentaccount.getUsername());
                    System.out.println("1. Đổi mật khẩu");
                    System.out.println("2. Xem thông tin cá nhân");
                    System.out.println("3. Đăng xuất");
                    System.out.println("--------------------------------");
                    System.out.print("Mời nhập lựa chọn : ");
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            System.out.print("Nhập mật khẩu cũ: ");
                            String oldPassword = scanner.nextLine();
                            System.out.print("Nhập mật khẩu mới: ");
                            String newPassword = scanner.nextLine();
                            authService.changePassword(currentaccount.getUsername(), oldPassword, newPassword);
                            break;
                        case 2:
                            System.out.println(currentaccount);
                            break;
                        case 3:
                            authService.logout();
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                    }
                }
            }


        }
    }
}
