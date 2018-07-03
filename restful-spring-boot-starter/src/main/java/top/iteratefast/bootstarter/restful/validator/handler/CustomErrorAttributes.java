package top.iteratefast.bootstarter.restful.validator.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import top.iteratefast.bootstarter.restful.error.SysErrors;

public class CustomErrorAttributes implements ErrorAttributes {

	@Override
	public Throwable getError(WebRequest webRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		result.put("success", false);
		result.put("errorCode",SysErrors.SYS_ERR_API_NOT_FUND.getCode()+"");
		result.put("errorDescription", SysErrors.SYS_ERR_API_NOT_FUND.getMessage());
		result.put("errorMsg",  SysErrors.SYS_ERR_API_NOT_FUND.getMessage());
		result.put("result", null);
		return result;
	}

}
