package business;
import java.time.LocalDate;
public class Account {
    private int accountID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private LocalDate birthday;
    private int sex;
    private int roleID;
    private int Status;

    public Account() {
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public Account(String firstName, String lastName, String email, String password, LocalDate birthday, int sex, int roleID, int Status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.sex = sex;
        this.roleID = roleID;
        this.Status = Status;
    }

    public Account(String firstName, String lastName, String email, String password, String phone, String address, LocalDate birthday, int sex, int roleID, int Status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.sex = sex;
        this.roleID = roleID;
        this.Status = Status;
    }

    public Account(int accountID, String firstName, String lastName, String email, String password, String phone, String address, LocalDate birthday, int sex, int roleID, int Status) {
        this.accountID = accountID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.sex = sex;
        this.roleID = roleID;
        this.Status = Status;
    }
    
    

    public Account(String firstName, String lastName, String email, String phone, String address, LocalDate birthday, int sex, int roleID, int Status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.sex = sex;
        this.roleID = roleID;
        this.Status = Status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }
    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
    
}
