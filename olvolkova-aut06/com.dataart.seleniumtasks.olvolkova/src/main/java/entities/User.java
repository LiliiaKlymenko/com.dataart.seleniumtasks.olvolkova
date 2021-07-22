package entities;


import com.opencsv.bean.CsvBindByPosition;
import testdata.TestEnums;


public class User {

    @CsvBindByPosition(position = 0)
    private String login;
    @CsvBindByPosition(position = 1)
    private String firstName;
    @CsvBindByPosition(position = 2)
    private String lastName;
    @CsvBindByPosition(position = 3)
    private String password;
    @CsvBindByPosition(position = 4)
    private String passwordConfirm;
    @CsvBindByPosition(position = 5)
    private TestEnums.UserRole userRole;

    public TestEnums.UserRole getUserRole() {
        return userRole;
    }

    public User withUserRole(TestEnums.UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public String getPassword() {
        return password;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User withLogin(String login) {
        this.login = login;
        return this;
    }

    public User withPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
        return this;
    }


    public User withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                '}';
    }
}
