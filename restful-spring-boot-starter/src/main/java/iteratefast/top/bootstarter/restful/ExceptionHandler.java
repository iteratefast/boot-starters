package iteratefast.top.bootstarter.restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import iteratefast.top.bootstarter.restful.error.BizErrors;
import iteratefast.top.bootstarter.restful.utils.JsonUtils;
import iteratefast.top.bootstarter.restful.vo.Resp;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

/**
 * 友好错误处理器。好的错误能让API访问者快速定位问题。
 * Created by cz on 2018-4-19.
 */
@ControllerAdvice
public class ExceptionHandler {
    static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(value=ValidationException.class)
    public ResponseEntity<String> handleValidationException(Exception exception, HttpServletRequest request) {
        ValidationException validationException = (ValidationException) exception;
        return doResponse(Resp.error(BizErrors.sysErrValidationError(validationException.getLocalizedMessage())));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value=Exception.class)
    public ResponseEntity<String> handleException(Exception exception, HttpServletRequest request) {
        logger.warn(exception.getMessage(),exception);
        return doResponse(Resp.error(exception));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value=MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleException(MethodArgumentTypeMismatchException exception, HttpServletRequest request) {
        MethodArgumentTypeMismatchException ex = (MethodArgumentTypeMismatchException)exception;
        String parmName = ex.getParameter().getParameterName();
        logger.warn(exception.getMessage());

        return doResponse(Resp.error(BizErrors.sysErrBadRequest("参数类型错误:"+parmName)));
    }

    private ResponseEntity<String> doResponse(Resp respResult) {
        String json = JsonUtils.toJson(respResult);
        logger.info("[Error Response] {}",json);

        return new ResponseEntity<String>(json, HttpStatus.OK);
    }
}
