package org.example.aitestpro.util;
import java.io.Serializable;
import java.util.HashMap;


public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private T data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    private String success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> R<T> ok(){
        R<T> r = new R<>();
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static <T> R<T> error(){
        R<T> r = new R<>();
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        r.setData((T)new HashMap<>());
        return r;
    }

    public R<T> message(String message){
        this.setMessage(message);
        return this;
    }

    public R<T> code(Integer code){
        this.setCode(code);
        return this;
    }


    public R<T> data(T value){
        this.setData(value);
        return this;
    }


}
