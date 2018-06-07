package iteratefast.top.bootstarter.restful.example.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.PropertySource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "添加对象描述")
public class AddVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -909845813881334805L;

	@ApiModelProperty(value = "Id")
	private Integer id;

	@ApiModelProperty(value = "姓名")
	@NotNull(message = "name 不能为空")
	private String name;

	@Size(min = 5, max = 10, message = "{password.length.illegal}")
	@ApiModelProperty(value = "密码")
	private String password;

	@Pattern(regexp = "1\\d{10}", message = "{user.phone.illegal}")
	@ApiModelProperty(value = "手机号")
	private String phone;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
