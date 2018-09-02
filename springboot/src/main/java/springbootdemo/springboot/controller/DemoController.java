package springbootdemo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootdemo.springboot.config.DoddConfig;

@RestController
public class DemoController {

    @Autowired
    DoddConfig doddConfig;

    @Value("${com.dodd}")
    String string;

    @RequestMapping("/")
    public String index(){
        return string;
    }

    @RequestMapping("/hobby")
    public String hobby(){
        return doddConfig.getName() + " 爱好是：" + doddConfig.getHobby();
    }

}
