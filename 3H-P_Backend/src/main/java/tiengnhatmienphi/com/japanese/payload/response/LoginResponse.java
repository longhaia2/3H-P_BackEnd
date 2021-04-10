package tiengnhatmienphi.com.japanese.payload.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String username;
    private String accessToken;
    private String tokenType = "Bearer ";
    private String role;

    public LoginResponse(String username, String jwt, String role) {
        this.username = username;
        this.accessToken = jwt;
        this.role = role;
    }
}
