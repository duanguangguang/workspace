package springbootdemo.springboot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/api", method = RequestMethod.POST)
public class ApiController {

//    @CrossOrigin(origins = "http://localhost:8989")
    @RequestMapping(value = "/app")
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "hello world");
        map.put("name", name);
        return map;
    }
}
