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
import springbootdemo.springboot.component.MongodbComponent;
import springbootdemo.springboot.dao.MongoDao;
import springbootdemo.springboot.entity.JpaUser;
import springbootdemo.springboot.entity.SbUser;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbTest {
    @Autowired
    private MongodbComponent mongodbComponent;
    @Test
    public void set() {
        SbUser sbUser = new SbUser();
        sbUser.setId(2); //mongoTemplate方式mongo主键不会自增
        sbUser.setName("doddmongo");
        sbUser.setCreateTime(new Date());
        mongodbComponent.insert(sbUser);
    }
    @Test
    public void select() {
        System.out.println(mongodbComponent.selectById(1));
    }
    @Test
    public void update() {
        SbUser sbUser = new SbUser();
        sbUser.setId(1);
        sbUser.setName("updateTest");
        sbUser.setCreateTime(new Date());
        mongodbComponent.updateById(sbUser);
        System.out.println(mongodbComponent.selectById(1));
    }
    @Test
    public void delete() {
        mongodbComponent.deleteById(1);
    }

    /**
     * 使用： MongoRepository
     */
    @Autowired
    private MongoDao mongoDao;
    @Test
    public void insertRep() {
        JpaUser entity = new JpaUser();
        entity.setId(1);//MongoRepository方式主键相同会覆盖
        entity.setUserName("doddRep");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        mongoDao.save(entity);
    }
    @Test
    public void deleteRep() {
        mongoDao.delete(1);
    }
    @Test
    public void updateRep() {
        JpaUser entity = new JpaUser();
        entity.setId(2);
        entity.setUserName("doddRep2");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        mongoDao.save(entity);
    }
    @Test
    public void selectRep() {
        JpaUser result = mongoDao.findOne(1);
        System.out.println(result);
    }
    @Test
    public void selectRep2() {
        JpaUser result = mongoDao.findByUserName("doddRep2");
        System.out.println(result);
    }
    // 分页
    @Test
    public void queryForPage() {
        Pageable pageable = new PageRequest(0, 20, new Sort(new
                Sort.Order(Sort.Direction.DESC, "id")));
        // Page<RoncooUserLog> result = mongoDao.findByUserName("doddRep2", pageable);
        Page<JpaUser> result = mongoDao.findAll(pageable);
        System.out.println(result.getContent());
    }



}
