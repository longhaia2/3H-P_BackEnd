package tiengnhatmienphi.com.japanese.payload.response;

import lombok.Data;

/**
 * Phan Thi Dieu Hien
 **/

@Data
public class GenericResponse {
    private String error;
    private String message;

    public GenericResponse() {

    }

    public GenericResponse(String message) {
        this.message = message;
    }

    public GenericResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }
}
