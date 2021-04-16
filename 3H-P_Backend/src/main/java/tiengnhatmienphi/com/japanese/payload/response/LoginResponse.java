package tiengnhatmienphi.com.japanese.payload.response;

import lombok.Data;

/**
 * Phan Thi Dieu Hien
 **/

@Data
public class LoginResponse {
    private String username;
    private String accessToken;
    private String tokenType = "Bearer ";
    private String role;
    private Integer userId;

    public LoginResponse(String username, String jwt, String role, Integer userId) {
        this.username = username;
        this.accessToken = jwt;
        this.role = role;
        this.userId =userId;
    }
}
