package tiengnhatmienphi.com.japanese.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Phan Thi Dieu Hien
 **/

@Data
@AllArgsConstructor
public class GenericResponse {
    private String error;
    private String message;
    private Object dataResponse;

    public GenericResponse() {

    }

    public GenericResponse(String message) {
        this.message = message;
    }

    public GenericResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public GenericResponse(String message, Object object) {
        this.message = message;
        this.dataResponse = object;
    }
}

