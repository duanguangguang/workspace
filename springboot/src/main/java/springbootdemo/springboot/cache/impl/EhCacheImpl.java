package springbootdemo.springboot.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import springbootdemo.springboot.cache.AbstractCache;
import springbootdemo.springboot.dao.JpaUserDao;
import springbootdemo.springboot.entity.JpaUser;

/**
 * @CacheConfig： 缓存配置
 */
@CacheConfig(cacheNames = "doddCache")
@Repository
public class EhCacheImpl implements AbstractCache {

    @Autowired
    private JpaUserDao jpaUserDao;

    /**
     * @Cacheable： 应用到读取数据的方法上，即可缓存的方法，如查找方法：先从缓存中读取，如果没有再调
     *              用方法获取数据，然后把数据添加到缓存中。 适用于查找
     */
    @Cacheable(key = "#p0")
    @Override
    public JpaUser selectById(Integer id) {
        System.out.println("查询功能，缓存找不到，直接读库, id=" +  id);
        return jpaUserDao.findOne(id);
    }

    /**
     * @CachePut： 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的
     *             是，它每次都会触发真实方法的调用。 适用于更新和插入
     */
    @CachePut(key = "#p0")
    @Override
    public JpaUser updateById(JpaUser jpaUser) {
        System.out.println("更新功能，更新缓存，直接写库, id=" + jpaUser);
        return jpaUserDao.save(jpaUser);
    }

    /**
     * @CacheEvict： 主要针对方法配置，能够根据一定的条件对缓存进行清空。 适用于删除
     */
    @CacheEvict(key = "#p0")
    @Override
    public String deleteById(Integer id) {
        System.out.println("删除功能，删除缓存，直接写库, id=" + id);
        return "清空缓存成功";
    }

}
