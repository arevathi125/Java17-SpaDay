package org.launchcode.models;

import jakarta.validation.constraints.*;

public class User {

    @NotBlank(message = "Username is required")
    @Size(min = 5 , max = 15, message = "User name must be 5-15 chars long.")
    private String username;
    @Email(message = "Invalid email. Try again. ")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "The Password should have at least 6 chars long.")
    private String password;

    @Size(min = 6, message = "Confirm Password must be at least 6 characters long.")
    @NotNull(message = "Confirm Passwords do not match.")
    private String confirmPassword;

    public User(){

    }

    public User(String username, String email, String password, String confirmPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    private void checkPassword(){
        if (password != null && confirmPassword != null && !password.equals(confirmPassword))
            setConfirmPassword(null);
    }
}
