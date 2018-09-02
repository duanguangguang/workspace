package springbootdemo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springbootdemo.springboot.cache.AbstractCache;
import springbootdemo.springboot.entity.JpaUser;

import java.util.Date;

@RestController
@RequestMapping("/ehcache")
public class EhCacheController {
    @Autowired
    private AbstractCache ehCache;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public JpaUser get(@RequestParam(defaultValue = "2") Integer id) {
        return ehCache.selectById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public JpaUser update(@RequestParam(defaultValue = "2") Integer id) {
        JpaUser bean = ehCache.selectById(id);
        bean.setUserName("dodd22");
        bean.setCreateTime(new Date());
        ehCache.updateById(bean);
        return bean;
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del(@RequestParam(defaultValue = "1") Integer id) {
        return ehCache.deleteById(id);
    }

}
