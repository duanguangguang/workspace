package springbootdemo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootdemo.springboot.config.ConfigBean;

@RestController
public class UserController {

    /** 自定义属性*/
    @Value("${com.example.demo.name}")
    private String name;
    @Value("${com.example.demo.want}")
    private String want;

    @RequestMapping("/say")
    public String say() {
        return name + "," + want;
    }

    /** 绑定属性对象*/
    @Autowired
    ConfigBean configBean;

    @RequestMapping("/obj")
    public String obj(){
        return configBean.getName() + "," + configBean.getWant();
    }
}
