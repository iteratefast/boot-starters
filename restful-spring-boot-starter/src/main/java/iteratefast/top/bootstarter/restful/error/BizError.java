package iteratefast.top.bootstarter.restful.error;

/**
 * 描述一个系统错误
 * Created by cz on 2018-5-11.
 */
public class BizError extends Exception {
    private static final long serialVersionUID = 7115007169148619049L;

    int code;
    String description;

    public BizError(int code, String message) {
        super(message);
        this.code = code;
    }

    public BizError(int code, String message,String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BizError(int code,String message, String description, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public BizError setCode(int code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BizError setDescription(String description) {
        this.description = description;
        return this;
    }

    public BizError withDescription(String description){
        BizError copy = new BizError(this.getCode(),this.getMessage());
        copy.setDescription(description);
        return copy;
    }
}
