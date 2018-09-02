package springbootdemo.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springbootdemo.springboot.component.RedisComponent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisComponent redisComponent;
    @Test
    public void set() {
        redisComponent.set("dodd", "hello world");
    }
    @Test
    public void get() {
        System.out.println(redisComponent.get("dodd"));
    }
    @Test
    public void del() {
        redisComponent.del("dodd");
    }


}
