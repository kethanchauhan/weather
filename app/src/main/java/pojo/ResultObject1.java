package pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kethan on 12/6/17.
 */

public class ResultObject1<T> {
    @Expose
    @SerializedName("message")
    public String message;

    @Expose
    @SerializedName("result")
    public int result;

    @Expose
    @SerializedName("errors")
    public List<String> errors;

    @Expose
    @SerializedName("list")
    public T list;


    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }


    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
