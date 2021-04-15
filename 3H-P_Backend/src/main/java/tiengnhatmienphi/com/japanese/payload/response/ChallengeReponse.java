package tiengnhatmienphi.com.japanese.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeReponse {
    private int room_id;
    private String room_name;
    private String level;
    private String pass;
    private String time;
    private int status;
    private String username;
}
