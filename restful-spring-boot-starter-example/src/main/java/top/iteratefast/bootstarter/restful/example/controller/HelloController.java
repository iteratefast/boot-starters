package top.iteratefast.bootstarter.restful.example.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import top.iteratefast.bootstarter.restful.example.vo.AddVo;
import top.iteratefast.bootstarter.restful.example.vo.HomePageVo;
import top.iteratefast.bootstarter.restful.vo.PagingResult;
import top.iteratefast.bootstarter.restful.vo.Resp;

/**
 * Created by cz on 2018-6-1.
 */
@Api(value = "demo演示", tags = { "demoController" })
@RestController
@RequestMapping("/")
@Validated
public class HelloController {

	@ApiOperation("方法描述")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	Resp<String> home() {
		return Resp.success("Hello World!");
	}

	@ApiOperation("添加对象")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	Resp add(@RequestBody @Valid AddVo addvo) {
		return Resp.success();
	}

	@ApiOperation("根据id查询对象")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "id", value = "id", required = true, dataType = "int", defaultValue = "1000") })
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	Resp<String> getById(@NotNull(message = "id 必填") Integer id) {
		return Resp.success();
	}

	@ApiOperation("分页查询")
	@RequestMapping(value = "/findAllByPage", method = RequestMethod.POST)
	PagingResult<AddVo> findAllByPage(@RequestBody HomePageVo pageVo) {
		return PagingResult.of(null);
	}
}
