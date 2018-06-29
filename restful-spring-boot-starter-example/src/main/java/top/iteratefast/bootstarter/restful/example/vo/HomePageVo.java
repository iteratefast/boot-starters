package top.iteratefast.bootstarter.restful.example.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.iteratefast.bootstarter.restful.vo.Pagination;

@ApiModel(description = "homePage分页查询Vo")
public class HomePageVo extends Pagination {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3871796434806288956L;

	@ApiModelProperty(value = "姓名", allowableValues = "张三")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
