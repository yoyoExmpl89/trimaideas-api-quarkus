package id.trimegah.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class ResourceNotifResponse {

    public String message;
    public boolean isError;

    @JsonProperty(value = "total_notification")
    private long total_notification;

    @JsonProperty(value = "unread_notification")
    private long unread_notification;

    private Object data;

    public long getTotal_notification() {
        return total_notification;
    }

    public void setTotal_notification(long total_notification) {
        this.total_notification = total_notification;
    }

    public long getUnread_notification() {
        return unread_notification;
    }

    public void setUnread_notification(long unread_notification) {
        this.unread_notification = unread_notification;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResourceNotifResponse dataDetail(Object data){
        ResourceNotifResponse response = new ResourceNotifResponse();

        if(data == null){
            response.setError(true);
            response.setMessage(ResourceMessage.DATA_NOT_FOUND);
        }else{
            response.setError(false);
            response.setMessage(ResourceMessage.SUCCESS);
        }
        response.setData(data);
        return response;
    }

    public static ResourceNotifResponse list(List<?> Result){
        ResourceNotifResponse response = new ResourceNotifResponse();
        if(Result.isEmpty()){
            response.setMessage(ResourceMessage.DATA_NOT_FOUND);
            response.setTotal_notification(0);
            response.setUnread_notification(0);
        }else{
            response.setMessage(ResourceMessage.SUCCESS);
            response.setTotal_notification(Result.size());
            response.setUnread_notification(Result.size());
        }
        response.setData(Result);

        return response;
    }

    public static ResourceNotifResponse datapaging(List<?> Result ,long count){
        //System.out.println();
        ResourceNotifResponse response = list(Result);
        return response;


        //return response;
    }
    public static ResourceNotifResponse errordata(String message){
        ResourceNotifResponse response = new ResourceNotifResponse();
        response.setError(true);
        response.setMessage(message);
        return response;
    }

    public static ResourceNotifResponse error(Object data, String message){
        ResourceNotifResponse response = new ResourceNotifResponse();
        response.setData(data);
        response.setError(true);
        response.setMessage(message);
        response.setTotal_notification(0);
        response.setUnread_notification(0);
        return response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceNotifResponse response = (ResourceNotifResponse) o;
        return isError() == response.isError() &&
                Objects.equals(getMessage(), response.getMessage()) &&
                Objects.equals(getData(), response.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), isError(), getData());
    }
}
