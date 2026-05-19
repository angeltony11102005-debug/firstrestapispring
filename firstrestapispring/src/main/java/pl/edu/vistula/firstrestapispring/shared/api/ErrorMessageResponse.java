package pl.edu.vistula.firstrestapispring.shared.api.response;

public class ErrorMessageResponse {

    private final String message;

    public ErrorMessageResponse() {
        this.message = null;
    }

    public ErrorMessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}