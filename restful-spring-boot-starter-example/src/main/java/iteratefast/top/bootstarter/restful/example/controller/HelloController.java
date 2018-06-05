package iteratefast.top.bootstarter.restful.example.controller;

import iteratefast.top.bootstarter.restful.vo.Resp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cz on 2018-6-1.
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    Resp<String> home() {
        return Resp.success("Hello World!");
    }
}
