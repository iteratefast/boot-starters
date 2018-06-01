package iteratefast.top.bootstarter.restful.error;

/**
 * Created by cz on 2018-5-11.
 */
public class BizErrors {
    public static final BizError SYS_ERR_BAD_REQUEST = new BizError(400,"Bad Request");
    public static final BizError SYS_ERR_UNAUTHORIZED = new BizError(401,"Unauthorized");
    public static final BizError SYS_ERR_VALIDATION_ERROR = new BizError(403,"Validation Error");
    public static final BizError SYS_ERR_API_NOT_FUND = new BizError(404,"API Not Fund");
    public static final BizError SYS_ERR_INTERNAL = new BizError(500,"System Internal Error");

    public static BizError sysErrBadRequest(String message){
        return cloneBizError(SYS_ERR_BAD_REQUEST,message);
    }

    public static BizError sysErrUnauthorized(String message){
        return cloneBizError(SYS_ERR_UNAUTHORIZED,message);
    }

    public static BizError sysErrValidationError(String message){
        return cloneBizError(SYS_ERR_VALIDATION_ERROR,message);
    }

    public static BizError sysErrNotFund(String message){
        return cloneBizError(SYS_ERR_API_NOT_FUND,message);
    }

    public static BizError sysErrSysError(String message){
        return cloneBizError(SYS_ERR_INTERNAL,message);
    }

    private static BizError cloneBizError(BizError error, String message) {
        return new BizError(error.getCode(),error.getDescription(),message);
    }
}
