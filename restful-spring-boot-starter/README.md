# restful-spring-boot-starter

## 基于以下技术栈 ：

    spring-boot 2.0.2.RELEASE
    spring-boot-starter-web
    jackson (JSON序列化实现)



##添加到项目

1. 首先假设你的项目是基于spring-boot的

```xml
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.2.RELEASE</version>
</parent>
```

2. 添加restful-spring-boot-starter依赖

```xml
<dependency>
    <groupId>iteratefast.top</groupId>
    <artifactId>restful-spring-boot-starter</artifactId>
    <version>${restful.starter.version}</version>
</dependency>
```



##响应对象

**例1:** 正常的响应Resp<T>:

```java
@RequestMapping(value = "/", method = RequestMethod.GET)
Resp<String> home() {
    return Resp.success("Hello World!");
}

@RequestMapping(value = "/getById", method = RequestMethod.GET)
Resp<User> getById(Integer id) {
    return Resp.success(userService.getById(id));
}

@RequestMapping(value = "/getList", method = RequestMethod.GET)
Resp<List<User>> getById(String nickName) {
    return Resp.success(userService.getAllByNickName(nickName));
}
```



**例2:** 分页响应 PagingResult<T>:

以下是一个基本的JPA持久化定义，其中有一个返回org.springframework.data.domain.Page的findAll方法:

```java
package com.example.myapp.domain;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

public interface CityRepository extends Repository<City, Long> {

	Page<City> findAll(Pageable pageable);

	City findByNameAndCountryAllIgnoringCase(String name, String country);

}
```

我们可以通过**PagingResult.of(page)**方法封装我们的分页数据响应结果:

```java
@Autowired
CityRepository cityRepository;

@RequestMapping("/pageable")
public PagingResult<City> pageable(){
  //Pageable是接口，PageRequest是接口实现
  //PageRequest的对象构造函数有多个，page是页数，初始值是0，size是查询结果的条数，后两个参数参考Sort对象的构造方法
  Pageable pageable = new PageRequest(0,3, Sort.Direction.DESC,"id");
  Page<Customer> page = cityRepository.findAll(pageable);
  return PagingResult.of(page);
}
```

**例3:** 返回系统错误:

每个系统异常定义了这个错误的错误码，和异常消息：

```
public interface SysErrors {
    BizError SYS_ERR_BAD_REQUEST = new BizError(400,"Bad Request");
    BizError SYS_ERR_UNAUTHORIZED = new BizError(401,"Unauthorized");
    BizError SYS_ERR_VALIDATION_ERROR = new BizError(403,"Validation Error");
    BizError SYS_ERR_API_NOT_FUND = new BizError(404,"API Not Fund");
    BizError SYS_ERR_INTERNAL = new BizError(500,"System Internal Error");
}
```

更多情况下，我们还要告诉API使用者具体发生了什么，而不仅仅提供一个错误码。

BizError对象提供了withDescription方法以便我们创建对应错误常量对象的**拷贝**，并且为其discription属性赋值:

```java
BizError error = SysErrors.SYS_ERR_INTERNAL.withDescription("这是错误描述");
```

接下来，利用Resp.error方法，我们可以快速创建一个错误响应:

```java
return Resp.error(
    SysErrors.SYS_ERR_INTERNAL.withDescription("这是错误描述"));
```

另外，非BizError也可以用来快速创建错误响应(虽然我们不建议你这样):

```java
return Resp.error(new IllegalArgumentException("呃~ 你传入了错误的参数"));
```



## 参数校验及友好错误响应