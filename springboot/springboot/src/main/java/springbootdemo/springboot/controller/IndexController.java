package springbootdemo.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springbootdemo.springboot.bean.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class IndexController {

    //@RestController就是@Controller多了@ResponseBody，将字符串返回
    @RequestMapping
    public String index(){
        return "Hello World!";
    }

    //springboot自带了json jar，自动进行json的编译和序列化返回json数据格式，并且默认使用utf-8，中文不会乱码
    //http://localhost:8080/index/get?name=dodd
    @RequestMapping("/get")
    public Map<String,String> get(@RequestParam String name){
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("value","hello world!");
        return map;
    }

    //动态获取url
    //http://localhost:8080/index/find/1/dodd
    @RequestMapping("/find/{id}/{name}")
    public User get(@PathVariable int id, @PathVariable String name){
        User u = new User();
        u.setId(id);
        u.setName(name);
        u.setDate(new Date());
        return u;
    }


}
