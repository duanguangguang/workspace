package springbootdemo.springboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springbootdemo.springboot.entity.JpaUser;

import java.util.List;

/**
 * Jpa
 */
public interface JpaUserDao extends JpaRepository<JpaUser, Integer> {

    /**
     * 内置关键字匹配
     * 通过实体类属性名称匹配
     */
    List<JpaUser> findByUserName(String userName);

    /**
     * 自定义扩展方法
     * 通过实体类属性名称匹配
     * 多个属性使用And连接
     */
    List<JpaUser> findByUserNameAndUserIp(String string, String string2);

    /**
     * 自定义扩展方法
     * 不匹配时使用@Query
     * 注解的优先级高
     */
    @Query(value = "select u from JpaUser u where u.userName=?1")
    List<JpaUser> findByName(String userName);

    /**
     * 分页
     */
    Page<JpaUser> findByUserName(String userName, Pageable pageable);
}
