package iteratefast.top.bootstarter.restful.validator.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import iteratefast.top.bootstarter.restful.error.BizError;
import iteratefast.top.bootstarter.restful.error.BizErrors;
import iteratefast.top.bootstarter.restful.utils.JsonUtils;
import iteratefast.top.bootstarter.restful.vo.Resp;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(BizError.class)
	@ResponseBody
	Resp<Object> handleException(BizError error) {
		Resp<Object> resp = new Resp<>();
		resp.setSuccess(false);
		resp.setErrorCode(error.getCode() + "");
		resp.setErrorMsg(error.getMessage());
		resp.setErrorDescription(error.getDescription());
		return resp;
	}

	/**
	 * bean val error
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	Resp<Object> handleException(MethodArgumentNotValidException e) {
		Resp<Object> resp = new Resp<>();
		resp.setSuccess(false);
		resp.setErrorCode(BizErrors.SYS_ERR_VALIDATION_ERROR.getCode() + "");
		resp.setErrorMsg(BizErrors.SYS_ERR_VALIDATION_ERROR.getMessage());
		BindingResult bindingResult = e.getBindingResult();
		List<ObjectError> list = bindingResult.getAllErrors();
		List<String> errorMsgList = new ArrayList<>();
		for (ObjectError objectError : list) {
			errorMsgList.add(objectError.getDefaultMessage());
		}
		resp.setErrorDescription(JsonUtils.toJson(errorMsgList));
		return resp;
	}

	/**
	 * param error
	 * 
	 * @param error
	 * @return
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	Resp<Object> handleException(ConstraintViolationException error) {
		Resp<Object> resp = new Resp<>();
		resp.setSuccess(false);
		resp.setErrorCode(BizErrors.SYS_ERR_VALIDATION_ERROR.getCode() + "");
		resp.setErrorMsg(BizErrors.SYS_ERR_VALIDATION_ERROR.getMessage());
		List<String> errorMsgList = new ArrayList<>();

		Set<ConstraintViolation<?>> set = error.getConstraintViolations();
		for (ConstraintViolation<?> constraintViolation : set) {
			errorMsgList.add(constraintViolation.getMessage());
		}

		resp.setErrorDescription(JsonUtils.toJson(errorMsgList));
		return resp;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseBody
	Resp<Object> handleException(NoHandlerFoundException error) {
		Resp<Object> resp = new Resp<>();
		resp.setSuccess(false);
		resp.setErrorCode(BizErrors.SYS_ERR_API_NOT_FUND.getCode() + "");
		resp.setErrorMsg(BizErrors.SYS_ERR_API_NOT_FUND.getMessage());
		resp.setErrorDescription(error.getMessage());
		return resp;
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	Resp<Object> handleException(Exception error) {
		Resp<Object> resp = new Resp<>();
		resp.setSuccess(false);
		resp.setErrorCode(BizErrors.SYS_ERR_INTERNAL.getCode() + "");
		resp.setErrorMsg(BizErrors.SYS_ERR_INTERNAL.getMessage());
		resp.setErrorDescription(error.getMessage());
		return resp;
	}

}
