package id.trimegah.response;

public class ResourceNotifResponseDetail {
    public String message;
    public boolean isError;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }


}
