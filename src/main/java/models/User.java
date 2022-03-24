package models;

public class User {
    private String Email;
    private String password;

    public String getEmail() {
        return Email;
    }

    public User withEmail(String email) {
        Email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
