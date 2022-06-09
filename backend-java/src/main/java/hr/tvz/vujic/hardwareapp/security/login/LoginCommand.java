package hr.tvz.vujic.hardwareapp.security.login;

import javax.validation.constraints.NotBlank;

public class LoginCommand {

    @NotBlank(message = "Username must not be empty")
    private String username;

    @NotBlank(message = "Password must not be empty")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}