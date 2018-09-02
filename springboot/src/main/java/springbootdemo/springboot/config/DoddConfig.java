package springbootdemo.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@EnableConfigurationProperties(value= {Config.class}) 注解注册此实体bean
@ConfigurationProperties(prefix="dodd")
public class DoddConfig {

    String name;

    List<String> hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }
}
