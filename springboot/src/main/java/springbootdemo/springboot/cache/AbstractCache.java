package springbootdemo.springboot.cache;

import springbootdemo.springboot.entity.JpaUser;

public interface AbstractCache {
    /**
     * 查询
     *
     * @param id
     * @return
     */
    JpaUser selectById(Integer id);
    /**
     * 更新
     *
     * @param jpaUser
     * @return
     */
    JpaUser updateById(JpaUser jpaUser);
    /**
     * 删除
     *
     * @param id
     * @return
     */
    String deleteById(Integer id);

}
