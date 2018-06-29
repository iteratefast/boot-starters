package top.iteratefast.bootstarter.restful.vo;

import top.iteratefast.bootstarter.restful.error.BizError;
import top.iteratefast.bootstarter.restful.error.SysErrors;

import java.io.Serializable;

/**
 * RESTFul 响应包装类
 * Created by cz on 2018-5-11.
 */
public class Resp<T> implements Serializable{
    private static final long serialVersionUID = 678807724492040902L;
    /**
     * 是否成功
     */
    boolean success = true;

    /**
     * 正常的结果
     */
    T result;

    /**
     * 错误码
     */
    String errorCode;

    /**
     * 错误描述
     */
    String errorDescription;

    /**
     * 错误消息
     */
    String errorMsg;

    /**
     * 成功
     * @param result
     * @param <T>
     * @return
     */
    public static <T> Resp<T> success(T result){
        Resp<T> resp = new Resp<T>();
        resp.success = true;
        resp.result = result;
        return resp;
    }

    /**
     * 成功(无返回值)
     * @return
     */
    public static  Resp<String> success(){
        return success("OK");
    }

    /**
     * 基于异常构建一个错误响应
     * @param e
     * @return
     */
    public static Resp error(Exception e){
        BizError bizError = SysErrors.SYS_ERR_INTERNAL;
        if(e instanceof BizError){
            bizError = (BizError)e;
        }
        return error(
                String.valueOf(bizError.getCode()),
                bizError.getDescription(),
                bizError.getMessage());
    }


    /**
     * 构建错误响应
     * @param errorCode
     * @param errorDescription
     * @param errorMsg
     * @return
     */
    public static Resp error(String errorCode,String errorDescription,String errorMsg){
        Resp resp = new Resp();
        resp.success = false;
        resp.errorCode = errorCode;
        resp.errorDescription = errorDescription;
        resp.errorMsg = errorMsg;
        return resp;
    }

    public boolean isSuccess() {
        return success;
    }

    public Resp setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Resp setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Resp setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public T getResult() {
        return result;
    }

    public Resp setResult(T result) {
        this.result = result;
        return this;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public Resp setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }
}
