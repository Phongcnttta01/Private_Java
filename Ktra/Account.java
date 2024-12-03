public class Account extends Person{
    public String username;
    public String password;
    public Role role;
    public Status status;

    public Account() {
        super();
    }

    public Account(String id, String fullName, int age, Address address, String birthday, String username, String password, Role role , Status status) {
        super(id, fullName, age, address, birthday);
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return
                " username : " + username + '\n' +
                " password : '" + password + '\n' +
                " role : " + role + '\n' +
                " status : " + status + '\n' +
                " id : " + id + '\n' +
                " fullName : " + fullName + '\n' +
                " age : " + age +
                address.toString() +
                " birthday : " + birthday + '\n'
                ;
    }
}
