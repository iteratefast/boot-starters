package iteratefast.top.bootstarter.restful.error;

/**
 * Created by cz on 2018-5-11.
 */
public interface SysErrors {
    BizError SYS_ERR_BAD_REQUEST = new BizError(400,"Bad Request");
    BizError SYS_ERR_UNAUTHORIZED = new BizError(401,"Unauthorized");
    BizError SYS_ERR_VALIDATION_ERROR = new BizError(403,"Validation Error");
    BizError SYS_ERR_API_NOT_FUND = new BizError(404,"API Not Fund");
    BizError SYS_ERR_INTERNAL = new BizError(500,"System Internal Error");
}
