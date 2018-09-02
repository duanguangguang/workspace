package springbootdemo.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springbootdemo.springboot.dao.JpaUserDao;
import springbootdemo.springboot.dao.SbUserDao;
import springbootdemo.springboot.entity.JpaUser;
import springbootdemo.springboot.entity.SbUser;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private SbUserDao sbUserDao;

    @Autowired
    private JpaUserDao jpaUserDao;

    /**
     * 用户注册
     *
     * @return
     */
    @Transactional
    public String register(String name, String ip) {
        // 1.添加用户
        SbUser sbUser = new SbUser();
        sbUser.setName(name);
        sbUser.setCreateTime(new Date());
        sbUserDao.insert(sbUser);

        // 测试使用
        boolean flag = true;
        if (flag) {
            throw new RuntimeException();
        }

        // 2.添加注册日志
        JpaUser jpaUser = new JpaUser();
        jpaUser.setUserName(name);
        jpaUser.setUserIp(ip);
        jpaUser.setCreateTime(new Date());
        jpaUserDao.save(jpaUser);

        return "success";
    }
}
