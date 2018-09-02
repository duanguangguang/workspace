package springbootdemo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/web")
public class WebController {
    private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(WebController.class);

    @RequestMapping(value = "index")
    public String index(ModelMap map) {
        logger.info("这里是FreeMarkerController");
        map.put("title", "freemarker hello 乐乐");
        return "index-backup"; // 开头不要加上/，linux下面会出错
    }

    @RequestMapping(value = "error")
    public String error(ModelMap map) {
        throw new RuntimeException("测试异常");
    }
}
