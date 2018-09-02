package springbootdemo.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import springbootdemo.springboot.dao.JpaUserDao;
import springbootdemo.springboot.entity.JpaUser;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {
    @Autowired
    private JpaUserDao jpaUserDao;

    @Test
    public void insert() {
        JpaUser entity = new JpaUser();
        entity.setUserName("dodd");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        jpaUserDao.save(entity);
    }
    @Test
    public void delete() {
        jpaUserDao.delete(1);
    }
    @Test
    public void update() {
        JpaUser entity = new JpaUser();
        entity.setId(2);
        entity.setUserName("dodd 2");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        jpaUserDao.save(entity);
    }
    @Test
    public void select() {
        JpaUser result = jpaUserDao.findOne(2);
        System.out.println(result);
    }

    @Test
    public void select1() {
        List<JpaUser> result = jpaUserDao.findByUserName("dodd 2");
        System.out.println(result);
    }

    @Test
    public void select2() {
        List<JpaUser> result = jpaUserDao.findByName("dodd 2");
        System.out.println(result);
    }

    @Test
    public void select3() {
        List<JpaUser> result = jpaUserDao.findByUserNameAndUserIp("dodd 2", "192.168.0.1");
        System.out.println(result);
    }

    // 分页
    @Test
    public void queryForPage() {
        Pageable pageable = new PageRequest(0, 20, new Sort(new Sort.Order(Sort.Direction.DESC, "id")));
        Page<JpaUser> result = jpaUserDao.findByUserName("dodd 2", pageable);
        System.out.println(result.getContent());
    }
}
