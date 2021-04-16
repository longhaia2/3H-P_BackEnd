package tiengnhatmienphi.com.japanese.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Phan Thi Dieu Hien
 **/

@Getter
@Setter
@AllArgsConstructor
public class AuthRequest {
    private String username;
    private String password;
}
