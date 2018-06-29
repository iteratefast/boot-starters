package iteratefast.top.bootstarter.restful.validator.handler;

import static iteratefast.top.bootstarter.restful.error.SysErrors.SYS_ERR_API_NOT_FUND;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import iteratefast.top.bootstarter.restful.vo.Resp;

@RestController
public class RestNotFoundFilter implements ErrorController {

	private static final String NOT_FOUND = "404";
	private static final String ERROR_PATH = "/error";

	@RequestMapping(value = ERROR_PATH)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public Resp<Object> handleError() {
		System.out.println();
		return Resp.error(SYS_ERR_API_NOT_FUND.withDescription(NOT_FOUND));
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}