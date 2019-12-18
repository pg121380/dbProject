package org.sfa.infomanage.bean;

public class User {

    private String username;
    private String password;
    private String employeeId;
    private String role;

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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String username, String password, String employeeId, String role) {
        this.username = username;
        this.password = password;
        this.employeeId = employeeId;
        this.role = role;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
