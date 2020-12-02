package id.trimegah.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ResourceResponse {

    private String message;

    private boolean isError;

    @JsonProperty(value = "total_data")
    private long totalData;

    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public boolean isError(){
        return isError;
    }

    public void setError(boolean error){
        this.isError = error;
    }

    public long getTotalData(){return totalData;}
    public void setTotalData(long totalData) {
        this.totalData = totalData;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResourceResponse() {
        this.isError = false;
    }

    public static ResourceResponse data(Object data) {
        ResourceResponse response = new ResourceResponse();
        if (data == null) {
            response.setError(true);
            response.setMessage(ResourceMessage.DATA_NOT_FOUND);
            response.setTotalData(0);
        } else {
            response.setMessage(ResourceMessage.SUCCESS);
            response.setTotalData(1);
        }
        response.setData(data);
        return response;
    }

    public static ResourceResponse list(List<?> result) {
        ResourceResponse response = new ResourceResponse();
        if (result.isEmpty()) {
            response.setMessage(ResourceMessage.DATA_NOT_FOUND);
            response.setTotalData(0);
        } else {
            response.setMessage(ResourceMessage.SUCCESS);
            response.setTotalData(result.size());
        }
        response.setData(result);
        return response;
    }

    public static ResourceResponse paging(List<?> result, long count) {
        ResourceResponse response =  list(result);
        response.setTotalData(count);
        return response;
    }

    public static ResourceResponse error(String message) {
        ResourceResponse response = new ResourceResponse();
        response.setData(null);
        response.setError(true);
        response.setMessage(message);
        response.setTotalData(0);
        return response;
    }

    public static ResourceResponse error(Object data, String message) {
        ResourceResponse response = error(message);
        response.setData(data);
        return response;
    }

    public static ResourceResponse error(Set<? extends ConstraintViolation<?>> violations) {
        return error(violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", ")));
    }

    public static ResourceResponse error(Object data, Set<? extends ConstraintViolation<?>> violations) {
        ResourceResponse response = error(violations);
        response.setData(data);
        return response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceResponse response = (ResourceResponse) o;
        return isError() == response.isError() &&
                getTotalData() == response.getTotalData() &&
                Objects.equals(getMessage(), response.getMessage()) &&
                Objects.equals(getData(), response.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), isError(), getTotalData(), getData());
    }

}
