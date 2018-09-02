package springbootdemo.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import springbootdemo.springboot.controller.IndexController;
import springbootdemo.springboot.dao.SbUserDao;
import springbootdemo.springboot.dao.entity.Page;
import springbootdemo.springboot.entity.SbUser;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    private MockMvc mockMvc;

    @Before
    public void before (){
        this.mockMvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
    }

    @Test
    public void contextLoads() throws Exception {
        RequestBuilder req = get("/index");
        mockMvc.perform(req).andExpect(status().isOk()).andExpect(content().string("Hello World!"));
    }

    @Autowired
    private SbUserDao sbUserDao;
    @Test
    public void insert() {
        SbUser sbUser = new SbUser();
        sbUser.setName("测试");
        sbUser.setCreateTime(new Date());
        int result = sbUserDao.insert(sbUser);
        System.out.println(result);
    }
    @Test
    public void delete() {
        int result = sbUserDao.deleteById(1);
        System.out.println(result);
    }
    @Test
    public void update() {
        SbUser sbUser = new SbUser();
        sbUser.setId(2);
        sbUser.setName("测试 2");
        sbUser.setCreateTime(new Date());
        int result = sbUserDao.updateById(sbUser);
        System.out.println(result);
    }
    @Test
    public void select() {
        SbUser result = sbUserDao.selectById(2);
        System.out.println(result);
    }

    // 分页测试
    @Test
    public void queryForPage(){
        Page<SbUser> result = sbUserDao.queryForPage(1, 20, "测试");
        System.out.println(result.getList());
    }

}
