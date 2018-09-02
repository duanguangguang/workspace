package springbootdemo.springboot.dao;

import springbootdemo.springboot.dao.entity.Page;
import springbootdemo.springboot.entity.SbUser;

/**
 * jdbcTemplate
 */
public interface SbUserDao {
    int insert(SbUser sbUser);

    int deleteById(int id);

    int updateById(SbUser sbUser);

    SbUser selectById(int id);

    Page<SbUser> queryForPage(int pageCurrent, int pageSize, String name);
}
