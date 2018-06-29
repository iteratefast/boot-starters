package top.iteratefast.bootstarter.restful.validator.handler;

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

import top.iteratefast.bootstarter.restful.error.BizError;
import top.iteratefast.bootstarter.restful.utils.JsonUtils;
import top.iteratefast.bootstarter.restful.vo.Resp;

import static top.iteratefast.bootstarter.restful.error.SysErrors.SYS_ERR_API_NOT_FUND;
import static top.iteratefast.bootstarter.restful.error.SysErrors.SYS_ERR_INTERNAL;
import static top.iteratefast.bootstarter.restful.error.SysErrors.SYS_ERR_VALIDATION_ERROR;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(BizError.class)
	@ResponseBody
	Resp<Object> handleException(BizError error) {
		return Resp.error(error);
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
		BindingResult bindingResult = e.getBindingResult();
		List<ObjectError> list = bindingResult.getAllErrors();
		List<String> errorMsgList = new ArrayList<>();
		for (ObjectError objectError : list) {
			errorMsgList.add(objectError.getDefaultMessage());
		}
		return Resp.error(SYS_ERR_VALIDATION_ERROR.withDescription(JsonUtils.toJson(errorMsgList)));
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
		Resp resp = Resp.error(error);
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
		return Resp.error(SYS_ERR_API_NOT_FUND.withDescription(JsonUtils.toJson(error.getMessage())));
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	Resp<Object> handleException(Exception error) {
		return Resp.error(SYS_ERR_INTERNAL.withDescription(JsonUtils.toJson(error.getMessage())));
	}

}
