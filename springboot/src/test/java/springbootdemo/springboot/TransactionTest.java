package springbootdemo.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springbootdemo.springboot.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTest {

    @Autowired
    private UserService userService;
    @Test
    public void register() {
        String result = userService.register("dodd3", "192.168.1.1");
        System.out.println(result);
    }
}
